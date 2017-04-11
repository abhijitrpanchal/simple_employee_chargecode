package com.accenture.lari.chargecode.domain;

import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;


/*@Entity
@Table(name = "CHARGECODE")*/
@Document
public class ChargeCodeEntity {

	@Id
	//@Column(name = "charge_code")
	@Field
	private String chargeCode;
	@Field	
	private String engagement;
	@Field
	private String company;
	@Field
	private String status;
	
	
	
	public ChargeCodeEntity(String chargeCode, String engagement, String company, String status,
			Set<EmployeeEntity> authorizedEmployees) {
		
		this.chargeCode = chargeCode;
		this.engagement = engagement;
		this.company = company;
		this.status = status;
		this.authorizedEmployees = authorizedEmployees;
	}

	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CHARGE_CODE_EMPLOYEE", joinColumns = { @JoinColumn(name = "charge_code") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
*/	private Set<EmployeeEntity> authorizedEmployees;
	
	
	public ChargeCodeEntity() {
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




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChargeCodeEntity [chargeCode=" + chargeCode + ", engagement=" + engagement + ", company=" + company
				+ ", status=" + status + ", authorizedEmployees=" + authorizedEmployees + "]";
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
