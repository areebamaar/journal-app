package net.areebamaar.journalApp.Service;

import net.areebamaar.journalApp.Entity.JournalEntry;
import net.areebamaar.journalApp.Entity.User;
import net.areebamaar.journalApp.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        User user= userService.findByuserName(userName);
        journalEntry.setDate(LocalDate.now());
        JournalEntry saved= journalEntryRepository.save(journalEntry);

        user.getJournalEntries().add(saved);
        userService.saveUser(user);

    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }


    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

   public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepository.findById(id);
   }




    public boolean deleteById(ObjectId myId, String username) {
        boolean removed=false;
        try {
            User user1=userService.findByuserName(username);
            removed= user1.getJournalEntries().removeIf(x->x.getId().equals(myId));
            if(removed){
                userService.saveUser(user1);
                journalEntryRepository.deleteById(myId);
            }
        }catch (Exception e){
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
        return removed;
    }
}
