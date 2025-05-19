package com.rough;

import java.util.Arrays;

public class Mellon {

    public void type(){
        System.out.println("I am having different types of melons");
    }

    public static void main(String[] args) {
        WaterMelon wm = new WaterMelon();
        wm.type();

        int[][] hello = new int[5][5];
        System.out.println(Arrays.deepToString(hello));
    }
}
