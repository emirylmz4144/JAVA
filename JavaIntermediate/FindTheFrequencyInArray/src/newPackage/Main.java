package newPackage;

import java.util.Arrays;

public class Main
{

    /**Dizide frekeansı bulunacak elemanın daha önce freakansı bulunmuşmu diye kontrol sağlanır.**/
    static boolean isCounted(int[] array, int value, int tempArrayLenght)
    {
        //tempArrayLength gelen value değerine kadar olan dizinin uzunluğudur
        for (int i = 0; i < tempArrayLenght; i++)
        {
            if (value == array[i])//gönderilen value değeri en baştan kontrol edilir
                return false;//eğer o kısma kadar daha önce bu value değeri ile aynı değer varsa o değer sayılmıştır
        }
        return true;//eğer yoksa demekki sayılmamıştır ve sayılması gerekiyordur
    }

    /**Elemann frekansı bulunur**/
    static int getFrequency(int[] array, int value) {
        int frequency = 0;
        for (int i : array)//Dizinin en başından kontrol sağlanarak elemanın kaç kere tekrar ettiği kontrol edilir
        {
            if (i == value)
                frequency++;
        }
        return frequency;
    }

    public static void main(String[] args)
    {

        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};
        System.out.println("Dizi : " + Arrays.toString(array));
        Arrays.sort(array);//Dizi sıralanmalı ki isFind metodu çalışabilsin
        System.out.println("Dizinin sıralanmış hali: " + Arrays.toString(array));

        for (int i = 0; i <array.length; i++)
        {
            if (isCounted(array, array[i], i))
                System.out.println(array[i] + " sayısı " + getFrequency(array, array[i]) + " kez tekrar edildi.");
        }
    }
}