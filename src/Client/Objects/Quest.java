package Client.Objects;

import Client.Objects.Cards.Card;

public class Quest {
    private int numberOfQuest;
    private String goal;
    private int goalNumber;
    private int reachNumber;
    private boolean isCompleted;
    private Card searchCard;

    public Quest(int numberOfQuest, String goal, int goalNumber, int reachNumber, boolean isCompleted) {
        System.out.println("Creating object of class Quest...");
        this.numberOfQuest = numberOfQuest;
        this.goal = goal;
        this.goalNumber = goalNumber;
        this.reachNumber = reachNumber;
        this.isCompleted = isCompleted;
        System.out.println("Finished creating object of class Quest.");
        System.out.println("Created quest:  numberOfQuest: " + numberOfQuest + ", goal: " + goal + ", goalNumber: " + goalNumber + ", reachNumber: " + reachNumber + ", isCompleted: " + isCompleted + ", searchCard: " + null);
    }

    public Quest(int numberOfQuest, String goal, int goalNumber, int reachNumber, boolean isCompleted, Card searchCard) {
        System.out.println("Creating object of class Quest...");
        this.numberOfQuest = numberOfQuest;
        this.goal = goal;
        this.goalNumber = goalNumber;
        this.reachNumber = reachNumber;
        this.isCompleted = isCompleted;
        this.searchCard = searchCard;
        System.out.println("Finished creating object of class Quest.");
        System.out.println("Created quest:  numberOfQuest: " + numberOfQuest + ", goal: " + goal + ", goalNumber: " + goalNumber + ", reachNumber: " + reachNumber + ", isCompleted: " + isCompleted + ", searchCard: " + searchCard);
    }

//    Quest(int nOQ, String g, int gN, int rN, boolean iC, ) {
//        System.out.println("Creating object of class Quest...");
//        numberOfQuest = nOQ;
//        goal = g;
//        goalNumber = gN;
//        reachNumber = rN;
//        isCompleted = iC;
//        searchCards = sC;
//        System.out.println("Finished creating object of class Quest.");
//        System.out.println("Created quest:  numberOfQuest: " + numberOfQuest + ", goal: " + goal + ", goalNumber: " + goalNumber + ", reachNumber: " + reachNumber + ", isCompleted: " + isCompleted + ", searchCard: " + searchCard);
//    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getGoalNumber() {
        return goalNumber;
    }

    public void setGoalNumber(int goalNumber) {
        this.goalNumber = goalNumber;
    }

    public int getReachNumber() {
        return reachNumber;
    }

    public void setReachNumber(int reachNumber) {
        this.reachNumber = reachNumber;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
