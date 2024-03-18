package com.cydeo.loosely;


import com.cydeo.loosely.CustomerBalance;
import com.cydeo.loosely.GiftCardBalance;

import java.math.BigDecimal;
import java.util.UUID;

public class BalanceService {
    Balance balance;

    public BalanceService(Balance balance) {
        this.balance = balance;
    }

    public boolean checkoutFromBalance(BigDecimal checkoutAmount) {

        BigDecimal customerBalanceAmount = this.balance.getAmount();

        if (balance.getAmount().subtract(checkoutAmount).compareTo(BigDecimal.ZERO) >= 0) {
            balance.setAmount(customerBalanceAmount.subtract(checkoutAmount));
            return true;
        }

        return false;
    }


}





