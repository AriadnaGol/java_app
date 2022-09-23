package pl.cyber.trainess.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

/**
 * @author Mariusz Tański
 */

@Getter
public class IntegerRequest {

  private final Integer parametrA;

  @ConstructorProperties({"parametrA"})
  public IntegerRequest(final Integer parametrA) {
    this.parametrA = parametrA;
  }
}
