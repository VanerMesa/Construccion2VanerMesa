package app.adapters.inputs.utils;

import org.springframework.stereotype.Component;

@Component
public class PetValidator extends SimpleValidator{
	
	public String petNameValidator(String value) throws Exception{
		return stringValidator(value, " nombre de mascota ");
	}
	public int ageValidator(String value) throws Exception {
        return intValidator(value, " edad ");
    }

}