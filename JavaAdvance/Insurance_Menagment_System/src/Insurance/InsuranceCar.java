package Insurance;

import java.util.Date;

public class InsuranceCar extends Insurance{
    public InsuranceCar(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 1200;
    }
}
