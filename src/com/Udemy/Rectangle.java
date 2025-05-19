package com.Udemy;

import java.util.Arrays;
import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter height of rectangle: ");
        int height = sc.nextInt();
        System.out.print("Please, enter width of rectangle: ");
        int width = sc.nextInt();

        drawRectangle(height, width);
    }

    public static void drawRectangle(int height, int width) {
        int rectableBorders = 2;
        outerLoop: for (int i = 1; i <= rectableBorders; i++) {
            if(i == 1){
                System.out.print(" ");
            }
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
            innerLoop: for(int j = 1; j <= height; j++) {
                if(j%2 != 0){
                    System.out.println();
                }else{
                    if (i == 2){
                        break outerLoop;
                    }
                    for (int k = 1; k <= width; k++) {
                        if(k == 1 || k == width){
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
