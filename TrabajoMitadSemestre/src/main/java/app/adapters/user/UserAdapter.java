package app.adapters.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.user.entity.UserEntity;
import app.adapters.user.repository.UserRepository;
import app.adapters.persons.entity.PersonEntity;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;


@Component 
public class UserAdapter implements UserPort {
	
	@Autowired 
	private UserRepository userRepository;	
	@Autowired 
	private PersonRepository personRepository;

	@Override
	public boolean existUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}
	
	@Override
	public User findByPersonId(Person person) {
		PersonEntity personEntity = personAdapter(person);
		UserEntity userEntity = userRepository.findByPersonId(personEntity);
		User user = userAdapter(userEntity);
		return user;
	}

	

	@Override
	public void saveUser(User user) {
		if (user.getRole() == null || (!user.getRole().equals("veterinario") && !user.getRole().equals("vendedor"))) {
			throw new IllegalArgumentException("Rol inválido. Debe ser veterinario o vendedor");
		}
		
		UserEntity userEntity = userEntityAdapter(user);
		if (!personRepository.existsById(userEntity.getPersonId().getPersonId())) {
			personRepository.save(userEntity.getPersonId());
			}
		
		userRepository.save(userEntity);
		System.out.println("Usuario guardado con éxito: " + user.getUserName());
	}


	@Override
	public User findByUserName(User user) {
		UserEntity userEntity = userRepository.findByUserName(user.getUserName());
		if (userEntity == null){
			return null;
		}
		return userAdapter(userEntity);
	}
	
	private User userAdapter(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		User user = new User();
		user.setPersonId(userEntity.getPersonId().getPersonId());
		user.setDocument(userEntity.getPersonId().getDocument());
		user.setName(userEntity.getPersonId().getName());
		user.setAge(userEntity.getPersonId().getAge());
		user.setRole(userEntity.getPersonId().getRole());
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());		
		user.setUserId(userEntity.getUserId());
		return user;
		
	}
	
	private UserEntity userEntityAdapter(User user) {
		PersonEntity personEntity = personAdapter(user);
		UserEntity userEntity = new UserEntity();
		userEntity.setPersonId(personEntity);
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());		
		return userEntity;
	}

	private PersonEntity personAdapter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setPersonId(person.getPersonId());
		personEntity.setDocument(person.getDocument());
		personEntity.setName(person.getName());
		personEntity.setAge(person.getAge());
		personEntity.setRole(person.getRole());
		return personEntity;
	}

}
