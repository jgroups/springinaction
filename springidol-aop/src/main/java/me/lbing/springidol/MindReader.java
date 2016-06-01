package me.lbing.springidol;

public interface MindReader {
  void interceptThoughts(String thoughts);

  String getThoughts();
}