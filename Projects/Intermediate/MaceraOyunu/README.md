## Adventure Game

### Oyunun amacı

```
Oyunun amacı oyuncuya çeşitli karakterler sunup bu karakterlerden biri
ile oyunda bulunan 3 savaş bölgesine gidip orada bulunan ekipmanların 
hepsini topladıktan sonra oyunu kazanmaktır

```

### Genel İşleyiş 

```
Oyunumuzun genel işleyişinde oyuncu önce karakter seçimini yapar.
Ardından 3 savaş mekanına gidip buradaki eşyaları toplayamaya çalışır
fakat her mekanın kendine özgü bir canavarı ve canavarların kendilerine
ait güçleri vardır.Her mekana her girişte kaç adet canavar çıkacağı 
oyun tarafından belirlenir ve öldürülen her canavardan belli miktarda para
çıkar bu paralarla oyuncu savunma veya saldırı araçları alabilir.
Oyuncu canı çok azaldıysa güvenli eve gidip bir kahve içip canını 
yeniledikten sonra ise silah dükkanına gidip bahsedilen araçları alabilir
Tüm ekipmanlar kazanıldıktan sonra bu cehennemden oyuncu ya kurtulur
ya da ölür 

```

We are making a text based adventure game with Java

#### Characters:

| Character | ID  | Demage | Health | Money |
|-----------|-----|--------|--------|-------|
| Samurai   | 1   | 4      | 23     | 14    |
| Archer    | 2   | 7      | 18     | 20    |
| Knight    | 3   | 8      | 24     | 10    |
| Legion    | 4   | 6      | 21     | 15    |

#### Monsters:

| Monster | ID  | Demage | Health | Money |
|---------|-----|--------|--------|-------|
| Zombie  | 1   | 4      | 22     | 6     |
| Vampire | 2   | 5      | 18     | 8     |
| Bear    | 3   | 3      | 26     | 10    |
   
#### Weapons:
| Weapons | ID  | Demage | Money |
|---------|-----|--------|-------|
| Pistol  | 1   | 3      | 25    |
| Sword   | 2   | 4      | 40    |
| Rifle   | 3   | 7      | 60    |
| Stunner | 4   | 1      | 10    |

#### Armors

| Armors | ID  | Block | Money |
|--------|-----|-------|-------|
| Light  | 1   | 1     | 15    |
| Medium | 2   | 3     | 25    |
| Heavy  | 3   | 5     | 40    |
| Strong | 4   | 7     | 60    |

### Places: 

```
Safe House
    -Attribute: Renewing Life
```
```
 Cave
    -Monster: Zombie(1-3)
    -Attribute: War + Loot
    -Item : Food
```
```
forest
    -Monster: Vampire (1-3 Pieces)
    -Attribute: War + Loot
    -Item: Wood (Firewood)
```
```
River
    -Monster : Bear (1-3 Pieces)
    -Attribute: War + Loot
    -Item: Water (Water)
```
```
Store
  -Attribute : Buying Supporting Items
  -Weapons: Pistol, Sword, Rifle
  -Armor: Light, Medium, Heavy
```

###  UML DİAGRAM: 


![](AdventureGameUml/AdventureGameUml.jpg)