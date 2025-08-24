import java.util.Scanner;

public  class MatrisSequence
{
    //Matrise göre transpoz alındığı için oluşacak matrise her iki metot ulaşmalı
    public static int [][] ourMatris;

    /*col değeri transpoz olduğunda row değerine dönüşeceği için iki metotunda bu değişkene iki metotta ulaşmalı bu yüzden bu değişken sınıfa ait olmalı */
    public static int col;
    /*row değeri transpoz olduğunda col değerine dönüşeceği için iki metotunda bu değişkene iki metotta ulaşmalı bu yüzden bu değişken sınıfa ait olmalı */
    public static int row;



    public static int [][] createArray()
    {
        // Dizi burada oluşacaktır

        Scanner input=new Scanner(System.in);

        System.out.println("Kaç sütunluk liste oluşturacaksınız?: ");row=input.nextInt();
        System.out.println("Kaç satırlık liste oluşturacaksınız:?: ");col=input.nextInt();

         ourMatris=new int[row][col];
         for (int i=0;i<row;i++)
         {
             for (int j=0;j<col;j++)
                 System.out.print("Dizinin "+(i+1)+" "+(j+1)+".elemanini giriniz: ");ourMatris[i][j]=input.nextInt();
         }
         return ourMatris;
    }




    public static void createToTranspoze(int [][] ourMatris)
    {
     //Transpoz burada oluşacaktır
        int [][] transpozeMatris=new int[col][row];
        for (int i=0;i<col;i++)
        {
            for (int j=0;j<row;j++)
            {
                transpozeMatris[i][j]=ourMatris[j][i];
                System.out.print(transpozeMatris[i][j]+" ");
            }
            System.out.println();

        }

    }

}
