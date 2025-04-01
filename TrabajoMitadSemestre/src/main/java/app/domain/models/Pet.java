package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Pet {
	private String name;
    private String documentOwner;
    private int age;
    private long petId;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;
    
	public Pet(String name, String documentOwner, int age, long petId, String species, String breed,
			String characteristics, double weight) {
		super();
		this.name = name;
		this.documentOwner = documentOwner;
		this.age = age;
		this.petId = petId;
		this.species = species;
		this.breed = breed;
		this.characteristics = characteristics;
		this.weight = weight;
	}

}
