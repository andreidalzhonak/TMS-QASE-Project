package testdata;

import models.CreateTestSuiteDataModel;
import utils.FakeMessageGenerator;

public class PrepareCreateSuiteData {

    public static CreateTestSuiteDataModel getCreateSuiteData() {
        return CreateTestSuiteDataModel
                .builder()
                .suiteName(FakeMessageGenerator.generateSuiteName())
                .description(FakeMessageGenerator.generateDescriptionNewSuite())
                .preconditions(FakeMessageGenerator.generatePreconditionsNewSuite())
                .build();
    }
}