package main.exo1;

import java.util.ArrayList;

public class Model {
    private ArrayList<Task> tasks;

    public Model(ArrayList<Task> tasks) {
        this.setTasks(tasks);
    }

    public void sortDescending() {
        Task temporary;
        for (Task task : tasks) {
            temporary = this.getTasks().get(task.getId() + 1);
            if (task.getDiDividedByWi() < temporary.getDiDividedByWi()) {
                this.getTasks().set(temporary.getId(), task);
                this.getTasks().set(task.getId(), temporary);
                return;
            }
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
