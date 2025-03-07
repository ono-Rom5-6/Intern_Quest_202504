package spring.intern_quest_202504.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/apply")
	public String getApply(Model model, ApplyForm applyForm) {
		
		Map<String, Integer> workPatternMap = userApplicationService.getWorkPatternMap(null);
		model.addAttribute("workPatternMap", workPatternMap);
		
		model.addAttribute("applyForm", applyForm);
		return "overtime/apply";
	}

	@PostMapping("/apply")
	public String poserApply(Model model, @ModelAttribute @Validated ApplyForm applyForm, BindingResult bindingResult, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		if (bindingResult.hasErrors()) {
			
			return getApply(model, applyForm);
		}
		
		User loginUser = loginUserDetails.getLoginUser();

		Overtime overtime = new Overtime();
		
		//System.out.println(loginUserDetails.getLoginUser().getId());
		
		overtime.setUserId(loginUser.getId()); 
		overtime.setDepartmentId(loginUser.getDepartmentId());
		
		//System.out.println(overtime.getUserId());
		
		//TODO: 勤務パターンが適切な値かチェックするメソッドを入れること(勤務パターンテーブル？？、追加機能)
		//System.out.println(applyForm.getMainPattern() + applyForm.getSubPattern());
		
		//overtime.setWorkPattern(applyForm.getMainPattern() + applyForm.getSubPattern());
		overtime.setMainPattern(applyForm.getMainPattern());
		overtime.setSubPattern(applyForm.getSubPattern());
		
		overtime.setScheduleStart(applyForm.getScheduleStart());
		overtime.setScheduleFinish(applyForm.getScheduleFinish());
		
		overtime.setReason(applyForm.getReason());
		
		overtimeService.addOvertime(overtime);

		model.addAttribute("title", "home");
		return "redirect:/home";
	}

	@GetMapping("/report/{id}")
	public String getReport(Model model, @PathVariable String id, @ModelAttribute ReportForm reportForm,  @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		//model.addAttribute("overtimeForm", new OvertimeForm());
		return "overtime/report";
	}

	@PostMapping("/report")
	public String postReport(Model model, @ModelAttribute @Validated ReportForm reportForm, BindingResult bindingResult,  @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String id = reportForm.getId();
		if (bindingResult.hasErrors()) {
			return getReport(model, id, reportForm, loginUserDetails);
		}
		
		//TODO:ユーザー確認
		
		
		//TODO:報告の登録処理
		Overtime overtime = new Overtime();
		
		overtime.setId(id);
		overtime.setActualStart(reportForm.getActualStart());
		overtime.setActualFinish(reportForm.getActualFinish());
		
		int restHour = reportForm.getRestHour();
		int restMin = reportForm.getRestMin();
		
		int restSecond = 3600*restHour + 60*restMin;
		System.out.println(restSecond);
		overtime.setRestSecond(restSecond);
		
		Date now = new Date();
		overtime.setApplyDate(now);
		
		overtime.setContent(reportForm.getContent());
		
		
		
		
		//それぞれの分類の時間
		/*
		 * 終了時間から休憩時間を引き、みなし終了時間を求める
		 * 開始時間がどの区分か判定。
		 * 開始時間から次の区切りの時間までに終了時間があるか？
		 * 　ある→秒数を求め、該当の区分に登録。
		 * 　ない→区切りまでの時間をその区分に登録。その区分の開始時間を開始時間として上を繰り返す。
		 */
		
		
		
		overtimeService.addReport(overtime);
		
		
		
		model.addAttribute("title", "home");
		return "redirect:/home";

	}

	@GetMapping("/select")
	public String getSelect() {
		//TODO:検索処理
		return "overtime/select";

	}

	@PostMapping("/select")
	public String postSlect() {
		//TODO:パラメータを受け取って渡す

		return getPrint();
	}

	@GetMapping("/print")
	public String getPrint() {
		//TODO:パラメータを受け取って渡す

		return "overtime/print";
	}

	@PostMapping("/print")
	public String postPrint(Model model) {
		//TODO:プリント処理
		
		model.addAttribute("title", "home");
		return "redirect:/home";

	}
	
	@GetMapping("/combine")
	public String getCombine(Model model,  @ModelAttribute CombineForm combineForm, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String departmentId =loginUserDetails.getLoginUser().getDepartmentId();
		
		
		ArrayList<Overtime> yetCombinedList = overtimeService.getYetCombinedList(departmentId);
		model.addAttribute("yetCombinedList", yetCombinedList);
		
		
		model.addAttribute("title", "combine");
		return "overtime/combine";
	}
	
	@PostMapping("/combine")
	public String postCombine(Model model, @ModelAttribute CombineForm combineForm, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		String[] overtimeIds = combineForm.getOvertimeIds();
		
		//insert
		Combine newCombine = new Combine();
		newCombine.setCreateUser(loginUserDetails.getLoginUser().getId());
		newCombine.setDepartmentId(loginUserDetails.getLoginUser().getDepartmentId());
		
		combineService.createCombine(newCombine);
		
		String combineId = newCombine.getId();
		
		
		for(String id : overtimeIds) {
			//System.out.println(id);
			
			overtimeService.addCombineId(id, combineId);
			
			
		}
		
		
		model.addAttribute("title", "home");
		return "redirect:/home";

	}

}
