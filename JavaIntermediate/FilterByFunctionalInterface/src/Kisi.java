public class Kisi
{
    private String name;
    private String surName;
    private int age;
    private ARABADURUMU arabadurumu;

    public Kisi(String name, String surName, int age,ARABADURUMU arabadurumu) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.arabadurumu=arabadurumu;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ARABADURUMU getArabadurumu() {
        return arabadurumu;
    }

    public void setArabadurumu(ARABADURUMU arabadurumu) {
        this.arabadurumu = arabadurumu;
    }

    @Override
    public String toString()
    {
        return "AD:"+this.getName().toUpperCase()+" SOYAD: "+this.getSurName().toUpperCase()+" YAŞ: "+this.getAge()+" "+this.getArabadurumu();
    }

    public enum ARABADURUMU
    {
        VAR,YOK
    }
}
