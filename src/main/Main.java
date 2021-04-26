package main;

import main.exo1.Limit;
import main.exo1.Model;
import main.exo1.Node;
import main.exo1.Task;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Task> buildTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 16, 2));
        tasks.add(new Task(2, 7, 15, 3));
        tasks.add(new Task(3, 2, 9, 1));
        tasks.add(new Task(4, 3, 4, 2));
        tasks.add(new Task(5, 5, 10, 4));
        return tasks;
    }

    public static void exo1() {
        Model model = new Model(Main.buildTasks());
        model.sortDescending();

        Node node = new Node(model.getTasks());
        Limit limit = node.calculateMinLimitFromNodes();

        System.out.println("\n - Question 1:");
        System.out.println("\n   Tri des tâches par ordre décroissant des di/wi: ");
        System.out.println("\n" + model.getTasks());
        System.out.println("\n   La somme des penalitées de retard: " + node.penalty().getMin());
        System.out.println("\n - Question 2:");
        System.out.println("\n   La borne inférieure: " + limit.getMin());
        System.out.println("\n - Question 3:");
        System.out.println("\n   Chemin: " + limit.getPath());
    }

    public static void main(String[] args){

        System.out.println("Exercice 1 : --------------------------------------------------------------------------------------\n");
        exo1();
    }

}
