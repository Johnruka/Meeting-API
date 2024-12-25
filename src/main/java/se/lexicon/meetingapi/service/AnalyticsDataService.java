package se.lexicon.meetingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.meetingapi.entity.AnalyticsData;
import se.lexicon.meetingapi.repository.AnalyticsDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyticsDataService {

    @Autowired
    private AnalyticsDataRepository repository;

    public List<AnalyticsData> findAll() {
        return repository.findAll();
    }

    public Optional<AnalyticsData> findById(Long id) {
        return repository.findById(id);
    }

    public AnalyticsData save(AnalyticsData analyticsData) {
        return repository.save(analyticsData);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
