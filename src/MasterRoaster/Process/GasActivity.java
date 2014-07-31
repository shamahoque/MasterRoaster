/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Process;

/**
 *
 * @author Shama H
 */
import MasterRoaster.Material.*;
import MasterRoaster.Properties.*;
public class GasActivity {
    HeatCapacity Cg;
    public GasActivity(Gas g){
        Cg=g.getHeatCapacity();
    }
    public double getCg(){
        return Cg.getValue();
    }

}
