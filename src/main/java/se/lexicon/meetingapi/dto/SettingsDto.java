package se.lexicon.meetingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SettingsDto(

        Long id, @NotBlank(message = "Settings are required")

        @NotBlank(message = "defaultView is required")
        @Pattern(
                regexp = "day|week|month",
                message = "defaultView must be 'day','week', 'month'"
        )
        String defaultView,

         @NotBlank(message = "TimeZone is required")
         @Pattern(
                 regexp = "UTC|EST|PST|MST|CST|GMT",
                 message = "TimeZone must be 'UTC', 'EST', 'PST', 'MST', 'CST', 'GMT'"
         )
                 String timeZone,

                 @NotBlank(message = "startOfTheWeek is required")
                 @Pattern(
                         regexp = "sunday|monday",
                         message = "startOfTheWeek must be 'sunday','monday'"
                 )
                         String startOfTheWeek


) {
}
