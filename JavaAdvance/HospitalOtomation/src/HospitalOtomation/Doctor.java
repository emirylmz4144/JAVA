package HospitalOtomation;

public class Doctor extends Person
{
    private String branch;

    public Doctor(String id,String name, String surName,String genter, String age,String branch) {
        super(id,name, surName, genter, age);
        this.branch=branch;

    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
