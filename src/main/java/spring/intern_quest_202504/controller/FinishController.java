package spring.intern_quest_202504.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinishController {
	@GetMapping("/finish")
	public String get(Model model) {
		
	//model.addAttribute("title", content);
		return "finish";
	}


}

