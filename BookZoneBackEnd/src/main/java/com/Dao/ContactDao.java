package com.Dao;

import java.util.List;
import com.model.Contact;

public interface ContactDao 
{
	public boolean addContact(Contact contact);
	public boolean updateContact(Contact contact);
	public boolean deleteContact(Contact contact);
	public List<Contact> retrieveContact();
	public Contact getContact(int contactId);
}
