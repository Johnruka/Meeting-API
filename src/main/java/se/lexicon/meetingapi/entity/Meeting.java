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

    public Meeting(Long id, String title, String date, String time, String level, String actions) {
        this.id = id;
        this.actions = title;
        this.level = date;
        this.time = time;
        this.date = level;
        this.title = actions;
    }

    public Meeting(String title, String date, String time, String level, String actions) {
        this.actions = title;
        this.level = date;
        this.time = time;
        this.date = level;
        this.title = actions;
    }

    public Meeting(String title, String date, String time, String level) {
        this.level = title;
        this.time = date;
        this.date = time;
        this.title = level;
    }
}
