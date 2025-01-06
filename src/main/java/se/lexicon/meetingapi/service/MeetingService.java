package se.lexicon.meetingapi.service;

import se.lexicon.meetingapi.dto.MeetingDto;

import java.util.List;

public interface MeetingService {

    MeetingDto createMeeting(MeetingDto meetingDto);

    MeetingDto getMeetingById(Long id);

    List<MeetingDto> getAllMeetings();

    MeetingDto updateMeeting(Long id, MeetingDto meetingDto);

    void deleteMeeting(Long id);

    MeetingDto saveMeeting(MeetingDto meetingDto);  // Add this line
}
