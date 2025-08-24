import java.util.Objects;

public class Person
{
    private String name;
    private int age;

    private Gender gender;


    public Person(String name, int age,Gender gender) {
        this.name = name;
        this.age = age;
        this.gender=gender;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString()
    {
        return "Ad: "+this.name+" Yaş: "+this.age+" Cinsiyet: "+this.gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Gender {Erkek,Kadın}
}
