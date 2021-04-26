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

        if (this.getUnplacedTasks().size() > 0)
            for (Task task : this.getUnplacedTasks()) {
                placed = this.getPlacedTasks();
                unplaced = this.getUnplacedTasks();
                placed.add(task);
                unplaced.remove(task);
                this.getChildren().add(new Node(placed, unplaced));
            }
    }

    public Limit penalty() {
        int sum = 0, penaltySum = 0;
        Task task;
        StringBuilder path = new StringBuilder();
        ArrayList<String> taskNumbers = new ArrayList<>();
        path.append("[");

        for (int index = 0; index < this.getUnplacedTasks().size(); index++) {
            task = this.getUnplacedTasks().get(index);
            sum += task.getPi();
            penaltySum += sum > task.getDi() ? (sum - task.getDi()) * task.getWi() : 0;
            taskNumbers.add(String.valueOf(this.getPlacedTasks().get(index).getId()));
        }

        for (int index = taskNumbers.size() - 1; index >= 0; index--) {
            path.append(this.getPlacedTasks().get(index).getId());
        }

        path.append("]");

        return new Limit(penaltySum, path.toString());
    }

    public Limit calculateMinLimitFromNodes() {
        Limit result = new Limit(Integer.MAX_VALUE, ""), temporary;
        if (this.getChildren().size() < 1) return result;
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
