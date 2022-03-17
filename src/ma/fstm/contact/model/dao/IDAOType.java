package ma.fstm.contact.model.dao;

import java.util.Collection;

import ma.fstm.contact.model.bo.Type;

public interface IDAOType {
	public Collection<Type> getAll();
	public Long getId(String titre);
}
