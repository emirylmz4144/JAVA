public class Officer extends Worker
{
    private String depertment;
    private int shift;
    Officer(String nameSurname, String telNumber, String eMail,String depertment,int  shift)
    {
        super(nameSurname, telNumber, eMail);
        this.depertment=depertment;
        this.shift=shift;
    }

    public String getDepertment()
    {
        return depertment;
    }

    public void setDepertment(String depertment)
    {
        this.depertment = depertment;
    }

    public int getShift()
    {
        return shift;
    }

    public void setShift(int shift)
    {
        this.shift = shift;
    }
    public String work()
    {
        return super.getNameSurname()+" "+this.depertment+" bölümünde günlük çalışmasına başladı";
    }
}
