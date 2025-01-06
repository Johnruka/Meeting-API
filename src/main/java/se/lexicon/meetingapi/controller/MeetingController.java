package se.lexicon.meetingapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.meetingapi.dto.MeetingDto;
import se.lexicon.meetingapi.service.MeetingService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/meetings")
@CrossOrigin(origins = "http://localhost:5173")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MeetingDto> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MeetingDto getMeetingById(@PathVariable Long id) {
        return meetingService.getMeetingById(id);
    }

    @PostMapping
    public ResponseEntity<MeetingDto> createMeeting(@Valid @RequestBody MeetingDto dto) {
        MeetingDto savedDto = meetingService.saveMeeting(dto); // Utilize saveMeeting for creation
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingDto> updateMeeting(
            @PathVariable Long id,
            @Valid @RequestBody MeetingDto dto) {
        MeetingDto updatedDto = meetingService.updateMeeting(id, dto); // Pass entire DTO
        return ResponseEntity.ok(updatedDto); // Returning updated entity with 200 OK
    }
}

