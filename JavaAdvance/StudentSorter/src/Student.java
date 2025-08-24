public class Student
{
    private String name;
   private int ID;
   private double CPGA;

    public Student (String name,double CPGA,int age)
    {
        this.name=name;
        this.CPGA=CPGA;
        this.ID =age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getCPGA() {
        return CPGA;
    }

    public void setCPGA(double CPGA) {
        this.CPGA = CPGA;
    }
}
