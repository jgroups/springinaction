package me.lbing.springidol.qualifiers;

import me.lbing.springidol.Instrument;
import me.lbing.springidol.PerformanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.lbing.springidol.Performer;

@Component
public class Instrumentalist implements Performer {
  public void perform() throws PerformanceException {
    getInstrument().play();
  }

  public Instrument getInstrument() {
    return instrument;
  }

  //<start id="autowire_property" />
  @Autowired
  @StringedInstrument
  @Strummed
  private Instrument instrument;
  //<end id="autowire_property" />

}