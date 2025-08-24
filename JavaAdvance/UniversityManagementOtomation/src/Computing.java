public class Computing extends Officer
{
    private String task;
    Computing(String nameSurname, String telNumber, String eMail, String depertment, int shift,String task)
    {
        super(nameSurname, telNumber, eMail, depertment, shift);
        this.task=task;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }
    public String networkCreate()
    {
        return super.getNameSurname()+" "+super.getDepertment()+" "+getTask()+" görevinde network Kurmaya başladı";
    }
}
