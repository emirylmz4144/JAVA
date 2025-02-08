package Account;

import Address.*;
import Insurance.Insurance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class Account implements Comparable
{
    private User user;
    private   List<Insurance> usersInsurance;

    private AuthenticationStatus status;

    public Account(User user)
    {
        this.user=user;
        this.usersInsurance=new ArrayList<>();
    }

    public void showUserInfo()
    {
        System.out.println("----------------Kullanıcı bilgileri-------------------");
        System.out.println("Adı: "+this.getUser().getName());
        System.out.println("Soyadı: "+this.getUser().getSurName());
        System.out.println("Mesleği: "+this.getUser().getJob());
        System.out.println("Son aktif olduğu zaman "+this.getUser().getLastLogin());
        System.out.println("---adres bilgileri---");
        for (Address address:this.getUser().getUsersAddress())
            System.out.println(address.toString());
        System.out.println("------------------");


    }

    public AuthenticationStatus login(String eMail,String password) throws InvalidAuthanticationStatus {
        if (this.getUser().geteMail().equals(eMail)&&this.getUser().getPassword().equals(password))
        {
            getUser().setLastLogin(LocalDateTime.now());
            status=AuthenticationStatus.SUCCESS;
        }

        else
        {
            status=AuthenticationStatus.FAIL;
            throw new InvalidAuthanticationStatus("Böyle bir kullanıcı bulunmamaktadır");
        }
        return status;
    }

    public void addAddress()
    {
        AddressMenager.addAddress(this.user);
    }
    public void deleteAddress()
    {
        AddressMenager.deleteAddress(this.user);
    }

    @Override
    public int hashCode()
    {
        return this.getUser().geteMail().hashCode();
    }
    @Override
    public boolean equals(Object o)
    {
        User userForEqualsMethod=(User) o;
        return userForEqualsMethod.geteMail().equals(this.getUser().getName());
    }
    @Override
    public int compareTo(Object o) {
        Account account=(Account) o;
        return this.getUser().getName().compareTo(account.getUser().getName());
    }
    public abstract double addInsurancePolicy();
    enum AuthenticationStatus
    {
        FAIL,
        SUCCESS
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Insurance> getUsersInsurance() {
        return usersInsurance;
    }

    public void setUsersInsurance(List<Insurance> usersInsurance) {
        this.usersInsurance = usersInsurance;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }
}
