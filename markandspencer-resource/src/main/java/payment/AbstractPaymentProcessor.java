package payment;

import utils.MovieBuyerObject;

/**
 * Created by Ugo on 01/06/2015.
 */

public abstract class AbstractPaymentProcessor {

    private final double discount;

    public AbstractPaymentProcessor(double discount){
        this.discount = discount;
    }

    public abstract boolean canProcess(MovieBuyerObject movieBuyerObject);

    public abstract double process(double totalCost);

    public final double getDiscount(){
        return discount;
    }
}
