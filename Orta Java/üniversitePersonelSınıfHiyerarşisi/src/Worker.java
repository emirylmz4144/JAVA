public class Worker
{
 private String nameSurname;
 private String telNumber;
 private String eMail;

 Worker(String nameSurname,String telNumber,String eMail)
 {
     this.nameSurname=nameSurname;
     this.telNumber=telNumber;
     this.eMail=eMail;
 }

    public String getNameSurname()
    {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname)
    {
        this.nameSurname = nameSurname;
    }

    public String getTelNumber()
    {
        return telNumber;
    }

    public void setTelNumber(String telNumber)
    {
        this.telNumber = telNumber;
    }

    public String geteMail()
    {
        return eMail;
    }

    public void seteMail(String eMail)
    {
        this.eMail = eMail;
    }
    public String come()
    {
        return this.nameSurname+" Okula giriş yaptı";
    }
    public String exit()
    {
        return this.nameSurname+" Okuldan cıkıs yaptı";
    }
    public String Eating()
    {
        return this.nameSurname+" Yemek hakkını kullandı";
    }
}
