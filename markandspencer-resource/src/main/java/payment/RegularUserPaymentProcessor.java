package payment;

import utils.MovieBuyerObject;

/**
 * Created by Ugo on 01/06/2015.
 */

public class RegularUserPaymentProcessor extends AbstractPaymentProcessor {


    public RegularUserPaymentProcessor(double discount) {
        super(discount);
    }

    @Override
    public boolean canProcess(MovieBuyerObject movieBuyerObject) {

        if(movieBuyerObject.getUserId() == null){
            return true;
        }
        return false;
    }

    @Override
    public double process(double totalCost) {
        return totalCost;
    }
}
