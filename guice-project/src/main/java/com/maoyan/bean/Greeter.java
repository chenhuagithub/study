package com.maoyan.bean;

import com.google.inject.Inject;
import com.maoyan.myannotation.Count;
import com.maoyan.myannotation.Message;

public class Greeter {
  private String message;
  private int count;
  
  @Inject
  public Greeter() {
  
  }

  // Greeter declares that it needs a string message and an integer
  // representing the number of time the message to be printed.
  // The @Inject annotation marks this constructor as eligible to be used by
  // Guice.
  public Greeter(@Message String message, @Count int count) {
    this.message = message;
    this.count = count;
  }

  public void sayHello() {
    for (int i=0; i < count; i++) {
      System.out.println(message);
    }
  }
  
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public int getCount() {
    return count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
}
