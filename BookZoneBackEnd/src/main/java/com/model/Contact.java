package com.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Contact 
{
	@Id
	@GeneratedValue
	private int contactId;
	private String contactName;
	private String contactEmail;
	private String contactNumber;
	private String queryTitle;
	private String queryMessage;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getQueryTitle() {
		return queryTitle;
	}
	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}
	public String getQueryMessage() {
		return queryMessage;
	}
	public void setQueryMessage(String queryMessage) {
		this.queryMessage = queryMessage;
	}
}
