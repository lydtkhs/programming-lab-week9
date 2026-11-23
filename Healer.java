package week9;

public class Healer extends GameCharacter implements Supporter{
    private int healAmount;
    
    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void getCharacterInfo() {
        System.out.println("Healer | Name: " + getName() + " | Level: " + getLevel()
                + " | Health: " + getHealth() + "/" + getMaxHealth()
                + " | Heal Amount: " + healAmount + " | Power: " + calculatePower());
    }

    @Override
    public double calculatePower() {
        return (getLevel() * 5) + healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        int amount = healAmount + getLevel();
        return target.restoreHealth(amount);
    }
}
