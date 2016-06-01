package me.lbing.springidol2;
//<start id="onemanband_java" /> 

import java.util.Map;

import me.lbing.springidol.Instrument;
import me.lbing.springidol.PerformanceException;
import me.lbing.springidol.Performer;

public class OneManBand implements Performer {
  public OneManBand() {
  }

  public void perform() throws PerformanceException {
    for (String key : instruments.keySet()) {
      System.out.print(key + " : ");
      Instrument instrument = instruments.get(key);
      instrument.play();
    }
  }

  private Map<String, Instrument> instruments;

  public void setInstruments(Map<String, Instrument> instruments) {
    this.instruments = instruments; //<co id="co_injectInstrumentMap"/>
  }
}
//<end id="onemanband_java" />
