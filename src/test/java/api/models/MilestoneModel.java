package api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MilestoneModel {

    private String title;
    private String description;
    private int due_date;

}