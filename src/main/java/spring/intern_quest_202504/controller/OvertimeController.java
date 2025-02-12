package spring.intern_quest_202504.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.intern_quest_202504.form.ApplyForm;
import spring.intern_quest_202504.form.ReportForm;

@RequestMapping("/overtime")
@Controller
public class OvertimeController {
	@GetMapping("/apply")
	public String getApply(Model model, @ModelAttribute ApplyForm applyForm, BindingResult bindingResult) {
		//model.addAttribute("overtimeForm", new OvertimeForm());
		return "overtime/apply";
	}

	@PostMapping("/apply")
	public String poserApply(Model model, @ModelAttribute @Validated ApplyForm applyForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			getApply(model, applyForm, bindingResult);
		}

		//TODO: データを保存する処理をここに記述（例：データベースへ保存）
		//従業員IDの取得とセット
		
		//System.out.println("残業登録成功: " + overtimeForm);

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
