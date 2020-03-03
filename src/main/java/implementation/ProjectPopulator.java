package implementation;

import interfaces.IProjectPopulator;
import pojo.Project;
import utilities.Utils;

import java.util.Optional;

/**
 * The Project populator.
 */
public class ProjectPopulator implements IProjectPopulator {

    /**
     * Creates an optional of project from an array. Tha array is a line of the text file split by ", ".
     *
     * @param data
     * @return
     */
    @Override
    public Optional<Project> populateProject(String[] data) {

        int projectId = Utils.parseInt(data[1]);
        if (projectId >= 0) {
            Project project = new Project(projectId, Utils.calculateInterval(data[2], data[3]));
            return Optional.of(project);
        }
        return Optional.empty();
    }
}
