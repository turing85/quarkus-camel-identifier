package de.turing85.quarkus.camel.identifier;

public class HelloGreeter implements Greeter {
  @Override
  public String greet() {
    return "Hello";
  }
}
