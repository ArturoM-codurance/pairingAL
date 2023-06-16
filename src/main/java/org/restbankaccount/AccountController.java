package org.restbankaccount;

import spark.Request;
import spark.Response;

public class AccountController {

    public String deposit(Request request, Response response) {
        return null;
    }

    public String withdraw(Request request, Response response) {
        throw new UnsupportedOperationException();
    }

    public String printStatement() {
        throw new UnsupportedOperationException();
    }
}
