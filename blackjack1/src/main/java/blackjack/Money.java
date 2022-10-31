package blackjack;

public class Money {
    double Money = 0;

    public Money() {

    }

    public Money(double input) {
        this.Money = input;
    }

    public void addMoney(double toAdd) {
        this.Money += toAdd;
    }

    public void subtractMoney(double toSubtract) {
        this.Money -= toSubtract;
    }

    public double getMoney() {
        return this.Money;
    }

    public void setMoney(double toSet) {
        this.Money = toSet;
    }

    public double makeBet(double bet) {
        subtractMoney(bet);
        return bet;
    }


}
