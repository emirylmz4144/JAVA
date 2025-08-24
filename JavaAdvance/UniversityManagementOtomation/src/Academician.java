public class Academician extends Worker
{
    private String branch;
    private String title;
    Academician(String nameSurname,String telNumber,String email,String branch,String title)
    {
        super(nameSurname,telNumber,email);
        this.branch=branch;
        this.title=title;
    }

    public String getBranch()
    {
        return branch;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public String attendClass()
    {
        return super.getNameSurname() +" "+this.title+" "+" olarak derse girdi";
    }
}
