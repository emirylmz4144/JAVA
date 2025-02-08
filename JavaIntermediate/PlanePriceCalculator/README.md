### UÇAK BİLETİ FİYATI HESAPLAMA

- Alınan yaş,bilet tarifesi ve kaç km yolculuk edileceğine dair 
bilgilere göre uçak bileti fiyatı hesaplanır
- Herhangi bir bilgide geçerli format dışında 3 kere bilgi girilirse
program kandırılmaya çalışıldığını anlar ve sonlandırılır
 ```java
 static  int count=3;


 double distance=controlDistance(input.nextDouble());
 
 
        while (distance<=0)
        {
        if (count>0)
        {
        count--;
        System.out.println("Lütfen uçuş mesafesini doğru bir mesafe olarak giriniz");
        distance=input.nextDouble();
        }
        else
        {
        status=false;
        break;
        }
        }
        return distance;

        if (!status)break;
```
Yukarıda görüldüğü gibi programın farklı yerlerinden alınan kod blokları ile
3 kere hatalı bilgi girilirse nasıl programın sonlandırılacağı 
gösterilmektedir