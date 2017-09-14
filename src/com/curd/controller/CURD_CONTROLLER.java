package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curd.dto.EmployeeDTO;
import com.curd.form.EmployeeForm;
import com.curd.service.CURD_SERVICE;

@Controller
public class CURD_CONTROLLER {

	@Autowired(required = true)
	private CURD_SERVICE service;

	@RequestMapping(value = "/save.mvc")
	public String save(Model model,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm) {
		String message = service.saveRecord(employeeForm);
		model.addAttribute("message", message);
		return "result";
	}

	@RequestMapping(value = "/update.mvc")
	public String update(@RequestParam("id") int id,
			@RequestParam("salary") double salary, Model model) {
		String updatedMessage = service.updateRecord(salary, id);
		model.addAttribute("updatedMessage", updatedMessage);
		return "result";
	}

	@RequestMapping(value = "/read.mvc")
	public String readData(Model model) {
		List<EmployeeDTO> employeeDTOs = service.readRecord();
		model.addAttribute("employeeDTOs", employeeDTOs);
		return "result";
	}

	@RequestMapping(value = "/delete.mvc")
	public String deleteRecord(@RequestParam("id") int id, Model model) {
		String deleteInfo = service.deleteRecord(id);
		model.addAttribute("deleteInfo", deleteInfo);
		return "result";
	}
}
