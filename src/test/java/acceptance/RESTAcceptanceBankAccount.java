package acceptance;

import com.eclipsesource.json.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restbankaccount.AccountController;
import org.restbankaccount.AccountService;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RESTAcceptanceBankAccount {

    @Mock
    private Request request;
    @Mock
    private Response response;
    @Mock
    private AccountService accountService;

    @Test
    void should_be_able_to_deposit_and_withdraw_and_then_print_the_operations_statement(){
        //Arrange
        AccountController accountController = new AccountController(accountService);

        //Act
        accountController.deposit(request, response);
        accountController.deposit(request, response);
        accountController.withdraw(request, response);

        String received = accountController.printStatement();
        //Assert
        String expected = """
                Date       || Amount || Balance
                14/01/2012 || -500   || 2500
                13/01/2012 || 2000   || 3000
                10/01/2012 || 1000   || 1000
                """;
        assertEquals(expected, received);
    }

}
