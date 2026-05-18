package com.taskTracker.ai.service;
import org.springframework.stereotype.Service;
@Service
public class WekaSearchService {

    public boolean searchSimilarDescription(String input) {

        return input.toLowerCase().contains("task");
    }
}