package Insurance;

import java.util.Date;

public class InsuranceHealth extends Insurance{
    public InsuranceHealth(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 1400;
    }
}
