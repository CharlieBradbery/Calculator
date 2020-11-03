package com.company;

import java.lang.invoke.StringConcatException;

public class Calculator{

    private static String [] arab = new String[]{"1","2","3","4","5","6","7","8","9", "10"};
    private static String [] romane = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    private static String [] romaneDozens = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    private String mystring;
    private static char [] operations = new char[]{'+', '-', '*', '/'};
    private int opId;
    private int op1, op2;
    private int op1Type, op2Type;
    public int result;

    public Calculator(String str){
        this.mystring = str;
    }
    public static int toInt(String num){
    int inx = -1;
        for (int i =0; i<arab.length; i++){
            if (num.equals(arab[i]))
                inx = i+1;
        }
        for (int i =0; i<romane.length; i++){
            if (num.equals(romane[i]))
                inx = i+1;
        }
        return inx;

    }

    public static int toType(String num){
        int inx = -1;
        for (int i =0; i<arab.length; i++){
            if (num.equals(arab[i]))
                inx = 1;
        }
        for (int i =0; i<romane.length; i++){
            if (num.equals(romane[i]))
                inx = 2;
        }
        return inx;

    }

    public void deleteSpaces (){
        this.mystring = this.mystring.replaceAll(" ", "");

    }

    public void getOperation (){
        opId = -1;
        for (int i = 0; i < mystring.length(); i++){
            for (int j=0; j<operations.length; j++){
                if (mystring.charAt(i) == operations[j]) {
                    opId = j;
                    mystring = mystring.substring(0, i) + " " + mystring.substring(i+1, mystring.length());
                }
            }
        }

    }

    public void getOps () {
        String[] list = mystring.split(" ");
        if (list.length == 2){
            op1 = toInt(list[0]);
            op2 = toInt(list[1]);
            op1Type = toType(list[0]);
            op2Type = toType(list[1]);
            if (op1 == -1 || op2 == -1 || op1Type!=op2Type){
                throw new NumberFormatException("ERROR");

                            }

        }
        else throw new NumberFormatException("ERROR");

    }

    public void calculate(){

        if (opId == 0)
            result = op1 + op2;
        if (opId == 1)
            result = op1 - op2;
        if (opId == 2)
            result = op1 * op2;
        if (opId == 3)
            result = op1 / op2;

    }

    public String resultStr(){
        if (op1Type == 1){
            return String.valueOf(result);
        }
        else{
            String rezStr = "";
            int result = this.result;

            if (result <0) {
                result *= -1;
                rezStr+="-";
            }

            if (result >=100)
                rezStr+="C";

            int dozens = result/10%10;
            if (dozens!=0){
                rezStr+= romaneDozens[dozens-1];
            }


            int last = result % 10;
            if (last>0)
                rezStr+= romane[last-1];

            return rezStr;}

    }
}