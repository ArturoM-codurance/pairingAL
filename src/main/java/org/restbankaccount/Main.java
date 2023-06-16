package org.restbankaccount;

import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {

        AccountController accountController = new AccountController();
        post("/account", "application/json", accountController::deposit);

    }
}