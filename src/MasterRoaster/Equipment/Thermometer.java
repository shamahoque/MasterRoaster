/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Equipment;
import ProcessFramework.Equipment;
import MasterRoaster.Dimensions.*;
import MasterRoaster.Properties.*;
import MasterRoaster.Specifications.*;

/**
 *
 * @author Shama H
 */
public class Thermometer extends Equipment{
    Mass Mt = new Mass();
    HeatCapacity Ct = new HeatCapacity();
    EHTC ht=new EHTC();
    Double At;

    public void setMass(double m){
        Mt.setValue(m);
    }
    public Mass getMass(){
        return Mt;
    }
    public void setCt(double ThermHC){
        Ct.setValue(ThermHC);
    }
    public HeatCapacity getCt(){
        return Ct;
    }
    public void setHt(double value){
        ht.setEHTC(value);;
    }
    public EHTC getHt(){
        return ht;
    }
    public void setAt(double value){
        At=value;
    }
    public double getAt(){
        return At;
    }
}
