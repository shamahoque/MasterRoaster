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
public class CalculateTemp {
    
    double G,Tgi,Tg,Tb,Ta,Tm,he,Agb,Cg,hgm, Agm,F,Qgm,Qmb,Rd,Qr,Lv, X,Cb,hbm, Abm,dp,He,Mm,Cm,ht,At,Mt,Ct,XRate=0,TbRate=0,TmRate,TaRate=0,Kt;

    public CalculateTemp(RDactivity rd,CoffeeBeanActivity ca, GasActivity ga ){
         G=rd.getG();
        Tgi=rd.getTgi();        
        Tb=ca.getTb();
        Ta=ca.getTa();
        Tm=rd.getTm();
        he=rd.getHe();
        Agb=rd.getArea();
        Cg=ga.getCg();
        hgm=rd.getHgm();
        Agm=rd.getArea();
        Rd=ca.getMb();
        Lv=ca.getLv();
        X=ca.getX();
        Cb=ca.getCb();
        hbm=rd.getHbm();
        Abm=rd.getArea();
        dp=ca.getdp();
        Mm=rd.getRDrumMass();
        Cm=rd.getMHeatCapacity();
        ht=rd.getThermHt();
        At=rd.getThermAt();
        Mt=rd.getThermMt();
        Ct=rd.getThermCt();

        He=0;
        Qr=0;
        F=(hgm*Agm)/(he*Agb);
        Kt=(ht*At)/(Mt*Ct);

    }
    public void setTgi(double g){
        Tgi=g+Tgi;
    }
    public double getHe(double qr){
        Qr=Qr+qr;
        return Qr;
    }
    public void CalculateTemp(){


        Tg=(Tgi-((Tb+(F*Tm))/(1+F)))*(1-Math.exp(-(he*Agb*(1+F))/(G*Cg)));

        XRate = -((4.32*Math.pow(X, 2))/Math.pow(dp,2))*Math.exp(-9889/(Tb+273.2))*1000;
        Qgm=(F*((he*Agb*(Tb-Tm))+G*Cg*Tg))/(1+F);
        Qr=116200*Math.exp(-5500/(Tb+273.2))*((232-getHe(Qr))/232);
        Qmb=hbm*Abm*(Tm-Tb);
        TbRate=(G*Cg*(Tg)-Qgm+Qmb+Rd*(Qr+(Lv*XRate)))/(Rd*Cb*(1+X));
        TmRate=(Qgm+((hbm*Abm)*(Tb-Tm)))/(Mm*Cm);
        TaRate=Kt*(Tb-Ta);

          try{
                Thread.sleep(300);
            }catch(Exception e){}
           Tb=Tb+TbRate;
        Ta=Ta+TaRate;
        Tm=Tm+TmRate;
        X=X+XRate;

 

    }
    public double getTb(){
        
        return Tb;
    }
    public double getTa(){
        return Ta;
    }
    public String getCalc(){
    String calc="\nChange in Tb: \n  "+TbRate+"\n\nChange in Ta: \n  "+TaRate+"\n\nMoisture Content: \n  "+X+"\n\nMoisture Loss: \n  "+XRate+"\n\nRate of Exothermic heat production: \n  "+Qr+"\n\n";
        return calc;

    }

}
