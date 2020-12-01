package io.pan.graphapi.demo.graph.client.application;

import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import io.pan.graphapi.authentication.TokenCache;
import io.pan.graphapi.authentication.request.credential.ApplicationCredential;
import io.pan.graphapi.demo.graph.client.AuthenticationProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApplicationGraphApiProperties.class)
public class ApplicationGraphClientConfiguration {

  private final ApplicationCredential credentials;

  public ApplicationGraphClientConfiguration(ApplicationCredential credentials) {
    this.credentials = credentials;
  }

  @Bean
  public IGraphServiceClient graphClient() {
    return GraphServiceClient.builder()
        .authenticationProvider(
            new AuthenticationProvider(
                new TokenCache(credentials)
            )
        )
        .buildClient();
  }
}
