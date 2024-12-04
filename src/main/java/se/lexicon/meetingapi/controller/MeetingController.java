package se.lexicon.meetingapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.meetingapi.dto.MeetingDto;
import se.lexicon.meetingapi.service.MeetingService;

import java.util.List;

public class MeetingController {
    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @ResponseStatus(HttpStatus.OK)
    public List<MeetingDto> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MeetingDto getMeetingById(@PathVariable Long id) {
        return meetingService.getMeetingById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MeetingDto> createMeeting(@RequestBody MeetingDto dto) {
        MeetingDto savedDto = meetingService.saveMeetingData(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    public ResponseEntity<Void> deleteMeetingData(@PathVariable Long id) {
        meetingService.deleteMeetingData(id);
        return ResponseEntity.noContent().build();
    }
}