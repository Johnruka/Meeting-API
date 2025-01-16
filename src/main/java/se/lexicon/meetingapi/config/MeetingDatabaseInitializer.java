package se.lexicon.meetingapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.meetingapi.entity.Meeting;
import se.lexicon.meetingapi.repository.MeetingRepository;

@Configuration
public class MeetingDatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(MeetingRepository meetingRepository) {
        return args -> {
            if (meetingRepository.count() == 0) { // Check if the database is already initialized
                meetingRepository.save(new Meeting("Morning Meeting", "2024-12-25", "10:00 AM", "12:30 PM", "Zoom", "team"));
                meetingRepository.save(new Meeting("Lecture", "2024-12-26", "2:00 PM", "4:00 PM", "Classroom", "department"));
                meetingRepository.save(new Meeting("Class Meeting", "2024-12-28", "1:00 PM", "4:00 PM", "Main hall", "company"));
                meetingRepository.save(new Meeting("Weekly Meeting", "2024-12-28", "1:00 PM", "3:00 PM", "Main Office", "company"));
                meetingRepository.save(new Meeting("Evening Meeting", "2024-12-30", "11:00 AM", "11:45 AM", "Meeting room", "team"));
                meetingRepository.save(new Meeting("Monthly Meeting", "2024-12-16", "10:00 AM", "11:30 AM", "Main hall", "department"));

                System.out.println("Database initialized with meeting data.");
            } else {
                System.out.println("Database already initialized. No action taken.");
            }
        };
    }
}


