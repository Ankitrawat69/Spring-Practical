package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	UserServiceInt userService;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form) {

		return "UserView";

	}

	@GetMapping("search")
	public String search(Model model) {

		UserDTO dto = new UserDTO();

		List list = userService.search(null, 0, 0);
		model.addAttribute("list", list);
		return "UserListView";

	}
	
	@PostMapping
	public String save(@ModelAttribute("form") UserForm form, Model model) {

		UserDTO dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		long pk = userService.add(dto);
		model.addAttribute("msg", "User Added Successfully!..");

		return "UserView";

	}

}