package week9;

public class Warrior extends GameCharacter implements Attacker{
    private int armor;
    
    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void getCharacterInfo() {
        System.out.println("Warrior | Name: " + getName() + " | Level: " + getLevel()
                + " | Health: " + getHealth() + "/" + getMaxHealth()
                + " | Armor: " + armor + " | Power: " + calculatePower());
    }

    @Override
    public double calculatePower() {
        return (getLevel() * 10) + (armor * 2);
    }
    
    @Override
    public int takeDamage(int damage) {
        int reducedDamage = Math.max(1, damage - (armor / 2));
        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        int damage = (int) (calculatePower() / 4);
        return target.takeDamage(damage);
    }
}
