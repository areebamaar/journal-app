package net.areebamaar.journalApp.ServiceTest;

import net.areebamaar.journalApp.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
     void emailTest(){
        emailService.sendEmail("areebamaar01@gmail.com", "Testing Spring Boot Email", "Successfully Sent");
    }

}
