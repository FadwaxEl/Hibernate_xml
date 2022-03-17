package ma.fstm.contact.model.bo;

import java.util.HashSet;
import java.util.Set;

public class Type {

	Long id;
	String titre;
	Set<Contact> c;
	public Type() {
		this.c = new HashSet<Contact>();
	}
	
	
	public Type(Long id, String titre, Set<Contact> c) {
		super();
		this.id = id;
		this.titre = titre;
		this.c = c;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Set<Contact> getC() {
		return c;
	}
	public void setC(Set<Contact> c) {
		this.c = c;
	}
}
