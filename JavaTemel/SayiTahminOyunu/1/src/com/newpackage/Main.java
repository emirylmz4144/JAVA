package com.newpackage;

import java.util.Random;
import java.util.Scanner;

public class Main {
   static Scanner input=new Scanner(System.in);

    public static void main(String[] args)
    {

        Random createRandomValue=new Random();
        System.out.println("Lütfen 1-50 arasında bir sayi giriniz: ");
        int sayi= createRandomValue.nextInt(1,50);//1-50 arası bir sayı üretilir
        int think,counter=4;
        boolean isWin=false;
        while (1<=counter)
        {
            System.out.println(sayi);
            System.out.println("Lütfen bir sayi giriniz: ");
            think=input.nextInt();
            if (think<=0 || think>50)
            {
                System.out.println("Hilebaz köpek 1 ile 50 arası sayi gir");
                continue;
            }
            if(think==sayi)
            {
                isWin=true;
                break;
            }
            else
            {
                System.out.println("Asdfjdsjf yanlış cevap :))))");
                counter-=1;
            }
        }
        if (isWin)
            System.out.println("Kazandınız:))");
        else
            System.out.println("basaramadiniz");

    }

}
