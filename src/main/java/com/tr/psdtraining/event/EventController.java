package com.tr.psdtraining.event;

import com.tr.psdtraining.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

    private static final String CREATE_EVENT_VIEW_NAME = "createEvent/createEvent";

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/createEvent", method = RequestMethod.POST)
    public String createEvent(@RequestBody Event event){
        eventService.save(event);
        return CREATE_EVENT_VIEW_NAME;
    }
}
