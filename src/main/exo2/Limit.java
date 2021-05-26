package main.exo2;

public class Limit extends main.exo1.Limit {
    /**
     * @param limit Limit
     */
    public Limit(Limit limit) {
        super(limit.getMin(), limit.getTasks());
    }
}
