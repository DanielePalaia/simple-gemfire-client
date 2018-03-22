package org.geode.test;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

public class RandomCar extends Car  {

    public RandomCar() {}

   public void random()  {
       // Random generate
       Random rn = new Random();
       int randomNumber = rn.nextInt(5);
       this.setIdTag(UUID.randomUUID().toString());
       switch (randomNumber)  {
           case 0:
               this.setDate("2012");
               this.setManufacturer("FCA");
               this.setModel("Panda");
               this.setColour("Red");
               break;
           case 1:
               this.setDate("2013");
               this.setManufacturer("Alfa Romeo");
               this.setModel("Giulietta");
               this.setColour("Red");
               break;
           case 2:
               this.setDate("2014");
               this.setManufacturer("Lancia");
               this.setModel("Y");
               this.setColour("White");
               break;
           case 3:
               this.setDate("2015");
               this.setManufacturer("FCA");
               this.setModel("Punto");
               this.setColour("Yellow");
               break;
           case 4:
               this.setDate("2016");
               this.setManufacturer("Crysler");
               this.setModel("Pacifica");
               this.setColour("White");
               break;
       }
   }
}