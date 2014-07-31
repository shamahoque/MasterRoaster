package MasterRoaster.Equipment;
import MasterRoaster.Specifications.*;
import MasterRoaster.Material.Metal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
public class RDRoaster extends Roaster{
    RotatingDrum Drum1 = new RotatingDrum();;
    GasInletTemp Tgi = new GasInletTemp();
    Thermometer Th = new Thermometer();
    double GasMFRate;

    public void setGasInletTemp(double min, double max){
        Tgi.setMinTgi(min);
        Tgi.setMaxTgi(max);
    }
    public GasInletTemp getGasInletTemp(){
        return Tgi;
    }
    public void setGasMFRate(double G){
        GasMFRate = G;
    }
    public double getGasMFRate(){
        return GasMFRate;
    }
   
    public void setDrum(double area, double he, double hgm, double hbm, double mass, Metal type){
        Drum1.setArea(area);
        Drum1.setEHTChbm(hbm);
        Drum1.setEHTChe(he);
        Drum1.setEHTChgm(hgm);
        Drum1.setMass(mass);
        Drum1.setMHeatCapacity(type);
    }
    public RotatingDrum getDrum(){
        return Drum1;
    }
    public void setThermometer(double mass, double hCapacity, double at, double ht){
        Th.setMass(mass);
        Th.setCt(hCapacity);
        Th.setAt(at);
        Th.setHt(ht);
    }
    public Thermometer getThermometer(){
        return Th;
    }

}
