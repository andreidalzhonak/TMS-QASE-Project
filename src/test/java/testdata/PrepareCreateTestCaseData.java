package testdata;

import models.CreateTestCaseDataModel;
import utils.FakeMessageGenerator;
import utils.GenerateTestData;

public class PrepareCreateTestCaseData {
    public static CreateTestCaseDataModel getCreateTestCaseData() {
        return CreateTestCaseDataModel
                .builder()
                .title(FakeMessageGenerator.generateTestCaseTitle())
                .description(FakeMessageGenerator.generateDescriptionTestCase())
                .status(GenerateTestData.getStatus())
                .suite(GenerateTestData.getSuite())
                .severity(GenerateTestData.getSeverity())
                .priority(GenerateTestData.getPriority())
                .type(GenerateTestData.getType())
                .layer(GenerateTestData.getLayer())
                .isFlaky(GenerateTestData.getIsFlaky())
                .milestone(GenerateTestData.getMilestone())
                .behavior(GenerateTestData.getBehavior())
                .automationStatus(GenerateTestData.getAutomationStatus())
                .preconditions(FakeMessageGenerator.generatePreConditionsTestCase())
                .postCondition(FakeMessageGenerator.generatePostConditionsTestCase())
                .action(FakeMessageGenerator.generateAction())
                .inputData(FakeMessageGenerator.generateInputDataTestCase())
                .expectedResult(FakeMessageGenerator.generateExpectedResult())
                .build();
    }
}