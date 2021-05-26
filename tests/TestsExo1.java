import main.Main;
import main.exo1.Model;
import main.exo1.Node;
import main.exo1.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TestsExo1 {

    private Model model;

    public ArrayList<Task> unsortedTasks() {
        ArrayList<Task> unsortedTasks = new ArrayList<>();

        unsortedTasks.add(new Task(4, 3, 4, 2));
        unsortedTasks.add(new Task(5, 5, 10, 4));
        unsortedTasks.add(new Task(1, 3, 16, 2));
        unsortedTasks.add(new Task(3, 2, 9, 1));
        unsortedTasks.add(new Task(2, 7, 15, 3));

        return unsortedTasks;
    }

    public Model freshModel() {
        return new Model(unsortedTasks());
    }

    @Test
    void sortModelTest() {

        ArrayList<Task> sortedTasks = new ArrayList<>();

        sortedTasks.add(new Task(3, 2, 9, 1));
        sortedTasks.add(new Task(1, 3, 16, 2));
        sortedTasks.add(new Task(2, 7, 15, 3));
        sortedTasks.add(new Task(5, 5, 10, 4));
        sortedTasks.add(new Task(4, 3, 4, 2));

        Model model = this.freshModel();

        Assertions.assertAll(() -> Assertions.assertNotEquals(sortedTasks, model.getTasks()), // Tasks are not sorted
                () -> Assertions.assertEquals(sortedTasks, model.sortDescending()),           // The tasks are sorted
                () -> Assertions.assertEquals(sortedTasks, model.getTasks()));                // Check if the sorted tasks are saved
    }

    @Test
    void penaltyFunctionsProperly() {
        Model model = freshModel();
        Assertions.assertFalse(model.penalty() < 0);
    }

    @Test
    void valueMinLimitTest() {
        Model model = freshModel();
        Node node = new Node(model.sortDescending());
        Assertions.assertEquals(14, node.calculateMinLimitFromNodes().getMin());
    }

    @Test
    void pathMinLimitTest() {
        Model model = freshModel();
        Node node = new Node(model.sortDescending());
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(4, 3, 4, 2));
        tasks.add(new Task(3, 2, 9, 1));
        tasks.add(new Task(5, 5, 10, 4));
        tasks.add(new Task(2, 7, 15, 3));
        tasks.add(new Task(1, 3, 16, 2));

        Assertions.assertEquals(tasks, node.calculateMinLimitFromNodes().getTasks());
    }

    @Test
    void reverseTest() {
        Assertions.assertEquals(Main.buildTasks(), Task.reverse(Task.reverse(Main.buildTasks())));
    }
}


