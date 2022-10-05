package models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CreateTestCaseDataModel {
    private String title;
    private String status;
    private String description;
    private String suite;
    private String severity;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String milestone;
    private String behavior;
    private String automationStatus;
    private String preconditions;
    private String postCondition;
    private String action;
    private String inputData;
    private String expectedResult;
}