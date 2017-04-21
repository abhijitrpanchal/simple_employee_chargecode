package com.accenture.lari.chargecode.resources.dto;

import java.util.Collection;


public class ChargeCodeDTO {
	

	private String chargeCode;
	private String engagement;
	private String company;
	private String status;
	
	
	
	public ChargeCodeDTO(String chargeCode, String engagement, String company, String status,
			Collection<EmployeeDTO> authorizedEmployees) {
		this.chargeCode = chargeCode;
		this.engagement = engagement;
		this.company = company;
		this.status = status;
		this.authorizedEmployees = authorizedEmployees;
	}

	public ChargeCodeDTO() {
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChargeCodeDTO [chargeCode=" + chargeCode + ", engagement=" + engagement + ", company=" + company
				+ ", status=" + status + ", authorizedEmployees=" + authorizedEmployees + "]";
	}

	
}
