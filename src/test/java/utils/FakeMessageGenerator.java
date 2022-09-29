package utils;

import com.github.javafaker.Faker;

import java.time.Instant;

public class FakeMessageGenerator {

    public static String generateAccountEmail() {

        return new Faker().internet().emailAddress();
    }

    public static String generateAccountPassword() {

        return new Faker().internet().password();
    }

    public static String generateTitleApi() {

        return new Faker().company().name();
    }

    public static String generateDescriptionApi() {
        return new Faker().gameOfThrones().house();
    }

    public static int generateDueDataApi() {
        long unixTime = Instant.now().getEpochSecond();
        return (int) unixTime;
    }

    public static int generateParent() {
        return new Faker().number().numberBetween(1, 6);
    }


    public static String generatePreconditionApi() {
        return new Faker().gameOfThrones().city();
    }

    public static String generatePostconditionApi() {
        return new Faker().gameOfThrones().city();
    }

    public static int generateSeverity() {
        return new Faker().number().numberBetween(0, 6);
    }

    public static int generatePriority() {
        return new Faker().number().numberBetween(0, 3);
    }

    public static int generateBehavior() {
        return new Faker().number().numberBetween(1, 4);
    }

    public static int generateType() {
        return new Faker().number().numberBetween(1, 11);
    }

    public static int generateLayer() {
        return new Faker().number().numberBetween(0, 3);
    }

    public static int generateIsFlaky() {
        return new Faker().number().numberBetween(0, 1);
    }

    public static int generateSuiteId() {
        return new Faker().number().numberBetween(0, 57);
    }

    public static int generateMilestoneId() {
        return new Faker().number().numberBetween(21, 30);
    }

    public static int generateAutomation() {
        return new Faker().number().numberBetween(0, 2);
    }

    public static int generateStatus() {
        return new Faker().number().numberBetween(0, 2);
    }

    public static String generateAction() {
        return new Faker().company().name();
    }

    public static String generateExpectedResult() {
        return new Faker().company().name();
    }

    public static String generateProjectName() {
        return new Faker().company().industry();
    }

    public static String generateDescriptionNewProject() {
        return new Faker().gameOfThrones().house();
    }

    public static String generateDescriptionNewSuite() {
        return new Faker().gameOfThrones().house();
    }

    public static String generateSuiteName() {
        return new Faker().company().industry();
    }

    public static String generatePreconditionsNewSuite() {
        return new Faker().gameOfThrones().house();
    }

    public static String generateTestCaseTitle() {
        return new Faker().company().industry();
    }

    public static String generateDescriptionTestCase() {
        return new Faker().gameOfThrones().house();
    }

    public static String generatePreConditionsTestCase() {
        return new Faker().gameOfThrones().house();
    }

    public static String generatePostConditionsTestCase() {
        return new Faker().gameOfThrones().house();
    }

    public static String generateActionTestCase() {
        return new Faker().team().name();
    }

    public static String generateInputDataTestCase() {
        return new Faker().cat().name();
    }

    public static String generateExpectedResultTestCase() {
        return new Faker().cat().breed();
    }

    public static String generateDescriptionTestRun() {
        return new Faker().gameOfThrones().house();
    }
}