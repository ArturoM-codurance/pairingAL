package org.restbankaccount;

import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        AccountController accountController = new AccountController(accountService);
        post("/deposit", "application/json", accountController::deposit);

    }
}