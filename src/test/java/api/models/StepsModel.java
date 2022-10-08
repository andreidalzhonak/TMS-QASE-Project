package api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepsModel {
    private String action;
    private String expected_result;
    private int position;
}