package org.restbankaccount;

import com.eclipsesource.json.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountControllerShould {

    @Mock
    private Request request;
    @Mock
    private Response response;

    @Test
    void call_account_service_when_storing_a_deposit(){
        //Arrange
        int amount = 10;
        AccountService accountService = mock(AccountService.class);
        AccountController accountController = new AccountController(accountService);
        when(request.body()).thenReturn(new JsonObject().add("amount", amount).toString());

        //Act
        accountController.deposit(request, response);

        //Assert
        verify(accountService).deposit(amount);
    }

}