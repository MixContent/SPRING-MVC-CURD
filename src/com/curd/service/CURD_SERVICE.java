package com.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.bo.EmployeeBO;
import com.curd.dao.CURD_DAO;
import com.curd.dto.EmployeeDTO;
import com.curd.form.EmployeeForm;

@Service
public class CURD_SERVICE {

	@Autowired(required = true)
	private CURD_DAO dao;

	public String saveRecord(EmployeeForm employeeForm) {
		String message = dao.save(new EmployeeBO(employeeForm.getId(),
				employeeForm.getName(), employeeForm.getDept(), employeeForm
						.getSalary()));
		return message;
	}

	public String updateRecord( double salary,int id) {
		int count = dao.update(salary,id);
		return count + " SALARY UPDATED SUCCESSFULLY WHOSE ID :" + id;
	}

	public List<EmployeeDTO> readRecord() {
		List<EmployeeDTO> employees = new ArrayList<>();
		List<EmployeeBO> emp = dao.read();

		for (EmployeeBO employee : emp) {
			EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(),
					employee.getName(), employee.getDept(),
					employee.getSalary());
			employees.add(employeeDTO);
		}
		return employees;
	}

	public String deleteRecord(int id) {
		int count = dao.delete(id);
		return count + " RECORD DELETED SUCCESSFULLY WITH ID :" + id;
	}
}
