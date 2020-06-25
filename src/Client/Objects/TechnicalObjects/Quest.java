package Client.Objects.TechnicalObjects;

import Client.Mechanic.MainGUIVariables;
import Client.Objects.Cards.Card;

import java.io.Serializable;
import java.util.ArrayList;

public class Quest implements Serializable {
    private int numberOfQuest;
    private String goal;
    private int goalNumber;
    private ArrayList<Card> reachCards = new ArrayList<>();
    private boolean isCompleted;
    private boolean isNow;
    private String searchCard;

    public Quest(int numberOfQuest, String goal, int goalNumber, String searchCard) {
        System.out.println("Creating object of class Quest...");
        this.numberOfQuest = numberOfQuest;
        this.goal = goal;
        this.goalNumber = goalNumber;
        this.searchCard = searchCard;
        System.out.println("Finished creating object of class Quest.");
        System.out.println("Created quest:  numberOfQuest: " + numberOfQuest + ", goal: " + goal + ", goalNumber: " + goalNumber + ", reachCards: " + reachCards + ", isCompleted: " + isCompleted + ", searchCard: " + searchCard);
    }
    public void runnableOn() {
        Runnable runnable = () -> {
            while (true) {
                if (isNow && !isCompleted) {
                    for (Card card : MainGUIVariables.playerCurrent.slots) {
                        if (reachCards.size() >= goalNumber) {
                            isCompleted = true;
                        } else if (card.name.equals(searchCard) && reachCards.indexOf(card) == -1) {
                            reachCards.add(card);
                        }
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public int getNumberOfQuest() {
        return numberOfQuest;
    }

    public void setNumberOfQuest(int numberOfQuest) {
        this.numberOfQuest = numberOfQuest;
    }

    public String getSearchCard() {
        return searchCard;
    }

    public void setSearchCard(String searchCard) {
        this.searchCard = searchCard;
    }

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

    public ArrayList<Card> getReachCards() {
        return reachCards;
    }

    public void setReachCards(ArrayList<Card> reachCards) {
        this.reachCards = reachCards;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isNow() {
        return isNow;
    }

    public void setNow(boolean now) {
        isNow = now;
    }

}
