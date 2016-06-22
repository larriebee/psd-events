package com.tr.psdtraining.event;

import com.tr.psdtraining.domain.Event;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

	@InjectMocks
	private EventService eventService;

	@Mock
	private EventRepository eventRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldPersistEvent() {
		final Event event = new Event("Nandos", new Date(), null, "get in muh BELLAY");

		when(eventRepository.save(event)).thenReturn(event);

		Event actualEvent = eventService.save(event);

		assertThat(actualEvent).isNotNull();
		assertThat(actualEvent).isEqualTo(event);
	}

	@Test
	public void shouldThrowError() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Event must not be null");

		eventService.save(null);
	}
}
