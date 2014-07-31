/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Material;
import ProcessFramework.Material;
import MasterRoaster.Properties.HeatCapacity;
/**
 *
 * @author Shama H
 */
public class Gas extends Material{

HeatCapacity Cg = new HeatCapacity();

    public void setHeatCapacity(double value){
        Cg.setValue(value);
    }
    public HeatCapacity getHeatCapacity(){
        return Cg;
    }

}
