package app.domain.services;

import app.domain.models.Person;
import app.domain.models.Pet;
import app.ports.PersonPort;
import app.ports.PetPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Setter
@Getter
@NoArgsConstructor
@Service

public class VetService {
	
	 @Autowired
	    private PersonPort personPort;
	 @Autowired
	    private PetPort petPort;
	 
	 public void registerPerson(Person person)throws Exception{
	        if (personPort.existPerson(person.getDocument())){
	            throw new Exception("ya existe un dueño con esa cedula");
	        }               
	        
	        personPort.savePerson(person);
	    
	    }
	 
	 public void registerPet(Pet pet)throws Exception{
		 if (pet.getPerson() == null ){
			 throw new Exception("La mascota debe tener un dueño asignado.");
		    }
		 if (pet.getPerson().getDocument() == 0) {
		        throw new Exception("El documento del dueño no es válido.");
		    }
		 
		 Person owner = personPort.findByDocument(pet.getPerson().getDocument());

		    if (owner == null) {
		        throw new Exception("No existe un dueño con esa cédula.");
		    }

		    if (petPort.existPetByOwnerAndName(owner.getPersonId(), pet.getName())) {
		        throw new Exception("Ya existe una mascota con este nombre para este dueño.");
		    }

		    pet.setPerson(owner); 

		    petPort.savePet(pet);
		}
}
