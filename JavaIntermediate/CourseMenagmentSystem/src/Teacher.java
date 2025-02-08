public class Teacher {
    String name;
    String mobilePhoneNumber;
    String branch;

    public Teacher(String name, String mobilePhoneNumber, String branch)
    {
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}