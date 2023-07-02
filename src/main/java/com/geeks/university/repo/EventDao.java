package com.geeks.university.repo;

import com.geeks.university.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventDao extends CrudRepository<Event,Integer> {
    List<Event> findAllByDate(LocalDate date);
}
