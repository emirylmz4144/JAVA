public class Main {
    static  Scanner input=new Scanner(System.in);
    static void PrimeNumber(int maxNumber)
    {
        int count=0;// Kontrol için sayaç atanmıştır
        for (int controlValue=4;controlValue<=maxNumber;controlValue++)//Başlangıç değerinden 100'e kadar
        {
            for (int checkingValue=1;checkingValue<=controlValue;checkingValue++)
            {
                if (controlValue%checkingValue==0)
                    count++;//asal sayılar 1 ve kendisine bölünür burası 2'yi geçmezse sayı asaldır
            }
            if (count==2)
                System.out.println("1-"+maxNumber+" arasında "+controlValue+" asal sayıdır");
            count=0; //sayaç sıfırlanarak bir sonraki değerin asal sayı kontrolü için hazır hale gelir
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Lütfen hangi sayıya gelene kadar kaç tane asal sayı bulunduğunu öğrenmek istediğiniz sayıyı yazınız: ");
        int maxNumber=input.nextInt();
        PrimeNumber(maxNumber);//Fonksiyon oluşturulmasının sebebi ileride tekrar ihtiyaç duyulursa kodu tekrar yazmamak
    }
}