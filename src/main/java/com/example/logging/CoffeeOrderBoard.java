package com.example.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author Podvorchan Ruslan 17.02.2023
 */
@Slf4j
public class CoffeeOrderBoard {

  private int number;
  private final List<Order> orders = new ArrayList<>();

  public void add(String name) {
    number++;
    orders.add(new Order(number, name));
    log.info("Order number " + number + " added");
  }

  public void deliver() {

    if (!orders.isEmpty()) {
      log.info(
          "Order " + orders.get(0).getOrderNumber()
              + " ready");
      orders.remove(0);
    } else {
      log.error("No ready orders.");
    }

  }

  public void deliver(int number) {
    if (checkOrderNumber(number)) {
      for (Order order : orders) {
        if (order.getOrderNumber() == number) {
          log.info("Order " + number + " ready");
          orders.remove(order);
          break;
        }
      }
    } else {
      log.error("No order number - " + number);
    }
  }


  public void draw() {
    if (!orders.isEmpty()) {
      log.info("Queue status: ");
      for (Order order : orders) {
        MDC.put("number", String.valueOf(order.getOrderNumber()));
        MDC.put("name", String.valueOf(order.getName()));
        log.info(" please wait");
      }
    } else {
      log.info("No orders ");
    }
  }


  private boolean checkOrderNumber(int number) {
    return !orders.isEmpty() && orders.stream().map(Order::getOrderNumber)
        .toList().stream().anyMatch(n -> Objects.equals(n, number));
  }
}
