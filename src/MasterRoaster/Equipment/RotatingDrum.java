package MasterRoaster.Equipment;


import ProcessFramework.Equipment;

import MasterRoaster.Dimensions.*;
import MasterRoaster.Specifications.*;
import MasterRoaster.Material.Metal;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
/*



 */
public class RotatingDrum extends Equipment{

    Radius area = new Radius();;
    EHTC he =new EHTC();
    EHTC hgm=new EHTC();
    EHTC hbm=new EHTC();
    Mass m = new Mass();
    double MheatCapacity;

    public void setArea(double value){
        
        area.setArea(value);
    }
    public Radius getArea(){
        return area;
    }
    public void setMass(double value){
        m.setValue(value);
    }
    public Mass getMass(){
        return m;
    }

    public void setEHTChe(double value){
        he.setEHTC(value);
    }
    public EHTC getEHTChe(){
        return he;
    }
    public void setEHTChgm(double value){
        hgm.setEHTC(value);
    }
    public EHTC getEHTChgm(){
        return hgm;
    }
    public void setEHTChbm(double value){
        hbm.setEHTC(value);
    }
    public EHTC getEHTChbm(){
        return hbm;
    }
    public void setMHeatCapacity(Metal type){
        MheatCapacity=type.getHeatCapacity().getValue();
    }
    public double getMHeatCapacity(){
        return MheatCapacity;
    }



}
