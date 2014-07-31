package MasterRoaster.Equipment;


import ProcessFramework.Equipment;
import MasterRoaster.Specifications.*;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
public class Roaster extends Equipment{
    BeanCapacity b= new BeanCapacity();
    EmissionFactor e = new EmissionFactor();
    double roastsPerHour;
    double tempLimit;
    double fuelConsumptionRate;

    public void setRoastsPerHr(double rphr){
        this.roastsPerHour = rphr;
    }
    public double getRoastsPerHr(){
        return roastsPerHour;
    }
    public void setTempLimit(double maxTemp){
        this.tempLimit=maxTemp;
    }
    public double getTempLimit(){
        return tempLimit;
    }
    public void setFuelConsumeRate(double FCRate){
        this.fuelConsumptionRate= FCRate;
    }
    public double getFuelConsumeRate(){
        return fuelConsumptionRate;
    }
    public void setBeanCapacity(double amount, double minT, double maxT){
        b.setBeanAmount(amount);
        b.setMinTime(minT);
        b.setMaxTime(maxT);
    }
    public BeanCapacity getBeanCapacity(){
        return b;
    }
    public void setEmissionFactor(double p, double voc, double co){
        e.setParticulateRate(p);
        e.setVOCRate(voc);
        e.setCORate(co);
    }
    public EmissionFactor getEmissionFactor(){
        return e;
    }
}
