/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MasterRoaster.Process;
import ProcessFramework.Process;
import MasterRoaster.Equipment.*;
import MasterRoaster.Material.*;
/**
 *
 * @author Shama H
 */
public class RoastingProcess extends Process {
    RDRoaster rd; BeanLot bean; Gas g;

    double roastTime;
    double roastEndTemp;
    double Tm;
    public RDactivity ra;
    public CoffeeBeanActivity ca;
    public GasActivity ga;



    public void setRDRoaster(RDRoaster r){
        rd=r;
    }
    public void setBeanLot(BeanLot b){
        bean=b;
    }
    public void setGas(Gas ga){
        g=ga;
    }


    public void setRoastTime(double rt){
        roastTime=rt;
    }


    public void setroastTemp(double ta){
        roastEndTemp=ta;
    }


    public void setTm(double tm){
        this.Tm=tm;
    }
    public void createActivity(){
        ra=new RDactivity(rd,Tm);
        ca = new CoffeeBeanActivity(bean);
        ga=new GasActivity(g);
    }

}
