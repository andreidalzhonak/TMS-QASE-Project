package models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CreateTestSuiteDataModel {
    private String suiteName;
    private String description;
    private String preconditions;
}