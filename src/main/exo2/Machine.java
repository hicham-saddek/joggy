package main.exo2;

import main.exo1.Task;

import java.util.ArrayList;

public class Machine {
    private int id;
    private ArrayList<Task> tasks;

    public Machine(int id) {
        this.setId(id);
        this.setTasks(tasks);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Machine {id: " + this.getId() + ", tasks: " + this.getTasks() + "}";
    }

    public boolean contains(Task task) {
        return this.getTasks().contains(task);
    }
}
