package se.lexicon.meetingapi.service;

import se.lexicon.meetingapi.entity.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetingService {

    Meeting saveMeeting(Meeting meeting);
    Optional<Meeting> findMeetingById(Long id);
    List<Meeting> findAllMeetings();
    Meeting updateMeeting(Long id, Meeting meeting);
    void deleteMeeting(Long id);
}