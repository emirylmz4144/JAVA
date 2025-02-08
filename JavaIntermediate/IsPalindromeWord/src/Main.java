import java.util.Scanner;
public class Main {
    static boolean isPalindrome(String word)
    {
        String temp="";
        for (int i=word.length()-1;i>=0;i--)
            temp+=word.charAt(i);

        if (temp.equals(word))
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Lütfen bir kelime giriniz: ");
        String word=input.nextLine();
        if (isPalindrome(word))
            System.out.println("Girdiğiniz kelime palindromik bir kelimedir");
        else
            System.out.println("Girdiğiniz kelime palindromik bir kelime değildir");

    }
}