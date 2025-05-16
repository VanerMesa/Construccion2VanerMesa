package app.domain.services;

import app.domain.models.Person;
import app.domain.models.User;
import app.ports.PersonPort;
import app.ports.UserPort;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService {

    @Autowired
    private PersonPort personPort;

    @Autowired
    private UserPort userPort;

    // Lista de roles válidos que puede registrar un administrador
    private final List<String> validRoles = Arrays.asList("administrador", "veterinario", "vendedor", "dueño");

    /**
     * Registra una persona con usuario (veterinario, vendedor, administrador)
     */
    public void registerPerson(User user) throws Exception {
        if (!validRoles.contains(user.getRole().toLowerCase())) {
            throw new Exception("Rol inválido. Debe ser uno de: " + validRoles);
        }

        if (personPort.existPerson(user.getDocument())) {
            throw new Exception("Ya existe una persona con esa cédula.");
        }

        if (userPort.existUserName(user.getUserName())) {
            throw new Exception("Ya existe ese nombre de usuario registrado.");
        }

        // Guardar persona y usuario
        Person person = new Person();
        person.setDocument(user.getDocument());
        person.setName(user.getName());
        person.setAge(user.getAge());
        person.setRole(user.getRole());

        personPort.savePerson(person);
        userPort.saveUser(user);

        System.out.println("Usuario registrado exitosamente: " + user.getUserName());
    }

    /**
     * Registra un dueño sin usuario (solo persona)
     */
    public void registerOwner(Person person) throws Exception {
        if (!"dueño".equalsIgnoreCase(person.getRole())) {
            throw new Exception("Solo se pueden registrar personas con rol 'dueño' en este método.");
        }

        if (personPort.existPerson(person.getDocument())) {
            throw new Exception("Ya existe una persona con esa cédula.");
        }

        personPort.savePerson(person);
        System.out.println("Dueño registrado exitosamente: " + person.getName());
    }
}
