package se.lexicon.meetingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.meetingapi.entity.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Long> {
}
