package spring.intern_quest_202504.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.intern_quest_202504.application.service.UserApplicationService;
import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.overtime.service.OvertimeService;
import spring.intern_quest_202504.domain.user.model.LoginUserDetails;
import spring.intern_quest_202504.form.ApplyForm;
import spring.intern_quest_202504.form.ReportForm;

@RequestMapping("/overtime")
@Controller
public class OvertimeController {
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private OvertimeService overtimeService;
	
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

		Overtime overtime = new Overtime();
		
		//System.out.println(loginUserDetails.getLoginUser().getId());
		
		overtime.setUserId(loginUserDetails.getLoginUser().getId()); 
		
		//System.out.println(overtime.getUserId());
		
		//TODO: 勤務パターンが適切な値かチェックするメソッドを入れること
		System.out.println(applyForm.getMainPattern() + applyForm.getSubPattern());
		
		overtime.setWorkPattern(applyForm.getMainPattern() + applyForm.getSubPattern());
		
		overtime.setScheduleStart(applyForm.getScheduleStart());
		overtime.setScheduleFinish(applyForm.getScheduleFinish());
		
		overtime.setReason(applyForm.getReason());
		
		overtimeService.addOvertime(overtime);

		
		model.addAttribute("successMessage", "残業登録が完了しました！");
		return "redirect:/home";
	}

	@GetMapping("/report")
	public String getReport(Model model, @ModelAttribute ReportForm reportForm, BindingResult bindingResult) {
		//model.addAttribute("overtimeForm", new OvertimeForm());
		return "overtime/report";
	}

	@PostMapping("/report")
	public String postReport(Model model, @ModelAttribute ReportForm reportForm, BindingResult bindingResult) {
		//TODO:報告の登録処理

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
	public String postPrint() {
		//TODO:プリント処理

		return "redirect:/home";

	}

}
