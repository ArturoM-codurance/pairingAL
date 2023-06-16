package acceptance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restbankaccount.AccountController;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RESTAcceptanceBankAccount {

    @Mock
    private Request request;
    @Mock
    private Response response;

    @Test
    void should_be_able_to_deposit_and_withdraw_and_then_print_the_operations_statement(){
        //Arrange
        AccountController accountController = new AccountController();

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
