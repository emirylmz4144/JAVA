import java.util.Scanner;

public class Main
{
    static double BodyMassIndex(double weight,double height)
    {
        return (weight)/(height*height);
    }
    static void InformationIndex(double index)
    {
        if (index<20)
            System.out.println("Vücut kitle indexin "+index+" Bu aralar detoxu fazla kaçırdın galiba :)");
        else if (index>=20)
            System.out.println("Vücut kitle indexin "+index+" Vaaayy formunu koruyosunnn");
        else if (index>=25)
            System.out.println("Vücut kitle indexin "+index+" Annene söylede çok fazla güzel yemek yapmasın :)");
        else if (index>=30)
            System.out.println("Vücut kitle indexin "+index+" Kardeşim seni üzmek istemem ama obezite hastalığına" +
                    "sahipsin profosyonel bir destek alman gerek");

    }
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);

        System.out.println("Vücut kitle endex hesaplamaya hoş geldiniz lütfen adınızı giriniz: ");
        String name=input.nextLine();

        System.out.println("Merhaba "+name+" Lütfen kilonu yazarmısın :) ");
        double weight=input.nextDouble();

        System.out.println(name+" şimdide senden boyunu yazmanı rica edeceğim " +
                "lütfen boyunu metre cinsinden yazarmısın (1,78) : ");
        double height=input.nextDouble();

        double index=BodyMassIndex(weight,height);

        InformationIndex(index);


    }
}