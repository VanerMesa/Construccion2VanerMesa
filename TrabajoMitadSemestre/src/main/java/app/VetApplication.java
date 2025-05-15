package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import app.adapters.inputs.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.ListableBeanFactory;

@SpringBootApplication
@ComponentScan(basePackages = "app")
@EnableJpaRepositories(basePackages = {"app.adapters.user.repository","app.adapters.persons.repository", "app.adapters.pets.repository"})
@EntityScan(basePackages = {
    "app.adapters.user.entity",
    "app.adapters.persons.entity", "app.adapters.pets.entity" 
})
public class VetApplication implements CommandLineRunner {

    @Autowired
    private LoginInput loginInput;

    @Autowired
    private ListableBeanFactory beanFactory;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Beans registrados en la aplicación:");
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        loginInput.menu();
    }

    public static void main(String[] args) {
        SpringApplication.run(VetApplication.class, args);
    }
}
