package MasterRoaster.Properties;


import ProcessFramework.Property;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
public class HeatCapacity extends Property{
    double value;

    public void setValue(double value){
        this.value=value;
    }
    public double getValue(){
        return value;
    }
}
