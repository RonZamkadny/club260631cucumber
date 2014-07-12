import cucumber.annotation.ru.Дано;
import cucumber.annotation.ru.Когда;
import cucumber.annotation.ru.Тогда;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class DepositStepDefinitions {

    private static final String FLOAT_POINT_NUMBER_REGEX = "([-+]?[0-9]*\\.?[0-9]*)";
    private Account account;

    @Дано("^у пользователя изначально нет денег$")
    public void у_пользователя_изначально_нет_денег() {
        User user = new User();
        account = new Account();
        user.setAccount(account);

        assertTrue("The balance is not zero", account.getBalance().equals(new BigDecimal(0)));
    }

    @Когда("^будет зачислено на счет £"+ FLOAT_POINT_NUMBER_REGEX +"$")
    public void будет_зачислено_на_счет£(String amount) {
        // Express the Regexp above with the code you wish you had
        account.deposit(new BigDecimal(amount));
    }

    @Тогда("^баланс будет £" + FLOAT_POINT_NUMBER_REGEX + "$")
    public void баланс_будет_£_(String balance) {

        assertTrue("The balance is not expected", account.getBalance().toPlainString().equals(balance));
    }
}