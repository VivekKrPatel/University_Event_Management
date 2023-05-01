package com.example.UniversityEventManagement.controllers;

import com.example.UniversityEventManagement.models.Event;
import com.example.UniversityEventManagement.models.Student;
import com.example.UniversityEventManagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService eventService;

//    Add event
    @PostMapping(value = "/events")
    public String addEvents(@RequestBody List<Event> eventList) {
        return eventService.addEvents(eventList);
    }

    //    Update event
    @PutMapping(value = "/byId/{id}/location/{location}")
    public void updateLocationById(@PathVariable Integer id,@PathVariable String location){
        eventService.updateLocationById(id,location);
    }

    //    Delete event
    @DeleteMapping(value = "/event/byId/{Id}")
    public void deleteById(@PathVariable Integer Id){
        eventService.deleteEventById(Id);
    }

    //    Get All events by date
    @GetMapping(value = "/events/all/byDate/{date}")
    public Optional<Event> getAllEvents(@PathVariable String date){
        return eventService.fetchAllEventsByDate(date);
    }
}
