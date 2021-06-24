package com.example.demo;

public class Utils {

    public static boolean checkHighwayLegalSpeed(int speed){
        if ( speed > 120)
            return false;
        else
            return true;
    }

    public static boolean checkUrbanLegalSpeed (int speed){
        if ( speed > 90)
            return false;
        else
            return true;
    }

}
