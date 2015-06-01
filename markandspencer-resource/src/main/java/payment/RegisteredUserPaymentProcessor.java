package payment;

import utils.MovieBuyerObject;

/**
 * Created by Ugo on 01/06/2015.
 */

public class RegisteredUserPaymentProcessor extends AbstractPaymentProcessor {
    public RegisteredUserPaymentProcessor(double discount){
        super(discount);
    }


    @Override
    public boolean canProcess(MovieBuyerObject movieBuyerObject) {
        if(movieBuyerObject.getUserId() != null){
            return true;
        }
        return false;
    }

    @Override
    public double process(double totalCost) {
        double cost = (totalCost/100) * getDiscount();
        return cost;
    }
}
