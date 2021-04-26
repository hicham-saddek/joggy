package main.exo1;

public class Limit {
    private int min;
    private String path;

    /**
     * @param min  int
     * @param path String
     */
    public Limit(int min, String path) {
        this.setMin(min).setPath(path);
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
     * @param path String
     */
    public void setPath(String path) {
        this.path = path;
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
    public String getPath() {
        return path;
    }
}
