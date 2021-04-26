package main.exo1;

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
     * @return int
     */
    public int getDi() {
        return this.di;
    }

    /**
     * @return int
     */
    public int getWi() {
        return this.wi;
    }

    /**
     * @return int
     */
    public int getDiDividedByWi() {
        return this.di / this.wi;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", pi=" + pi +
                ", di=" + di +
                ", wi=" + wi +
                '}';
    }
}
