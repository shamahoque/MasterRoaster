/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Dimensions;
import ProcessFramework.Dimension;
/**
 *
 * @author Shama H
 */
public class Temperature extends Dimension{
    double value;

     public void setValue(double value){
        this.value=value;
    }
    public double getValue(){
        return value;
    }

}
