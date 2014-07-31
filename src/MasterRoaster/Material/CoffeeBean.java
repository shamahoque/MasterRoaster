/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Material;
import ProcessFramework.Material;
import MasterRoaster.Dimensions.*;
import MasterRoaster.Properties.*;
import java.awt.*;
/**
 *
 * @author Shama H
 */
public class CoffeeBean extends Material{
    Mass m = new Mass();
    Radius diameter= new Radius();
    Temperature Tb = new Temperature();
    Color c;
    double MoistureContent;
    HeatCapacity Cb = new HeatCapacity();
    LatentHeatVp Lb = new LatentHeatVp();

    public void setBeanMass(double R){
        this.m.setValue(R);
    }
    public Mass getBeanMass(){
     return m;
    }
    public void setBeanDiameter(double d){
       this.diameter.setDiameter(d);
    }
    public Radius getBeanDiameter(){
        return diameter;
    }
    public void setBeanTemperature(double Tempb){
        this.Tb.setValue(Tempb);
    }
    public Temperature getBeanTemperature(){
        return Tb;
    }
    public void getBeanColor(Color Cbean){
        this.c=Cbean;
    }
    public void setBeanMoistureContent(double X){
        this.MoistureContent= X;
    }
    public double getBeanMoistureContent(){
        return MoistureContent;
    }
    public void setCb(double cb){
        this.Cb.setValue(cb);
    }
    public HeatCapacity getCb(){
        return Cb;
    }
    public void setBeanLv(double lb){
        this.Lb.setValue(lb);
    }
    public LatentHeatVp getBeanLv(){
        return Lb;
    }

}
