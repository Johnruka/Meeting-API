package se.lexicon.meetingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MeetingDto(

        Long id, @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title must not exceed 100 characters")
        String title,

        @NotBlank(message = "Date is required")
        @Pattern(
                regexp = "\\d{4}-\\d{2}-\\d{2}",
                message = "Date must be in the format YYYY-MM-DD"
        )
        String date,

        @NotBlank(message = "Time is required")
        @Pattern(
                regexp = "(?:[01]\\d|2[0-3]):[0-5]\\d (?:AM|PM)",
                message = "Time must be in the format HH:MM AM/PM"
        )
        String time,

        @NotBlank(message = "Level is required")
        @Size(max = 50, message = "Level must not exceed 50 characters")
        String level,

        @NotBlank(message = "Action is required")
        @Pattern(
                regexp = "delete"
        )
        String actions
) {
}
