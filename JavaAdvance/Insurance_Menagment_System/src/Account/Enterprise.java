package Account;

import Insurance.Insurance;

public class Enterprise extends Account {

    public Enterprise(User user) {
        super(user);
    }

    @Override
    public double addInsurancePolicy() {
        double price=0;
        for (Insurance insurance:getUsersInsurance())
        {
            price+=insurance.calculate();
        }
      return price*1.4;
    }

}
