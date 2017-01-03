/**
 * 
 */
package com.accenture.microservices.emp.chargecode.domain.vo;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

/**
 * @author j.venugopalan
 *
 */

@Document
public class ChargeCode_bkp {
	
	@Id
	@Field
	public Integer id;
	@Field
	public String chargeCode;
	@Field
	public String engagement;
	@Field
	public String company;
	@Field
	public String status;
	
	
	
	/*public String validFrom;
	public String validTill;
	public String clientName;
	public String contractName;
	public String description;
	public String type;
	public String parentWBS;
	public String businessActivityLevel1;
	public String businessActivityLevel2;
	public String businessActivityLevel3;
	public String canChargeTime;
	public String canChargeExpense;
	public String display;*/
	public ChargeCode_bkp(Integer id, String chargeCode, String engagement, String company, String status) {
		this.id = id;
		this.chargeCode = chargeCode;
		this.engagement = engagement;
		this.company = company;
		this.status = status;
	}
	public ChargeCode_bkp() {
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChargeCode [id=" + id + ", chargeCode=" + chargeCode + ", engagement=" + engagement + ", company="
				+ company + ", status=" + status + "]";
	}
	

}
