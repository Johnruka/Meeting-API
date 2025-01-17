package se.lexicon.meetingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.meetingapi.entity.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
