package net.areebamaar.journalApp.ServiceTest;


import net.areebamaar.journalApp.Repository.UserEntryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserEntryRepository userEntryRepository;

    @Disabled
    @Test
    public void testFindByusername(){
        assertNotNull(userEntryRepository.findByUserName("Adyaan"));
    }

    @ParameterizedTest
    @CsvSource({
            "Areeb",
            "Adyaan",
            "Azhaan"
    })
    public void testFindByusername1(String username){
        assertNotNull(userEntryRepository.findByUserName(username));
    }


}
