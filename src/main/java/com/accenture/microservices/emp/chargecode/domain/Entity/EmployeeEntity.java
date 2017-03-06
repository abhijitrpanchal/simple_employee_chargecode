package com.accenture.microservices.emp.chargecode.domain.Entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
	
	@Id 
	@Column(name = "employee_id")
	private Integer employeeId;
	
	private String name;
	
	private String address;
	
	
	
	
	public EmployeeEntity() {
		
		
			
	}
	
	public EmployeeEntity(Integer employeeId,String name,String address) {
		
		this.employeeId=employeeId;
		this.name=name;
		this.address=address;
		
				
		
	}
	
	
	
	
	
	

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
