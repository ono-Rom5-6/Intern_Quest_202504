//残業の申請、報告、印刷、取りまとめ、承認の機能
package spring.intern_quest_202504.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.intern_quest_202504.application.service.UserApplicationService;
import spring.intern_quest_202504.domain.combine.model.Combine;
import spring.intern_quest_202504.domain.combine.service.CombineService;
import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.overtime.service.OvertimeService;
import spring.intern_quest_202504.domain.user.model.LoginUserDetails;
import spring.intern_quest_202504.domain.user.model.User;
import spring.intern_quest_202504.form.ApplyForm;
import spring.intern_quest_202504.form.ApproveForm;
import spring.intern_quest_202504.form.CombineForm;
import spring.intern_quest_202504.form.ReportForm;

@RequestMapping("/overtime")
@Controller
public class OvertimeController {
	@Autowired
	private UserApplicationService userApplicationService;

	@Autowired
	private OvertimeService overtimeService;

	@Autowired
	private CombineService combineService;

	@GetMapping("/apply")
	public String getApply(Model model, ApplyForm applyForm) {
		Map<String, Integer> workPatternMap = userApplicationService.getWorkPatternMap(null);
		model.addAttribute("workPatternMap", workPatternMap);

		model.addAttribute("applyForm", applyForm);
		return "overtime/apply";
	}

	@PostMapping("/apply")
	public String poserApply(Model model, @ModelAttribute @Validated ApplyForm applyForm, BindingResult bindingResult,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		if (bindingResult.hasErrors()) {
			return getApply(model, applyForm);
		}
		User loginUser = loginUserDetails.getLoginUser();
		Overtime overtime = new Overtime();

		overtime.setUserId(loginUser.getId());
		overtime.setDepartmentId(loginUser.getDepartmentId());
		overtime.setMainPattern(applyForm.getMainPattern());
		overtime.setSubPattern(applyForm.getSubPattern());
		overtime.setScheduleStart(applyForm.getScheduleStart());
		overtime.setScheduleFinish(applyForm.getScheduleFinish());
		overtime.setReason(applyForm.getReason());

		overtimeService.addOvertime(overtime);

		return "redirect:/finish";
	}

	@GetMapping("/report/{id}")
	public String getReport(Model model, @PathVariable String id, @ModelAttribute ReportForm reportForm,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		
		if(overtimeService.getOvertime(id) ==null) {
			set404error(model);
			return "error";
		}
		if (mismatchUserId(id, loginUserDetails)) {
			set403error(model);
			return "error";
		}

		return "overtime/report";
	}

	@PostMapping("/report")
	public String postReport(Model model, @ModelAttribute @Validated ReportForm reportForm, BindingResult bindingResult,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String id = reportForm.getId();
		
		if(overtimeService.getOvertime(id) ==null) {
			set404error(model);
			return "error";
		}
		if (mismatchUserId(id, loginUserDetails)) {
			set403error(model);
			return "error";
		}

		if (bindingResult.hasErrors()) {
			return getReport(model, id, reportForm, loginUserDetails);
		}
		Overtime overtime = new Overtime();

		overtime.setId(id);
		overtime.setActualStart(reportForm.getActualStart());
		overtime.setActualFinish(reportForm.getActualFinish());

		int restHour = reportForm.getRestHour();
		int restMin = reportForm.getRestMin();

		int restSecond = 3600 * restHour + 60 * restMin;
		overtime.setRestSecond(restSecond);

		LocalDateTime now = LocalDateTime.now();
		overtime.setApplyDate(now);

		overtime.setContent(reportForm.getContent());
		overtimeService.addReport(overtime);

		return "redirect:/finish";
	}

	@GetMapping("/print/{id}")
	public String getPrint(Model model, @PathVariable String id,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		if(overtimeService.getOvertime(id) ==null) {
			set404error(model);
			return "error";
		}
		if (mismatchUserId(id, loginUserDetails)) {
			set403error(model);
			return "error";
		}
		Overtime overtime = overtimeService.getOvertime(id);

		model.addAttribute("item", overtime);
		return "overtime/print";
	}

	@GetMapping("/combine")
	public String getCombine(Model model, @ModelAttribute CombineForm combineForm,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String departmentId = loginUserDetails.getLoginUser().getDepartmentId();

		ArrayList<Overtime> yetCombinedList = overtimeService.getYetCombinedList(departmentId);
		model.addAttribute("yetCombinedList", yetCombinedList);

		model.addAttribute("title", "combine");
		return "overtime/combine";
	}

	@PostMapping("/combine")
	public String postCombine(Model model, @ModelAttribute CombineForm combineForm,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		List<String> overtimeIdsForCombine = Arrays.asList(combineForm.getOvertimeIds());
		String departmentId = loginUserDetails.getLoginUser().getDepartmentId();

		if (!overtimeIdsForCombineIsCorrect(departmentId, overtimeIdsForCombine)) {
			set403error(model);
			return "error";
		}

		Combine newCombine = new Combine();
		newCombine.setCreateUser(loginUserDetails.getLoginUser().getId());
		newCombine.setDepartmentId(loginUserDetails.getLoginUser().getDepartmentId());

		combineService.createCombine(newCombine);
		String combineId = newCombine.getId();

		for (String id : overtimeIdsForCombine) {
			overtimeService.addCombineId(id, combineId);
		}

		return "redirect:/finish";
	}

	@GetMapping("/approve")
	public String getApprove(Model model, @ModelAttribute ApproveForm approveForm,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String departmentId = loginUserDetails.getLoginUser().getDepartmentId();

		approveForm.setOvertimeList(overtimeService.getCombinedList(departmentId));

		model.addAttribute("approveForm", approveForm);

		model.addAttribute("title", "approve");
		return "overtime/approve";
	}


	@PostMapping("/approve")
	public String postApprove(Model model, @ModelAttribute ApproveForm approveForm,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String departmentId = loginUserDetails.getLoginUser().getDepartmentId();
		
		if (!idsForApproveIsCorrect(departmentId, approveForm)) {
			set403error(model);
			return "error";
		}

		String approveName = loginUserDetails.getLoginUser().getName();
		LocalDateTime now = LocalDateTime.now();

		for (Overtime item : approveForm.getOvertimeList()) {
			Overtime overtime = new Overtime();

			overtime.setId(item.getId());
			overtime.setState(item.getState());
			overtime.setApproveDate(now);
			overtime.setApproveName(approveName);

			overtimeService.approve(overtime);
		}

		return "redirect:/finish";
	}

	@GetMapping("/monthly-processing")
	public String getMonthlyProcessing(Model model, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String departmentId = loginUserDetails.getLoginUser().getDepartmentId();

		ArrayList<Overtime> monthlyProcessingList = overtimeService.getMonthlyProcessingList(departmentId);
		model.addAttribute("monthlyProcessingList", monthlyProcessingList);

		return "overtime/monthly-processing";

	}

	//メソッド類
	public boolean mismatchUserId(String id, LoginUserDetails loginUserDetails) {
		String userIdByOvertimeId = overtimeService.getOvertime(id).getUserId();
		if (userIdByOvertimeId.equals(loginUserDetails.getLoginUser().getId())) {
			return false;
		}
		return true;
	}

	public boolean overtimeIdsForCombineIsCorrect(String departmentId, List<String> overtimeIdsForCombine) {
		List<String> idsYetCombine = overtimeService.getYetCombinedList(departmentId).stream()
				.map(overtime -> overtime.getId())
				.toList();
		
		return overtimeIdsForCombine.stream()
				.allMatch(id -> idsYetCombine.contains(id));
	}
	
	public boolean idsForApproveIsCorrect(String departmentId, ApproveForm approveForm) {
		List<String> idsForApprove = overtimeService.getCombinedList(departmentId).stream()
				.map(overtime -> overtime.getId())
				.toList();

		return approveForm.getOvertimeList().stream()
				.map(overtime -> overtime.getId())
				.allMatch(id -> idsForApprove.contains(id));

	}


	public void set403error(Model model) {
		model.addAttribute("error", " ");
		model.addAttribute("message", "Exceptionが発生しました");
		model.addAttribute("status", HttpStatus.FORBIDDEN);
	}

	public void set404error(Model model) {
		model.addAttribute("error", " ");
		model.addAttribute("message", "Exceptionが発生しました");
		model.addAttribute("status", HttpStatus.NOT_FOUND);
	}

}
