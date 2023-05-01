package com.example.UniversityEventManagement.services;

import com.example.UniversityEventManagement.models.Event;
import com.example.UniversityEventManagement.models.Student;
import com.example.UniversityEventManagement.repositories.IEventRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    IEventRepo iEventRepo;

    public Optional<Event> fetchAllEventsByDate(String date) {
        return iEventRepo.findByDate(date);
    }

    public void deleteEventById(Integer id) {
        iEventRepo.deleteById(id);
    }

    @Transactional
    public void updateLocationById(Integer id, String location) {
        iEventRepo.updateLocationById(id,location);
    }

    public String addEvents(List<Event> eventList) {
        Iterable<Event> added = iEventRepo.saveAll(eventList);
        if(added != null){
            return "Added Event successfully";
        }
        return "Failed to add Event";
    }
}
