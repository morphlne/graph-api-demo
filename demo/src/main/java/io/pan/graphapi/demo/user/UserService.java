package io.pan.graphapi.demo.user;

import com.microsoft.graph.models.extensions.IGraphServiceClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements Users {

  private final IGraphServiceClient graphClient;

  public UserService(IGraphServiceClient applicationGraphClient) {
    this.graphClient = applicationGraphClient;
  }

  @Override
  public List<User> all() {
    return graphUsers().stream()
        .map(user -> new User(user.displayName, user.id))
        .collect(Collectors.toList());
  }

  private List<com.microsoft.graph.models.extensions.User> graphUsers() {
    return graphClient.users().buildRequest().get().getCurrentPage();
  }
}
