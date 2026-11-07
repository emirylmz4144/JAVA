package Address;

public class HomeAddress implements Address
{

    private String city;
    private String town;
    private String neighborhood;
    private String street;
    private String builName;
    private int doorNumber;

    public HomeAddress(String city, String town, String neighborhood, String street, String builName, int doorNumber) {
        this.city = city;
        this.town = town;
        this.neighborhood = neighborhood;
        this.street = street;
        this.builName = builName;
        this.doorNumber = doorNumber;
    }


    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String city) {
        this.city=city;
    }

    @Override
    public String getTown() {
        return this.town;
    }

    @Override
    public void setTown(String town) {
        this.town=town;
    }

    @Override
    public String getNeighborhood() {
        return this.neighborhood;
    }

    @Override
    public void setNeighborhood(String neighborhood) {
        this.neighborhood=neighborhood;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public void setStreet(String street) {
        this.street=street;
    }

    @Override
    public String getBuilOrCompanyName() {
        return this.builName;
    }

    @Override
    public void setBuilOrCompanyName(String buildOrCompanyName) {
        this.builName= buildOrCompanyName;
    }

    @Override
    public int getDoorOrComplexNumber() {
        return this.doorNumber;
    }

    @Override
    public void setDoorOrComplexNumber(int buildOrComplexNumber) {
        this.doorNumber= buildOrComplexNumber;
    }
    @Override
    public String toString()
    {
        return this.city+"/"+this.town+"/"+this.neighborhood+"/"+this.street+"/"+this.builName+"/"+this.doorNumber;
    }
}
