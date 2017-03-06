package com.accenture.microservices.emp.chargecode.domain.Entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHARGECODE")
public class ChargeCodeEntity {

	@Id
	@Column(name = "charge_code")
	private String chargeCode;

	
	private String engagement;

	private String company;

	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CHARGE_CODE_EMPLOYEE", joinColumns = { @JoinColumn(name = "charge_code") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
	private Set<EmployeeEntity> authorizedEmployees;
	
	
	public ChargeCodeEntity() {
		
		
		
	}
	
	
	public ChargeCodeEntity(String chargeCode,String engagement,String company,String status,Set<EmployeeEntity> authorizedEmployees) {
		
		this.chargeCode=chargeCode;
		this.engagement=engagement;
		this.company=company;
		this.status=status;
		this.authorizedEmployees=authorizedEmployees;
				
		
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

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<EmployeeEntity> getAuthorizedEmployees() {
		return authorizedEmployees;
	}

	public void setAuthorizedEmployees(Set<EmployeeEntity> authorizedEmployees) {
		this.authorizedEmployees = authorizedEmployees;
	}
	
	
	

}
