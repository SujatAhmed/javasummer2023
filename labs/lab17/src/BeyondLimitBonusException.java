public class BeyondLimitBonusException extends Exception {
    private double bonus;
    public BeyondLimitBonusException(double bonus){
        super("Invalid bonus: " + bonus);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}

