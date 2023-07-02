package com.geeks.university.controller;

import com.geeks.university.model.Event;
import com.geeks.university.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController

public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("events")  // get aa events
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    // get by date
    @GetMapping("event/{date}")
    public List<Event> getEventByDate(@PathVariable LocalDate date){
        return eventService.getEventByDate(date);
    }

    // add eventss
    @PostMapping("addEvents")
    public String addEvent(@RequestBody List<Event> events) {
        return eventService.addEvent(events);
    }

    // update event by id
    @PutMapping("event/{id}/{location}")
    public String updateEventById(@PathVariable Integer id,@PathVariable String location){
        return eventService.updateEventById(id,location);
    }

    @DeleteMapping("event/{Id}")
    public String deleteEventById(@PathVariable Integer Id){
        return eventService.deleteEventById(Id);
    }
}
