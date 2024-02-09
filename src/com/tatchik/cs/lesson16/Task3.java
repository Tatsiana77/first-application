package com.tatchik.cs.lesson16;

public class Task3 {
    public static void main(String[] args) {
        int rubles = -4;
        int remainder10 = rubles % 10;
        int remainder100 = rubles % 100;
        if(remainder10 == 0 || (5 <= remainder10 && remainder10 <=9) || 11<= remainder100 && remainder100<= 19){
            System.out.println( rubles + " рублей");
        } else if ( 2 <= remainder10 && remainder10 <= 4){
            System.out.println( rubles + " рубля");
        } else if (remainder10 == 1) {
            System.out.println(rubles + "рубль");
        }else {
            System.out.println(rubles + "  Rubles variables is not valid");
        }
    }
}
