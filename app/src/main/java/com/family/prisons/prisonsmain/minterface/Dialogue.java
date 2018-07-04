package com.family.prisons.prisonsmain.minterface;

public class Dialogue {

  public static  Idialogue mIdialogue;


  public void setDiloguecClick(Idialogue idialogue){
      this.mIdialogue=idialogue;
  }

  public void  DologuesClick(){
      mIdialogue.doSomeClick();;
  }
}
