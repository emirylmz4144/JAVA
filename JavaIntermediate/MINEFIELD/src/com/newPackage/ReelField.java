package com.newPackage;
import java.util.Random;

public class ReelField extends Field
{
    Random random=new Random();
    int olusacakSatir,olusacakSutun;
    int olusacakMayin=0;
    ReelField(int olusacakSatir,int olusacakSutun)
    {
        super(olusacakSatir,olusacakSutun);
        this.olusacakSatir=olusacakSatir;
        this.olusacakSutun=olusacakSutun;

    }
    public int[][] create()
    {
        olusacakMayin=(olusacakSatir*olusacakSutun)/3;
        FakeField fakeField=new FakeField(olusacakSatir,olusacakSutun);
        int[][] olusacakTarla1=fakeField.create();
        while (olusacakMayin>0)
        {
            int i=random.nextInt(0,olusacakSatir);
            int j= random.nextInt(0,olusacakSutun);
            if (olusacakTarla1[i][j]!=-1)
            {
                olusacakTarla1[i][j]=-1;
            }
            olusacakMayin--;
        }
        return olusacakTarla1;
    }


}
