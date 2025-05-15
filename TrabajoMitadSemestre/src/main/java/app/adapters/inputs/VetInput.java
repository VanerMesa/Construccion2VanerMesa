package app.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.Person;
import app.domain.services.VetService;
import app.ports.InputPort;

@Component
public class VetInput implements InputPort {

    @Autowired
    private PersonValidator personValidator;

    @Autowired
    private VetService vetService;

    private final String MENU = "Ingrese la opción:\n"
            + "1. Registrar dueño de mascota\n"
            + "2. Registrar mascota\n"
            + "3. Registrar historia clínica\n"
            + "4. Cerrar sesión";

    @Override
    public void menu() {
        boolean sesion = true;
        while (sesion) {
            sesion = options();
        }
    }

    private boolean options() {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            switch (option) {
                case "1":
                    this.createOwner();
                    return true;
                case "4":
                    System.out.println("Se ha cerrado la sesión.");
                    return false;
                default:
                    System.out.println("Opción no válida.");
                    return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }

    private void createOwner() throws Exception {
        System.out.println("Ingrese el nombre:");
        String name = personValidator.nameValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese el documento:");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese la edad:");
        int age = personValidator.ageValidator(Utils.getReader().nextLine());

        String role = "dueño"; // Solo se puede crear dueños desde el rol de veterinario

        Person person = new Person();
        person.setDocument(document);
        person.setName(name);
        person.setAge(age);
        person.setRole(role);

        vetService.registerPerson(person);
        System.out.println("Dueño registrado exitosamente.");
    }
}