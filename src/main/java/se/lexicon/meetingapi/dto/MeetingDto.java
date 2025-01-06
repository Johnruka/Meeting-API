package se.lexicon.meetingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDto {

        private Long id;

        @NotBlank(message = "Title is required")
        private String title;

        @NotBlank(message = "Date is required")
        private String date;

        @NotBlank(message = "Start time is required")
        private String startTime;

        @NotBlank(message = "End time is required")
        private String endTime;

        @NotBlank(message = "Location is required")
        private String location;

        @NotBlank(message = "Level is required")
        @Pattern(regexp = "team|company|department", message = "Level must be 'team', 'company', or 'department'")
        private String level;
}


