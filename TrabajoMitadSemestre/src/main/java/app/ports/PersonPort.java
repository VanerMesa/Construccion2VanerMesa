package app.ports;

import app.domain.models.Person;

public interface PersonPort {
	
	public boolean existPerson(long document);
	void savePerson(Person Person);
	public boolean existsByDocument(long document);

}
