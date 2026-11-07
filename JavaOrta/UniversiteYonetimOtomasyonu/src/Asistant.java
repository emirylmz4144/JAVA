public class Asistant extends Academician
{
    private int officeTime;
    Asistant(String nameSurname, String telNumber, String email, String branch, String title,int officeTime)
    {
        super(nameSurname, telNumber, email, branch, title);
        this.officeTime=officeTime;
    }

    public int getOfficeTime()
    {
        return officeTime;
    }

    public void setOfficeTime(int officeTime)
    {
        this.officeTime = officeTime;
    }
    public String doQuiz()
    {
        return super.getNameSurname()+" "+getBranch()+" alanında"+getTitle()+" dersinin quizini yaptı";
    }

}
