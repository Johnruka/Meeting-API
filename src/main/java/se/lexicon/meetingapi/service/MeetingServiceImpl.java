package se.lexicon.meetingapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lexicon.meetingapi.config.ResourceNotFoundException;
import se.lexicon.meetingapi.dto.MeetingDto;
import se.lexicon.meetingapi.entity.Meeting;
import se.lexicon.meetingapi.repository.MeetingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    @Override
    public MeetingDto createMeeting(MeetingDto meetingDto) {
        Meeting meeting = mapToEntity(meetingDto);
        Meeting savedMeeting = meetingRepository.save(meeting);
        return mapToDto(savedMeeting);
    }

    @Override
    public MeetingDto getMeetingById(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting not found with id: " + id));
        return mapToDto(meeting);
    }

    @Override
    public List<MeetingDto> getAllMeetings() {
        return meetingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MeetingDto updateMeeting(Long id, MeetingDto meetingDto) {
        Meeting existingMeeting = meetingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting not found with id: " + id));

        existingMeeting.setTitle(meetingDto.getTitle());
        existingMeeting.setDate(meetingDto.getDate());
        existingMeeting.setStartTime(meetingDto.getStartTime());
        existingMeeting.setEndTime(meetingDto.getEndTime());
        existingMeeting.setLocation(meetingDto.getLocation());
        existingMeeting.setLevel(meetingDto.getLevel());

        Meeting updatedMeeting = meetingRepository.save(existingMeeting);
        return mapToDto(updatedMeeting);
    }

    @Override
    public void deleteMeeting(Long id) {
        Meeting existingMeeting = meetingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting not found with id: " + id));
        meetingRepository.delete(existingMeeting);

    }

    @Override
    public MeetingDto saveMeeting(MeetingDto meetingDto) {
        // Check if the meeting already exists (update)
        if (meetingDto.getId() != null) {
            Optional<Meeting> optionalMeeting = meetingRepository.findById(meetingDto.getId());
            if (optionalMeeting.isPresent()) {
                Meeting existingMeeting = optionalMeeting.get();
                existingMeeting.setTitle(meetingDto.getTitle());
                existingMeeting.setDate(meetingDto.getDate());
                existingMeeting.setStartTime(meetingDto.getStartTime());
                existingMeeting.setEndTime(meetingDto.getEndTime());
                existingMeeting.setLocation(meetingDto.getLocation());
                existingMeeting.setLevel(meetingDto.getLevel());
                Meeting updatedMeeting = meetingRepository.save(existingMeeting);
                return mapToDto(updatedMeeting);
            }
        }
        // Create a new meeting
        Meeting meeting = mapToEntity(meetingDto);
        Meeting newMeeting = meetingRepository.save(meeting);
        return mapToDto(newMeeting);
    }


    private MeetingDto mapToDto(Meeting meeting) {
        return new MeetingDto(
                meeting.getId(),
                meeting.getTitle(),
                meeting.getDate(),
                meeting.getStartTime(),
                meeting.getEndTime(),
                meeting.getLocation(),
                meeting.getLevel()
        );
    }

    private Meeting mapToEntity(MeetingDto meetingDto) {
        return new Meeting(
                meetingDto.getTitle(),
                meetingDto.getDate(),
                meetingDto.getStartTime(),
                meetingDto.getEndTime(),
                meetingDto.getLocation(),
                meetingDto.getLevel()
        );
    }
}

