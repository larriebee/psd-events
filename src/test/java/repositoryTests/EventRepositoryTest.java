package repositoryTests;

import com.tr.psdtraining.config.ApplicationConfig;
import com.tr.psdtraining.domain.Event;
import com.tr.psdtraining.domain.User;
import com.tr.psdtraining.event.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Made by kristopherstevens n dave lol, on 22/06/2016.
 */

@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = {
    ApplicationConfig.class
})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;

    @Test
    public void testSaveEventWithOwner() {
        Event event = new Event("loc", new Date(), new User("yo", "email"), "deets");
        eventRepository.save(event);
        Event retrievedEvent = eventRepository.getOne(event.getId());
        final String retrievedName = retrievedEvent.getOwner().getName();


        assertThat(event.getId(), is(retrievedEvent.getId()));
        assertThat(event.getOwner().getName(), is(retrievedName));
    }

}
