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
public class GasInletTemp extends Specification{
    double minGasRate;
    double maxGasRate;

    public void setMinTgi(double min){
        minGasRate=min;
    }
    public void setMaxTgi(double max){
        maxGasRate=max;
    }
    public double getMinTgi(){
        return minGasRate;
    }
    public double getMaxTgi(){
        return maxGasRate;
    }

}
