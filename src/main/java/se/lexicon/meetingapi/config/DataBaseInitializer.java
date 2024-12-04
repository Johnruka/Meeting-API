package se.lexicon.meetingapi.config;

import org.springframework.stereotype.Component;
import se.lexicon.meetingapi.entity.Meeting;
import se.lexicon.meetingapi.repository.MeetingRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DataBaseInitializer {

    private final MeetingRepository meetingRepository;

    public DataBaseInitializer(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public void initializeDatabase() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("Morning Meeting", "2024-12-25", "10:00 AM", "Team"),
                new Meeting("Lecture", "2024-12-26", "2:00 PM", "company"),
                new Meeting("Weekly Meeting", "2024-12-28", "1:00 PM", "Team"),
                new Meeting("One-on-one", "2024-12-30", "11:00 AM", "company"),
                new Meeting("Monthly Meeting", "2024-12-16", "10:00 AM", "Team")
        );

        // Save all meetings to the database
        meetingRepository.saveAll(meetings);
        System.out.println("Database initialized with meeting data.");
    }
}
