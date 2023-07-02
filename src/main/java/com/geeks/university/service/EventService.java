package com.geeks.university.service;

import com.geeks.university.model.Event;
import com.geeks.university.repo.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventDao eventDao;

    public List<Event> getEventByDate(LocalDate localDate) {
        return eventDao.findAllByDate(localDate);
    }

    public String addEvent(List<Event> events) {
        eventDao.saveAll(events);
        return "Added successfully";
    }

    public String updateEvent(Event event) {
        if(eventDao.existsById(event.getEventId())){
            eventDao.save(event);
            return "Updated successfully";
        }
        return "No Event to update like this,you can add new event with this Id ";
    }




    public String deleteEventById(int eventId) {
        if(eventDao.existsById(eventId)){
            eventDao.deleteById(eventId);
            return "Deleted successfully";
        }
        return "No Event to delete with this eventId like this ";

    }

    public Iterable<Event> getAllEvent() {
        return eventDao.findAll();
    }


    public String updateEventById(Integer id, String location) {
        Optional<Event> eventOptional = eventDao.findById(id);
        Event event =  eventOptional.get();
        if(event==null){
            return "event not found for id "+id;

        }
        event.setLocationOfEvent(location);
        eventDao.save(event);
        return "event updated successfully for event id "+id;

    }
}
