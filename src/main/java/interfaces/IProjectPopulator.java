package interfaces;

import pojo.Project;

import java.util.Optional;

/**
 * The interface Object populator.
 */
public interface IProjectPopulator {

    /**
     * Populate project optional.
     *
     * @param data the data
     * @return the optional
     */
    Optional<Project> populateProject(String[] data);
}