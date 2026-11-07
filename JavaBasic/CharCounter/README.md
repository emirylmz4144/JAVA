## BİR KELİMEDE HANGİ HARFTEN KAÇ ADET OLDUĞUNU BULMAK

Yapılan projenin amacı bir cümlede hangi harften kaç adet
olduğunu bulmak ve ekrana yazdırmaktır

### Dikkat edilmesi gereken
```java
 for (int i=0;i<word.length();i++)
        {
        if ((int) kelime.charAt(i) > 26)
        throw new Exception("Türkçe karakter kullanmayınız");
        else
        alfabe[((int) word.charAt(i)) - 97]++;
        }
```
Yukarıdaki kod bloğu  her harfte türkçe karakter kontrolü yapar ve
her harfin ascii değerinden alfabe ascii değer 97 yi çıkararak
kelimenin ilgili harfinin sayacını bir arttırır böylece 
hangi harften kaç adet olduğunu bulmuş oluruz.
