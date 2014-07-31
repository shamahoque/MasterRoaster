/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Material;
import ProcessFramework.MaterialLot;
import MasterRoaster.Dimensions.*;
/**
 *
 * @author Shama H
 */
public class BeanLot extends MaterialLot{
    Mass totalMass = new Mass();
    Temperature lotTemperature = new Temperature();
    CoffeeBean bean;

    public void setMass(double m){
        this.totalMass.setValue(m);
    }
    public Mass getMass(){
        return totalMass;
    }
    public void setTemp(double temp){
        this.lotTemperature.setValue(temp);
    }
    public Temperature getTemp(){
        return lotTemperature;
    }
    public void setCoffeeBean(CoffeeBean cbean){
        this.bean= cbean;
    }
    public CoffeeBean getCoffeeBean(){
        return bean;
    }

}
