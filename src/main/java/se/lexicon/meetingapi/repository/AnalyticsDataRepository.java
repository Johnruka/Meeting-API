package se.lexicon.meetingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.meetingapi.entity.AnalyticsData;

public interface AnalyticsDataRepository extends JpaRepository<AnalyticsData, Long> {
}
