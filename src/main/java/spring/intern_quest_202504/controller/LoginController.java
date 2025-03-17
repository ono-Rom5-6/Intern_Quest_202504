//ログイン画面の表示
package spring.intern_quest_202504.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String get() {
		return "login";
	}

}
