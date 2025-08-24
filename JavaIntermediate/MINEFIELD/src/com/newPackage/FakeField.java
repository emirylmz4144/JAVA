package com.newPackage;

public class FakeField extends Field
{
    int olusacakSatir,olusacakSutun;
    int[][] olusacakTarla1;
    FakeField (int olusacakSatir,int olusacakSutun)
    {
        super(olusacakSatir,olusacakSutun);
        this.olusacakSatir=olusacakSatir;
        this.olusacakSutun=olusacakSutun;
        olusacakTarla1 = new int[this.olusacakSatir][this.olusacakSutun];
    }
    public int[][] create()
    {

        for (int i = 0; i< olusacakSatir; i++)
        {
            for (int j = 0; j < olusacakSutun; j++)
            {
                this.olusacakTarla1[i][j] = 0;
            }
        }
        return olusacakTarla1;
    }
}
