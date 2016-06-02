package me.lbing.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

  @DeclareParents( //<co id="co_declareParents"/>
      value = "Performer+",
      defaultImpl = GraciousContestant.class)
  public static Contestant contestant;
}