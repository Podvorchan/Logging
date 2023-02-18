package com.example.logging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 17.02.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

  private int OrderNumber;
  private String name;

}
