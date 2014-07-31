/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Calculations;

/**
 *
 * @author Shama H
 */
import MasterRoaster.Process.*;
import MasterRoaster.Specifications.*;
public class CalculateEmissions {
    double beanAmount,particulate, VOC, CO;
    EmissionFactor ef;
    RDactivity ra;
    public CalculateEmissions(RDactivity ra){
        this.ra=ra;
        ef=ra.getEF();
        beanAmount=ra.getBeanAmount();    
    }

    public double getCO(){
        CO=beanAmount*ra.getEF().getCORate();
        return CO;
    }
    public double getVOC(){
        VOC=beanAmount*ra.getEF().getVOCRate();
        return VOC;
    }
    public double getParticulate(){
         particulate=beanAmount*ra.getEF().getParticulateRate();
         System.out.println(particulate);
         return particulate;
    }
}
