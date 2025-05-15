package app.adapters.inputs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import app.ports.InputPort;

@Component
public class RoleInputFactory {

    private final Map<String, InputPort> roleMap = new HashMap<>();

    public RoleInputFactory(List<InputPort> inputPorts) {
        for (InputPort input : inputPorts) {
            // Evita incluir LoginInput para romper la dependencia circular
            if (input instanceof LoginInput) {
                continue;
            }
            if (input instanceof AdminInput) {
                roleMap.put("admin", input);
            } else if (input instanceof VetInput) {
                roleMap.put("veterinario", input);
            } else if (input instanceof SellerInput) {
                roleMap.put("vendedor", input);
            }
        }
    }

    public InputPort getByRole(String role) {
        return roleMap.get(role.toLowerCase());
    }
}
