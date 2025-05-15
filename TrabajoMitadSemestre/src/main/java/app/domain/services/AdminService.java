package app.domain.services;

import app.domain.models.User;
import app.ports.PersonPort;
import app.ports.UserPort;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService {
   
    @Autowired
    private PersonPort personPort;
    @Autowired
    private UserPort userPort;
    
    public void registerPerson(User user)throws Exception{
        if (personPort.existPerson(user.getDocument())){
            throw new Exception("ya existe una persona con esa cedula");
        }
        if (userPort.existUserName(user.getUserName())){
            throw new Exception("ya existe ese username registrado");
        }        
        
        userPort.saveUser(user);
    
    }
 }