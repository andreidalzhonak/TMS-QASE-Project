package api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuiteModel {

    private String title;
    private String description;
    private String precondition;
    private int parent_id;
}