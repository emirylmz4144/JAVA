## Functional Interface ile çoklu metot 

```
Bu projede amaç bir sınıfa ait özelliklere göre filtrelemeyi
birden çok metot veya özellik kullanarak yapmak yerine 
functional inrerface yardımıyla tek bir metot
kullanarak yapmaktır.
```

###### Functional Interface

````java
@FunctionalInterface
public interface KisiFiltreleme
{
   public boolean filtrele(Kisi kisi);
}
````
- filtrele metodu ile Kisi sınıfına ait özelliklerin
interface'e ait metoda geleceği belirlenir
````java
kisileriFiltrele(arrayList,k->k.getName().contains("e"));
````

Yukarıda ise filteleme yapılacak liste ve Functional Interface'te
yer alacak filtrelemenin hangi property ile yapılacağı 
ilgili metoda gönderilir


````java
  public static void kisileriFiltrele(List<Kisi> kisiler,KisiFiltreleme filtreleme)
````

- Yukarıdaki örnek filtrelemede görüldüğü filtreleme için bir metot
ve bu metoda filtrelenecek liste ile Funtional Interface Classın
nasıl bir filteleme yapacağı bilgisi parametre olarak gönderilir
- 
