package me.lbing.springidol;

public class Magician implements MindReader {
  private String thoughts;

  public void interceptThoughts(String thoughts) {
    System.out.println("Intercepting volunteer's thoughts:"+thoughts);
    this.thoughts = thoughts;
  }

  public String getThoughts() {
    return thoughts;
  }
}