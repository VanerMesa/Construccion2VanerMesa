package app.ports;

import java.util.List;

import app.domain.models.Pet;

public interface PetPort {
	
	public boolean existPet(long petId);
    public void savePet(Pet pet);
    public Pet findById(long petId);
    public List<Pet> findByPersonId(long personId); 
    public boolean existPetByOwnerAndName(long personId, String petName);
    

}