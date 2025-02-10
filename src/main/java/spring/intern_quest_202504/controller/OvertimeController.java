package spring.intern_quest_202504.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.intern_quest_202504.form.OvertimeForm;

@RequestMapping("/overtime")
@Controller
public class OvertimeController {
	@GetMapping("/apply")
	public String getApply(Model model, @ModelAttribute OvertimeForm overtimeForm, BindingResult bindingResult) {
		model.addAttribute("overtimeForm", new OvertimeForm());
		return "overtime/apply";
	}

	@PostMapping("/apply")
	public String poserApply(Model model, @ModelAttribute @Validated OvertimeForm overtimeForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			getApply(model, overtimeForm, bindingResult);
		}

		// データを保存する処理をここに記述（例：データベースへ保存）
		System.out.println("残業登録成功: " + overtimeForm);

		model.addAttribute("successMessage", "残業登録が完了しました！");
		return "redilect:home";
	}

}
