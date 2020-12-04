package io.pan.graphapi.demo.graph.client.delegate;

import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import io.pan.graphapi.authentication.TokenCache;
import io.pan.graphapi.authentication.request.credential.UserCredential;
import io.pan.graphapi.demo.graph.client.AuthenticationProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DelegateGraphApiProperties.class)
public class DelegateGraphClientConfiguration {

  private final UserCredential credentials;

  public DelegateGraphClientConfiguration(UserCredential credentials) {
    this.credentials = credentials;
  }

  @Bean("delegateGraphClient")
  public IGraphServiceClient graphClient() {
    return GraphServiceClient.builder()
        .authenticationProvider(
            new AuthenticationProvider(
                new TokenCache(credentials)
            )
        ).buildClient();
  }
}
