package com.tr.psdtraining.event;

import com.google.common.collect.ImmutableList;
import com.tr.psdtraining.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;

	private static List<Event> testEvents = ImmutableList.of(
			new Event("Nandos", new Date(), null, "get in muh BELLAY"),
			new Event("KFC", new Date(), null, "finger lickin' good"),
			new Event("Chicken Cottage", new Date(), null, "kentucky fried rat"));

	@PostConstruct
	protected void initialize() {
		for (final Event event : testEvents) {
			save(event);
		}
	}

	@Transactional
	public Event save(Event event) {
		eventRepository.save(event);
		return event;
	}

	@Transactional(readOnly = true)
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

}
