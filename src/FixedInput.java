/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
import MasterRoaster.Equipment.*;
import MasterRoaster.Material.*;
public class FixedInput {

   RDRoaster IR5=new RDRoaster();
   RDRoaster IR12=new RDRoaster();
   CoffeeBean peaBerry1= new CoffeeBean();
   CoffeeBean KonaPrimeBean = new CoffeeBean();
   BeanLot pb1Lot=new BeanLot();
   BeanLot kpbLot = new BeanLot();
   Metal m1 = new Metal();
   Metal m2 = new Metal();
   Gas g = new Gas();

   RDRoaster createIR5(){
        IR5.setGasMFRate(35);
        IR5.setThermometer(20, 2,15,5);
        IR5.setDrum(350, 2, 1, 2, 1500, m1);
        IR5.setBeanCapacity(450, 1, 7);
        IR5.setEmissionFactor(.000046, .00008, .000049);
        IR5.setFuelConsumeRate(43);
        IR5.setRoastsPerHr(3);
        IR5.setTempLimit(510);
        IR5.setGasInletTemp(313,863);
    return IR5;

   }
   RDRoaster createIR12(){
       IR12.setGasMFRate(26.7);
       IR12.setThermometer(20, 2,14,5);
       IR12.setDrum(250, 5, 4, .5, 3500, m2);
       IR12.setBeanCapacity(650, 1, 8);
       IR12.setEmissionFactor(.00006, .000024, .00028);
       IR12.setFuelConsumeRate(43);
       IR12.setRoastsPerHr(3);
       IR12.setTempLimit(510);
       IR12.setGasInletTemp(306.7,1336.7);

    return IR12;
   }

   CoffeeBean createGreenBean(){
       peaBerry1.setBeanDiameter(.6);
       peaBerry1.setBeanLv(0.5);
       peaBerry1.setBeanMass(.03);
       peaBerry1.setBeanMoistureContent(.111);
       peaBerry1.setBeanTemperature(75);
       peaBerry1.setCb(12);
    return peaBerry1;
   }
   CoffeeBean createKPBean(){
       KonaPrimeBean.setBeanDiameter(.2);
       KonaPrimeBean.setBeanLv(15);
       KonaPrimeBean.setBeanMass(.01);
       KonaPrimeBean.setBeanMoistureContent(.2);
       KonaPrimeBean.setBeanTemperature(75);
       KonaPrimeBean.setCb(10);
    return KonaPrimeBean;
   }
   BeanLot createPB1Lot(double m){
       pb1Lot.setCoffeeBean(peaBerry1);
       pb1Lot.setMass(m);
       pb1Lot.setTemp(70);
    return pb1Lot;
   }

   BeanLot createKPBLot(double m){
       kpbLot.setCoffeeBean(KonaPrimeBean);
       kpbLot.setMass(m);
       kpbLot.setTemp(70);
    return kpbLot;
   }
   Metal createM1(){
       m1.setHeatCapacity(.418);
    return m1;
   }
   Metal createM2(){
       m2.setHeatCapacity(.130);
    return m2;
   }
   Gas createG(){
        g.setHeatCapacity(2);
    return g;
   }


}
