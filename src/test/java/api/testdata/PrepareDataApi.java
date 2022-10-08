package api.testdata;

import api.models.MilestoneModel;
import api.models.StepsModel;
import api.models.TestCaseModel;
import api.models.TestSuiteModel;
import utils.FakeMessageGenerator;
import java.util.ArrayList;
import java.util.List;

public class PrepareDataApi {
    public static MilestoneModel getValidDataForMilestoun() {
        return MilestoneModel
                .builder()
                .title(FakeMessageGenerator.generateTitleApi())
                .description(FakeMessageGenerator.generateDescriptionApi())
                .due_date(FakeMessageGenerator.generateDueDataApi())
                .build();
    }

    public static TestSuiteModel getValidDataForTestSuite() {
        return TestSuiteModel
                .builder()
                .title(FakeMessageGenerator.generateTitleApi())
                .description(FakeMessageGenerator.generateDescriptionApi())
                .precondition(FakeMessageGenerator.generatePreconditionApi())
                .parent_id(FakeMessageGenerator.generateParent())
                .build();
    }

    public static TestCaseModel getValidDataForTestCase() {
        return TestCaseModel
                .builder()
                .steps(getValidObjectForTestCase())
                .description(FakeMessageGenerator.generateDescriptionApi())
                .preconditions(FakeMessageGenerator.generatePreconditionApi())
                .postconditions(FakeMessageGenerator.generatePostconditionApi())
                .severity(FakeMessageGenerator.generateSeverity())
                .priority(FakeMessageGenerator.generatePriority())
                .title(FakeMessageGenerator.generateTitleApi())
                .behavior(FakeMessageGenerator.generateBehavior())
                .type(FakeMessageGenerator.generateType())
                .layer(FakeMessageGenerator.generateLayer())
                .is_flaky(FakeMessageGenerator.generateIsFlaky())
                .suite_id(FakeMessageGenerator.generateSuiteId())
                .milestone_id(FakeMessageGenerator.generateMilestoneId())
                .automation(FakeMessageGenerator.generateAutomation())
                .status(FakeMessageGenerator.generateStatus())
                .build();
    }

    public static List<StepsModel> getValidObjectForTestCase() {
        StepsModel step = StepsModel
                .builder()
                .action(FakeMessageGenerator.generateAction())
                .expected_result(FakeMessageGenerator.generateExpectedResult())
                .position(1)
                .build();
        List<StepsModel> steps = new ArrayList<>();
        steps.add(step);
        return steps;
    }
}