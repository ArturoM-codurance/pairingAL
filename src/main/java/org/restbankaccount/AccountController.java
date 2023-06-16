package org.restbankaccount;


import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import spark.Request;
import spark.Response;

public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public String deposit(Request request, Response response) {
        JsonObject JSONBody = Json.parse(request.body()).asObject();
        int amount = JSONBody.getInt("amount", 0);
        accountService.deposit(amount);
        return null;
    }

    public String withdraw(Request request, Response response) {
        throw new UnsupportedOperationException();
    }

    public String printStatement() {
        throw new UnsupportedOperationException();
    }
}
