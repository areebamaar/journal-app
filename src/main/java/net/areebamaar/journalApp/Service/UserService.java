package net.areebamaar.journalApp.Service;

import lombok.extern.slf4j.Slf4j;
import net.areebamaar.journalApp.Entity.User;
import net.areebamaar.journalApp.Repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserEntryRepository userEntryRepository;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userEntryRepository.save(user);
    }

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList("USER"));
        userEntryRepository.save(user);
    }
    public void saveUser(User user) {
        userEntryRepository.save(user);
    }


    public List<User> getAll(){
        return userEntryRepository.findAll();
    }

    public Optional<User> getById(ObjectId id){
        return userEntryRepository.findById(id);
    }

    public void deleteEntry(ObjectId id){
        userEntryRepository.deleteById((id));
    }

    public User findByuserName(String username){
        return userEntryRepository.findByUserName(username);
    }
}
