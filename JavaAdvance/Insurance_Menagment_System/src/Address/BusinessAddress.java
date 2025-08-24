package Address;

public class BusinessAddress implements Address
{
    private String city;
    private String town;
    private String neighborhood;
    private String street;
    private String companyName;
    private int complexNumber;

    public BusinessAddress(String city, String town, String neighborhood, String street, String companyName, int complexNumber) {
        this.city = city;
        this.town = town;
        this.neighborhood = neighborhood;
        this.street = street;
        this.companyName = companyName;
        this.complexNumber = complexNumber;
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
        return this.companyName;
    }

    @Override
    public void setBuilOrCompanyName(String buildOrCompanyName) {
        this.companyName=companyName;
    }

    @Override
    public int getDoorOrComplexNumber() {
        return this.complexNumber;
    }

    @Override
    public void setDoorOrComplexNumber(int buildOrComplexNumber) {
        this.complexNumber=complexNumber;
    }

    @Override
    public String toString()
    {
        return this.city+"/"+this.town+"/"+this.neighborhood+"/"+this.street+"/"+this.companyName+"/"+this.complexNumber;
    }

}
