package io.pan.graphapi.demo.event;

import java.time.LocalDateTime;

public class Event {

  private final String subject;
  private final String description;
  private final LocalDateTime start;
  private final LocalDateTime end;

  public Event(String subject, String description, LocalDateTime start, LocalDateTime end) {
    this.subject = subject;
    this.description = description;
    this.start = start;
    this.end = end;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getStart() {
    return start;
  }

  public LocalDateTime getEnd() {
    return end;
  }
}
