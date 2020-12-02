package io.pan.graphapi.demo.event;

import com.microsoft.graph.models.extensions.IGraphServiceClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService implements Events {

  private final IGraphServiceClient graphClient;

  public EventService(IGraphServiceClient delegateGraphClient) {
    this.graphClient = delegateGraphClient;
  }

  @Override
  public List<Event> all() {
    return graphEvents().stream()
        .map(this::toEvent)
        .collect(Collectors.toList());
  }

  private List<com.microsoft.graph.models.extensions.Event> graphEvents() {
    return graphClient.me().events().buildRequest().get().getCurrentPage();
  }

  private Event toEvent(com.microsoft.graph.models.extensions.Event event) {
    return new Event(
        event.subject,
        event.bodyPreview,
        LocalDateTime.parse(event.start.dateTime),
        LocalDateTime.parse(event.end.dateTime)
    );
  }
}
