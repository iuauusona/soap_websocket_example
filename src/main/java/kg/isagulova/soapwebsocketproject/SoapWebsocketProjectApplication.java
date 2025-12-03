package kg.isagulova.soapwebsocketproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapWebsocketProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWebsocketProjectApplication.class, args);
        //после запуска перейдем на http://localhost:8080/ws/greeting.wsdl
    }

}
