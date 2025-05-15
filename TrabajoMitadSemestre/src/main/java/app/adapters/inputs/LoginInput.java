package app.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.User;
import app.domain.services.LoginService;
import app.ports.InputPort;

@Component
public class LoginInput implements InputPort {

    @Autowired
    @Lazy // Precaución adicional por si surgen otras dependencias cíclicas
    private RoleInputFactory roleInputFactory;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private LoginService loginService;

    private final String MENU = "Ingrese la opción que desea:\n 1. Iniciar sesión \n 2. Salir";

    @Override
    public void menu() throws Exception {
        boolean sesion = true;
        while (sesion) {
            sesion = options();
        }
    }

    private boolean options() throws Exception {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            switch (option){
                case "1":
                    this.login();
                    return true;
                case "2":
                    System.out.println("Hasta una próxima ocasión.");
                    return false;
                default:
                    System.out.println("Ha elegido una opción inválida.");
                    return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }

    private void login() {
        try {
            System.out.println("Ingrese su usuario:");
            String userName = userValidator.userNameValidator(Utils.getReader().nextLine());

            System.out.println("Ingrese su contraseña:");
            String password = userValidator.passwordValidator(Utils.getReader().nextLine());

            User user = new User();
            user.setName(userName);
            user.setPassword(password);

            user = loginService.login(user);
            InputPort inputPort = roleInputFactory.getByRole(user.getRole().toLowerCase());

            if (inputPort != null) {
                inputPort.menu();
            } else {
                System.out.println("Rol no reconocido o sin permisos de acceso.");
            }

        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
    }
}
