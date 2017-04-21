package com.accenture.lari.chargecode.domain;

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
//@Document
public class ChargeCodeEntity {

	@Id
	//private Integer id;
	@Column(name = "charge_code")
	//@Field
	private String chargeCode;
	//@Field	
	private String engagement;
	//@Field
	private String company;
	//@Field
	private String status;
	//@Field
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CHARGE_CODE_EMPLOYEE", joinColumns = { @JoinColumn(name = "charge_code") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
	private Set<EmployeeEntity> authorizedEmployees;
	public ChargeCodeEntity(String chargeCode, String engagement, String company, String status,
			Set<EmployeeEntity> authorizedEmployees) {
		super();
		this.chargeCode = chargeCode;
		this.engagement = engagement;
		this.company = company;
		this.status = status;
		this.authorizedEmployees = authorizedEmployees;
	}
	public ChargeCodeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the chargeCode
	 */
	public String getChargeCode() {
		return chargeCode;
	}
	/**
	 * @param chargeCode the chargeCode to set
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	/**
	 * @return the engagement
	 */
	public String getEngagement() {
		return engagement;
	}
	/**
	 * @param engagement the engagement to set
	 */
	public void setEngagement(String engagement) {
		this.engagement = engagement;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the authorizedEmployees
	 */
	public Set<EmployeeEntity> getAuthorizedEmployees() {
		return authorizedEmployees;
	}
	/**
	 * @param authorizedEmployees the authorizedEmployees to set
	 */
	public void setAuthorizedEmployees(Set<EmployeeEntity> authorizedEmployees) {
		this.authorizedEmployees = authorizedEmployees;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorizedEmployees == null) ? 0 : authorizedEmployees.hashCode());
		result = prime * result + ((chargeCode == null) ? 0 : chargeCode.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((engagement == null) ? 0 : engagement.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargeCodeEntity other = (ChargeCodeEntity) obj;
		if (authorizedEmployees == null) {
			if (other.authorizedEmployees != null)
				return false;
		} else if (!authorizedEmployees.equals(other.authorizedEmployees))
			return false;
		if (chargeCode == null) {
			if (other.chargeCode != null)
				return false;
		} else if (!chargeCode.equals(other.chargeCode))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (engagement == null) {
			if (other.engagement != null)
				return false;
		} else if (!engagement.equals(other.engagement))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
