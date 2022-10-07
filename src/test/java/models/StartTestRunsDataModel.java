package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StartTestRunsDataModel {
    private String description;
    private String milestone;
    private String defaultAssignee;
    private String suite;

}