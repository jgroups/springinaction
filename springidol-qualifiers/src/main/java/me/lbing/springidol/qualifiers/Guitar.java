package me.lbing.springidol.qualifiers;

import me.lbing.springidol.Instrument;

@StringedInstrument
@Strummed
public class Guitar implements Instrument {
  public void play() {
    System.out.println("Strum strum strum");
  }
}
