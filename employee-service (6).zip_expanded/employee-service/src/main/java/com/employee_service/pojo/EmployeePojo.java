package com.employee_service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeePojo {
	private int empId;
	private String empName;
	private DepartmentPojo empDept;
}
