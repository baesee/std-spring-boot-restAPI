package com.billlog.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping
    public ResponseEntity createEvent(@RequestBody Event event){
        Event newEvnet = eventRepository.save(event);
        URI createdUri = linkTo(EventController.class).slash(newEvnet.getId()).toUri();
        return ResponseEntity.created(createdUri).body(event);
    }
}
