package la.lymd.bs14_project01;

import la.lymd.bs14_project01.services.FillDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Bs14Project01Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Bs14Project01Application.class, args);

        context.getBean(FillDatabase.class).start();
    }

}

