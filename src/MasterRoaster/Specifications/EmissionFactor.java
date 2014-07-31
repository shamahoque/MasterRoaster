package MasterRoaster.Specifications;


import ProcessFramework.Specification;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
public class EmissionFactor extends Specification{
    double particulate;
    double VOC;
    double CO;

    public void setParticulateRate(double particulate){
        this.particulate=particulate;
    }
    public void setVOCRate(double VOC){
        this.VOC=VOC;
    }
    public void setCORate(double CO){
        this.CO=CO;
    }
    public double getParticulateRate(){
        return particulate;
    }
    public double getVOCRate(){
        return VOC;
    }
    public double getCORate(){
        return CO;
    }
}
