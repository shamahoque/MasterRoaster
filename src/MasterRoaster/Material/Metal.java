package MasterRoaster.Material;


import ProcessFramework.Material;
import MasterRoaster.Properties.HeatCapacity;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
public class Metal extends Material{

    HeatCapacity Cm = new HeatCapacity();


    public void setHeatCapacity(double value){
        Cm.setValue(value);
    }
    public HeatCapacity getHeatCapacity(){
        return Cm;
    }


}
