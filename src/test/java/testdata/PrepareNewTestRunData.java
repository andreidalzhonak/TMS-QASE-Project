package testdata;


import models.StartTestRunsDataModel;
import utils.FakeMessageGenerator;
import utils.GenerateTestData;

public class PrepareNewTestRunData {
    public static StartTestRunsDataModel getTestRunData() {
        return StartTestRunsDataModel
                .builder()
                .description(FakeMessageGenerator.generateDescriptionTestRun())
                .milestone(GenerateTestData.getMilestone())
                .defaultAssignee(GenerateTestData.getDefaultAssignee())
                .suite(GenerateTestData.getSuite())
                .build();
    }
}