package HospitalOtomation;

public abstract class Person
{
    private String id;
    private String name;
    private String surName;
    private String genter;
    private String age;


    public Person(String id,String name, String surName, String genter,String age) {

        this.id=id;
        this.name = name;
        this.surName = surName;
        this.genter = genter;
        this.age = age;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGenter() {
        return genter;
    }

    public void setGenter(String genter) {
        this.genter = genter;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



}
