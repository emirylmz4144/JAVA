package com.newPackage;
import java.util.Scanner;

public class Field
{
    Scanner veri = new Scanner(System.in);
    int olusacakSatir, olusacakSutun;

              Field(int olusacakSatir, int olusacakSutun)
             {
                  this.olusacakSatir = olusacakSatir;
                  this.olusacakSutun = olusacakSutun;
             }

                   public void run()
                  {
                      ReelField reelField = new ReelField(olusacakSatir, olusacakSutun);
                      FakeField fakeField = new FakeField(olusacakSatir, olusacakSutun);

                      int kazanmaDurumu = 0;
                      int puan = 0;

                      int[][] olusacakTarla = reelField.create();
                      int[][] gosterilecekTarla = fakeField.create();

                               while (true)
                              {
                                  for (int [] k :gosterilecekTarla)
                                 {
                                      for (int m : k)
                                      {
                                         if (m>=0)
                                        {
                                           System.out.print(" "+m);
                                        }
                                         else
                                        {
                                           System.out.print(m);
                                        }
                                      }
                                        System.out.println();
                                 }
                              if (kazanmaDurumu ==(((olusacakSatir * olusacakSutun)- ((olusacakSatir*olusacakSutun)/3))))
                              {
                                  System.out.println("Tebrikler Kazandiniz..");
                                  System.out.println("Paniniz: " + puan);
                                  break;
                              }

                             System.out.print("Lütfen bir satir giriniz: ");
                             int satir = veri.nextInt();
                             System.out.print("Lütfen bir sütun giriniz: ");
                             int sutun = veri.nextInt();



                             if (satir < 0 || sutun < 0 || satir > olusacakSatir || sutun > olusacakSutun)
                               {
                                 System.out.println("Lütfen harita içinden bir alan seçiniz");
                                 continue;
                               }
                              if (olusacakTarla[satir][sutun] == -1)
                              {
                                System.out.println("Öldünüz..");
                                System.out.print("Puaniniz: " + puan);
                                break;
                              }
                              kazanmaDurumu++;
                             if ((sutun - 1) >=0 && olusacakTarla[satir][sutun - 1] == -1)
                             {
                                 gosterilecekTarla[satir][sutun]++;
                                 puan += 10;
                             }
                             if ((satir - 1) >=0 && olusacakTarla[satir - 1][sutun] == -1)
                             {
                                 gosterilecekTarla[satir][sutun]++;
                                 puan += 10;
                             }
                             if ((sutun + 1) < olusacakSutun && olusacakTarla[satir][sutun + 1] == -1)
                             {
                                 gosterilecekTarla[satir][sutun]++;
                                 puan += 10;
                             }
                             if ((satir + 1) < olusacakSatir && olusacakTarla[satir + 1][sutun] == -1)
                             {
                               gosterilecekTarla[satir][sutun]++;
                               puan +=10;
                             }
                            if (gosterilecekTarla[satir][sutun]==0)
                            {
                                 gosterilecekTarla[satir][sutun]=-2;
                            }
            }
        }
    }

