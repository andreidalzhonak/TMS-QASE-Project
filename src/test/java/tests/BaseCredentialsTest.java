package tests;

import models.CredentialsModel;
import org.testng.annotations.BeforeMethod;

public class BaseCredentialsTest {
    public CredentialsModel admin;

    @BeforeMethod
    public void getAdmin() {
        admin = CredentialsModel
                .builder()
                .email(System.getProperty("email"))
                .password(System.getProperty("password"))
                .token(System.getProperty("token"))
                .build();
    }
}
