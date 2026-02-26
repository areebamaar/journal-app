package net.areebamaar.journalApp.SchedulerTest;

import net.areebamaar.journalApp.Scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTests {

    @Autowired
    private UserScheduler userScheduler;

    @Test
    public void setUserScheduler(){
        userScheduler.fetchUserAndSendSaMail();
    }
}
