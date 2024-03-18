package com.cydeo.loosely;

import com.cydeo.loosely.BalanceService;
import com.cydeo.loosely.CustomerBalance;
import com.cydeo.loosely.GiftCardBalance;

import java.math.BigDecimal;
import java.util.UUID;

public class CouplingTestRunner {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

       Balance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
     Balance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);

        BalanceService custombalanceService = new BalanceService(customerBalance);
        BalanceService gifitbalanceService = new BalanceService(giftCardBalance);
        customerBalance.addBalance(BigDecimal.valueOf(100));
        giftCardBalance.addBalance(BigDecimal.valueOf(100));

        System.out.println("CUSTOMER BALANCE:");
        System.out.println(customerBalance.getAmount()); // 100
        System.out.println(custombalanceService.checkoutFromBalance(BigDecimal.valueOf(50)));
        System.out.println(customerBalance.getAmount()); // 50

        System.out.println("GIFT CARD BALANCE:");
        System.out.println(giftCardBalance.getAmount()); // 110
        System.out.println(gifitbalanceService.checkoutFromBalance(BigDecimal.valueOf(50)));
        System.out.println(giftCardBalance.getAmount()); // 60



    }
}
