/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ProcessFramework;

/**
 *
 * @author Shama H
 */
public enum SIprefix {

GIGA(1000000000),MEGA(1000000), KILO(1000),HECTO(100), DEKA(10), DECI(1),CENTI(0.01), MILLI(.001), MICRO(0.000001),PICO(0.000000001);
SIprefix(double prefix) { // constructor
this.prefix = prefix;
}
private double prefix; // an instance variable
public double getPrefix() {
    return prefix;
}
}
