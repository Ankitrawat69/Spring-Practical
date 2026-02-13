package com.rays.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "Login")
public class LoginCtl {

	@Autowired
	UserServiceInt userService;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (operation != null) {
			session.invalidate();
			model.addAttribute("msg", "user logout successfully");
		}
		return "LoginView";
	}

	@PostMapping
	public String login(@ModelAttribute("form") LoginForm form, HttpSession session, Model model) {

		UserDTO dto = new UserDTO();

		dto = userService.authenticate(form.getLogin(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			return "redirect:/Welcome";
		} else {
			model.addAttribute("emsg", "Please Enter Vaild Login and Password");
			return "LoginView";
		}

	}

}