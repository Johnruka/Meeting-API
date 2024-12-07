package se.lexicon.meetingapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String date;
    private String time;
    private String level;
    private String actions;

    public Meeting(String title, String date, String time, String level, String actions) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.level = level;
        this.actions = actions;
    }

    public Meeting(String title, String date, String time, String level) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.level = level;
    }
}

