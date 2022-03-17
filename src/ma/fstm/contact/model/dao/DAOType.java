package ma.fstm.contact.model.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.fstm.contact.model.bo.Contact;
import ma.fstm.contact.model.bo.Type;

public class DAOType implements IDAOType{

	@Override
	public Collection<Type> getAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = ConnexionHibernat.getSession();
	    Session session = sessionFactory.openSession();
	    return  session.createQuery("from Type").list();
	}

	@Override
	public Long getId(String titre) {
		// TODO Auto-generated method stub
	  Type T = new Type();
	  SessionFactory sessionFactory=ConnexionHibernat.getSession();
		Session session=sessionFactory.openSession();
		  Query query = session.createQuery("from Type p where p.titre = :nom");
	      query.setString("nom", titre);
	      Iterator personnes = query.iterate();
	      
	      while (personnes.hasNext()) {
	     T = (Type) personnes.next();
	        System.out.println("nom = " + T.getId());
	      }
	      return T.getId();
	
}
}
