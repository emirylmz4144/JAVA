package Insurance;

import java.util.Date;

public class InsuranceTravel extends Insurance{
    public InsuranceTravel(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 700;
    }
}
