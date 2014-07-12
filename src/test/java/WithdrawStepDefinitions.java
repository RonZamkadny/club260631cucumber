import cucumber.annotation.ru.Дано;
import cucumber.annotation.ru.Когда;
import cucumber.annotation.ru.Тогда;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class WithdrawStepDefinitions {

    private static final String FLOAT_POINT_NUMBER_REGEX = "([-+]?[0-9]*\\.?[0-9]*)";
    private Account account;

    @Дано("^у пользователя изначально нет денег на счете$")
    public void у_пользователя_изначально_нет_денег_на_счете() {
        User user = new User();
        account = new Account();
        user.setAccount(account);

        assertTrue("The balance is not zero", account.getBalance().equals(new BigDecimal(0)));
    }

    @Когда("^будет зачислено £" + FLOAT_POINT_NUMBER_REGEX + "$")
    public void будет_зачислено_£(String amount) {
        account.deposit(new BigDecimal(amount));
    }

    @Тогда("^вывести со счета £" + FLOAT_POINT_NUMBER_REGEX + "$")
    public void вывести_со_счета_£(String amount) {
        account.setBalance(account.getBalance().subtract(new BigDecimal(amount)));
    }

    @Тогда("^баланс должен стать £" + FLOAT_POINT_NUMBER_REGEX + "$")
    public void баланс_должен_стать_£(String balance) {
        assertTrue("The balance is not as expected", account.getBalance().toPlainString().equals(balance));
    }
}