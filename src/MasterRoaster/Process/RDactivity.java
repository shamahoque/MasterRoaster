/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Process;

/**
 *
 * @author shama
 */
import MasterRoaster.Equipment.*;
import MasterRoaster.Specifications.*;

public class RDactivity {

    RDRoaster r;
 
    double initialG,Tm;
    public RDactivity(RDRoaster r, double Tm){
        this.r=r;
        this.Tm=Tm;
    }

    public double getG(){
        return r.getGasMFRate();
    }
    public double getTm(){
        return Tm;
    }
  
    public double getArea(){
        return r.getDrum().getArea().getArea();
    }
    public double getTgi(){
        return r.getGasInletTemp().getMinTgi();
    }
    public double getRDrumMass(){
        return r.getDrum().getMass().getValue();
    }
    public double getHe(){
        return r.getDrum().getEHTChe().getValue();
    }
    public double getHgm(){
        return r.getDrum().getEHTChgm().getValue();
    }
    public double getHbm(){
        return r.getDrum().getEHTChbm().getValue();
    }
    public  double getThermHt(){
        return r.getThermometer().getHt().getValue();
    }
     public  double getThermMt(){
        return r.getThermometer().getMass().getValue();
    }
     public  double getThermAt(){
        return r.getThermometer().getAt();
    }
     public double getThermCt(){
        return r.getThermometer().getCt().getValue();
     }
    public double getMHeatCapacity(){
        return r.getDrum().getMHeatCapacity();
    }

    public EmissionFactor getEF(){
     return r.getEmissionFactor();
    }
    public double getBeanAmount(){
        return r.getBeanCapacity().getBeanAmount();
    }


}
