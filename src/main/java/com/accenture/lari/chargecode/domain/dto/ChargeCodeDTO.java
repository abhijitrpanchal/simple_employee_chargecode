package com.accenture.lari.chargecode.domain.dto;

import java.util.Collection;


public class ChargeCodeDTO {
	

	private String chargeCode;

	
	private String engagement;

	private String company;

	private String status;
	

	private Collection<EmployeeDTO> authorizedEmployees;
	
	

	public Collection<EmployeeDTO> getAuthorizedEmployees() {
		return authorizedEmployees;
	}

	public void setAuthorizedEmployees(Collection<EmployeeDTO> authorizedEmployees) {
		this.authorizedEmployees = authorizedEmployees;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}

	public String getEngagement() {
		return engagement;
	}

	public void setEngagement(String engagement) {
		this.engagement = engagement;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

}
