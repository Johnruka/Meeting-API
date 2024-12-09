package se.lexicon.meetingapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.meetingapi.dto.MeetingDto;
import se.lexicon.meetingapi.entity.Meeting;
import se.lexicon.meetingapi.repository.MeetingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;

    }

    private MeetingDto toDto(Meeting meeting) {
        // Convert Entity to DTO
        return new MeetingDto(
                meeting.getId(),
                meeting.getTitle(),
                meeting.getDate(),
                meeting.getTime(),
                meeting.getLevel(),
                meeting.getLocation(),
                meeting.getStatus()

        );
    }

    // Convert DTO to Entity
    private Meeting toEntity(MeetingDto dto) {
        Meeting meeting = new Meeting();
        meeting.setId(dto.id());
        meeting.setTitle(dto.title());
        meeting.setDate(dto.date());
        meeting.setTime(dto.time());
        meeting.setLevel(dto.level());
        meeting.setLocation(dto.location());
        meeting.setStatus(dto.status());
        return meeting;
    }

    public List<MeetingDto> getAllMeetings() {
        return meetingRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    public MeetingDto getMeetingById(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitation not found with ID: " + id));
        return toDto(meeting);
    }

    public MeetingDto saveMeetingData(MeetingDto dto) {
        Meeting meeting = toEntity(dto);
        Meeting savedMeeting = meetingRepository.save(meeting);
        return toDto(savedMeeting);
    }

    public void deleteMeetingData(Long id) {
        if (!meetingRepository.existsById(id)) {
            throw new RuntimeException("Invitation not found with ID: " + id);
        }
        meetingRepository.deleteById(id);
    }

    public void updateMeetingData(Long id, String status) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meeting not found with ID: " + id));

        meeting.setTitle(meeting.getTitle());
        meeting.setDate(meeting.getDate());
        meeting.setTime(meeting.getTime());
        meeting.setLevel(meeting.getLevel());
        meeting.setLocation(meeting.getLocation());
        meeting.setStatus(meeting.getStatus());
        meetingRepository.save(meeting);
    }


}

