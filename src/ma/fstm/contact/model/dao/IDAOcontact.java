package ma.fstm.contact.model.dao;

import java.util.Collection;
import java.util.Set;

import ma.fstm.contact.model.bo.Contact;

public interface IDAOcontact {

	public Long Create(Contact C);
	public boolean Delete (Contact C);
	public boolean Update(Contact C);
	public Collection<Contact>  Retrieve();
	
}
