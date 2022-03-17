package ma.fstm.contact.model.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.fstm.contact.model.bo.Contact;




public class DAOcontact implements IDAOcontact {

	@Override
   public Long Create(Contact C) {
		
	    SessionFactory sessionFactory = ConnexionHibernat.getSession();
	    Session session = sessionFactory.openSession();
	    Transaction T = null;
	    try{
	    	T = session.beginTransaction();
			    session.save(C);
			    System.out.println("Inserted Successfully");
			    session.flush() ;
			   T.commit();
			    List<Contact> c =  (List<Contact>) this.Retrieve();
				   Contact f =c.get(c.size()-1);
				   session.close();
				  // sessionS
			    return f.getId();
	    }catch(HibernateException e) {
	    	 System.out.println(e);
	    	 T.rollback();
	    	 return null;
	    }
	}


	@Override
	public boolean Delete(Contact C) {
		// TODO Auto-generated method stub

	    SessionFactory sessionFactory = ConnexionHibernat.getSession();
	    Session session = sessionFactory.openSession();
	    Transaction T = null;
	    try{
	    	T = session.beginTransaction();
			    session.delete(C);
			    System.out.println("Inserted Successfully");
			    session.flush() ;

			T.commit();
			    session.close();
			   // sessionFactory.close();
			
			  
			    return true;
	    }catch(HibernateException e) {
	    	 System.out.println(e);
	    	 T.rollback();
	    	 return false;
	    }
	}

	@Override
	public boolean Update(Contact C) {
		// TODO Auto-generated method stub

	    SessionFactory sessionFactory = ConnexionHibernat.getSession();
	    Session session = sessionFactory.openSession();
	    Transaction T = null;
	    try{
	    	T = session.beginTransaction();
			    session.update(C);
			    System.out.println("Inserted Successfully");
			    session.flush() ;

			T.commit();
			    session.close();
			  //  sessionFactory.close();
			    return true;
	    }catch(HibernateException e) {
	    	 System.out.println(e);
	    	 T.rollback();
	    	 return false;
	    }
	}

	@Override
	public Collection<Contact>  Retrieve() {
		// TODO Auto-generated method stub
		 SessionFactory sessionFactory = ConnexionHibernat.getSession();
		    Session session = sessionFactory.openSession();
		    return (Collection<Contact> ) session.createQuery("from Contact").list();
		    
	}
	
}
