## MİKROTARY BİRD

Projenin amacı bir dizi içerisinde en fazla tekrar eden 
elemanı bulmaktır



- Bu fonksiyon  dizinin i.elemanı, dizi ve i sayısı gönderilerek
i sayısını almadan o sayıya kadar olan indisdeki değişkenleri dizinin i.elemanı 
ile kontrol eder ve eğer eşitlerse zaten o dizi sayaca eklenmiştir demektir.
true değer döndererek ilgili indisin zaten daha önce sayaca dahil edildiğini
belirtir ve böylece sayaca dahil olmaz..

   ````java
  public static boolean isFind(int value,int array[],int tempCounter)

    ````

- eğer kontrol edilmemişse sayaç dizisinin o elemanı artar

   ````java
   if (ourArray[i]==ourArray[j])
   migrotaryBird[i]++;
   ````
