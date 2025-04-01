package app.adapters.persons;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Person;
import app.ports.PersonPort;

public class PesonAdapter implements PersonPort{
	private PersonRepository personRepository;

	@Override
	public boolean existPerson(long document) {
		return personRepository.existsByDocument(document);
	}

	@Override
	public void savePerson(Person person) {
		PersonEntity personEntity = new PersonEntity(person);
		personRepository.save(personEntity);
		
	}

	@Override
	public boolean existsByDocument(long document) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
