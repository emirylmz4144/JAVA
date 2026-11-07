package HospitalOtomation;

public class Patient extends Person
{

    private String tc;
    public Patient(String id,String name, String surName, String genter,String age,String tc) {
        super(id,name,surName,genter,age);
        this.tc=tc;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
}
