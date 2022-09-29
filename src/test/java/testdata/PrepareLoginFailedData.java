package testdata;

import models.FailedLoginData;
import utils.FakeMessageGenerator;


public class PrepareLoginFailedData {

    public static FailedLoginData getValidData() {
        return FailedLoginData
                .builder()
                .email(FakeMessageGenerator.generateAccountEmail())
                .password(FakeMessageGenerator.generateAccountPassword())
                .build();
    }
}