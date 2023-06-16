package org.restbankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        AccountController accountController = new AccountController();

        //Act
        accountController.deposit(request, response);

        //Assert
        verify(accountService).deposit(amount);
    }

}