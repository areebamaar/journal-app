package net.areebamaar.journalApp.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.areebamaar.journalApp.Enum.Sentiment;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDate date;
    private Sentiment sentiment;


}
