package Insurance;

import java.util.Date;

public class InsuranceResidence extends Insurance{
    public InsuranceResidence(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 2000;
    }
}
