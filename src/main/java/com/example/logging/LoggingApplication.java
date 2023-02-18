package com.example.logging;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LoggingApplication {

  CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

  public static void main(String[] args) {
    SpringApplication.run(LoggingApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void start() {

    coffeeOrderBoard.draw();
    coffeeOrderBoard.deliver(1);
    coffeeOrderBoard.add("Ruslan");
    coffeeOrderBoard.add("Nadiya");
    coffeeOrderBoard.deliver();
    coffeeOrderBoard.deliver(2);
    coffeeOrderBoard.draw();
  }

}
