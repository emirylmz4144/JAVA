package Insurance;

import java.util.Date;

public abstract class Insurance
{
    private String insuranceName;
    private int insurancePrice;
    private Date insuranceStartDate;
    private Date insuranceFinishDate;



    public Insurance(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceFinishDate = insuranceFinishDate;
    }

    public abstract double calculate();
    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public int getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(int insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public Date getInsuranceFinishDate() {
        return insuranceFinishDate;
    }

    public void setInsuranceFinishDate(Date insuranceFinishDate) {
        this.insuranceFinishDate = insuranceFinishDate;
    }
}
