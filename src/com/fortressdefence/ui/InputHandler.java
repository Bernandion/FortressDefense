package com.fortressdefence.ui;


import java.util.Scanner;

public class InputHandler {
    private Scanner input;

    public InputHandler() {
       input = new Scanner(System.in);
    }


    public void getInput(){

        System.out.print("Enter the board location you want to attack: ");
        String in = this.input.nextLine();
        char [] inCharArray = in.toCharArray();
        if((inCharArray[0] >= 'a' && inCharArray[0] <= 'j' || inCharArray[0] >= 'A' && inCharArray[0] <= 'J') && ((inCharArray[1] - '0') >= 1 && (inCharArray[1] - '0') <= 10 ) && !(inCharArray.length > 2)){
           System.out.println("Test Works");
        } else{
            System.out.println("Test Didn't Work");
        }
    }

}
