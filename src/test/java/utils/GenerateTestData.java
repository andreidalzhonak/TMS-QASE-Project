package utils;

import constants.*;

import java.util.List;
import java.util.Random;

public class GenerateTestData {
    public static int getRandomIndex(int listSize) {
        Random rand = new Random();
        return rand.nextInt(listSize);
    }

    public static String getStatus() {
        List<String> status = StatusTestCase.getStatus();
        return status.get(getRandomIndex(status.size()));
    }

    public static String getSuite() {
        List<String> suite = SuiteTestCase.getSuite();
        return suite.get(getRandomIndex(suite.size()));
    }

    public static String getSeverity() {
        List<String> severity = SeverityTestCase.getSeverity();
        return severity.get(getRandomIndex(severity.size()));
    }

    public static String getPriority() {
        List<String> priority = PriorityTestCase.getPriority();
        return priority.get(getRandomIndex(priority.size()));
    }

    public static String getType() {
        List<String> type = TypeTestCase.getType();
        return type.get(getRandomIndex(type.size()));
    }

    public static String getLayer() {
        List<String> layer = LayerTestCase.getLayer();
        return layer.get(getRandomIndex(layer.size()));
    }

    public static String getIsFlaky() {
        List<String> isFlaky = IsFlakyTestCase.getIsFlaky();
        return isFlaky.get(getRandomIndex(isFlaky.size()));
    }

    public static String getMilestone() {
        List<String> milestone = MilestoneTestCase.getMilestone();
        return milestone.get(getRandomIndex(milestone.size()));
    }

    public static String getBehavior() {
        List<String> behavior = BehaviorTestCase.getBehavior();
        return behavior.get(getRandomIndex(behavior.size()));
    }

    public static String getAutomationStatus() {
        List<String> automationStatus = AutomationStatusTestCase.getAutomationStatus();
        return automationStatus.get(getRandomIndex(automationStatus.size()));
    }

    public static String getDefaultAssignee() {
        List<String> defaultAssignee = DefaultAssignee.getDefaultAssignee();
        return defaultAssignee.get(getRandomIndex(defaultAssignee.size()));
    }
}