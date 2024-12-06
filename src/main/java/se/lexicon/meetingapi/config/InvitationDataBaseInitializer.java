package se.lexicon.meetingapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.meetingapi.entity.Invitation;
import se.lexicon.meetingapi.repository.InvitationRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class InvitationDataBaseInitializer {

    private final InvitationRepository invitationRepository;

    public InvitationDataBaseInitializer(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    @PostConstruct
    public void initializeDatabase() {
        List<Invitation> invitations = Arrays.asList(
                new Invitation("Team Meeting", "2024-12-05", "10:00 AM", "Zoom", "pending"),
                new Invitation("Client Call", "2024-12-06", "2:00 PM", "Microsoft Teams", "accepted"),
                new Invitation("Project Review", "2024-12-07", "3:30 PM", "Office - Room 301", "declined"),
                new Invitation("Weekly Sync", "2024-12-08", "11:00 AM", "Zoom", "pending"),
                new Invitation("Sprint Planning", "2024-12-09", "1:00 PM", "Google Meet", "pending"),
                new Invitation("One-on-One", "2024-12-10", "4:00 PM", "Office - Room 101", "pending")
        );

        // Save all invitations to the database
        invitationRepository.saveAll(invitations);
        System.out.println("Database initialized with invitation data.");
    }
}
