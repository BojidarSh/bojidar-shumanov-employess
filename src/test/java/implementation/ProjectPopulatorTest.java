package implementation;

import interfaces.IProjectPopulator;
import org.junit.Test;
import pojo.Project;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The Project populator test.
 */
public class ProjectPopulatorTest {

    private IProjectPopulator projectPopulator;

    /**
     * Tests {@link ProjectPopulator#populateProject(String[])}.
     */
    @Test
    public void populateProject() {

        projectPopulator = new ProjectPopulator();
        Optional<Project> projectOptional = projectPopulator.populateProject(new String[]{"10", "15", "2013-11-01", "2014-01-05"});

        assertTrue(projectOptional.isPresent());
        assertEquals(Project.class, projectOptional.get().getClass());

        Project project = projectOptional.get();
        assertEquals(15, project.getId());
        assertEquals(65, project.getTime());
    }
}