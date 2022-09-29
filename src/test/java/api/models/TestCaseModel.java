package api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestCaseModel {
    private String title;
    private String description;
    private String preconditions;
    private String postconditions;
    private int severity;
    private int priority;
    private int behavior;
    private int type;
    private int layer;
    private int is_flaky;
    private int suite_id;
    private int milestone_id;
    private int automation;
    private int status;
    private List<StepsModel> steps;
}