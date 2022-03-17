package ma.fstm.contact.controller;

import java.util.Collection;

import ma.fstm.contact.model.bo.Contact;
import ma.fstm.contact.model.bo.Type;
import ma.fstm.contact.model.dao.DAOType;
import ma.fstm.contact.model.dao.DAOcontact;
import ma.fstm.contact.model.dao.IDAOType;
import ma.fstm.contact.model.dao.IDAOcontact;

public class ContactCtr {

	IDAOcontact myContact;
	IDAOType  type;
	public ContactCtr() {
		myContact = new DAOcontact();
		type= new DAOType();
	}
	
	
	
	public Long Ajouter_cont(String text, String text2, String text3, String cbox) {
		// TODO Auto-generated method stub
		
		if(text3.length() != 0)
		{
			//Contact C = new Contact(text,text2,text3,cbox);
			//myContact.Create();
			type.getId(cbox);
			System.out.println(type.getId(cbox));
			Type T = new Type();
			T.setId(type.getId(cbox));
		 return myContact.Create(new Contact(text,text2,text3,T) );
		}
		return null;
	}
	
	
	public Collection<Contact> Afficher() {
		
		Collection<Contact> c =  myContact.Retrieve();
		for(Contact d : c)
		{
			System.out.println(d.getNom());
		}
	
		return c;
	}

	public void Delete(Long id) {
		
		Contact c = new Contact();
		c.setId(id);
		myContact.Delete(c);
		System.out.println("deleted successfully ");
	}
	
	public Contact Modifier(Long id,String text, String text2, String text3, String cbox)
	{
		type.getId(cbox);
		System.out.println(type.getId(cbox));
		Type T = new Type();
		T.setId(type.getId(cbox));
		Contact C = new Contact(text,text2,text3,T);
		C.setId(id);
		C.setNom(text);
		C.setPrenom(text2);
		C.setTel(text3);
		C.setType(T);
		myContact.Update(C);
		return C;
		
	}
}