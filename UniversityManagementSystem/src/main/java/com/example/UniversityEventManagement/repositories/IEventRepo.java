package com.example.UniversityEventManagement.repositories;

import com.example.UniversityEventManagement.models.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEventRepo extends CrudRepository<Event,Integer> {

//    custom finder
    public Optional<Event> findByDate(String date);

    @Modifying
    @Query(value = "update event set location_of_event =:locationOfEvent where event_Id =:id",nativeQuery = true)
    public void updateLocationById(Integer id, String locationOfEvent);
}