package com.Udemy;

import java.util.Scanner;

public class PyramidInConsole {

    public static void main(String[] args) {
        System.out.print("Please, enter height of the pyramid: ");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        for(int i = 1; i<=userInput; i++){
            for(int k =1; k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=userInput - 1; i>=0; i--){
            for(int k =1; k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}