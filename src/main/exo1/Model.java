package main.exo1;

import java.util.ArrayList;
import java.util.Collections;

public class Model {
    private ArrayList<Task> tasks;

    public Model(ArrayList<Task> tasks) {
        this.setTasks(tasks);
    }

    public void sortDescending() {
        for (int i = 0; i < this.getTasks().size(); i++) {
            Task task = this.getTasks().get(i);
            for(int j = i + 1; j < this.getTasks().size(); j++){
                Task otherTask = this.getTasks().get(j);
                if(task.getDiDividedByWi() < otherTask.getDiDividedByWi())
                    Collections.swap(this.getTasks(), this.getTasks().indexOf(task), this.getTasks().indexOf(otherTask));
            }
        }
    }

    public int penalty() {
        int sum = 0, penaltySum = 0;

        for (Task task : this.getTasks()) {
            sum += task.getPi();
            penaltySum += sum > task.getDi() ? (sum - task.getDi()) * task.getWi() : 0;
        }

        return penaltySum;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
