package ma.fstm.contact.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class ConnexionHibernat {
	private static SessionFactory session;

	public static SessionFactory getSession() {
		return session;
	}

	public static void setSession(SessionFactory session) {
		 ConnexionHibernat.session = session;
	}
	static {
		// TODO Auto-generated method stub
		//ConnectionHibernate.getSession();
		try {
			Configuration config=new Configuration();
			config.configure("/ma/fstm/contact/model/dao/hibernate.cfg.xml");
			session=config.buildSessionFactory();
			System.out.println("it's hoji");
			}catch(HibernateException exep) {
				System.out.println("error");
				exep.printStackTrace();
		}

	}
}
