package Account;

import Insurance.Insurance;

public class Individual extends Account{
    public Individual(User user) {
        super(user);
    }

    @Override
    public double addInsurancePolicy() {
        double price=0;
        for (Insurance insurance:getUsersInsurance())
        {
            price+=insurance.calculate();
        }
        return price*1.1;
    }

}
