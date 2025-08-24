public class Lecturer extends Academician
{
    private int doorNumber;
    Lecturer(String nameSurname, String telNumber, String email, String branch, String title,int doorNumber)
    {
        super(nameSurname, telNumber, email, branch, title);
        this.doorNumber=doorNumber;
    }

    public int getDoorNumber()
    {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber)
    {
        this.doorNumber = doorNumber;
    }
    public String meeting()
    {
        return super.getNameSurname()+" "+super.getTitle()+" "+this.doorNumber+" dan toplantıya katıldı";
    }
    public String exam()
    {
        return super.getNameSurname()+" "+super.getBranch()+" alanında sınav yaptı";
    }
}
