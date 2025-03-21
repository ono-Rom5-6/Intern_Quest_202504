//ホーム画面の表示
package spring.intern_quest_202504.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.overtime.service.OvertimeService;
import spring.intern_quest_202504.domain.user.model.LoginUserDetails;
import spring.intern_quest_202504.domain.user.model.User;

@Controller
public class HomeController {
	@Autowired
	private OvertimeService overtimeService;
	
	
	@GetMapping("/home")
	public String get(Model model, @AuthenticationPrincipal LoginUserDetails loginUser) {
		User user = loginUser.getLoginUser();
		
		List<Overtime> thisOvertimeList = overtimeService.getThisOvertimeList(user);
		model.addAttribute("thisOvertimeList", thisOvertimeList);
		
		model.addAttribute("title", "home");
		return "home";
	}

}
