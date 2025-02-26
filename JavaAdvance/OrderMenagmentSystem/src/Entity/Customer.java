package Entity;

public class Customer {

    private int id;
    private String name;
    private String surname;
    private Type person_type;
    private String phone;
    private String e_mail;
    private String address;

    public Customer(String name, String surname, Type person_type, String phone, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.person_type = person_type;
        this.phone = phone;
        this.e_mail = email;
        this.address = address;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Type getPerson_type() {
        return person_type;
    }

    public void setPerson_type(Type person_type) {
        this.person_type = person_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", person_type=" + person_type +
                ", phone='" + phone + '\'' +
                ", email='" + e_mail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public enum Type {
        person,
        company
    }
}
