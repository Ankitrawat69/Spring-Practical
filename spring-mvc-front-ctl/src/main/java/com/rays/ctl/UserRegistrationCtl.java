package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "Registration")
public class UserRegistrationCtl {

	@Autowired
	UserServiceInt userService;

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {

		return "UserRegistration";

	}

	@PostMapping
	public String register(@ModelAttribute("form")@Valid UserRegistrationForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "UserRegistration";
			
		}
		 
		UserDTO dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		try {
			long pk = userService.add(dto);
			model.addAttribute("msg", "User Register Successfully!..");
		} catch (Exception e) {
			model.addAttribute("emsg", e.getMessage());
		}
		return "UserRegistration";

	}
}