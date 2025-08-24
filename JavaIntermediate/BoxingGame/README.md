## BOXİNG GAME

### AMAÇ

``
Konsol üzerinde oynanacak olan box oyununda 
amaç iki adet dövüşçünün kullanıcının kontrolü dışında
adeta bir box maçı izler gibi kimin kazandığını , kimin 
atak yapacağını ve kimin savunma yapacağını bilmeden bir 
box oyunu yapmaktır
``

#### Kullanılacak sınıflar ve temsilleri

- MatchArea -Ring
- Fighter- Dövüşçü

###### Fighter Sınıfı

  Bir dövüşçüye ait name,demage,healty,weight özellikleri atanmalıdır
  
- Öne çıkan fonksiyonlar
 ```
Bir dövüşçü atak ve savunma yapabileceği için bu özellikleri
temsil eden fonksiyonlar dövüşçü sınıfında bulunmalıdır
```

````java
 int hit(Fighter warriorToBeAttacked)
/* Dövüşçü karşı tarafa saldıracağından karşı tarafın nesnesi bu fonksiyona parametre olarak gönderilir*/

 int dodge() //Dövüşçünün savunma miktarı burada üretilir
````

###### MatchArea Sınıfı

- Öne çıkan fonksiyonlar

````java
//Dövüşçüler ve sikletleri ring'e gönderilir

 public MatchArea(Fighter fighter1, Fighter fighter2, int maxWeight, int minWeight)

//Sikletler uyuşuyormu kontrolü
 boolean weightControl()

//Kimin atak yapacağı belirlenir
 void whoIsAttacker()

// Atak işlemi iki kişi arasında etkileşimdir
public void attack(Fighter fighter1,Fighter fighter2)

//Kazanan kontrolü yapılırboolean whoWin()
````