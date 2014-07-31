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
public class BeanCapacity extends Specification{

    double beanAmount;
    double minTime, maxTime;

    public void setBeanAmount(double b){
        this.beanAmount=b;
    }
    public void setMinTime(double minT){
        this.minTime=minT;
    }
    public void setMaxTime(double maxT){
        this.maxTime=maxT;
    }
    public double getBeanAmount(){
        return beanAmount;
    }
    public double getMinTime(){
        return minTime;
    }
    public double getMaxTime(){
        return maxTime;
    }

}
