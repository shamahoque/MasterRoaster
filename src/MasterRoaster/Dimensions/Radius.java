package MasterRoaster.Dimensions;



import ProcessFramework.Dimension;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
/*



 */
public class Radius extends Dimension{

    double value;
    double diameter;
    double area;

    public void setValue(double value){
        this.value=value;
    }


    public void setDiameter(double d){
        this.diameter=d;
    }

    public void setArea(double a){
        this.area=a;
    }
    public double calculateArea(){
        area=Math.PI*Math.pow(value, 2);
        return area;
    }
    public double getValue(){
        return value;
    }
    public double getDiameter(){
        return diameter;
    }
    public double getArea(){
        return area;
    }
  

}


