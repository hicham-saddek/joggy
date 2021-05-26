package main.exo1;

import java.util.ArrayList;
import java.util.Collections;

public class Model {
    private ArrayList<Task> tasks;

    public Model(ArrayList<Task> tasks) {
        this.setTasks(tasks);
    }

    public ArrayList<Task> sortDescending() {
        ArrayList<Task> TL = this.getTasks();
        for (int i = 0; i < TL.size(); i++) {
            int s = i;
            for (int j = i; j < TL.size(); j++) {
                s = TL.get(s).getDiDividedByWi() < TL.get(j).getDiDividedByWi() ? j : s;
            }
            if (s != i) Collections.swap(TL, i, s);
        }
        this.setTasks(TL);
        return this.getTasks();
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
        return this.tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {

        String result = "Model{\n";
        for (Task task : this.getTasks()) {
            result += "task[" +
                    "id=" + task.getId() +
                    ", di/wi= " + task.getDiDividedByWi() + "]\n";
        }
        result += "}";
        return result;
    }
}
