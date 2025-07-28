package de.turing85.quarkus.camel.identifier;

import jakarta.enterprise.inject.Produces;
import jakarta.jms.ConnectionFactory;

import io.quarkus.arc.Unremovable;
import io.smallrye.common.annotation.Identifier;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class ConnectionFactoryProducer {
  public static final String EXTERNALLY_DEFINED = "externally-defined";

  @Produces
  @Identifier(EXTERNALLY_DEFINED)
  @Unremovable
  public ConnectionFactory createConnectionFactory(
      @ConfigProperty(name = "quarkus.artemis.url") String url) {
    return new ActiveMQConnectionFactory(url);
  }
}
