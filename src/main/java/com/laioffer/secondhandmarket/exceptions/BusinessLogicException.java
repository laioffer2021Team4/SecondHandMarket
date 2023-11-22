package com.laioffer.secondhandmarket.exceptions;

public class BusinessLogicException extends RuntimeException {

  public BusinessLogicException(String message) {
    super(message);
  }

  public BusinessLogicException(String message, Throwable cause) {
    super(message, cause);
  }
}
