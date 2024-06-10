package module4.ex;

import module4.ex.common.UserConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class ExApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExApplication.class, args);
    }
    @Bean
    public UserConverter convertAccount(){
        return new UserConverter();
    }

}
