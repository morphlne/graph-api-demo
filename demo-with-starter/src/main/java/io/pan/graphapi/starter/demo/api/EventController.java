package io.pan.graphapi.starter.demo.api;

import io.pan.graphapi.starter.demo.event.Event;
import io.pan.graphapi.starter.demo.event.Events;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

  private final Events events;

  public EventController(Events events) {
    this.events = events;
  }

  @GetMapping
  public List<Event> events() {
    return events.all();
  }
}
