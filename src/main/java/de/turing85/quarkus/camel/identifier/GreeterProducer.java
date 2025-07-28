package de.turing85.quarkus.camel.identifier;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.Identifier;

public class GreeterProducer {
  public static final String NAME_HELLO_GREETER = "hello-greeter";

  @Produces
  @Singleton
  @Identifier(NAME_HELLO_GREETER)
  public Greeter helloGreeter() {
    Log.info("Hello greeter initialized");
    return new HelloGreeter();
  }
}
