package com.accenture.lari.chargecode.resources.dto;


public class EmployeeDTO {

	private Integer employeeId;
	private String name;
	private String address;

	
	
	public EmployeeDTO(Integer employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

	public EmployeeDTO() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", name=" + name + ", address=" + address + "]";
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
