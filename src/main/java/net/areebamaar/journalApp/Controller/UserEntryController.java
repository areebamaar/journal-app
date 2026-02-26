package net.areebamaar.journalApp.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.areebamaar.journalApp.Dto.UserDto;
import net.areebamaar.journalApp.Entity.User;
import net.areebamaar.journalApp.Repository.UserEntryRepository;
import net.areebamaar.journalApp.Service.UserService;
import net.areebamaar.journalApp.Service.WeatherApiService;
import net.areebamaar.journalApp.api.response.WeatherResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User Controller", description = "used for update, delete and greet user")
public class UserEntryController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntryRepository userEntryRepository;

    @Autowired
    private WeatherApiService weatherApiService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDto user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByuserName(userName);

        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(ObjectId id) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            userEntryRepository.deleteByUserName(authentication.getName());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

        WeatherResponse weatherResponse= weatherApiService.getWeather("New York");

        String greet="";

        if(weatherResponse !=null){
            greet=" Weather feels like "+weatherResponse.getCurrent().getFeelslike();
        }
    return new ResponseEntity<>("Hi "+authentication.getName()+greet, HttpStatus.OK);
    }


}
