package com.tr.psdtraining.event;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.events.Event;

public class EventController {

    EventService eventService;

    @RequestMapping
    public String createEvent(@RequestBody Event event){
        return "/";
    }
}
