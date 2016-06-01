package me.lbing.springidol.qualifiers;

import me.lbing.springidol.Instrument;

@StringedInstrument
public class HammeredDulcimer implements Instrument {
  public void play() {
    System.out.println("Ting ting ting");
  }
}
