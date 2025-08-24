public class Main {
    public static void main(String[] args)
    {
     MatrisSequence matrisSequence=new MatrisSequence();// Dizi işlemlerinin olduğu sınıfın nesnesi üretildi
     int [][] ourArray=matrisSequence.createArray();//Dizinin oluştuğu metot
     System.out.println("*********************TRANSPOZ DİZİ****************************");
     matrisSequence.createToTranspoze(ourArray);// Dizinin transpozunun alındığı metot

    }
}