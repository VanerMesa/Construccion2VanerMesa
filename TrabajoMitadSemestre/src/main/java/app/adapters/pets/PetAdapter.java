package app.adapters.pets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.pets.entity.PetEntity;
import app.adapters.pets.repository.PetRepository;
import app.domain.models.Pet;
import app.ports.PetPort;

@Component
public class PetAdapter implements PetPort {

    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean existPet(long petId) {
        return petRepository.existsById(petId);
    }

    @Override
    public void savePet(Pet pet) {
        PetEntity entity = new PetEntity(pet);
        petRepository.save(entity);
    }

    @Override
    public Pet findById(long petId) {
        return petRepository.findById(petId)
                .map(PetEntity::toDomain)
                .orElse(null);
    }

    @Override
    public List<Pet> findByPersonId(long personId) {
        return petRepository.findByPersonId(personId)
                .stream()
                .map(PetEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existPetByOwnerAndName(long personId, String petName) {
        return petRepository.existsByPersonIdAndName(personId, petName);
    }
}
