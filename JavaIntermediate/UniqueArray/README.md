## Uniq Dizi Oluşturucu

* Bu projedeki amacımız her elemanı benzersiz bir dizi oluşturmaktır.
Bunu sağlayacak temel bir fonksiyonumuz vardır 
````java
for (int controlIndex = 0; controlIndex <index; controlIndex++)
````
yukarıdaki gibi dizi elemanları baştan gezilir
````java
(tempElement == list[controlIndex])
````
eğer girilen elemanla dizinin o anki indexi aynıysa elaman eklenmez 
- Önemli olan nokta şudur bu şart sağlanırsa dizinin kontrol indexi bir azaltılmalıdır
çünkü bir sonraki adımda controlIndex++ olacağı için if bloğu sağlanırsa 
kilit nokta olan aşağıdaki kod yazılmalıdır
````java
 controlIndex--;
````