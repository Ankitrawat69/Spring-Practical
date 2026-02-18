package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.StudentServiceInt;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "/ctl/Student")
public class StudentCtl {
	
	@Autowired
	StudentServiceInt studentService;

	@GetMapping
	public String display(@ModelAttribute("form") StudentForm form, @RequestParam(required = false) Long id) {
		
		if (id != null && id > 0) {
			StudentDTO dto = studentService.findByPk(id);
			form.setId(dto.getId());
			form.setStudentName(dto.getStudentName());
			form.setLogin(dto.getLogin());
			form.setPassword(dto.getPassword());
			form.setAddress(dto.getAddress());
		}
		return "StudentView";

	}

	@GetMapping("search")

	// Ye puri list search krke laane ke lie5555
	public String search(@ModelAttribute("form") StudentForm form, Model model) {

		StudentDTO dto = new StudentDTO();

		List list = studentService.search(null, 0, 0);
		model.addAttribute("list", list);
		return "StudentListView";

	}

	@PostMapping("search")
	public String search(@ModelAttribute("form") StudentForm form, @RequestParam(required = false) String operation,
			Model model) {

		StudentDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;

		if (operation.equals("next")) {
			pageNo = form.getPageNo();
			pageNo++;

		}

		if (operation.equals("previous")) {
			pageNo = form.getPageNo();
			pageNo--;

		}

		if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					studentService.delete(id);

				}

			}

		}

		if (operation.equals("search")) { // Search filter
			dto = new StudentDTO();
			dto.setStudentName(form.getStudentName());

		}

		form.setPageNo(pageNo);

		List list = studentService.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "StudentListView";

	}

	@PostMapping
	public String save(@ModelAttribute("form") @Valid StudentForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "StudentView";
		}

		StudentDTO dto = new StudentDTO();
		dto.setId(form.getId());
		dto.setStudentName(form.getStudentName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setAddress(form.getAddress());

		try {
			if (dto.getId() > 0) {
				studentService.update(dto);
				model.addAttribute("msg", "Student Update Successfully!..");
			} else {
				long pk = studentService.add(dto);
				model.addAttribute("msg", "Student Added Successfully!..");
			}
		} catch (Exception e) {
			model.addAttribute("emsg", e.getMessage());
		}
		return "StudentView";
	}
}
