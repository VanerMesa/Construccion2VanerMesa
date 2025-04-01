package app.domain.services;

import app.domain.models.*;
import app.ports.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class AdminService {
    @Autowired
    private PersonPort personPort;
    @Autowired
    private UserPort userPort;

    public void registerDoctor(User doctor) throws Exception {
        if (personPort.existsByDocument(doctor.getDocument())) {
            throw new Exception("Ya existe una persona con esa cédula");
        }
        if (userPort.existsByUserName(doctor.getUsername())) {
            throw new Exception("Ya existe ese usuario registrado");
        }
        personPort.savePerson(doctor);
        userPort.saveUser(doctor);
    }
}