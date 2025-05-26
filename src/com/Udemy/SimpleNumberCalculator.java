package com.Udemy;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumberCalculator {

    public static void main(String[] args) {
        if(args[0].contains(".") || args[1].contains(".")){
            double paramDouble1 = Double.parseDouble(args[0]);
            double paramDouble2 = Double.parseDouble(args[1]);
            System.out.println(paramDouble1 + paramDouble2);
        } else{
            int paramInt1 = Integer.parseInt(args[0]);
            int paramInt2 = Integer.parseInt(args[1]);
            System.out.println(paramInt1 + paramInt2);
        }
    }
}
