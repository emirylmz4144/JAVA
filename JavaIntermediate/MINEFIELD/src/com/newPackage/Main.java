package com.newPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner veri = new Scanner(System.in);
        System.out.print("Lütfen oluşacak tarlanın satır sayısını giriniz: ");
        int olusacakSatir = veri.nextInt();
        System.out.print("Lütfen oluşacak tarlanın sütun sayısını giriniz: ");
        int olusacakSutun = veri.nextInt();
       Field field=new Field(olusacakSatir,olusacakSutun);
       field.run();

    }
}
