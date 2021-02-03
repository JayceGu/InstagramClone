package com.example.instagramapp;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("UsquDcdaiL75i6qmIIrtWQ067nRdMSKJ7DU89A33")
                .clientKey("wimzIK0NZhsWEx0WcqCorXxiHvodwwtgSPCqq7Ge")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    };


}
