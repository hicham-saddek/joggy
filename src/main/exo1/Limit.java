package main.exo1;

import java.util.ArrayList;

public class Limit {
    private int min;
    private ArrayList<Task> tasks;

    /**
     * @param min  int
     * @param tasks String
     */
    public Limit(int min, ArrayList<Task> tasks) {
        this.setMin(min).setTasks(tasks);
    }

    /**
     * @param min int
     * @return Limit
     */
    public Limit setMin(int min) {
        this.min = min;
        return this;
    }

    /**
     * @param tasks String
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * @return int
     */
    public int getMin() {
        return min;
    }

    /**
     * @return String
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
