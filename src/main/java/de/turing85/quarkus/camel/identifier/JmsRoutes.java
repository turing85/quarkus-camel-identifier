package de.turing85.quarkus.camel.identifier;

import io.quarkus.artemis.core.runtime.ArtemisUtil;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.jms;

public class JmsRoutes extends RouteBuilder {
  @Override
  public void configure() {
    // @formatter:off
    from(jms("default").connectionFactory(ArtemisUtil.DEFAULT_CONFIG_NAME))
        .log("body: ${body}");
    from(jms("external").connectionFactory(ConnectionFactoryProducer.EXTERNALLY_DEFINED))
        .log("body: ${body}");
    // @formatter:on
  }
}
