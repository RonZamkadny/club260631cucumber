import java.math.BigDecimal;

/**
 * Created by ronx on 10.07.2014.
 */
public class Account {


    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount)   {
        balance = balance.add(amount);
    }
}
