package testdata;

import models.CreateNewProjectDataModel;;
import utils.FakeMessageGenerator;

public class PrepareCreateNewProjectData {
    public static CreateNewProjectDataModel getCreateProjectData() {
        return CreateNewProjectDataModel
                .builder()
                .projectName(FakeMessageGenerator.generateProjectName())
                .projectCode(FakeMessageGenerator.generateProjectName())
                .description(FakeMessageGenerator.generateDescriptionNewProject())
                .build();
    }
}