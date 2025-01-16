package se.lexicon.meetingapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import se.lexicon.meetingapi.entity.Meeting;
import se.lexicon.meetingapi.repository.MeetingRepository;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Meeting saveMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Optional<Meeting> findMeetingById(Long id) {
        return meetingRepository.findById(id);
    }

    @Override
    public List<Meeting> findAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting updateMeeting(Long id, Meeting meetingDetails) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Meeting not found with id: " + id));

        meeting.setTitle(meetingDetails.getTitle());
        meeting.setDate(meetingDetails.getDate());
        meeting.setStartTime(meetingDetails.getStartTime());
        meeting.setEndTime(meetingDetails.getEndTime());
        meeting.setLocation(meetingDetails.getLocation());
        meeting.setLevel(meetingDetails.getLevel());

        return meetingRepository.save(meeting);
    }

    @Override
    public void deleteMeeting(Long id) {
        if (!meetingRepository.existsById(id)) {
            throw new EntityNotFoundException("Meeting not found with id: " + id);
        }
        meetingRepository.deleteById(id);
    }
}

