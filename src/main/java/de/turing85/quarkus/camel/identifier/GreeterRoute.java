package de.turing85.quarkus.camel.identifier;

import java.util.Objects;

import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.platformHttp;

public class GreeterRoute extends RouteBuilder {
  public static final String HTTP_PATH = "/hello";
  public static final String ROUTE_ID = "hello";

  @Override
  public void configure() {
    // @formatter:off
    from(
        platformHttp(HTTP_PATH)
            .httpMethodRestrict("GET"))
        .id(ROUTE_ID)
        .setBody(exchange -> Objects.requireNonNull(exchange.getContext().getRegistry()
                .findByTypeWithName(Greeter.class)
                .get(GreeterProducer.NAME_HELLO_GREETER))
            .greet());
    // @formatter:on
  }
}
