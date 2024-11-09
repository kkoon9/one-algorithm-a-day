package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        int simplePrice = 20000;
        Integer rowPriceResult = calculateTotalSupplyPrice(simplePrice);
        System.out.println("간단한 금액 : " + rowPriceResult);
        int complicatedPrice = 234131414;
        Integer highPriceResult = calculateTotalSupplyPrice(complicatedPrice);
        System.out.println("복잡한 금액 : " + highPriceResult);

    }

    public static Integer calculateTotalSupplyPrice(final int price) {
        BigDecimal bdPrice = new BigDecimal(price);
        BigDecimal rate = BigDecimal.valueOf(1.1);

        return bdPrice.divide(rate, 0, RoundingMode.FLOOR).intValue();
    }
}
