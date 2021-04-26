package main.exo1;

import java.util.ArrayList;

public class Node {
    private ArrayList<Node> children;
    private ArrayList<Task> placedTasks;
    private ArrayList<Task> unplacedTasks;

    public Node(ArrayList<Task> unplacedTasks) {
        this.setPlacedTasks(new ArrayList<>());
        this.setUnplacedTasks(unplacedTasks);
        this.setChildren(new ArrayList<>());
        this.build();
    }

    public Node(ArrayList<Task> placedTasks, ArrayList<Task> unplacedTasks) {
        this.setPlacedTasks(placedTasks);
        this.setUnplacedTasks(unplacedTasks);
        this.setChildren(new ArrayList<>());
        this.build();
    }

    public void build() {
        ArrayList<Task> placed;
        ArrayList<Task> unplaced;

        for (Task task : this.getUnplacedTasks()) {
            placed = new ArrayList<>(this.getPlacedTasks());
            placed.add(task);
            unplaced = new ArrayList<>(this.getUnplacedTasks());
            unplaced.remove(task);
            this.getChildren().add(new Node(placed, unplaced));
        }
    }

    public Limit penalty() {
        int sum = 0, penaltySum = 0;
        StringBuilder path = new StringBuilder();
        ArrayList<String> taskNumbers = new ArrayList<>();
        path.append("[");

        for (Task task : this.getPlacedTasks()) {
            sum += task.getPi();
            penaltySum += sum > task.getDi() ? (sum - task.getDi()) * task.getWi() : 0;
            taskNumbers.add(String.valueOf(task.getId()));
        }

        for (int i = 0; i < taskNumbers.size(); i++){

            path.append(this.getPlacedTasks().get(i).getId());
        }

        path.append("]");

        return new Limit(penaltySum, path.toString());
    }

    public Limit calculateMinLimitFromNodes() {
        Limit result = new Limit(Integer.MAX_VALUE, ""), temporary;

        if (this.getChildren().size() < 1)
            return penalty();

        for (Node node : this.getChildren()) {
            temporary = node.calculateMinLimitFromNodes();
            result = temporary.getMin() < result.getMin() ? temporary : result;
        }

        return result;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public ArrayList<Task> getPlacedTasks() {
        return this.placedTasks;
    }

    public void setPlacedTasks(ArrayList<Task> placedTasks) {
        this.placedTasks = placedTasks;
    }

    public ArrayList<Task> getUnplacedTasks() {
        return this.unplacedTasks;
    }

    public void setUnplacedTasks(ArrayList<Task> unplacedTasks) {
        this.unplacedTasks = unplacedTasks;
    }
}
