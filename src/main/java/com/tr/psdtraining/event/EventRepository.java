package com.tr.psdtraining.event;

import com.tr.psdtraining.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event getOne(Long var1);
	List<Event> findAll();
	Event save(Event newEvent);
}
