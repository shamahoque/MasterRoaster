/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Properties;
import ProcessFramework.Property;
/**
 *
 * @author Shama H
 */
public class LatentHeatVp extends Property {

    double value;

    public void setValue(double value){
        this.value=value;
    }
    public double getValue(){
        return value;
    }

}
