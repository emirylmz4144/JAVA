import java.util.*;

public class FixtureCreater
{
    Scanner input=new Scanner(System.in);
    ArrayList <String> clubs=new ArrayList<>();// Takımların ekleneceği arrayList
    ArrayList <String >coupleTeams=new ArrayList<>();// Fikstüre eklenmiş olan takımların eklendiği arrayList
    int fixtureValue=0;// O hafta takım sayasına göre kaç adet maç oynanacağını belirleyecek sayaçta kullanılacak sayaç(ileride anlatılacak)

    Random random=new Random();


    public void run()
    {

        boolean status=true;
        while (status)
        {

            System.out.println("""
                Lütfen yapmak istediğiniz işlemi seçiniz:\s
                1-Takım ekleme
                2-Fikstür oluşturma
                0-Çıkış""");

            System.out.println("--------------------");
            int choose=input.nextInt();


            switch (choose) {
                case 1 -> {
                    System.out.print("Eklenecek olan takımın adını giriniz: ");
                    input.nextLine();
                    String clubName = input.nextLine();
                    clubs.add(clubName);
                    System.out.println("Takım eklendi: " + clubs.get(clubs.size() - 1));
                    System.out.println("--------------------");
                }
                case 2 -> createFixture();
                case 0 -> status = false;
                default -> System.out.println("Lütfen geçerli bir işlen giriniz..");
            }
        }
    }


    public void createFixture()
    {
        if (clubs.size()%2!=0)//Takım sayısı 'Bay' adında takım
            clubs.add("Bay");


        for (int i=0;i<clubs.size()-1;i++)//kulüp sayısının 1 eksiğinin 2 katı kadar fixtür olacaktır
        {
            String away;
            String home;
            int matchQuality=0;
            String selectedTeams="";// bir sonraki haftaya geçildiği için seçilen takımlar listesi boşaltılır(Kullanım amacı aşağıdadır)




               while (matchQuality<clubs.size()/2)//ilgilil haftada maç sayısının yarısı kadar maç vardır
               {
                    away=clubs.get(random.nextInt(clubs.size()));//random bir takım
                    home=clubs.get(random.nextInt(clubs.size()));//random bir takım
                      if (!away.equals(home))//Aynı takımın seçilmesi engellenmiştir
                      {
                             if (!selectedTeams.contains(away) && !selectedTeams.contains(home))//O hafta maç yapan takımlar *o hafta* birdaha seçilmemelidir
                             {
                                 String match1=(away+" vs "+home);//Hem rövanş hem normal maç eklenir böylece fixtürler sağlanmış olur
                                 String match2=(home+" vs "+away);

                                     if (!coupleTeams.contains(match1) && !coupleTeams.contains(match2))//müsabaka yapan takımlar birdaha karşılaşmamalıdır
                                     {
                                         coupleTeams.add(match1);//Maç yapan takımlar listeye eklenerek birdaha karşılaşmamaları sağlanmıştır
                                         coupleTeams.add(match2);

                                         selectedTeams+=home;//O hafta maç yapan takımlar birdaha seçilmemesi için bir stringe atanmıştır
                                         selectedTeams+=away;

                                         matchQuality++;//O haftada oynanması gereken maç miktarı şartlar sağlanırsa arttırılır
                                     }
                             }
                      }

               }
        }

        printFixtures();
    }

    public void printFixtures()
    {
       for (int bringMeet=0;bringMeet<coupleTeams.size();bringMeet+=2)
       {
           /*bringMeet 0 dan başlayarak 2 şer 2 şer artar çünki müsabakalar eklendiğinde rövanş maçlarıda eklenmektedir
            bu yüzden rövanş maçlarıdan önce normal maçları yazdırmak için böyle bir yöntem eklenmiştir */

           fixtureValue++;// Döngünün artış miktarından dolayı fixtürün doğru yazılması için bir değişken atanmıştır

           System.out.println("--------Fixture "+fixtureValue+"--------");
           int fixtureCounter=0;//O haftadaki maç miktarı sağlanana kadar devam edecek döngü için eklenene değişken
           while (fixtureCounter<clubs.size()/2)
           {
               /*Burada ise bringMeet'den gelen değerden o haftaki maç miktarın kadar maçları ekrana yazdıracağımız için
               bringMeet'den gelen değerden maç miktarı kadar 2 şer 2 şer ekrana yazdırırız  */
               System.out.println(coupleTeams.get(bringMeet));
               fixtureCounter++;
               bringMeet+=2;
               if (bringMeet>=coupleTeams.size())//Eğer toplam maç miktarını geçerse döngüyü kır.
                   break;
           }

           bringMeet-=2;/*En sonda bringMeet'i 2 arttıracak ve while sağlanmayacak ama ilgili haftakii maçı silmiş olacak
                         bu yüzden azaltıyoruz (2 maç varsa 0 ve 2 yazacak ama 4 olunca whiledan çıkacak ve fora gidince 6 olacak
                                                 bu yüzden 4.değerdeki maç kaybolmasın diye azaltıyoruz..)  */
       }


        for (int bringMeet=1;bringMeet<coupleTeams.size();bringMeet+=2)
        {
            //rövanş maççları yazdırılıyor
            fixtureValue++;
            System.out.println("--------Fixture "+fixtureValue+"--------");
            int fixtureCounter=0;
            while (fixtureCounter<clubs.size()/2)
            {
                System.out.println(coupleTeams.get(bringMeet));
                fixtureCounter++;
                bringMeet+=2;

                if (bringMeet>=coupleTeams.size())
                {
                    break;
                }
            }
            bringMeet-=2;
        }
    }
}
