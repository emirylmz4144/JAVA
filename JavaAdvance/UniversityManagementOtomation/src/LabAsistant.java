public class LabAsistant extends Asistant
{
    LabAsistant(String nameSurname, String telNumber, String email, String branch, String title,int officeTime)
    {
        super(nameSurname, telNumber, email, branch, title,officeTime);
    }
    public String intoTheLabs()
    {
        return super.getNameSurname()+" "+getTitle()+" unvanında laboratuvara giriş yaptı";
    }
    public String intoTheClass()
    {
        return super.getNameSurname()+" "+getTitle()+" Derse  giriş yaptı";
    }

}
