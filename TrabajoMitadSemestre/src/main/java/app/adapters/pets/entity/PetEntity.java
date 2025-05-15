package app.adapters.pets.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String name;
    private String type;
    private int age;

    private Long personId; 

    public PetEntity() {}

    public PetEntity(app.domain.models.Pet pet) {
        this.petId = pet.getPetId();
        this.name = pet.getName();
        this.type = pet.getType();
        this.age = pet.getAge();
        this.personId = pet.getPersonId();
    }

    public app.domain.models.Pet toDomain() {
        app.domain.models.Pet pet = new app.domain.models.Pet();
        pet.setPetId(this.petId);
        pet.setName(this.name);
        pet.setType(this.type);
        pet.setAge(this.age);
        pet.setPersonId(this.personId);
        return pet;
    }

    // Getters y setters

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
