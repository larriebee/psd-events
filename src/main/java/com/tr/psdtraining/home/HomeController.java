package com.tr.psdtraining.home;

import java.security.Principal;

import com.tr.psdtraining.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private static final String EVENTS = "events";

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
        model.addAttribute(EVENTS, eventService.findAll());
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
