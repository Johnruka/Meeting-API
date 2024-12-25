package se.lexicon.meetingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.meetingapi.entity.AnalyticsData;
import se.lexicon.meetingapi.service.AnalyticsDataService;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsDataController {

    @Autowired
    private AnalyticsDataService service;

    @GetMapping
    public List<AnalyticsData> getAllAnalyticsData() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyticsData> getAnalyticsDataById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AnalyticsData createAnalyticsData(@RequestBody AnalyticsData analyticsData) {
        return service.save(analyticsData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalyticsData(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
