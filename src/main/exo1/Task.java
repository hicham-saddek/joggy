package main.exo1;

import java.util.ArrayList;
import java.util.Objects;

public class Task {
    private int id, pi, di, wi;

    /**
     * @param id int
     * @param pi int
     * @param di int
     * @param wi int
     */
    public Task(int id, int pi, int di, int wi) {
        this
                .setId(id)
                .setDi(di)
                .setPi(pi)
                .setWi(wi);
    }

    /**
     * @param id int
     * @return Task
     */
    public Task setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * @param pi int
     * @return Task
     */
    public Task setPi(int pi) {
        this.pi = pi;
        return this;
    }

    /**
     * @param di int
     * @return Task
     */
    public Task setDi(int di) {
        this.di = di;
        return this;
    }

    /**
     * @param wi int
     */
    public void setWi(int wi) {
        this.wi = wi;
    }

    /**
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return int
     */
    public int getPi() {
        return this.pi;
    }

    /**
     * @return float
     */
    public float getDi() {
        return (float)this.di;
    }

    /**
     * @return float
     */
    public float getWi() {
        return (float)this.wi;
    }

    /**
     * @return float
     */
    public float getDiDividedByWi() {
        return (float)(this.getDi() / this.getWi());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", pi=" + pi +
                ", di=" + di +
                ", wi=" + wi +
                ", di/wi= " + this.getDiDividedByWi() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && pi == task.pi && di == task.di && wi == task.wi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pi, di, wi);
    }

    public static ArrayList<Task> reverse(ArrayList<Task> tasks){

        for (int i = 0; i <= tasks.size()/2; i++) {
            Task task = tasks.get(i);
            Task otherTask = tasks.get(tasks.size()-1-i);
            tasks.set(i, otherTask);
            tasks.set(i, task);
        }

        return tasks;
    }
}
