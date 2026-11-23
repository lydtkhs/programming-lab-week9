package week9;

public class Mage extends GameCharacter implements Attacker, Supporter{
    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    

    @Override
    public void getCharacterInfo() {
        System.out.println("Mage | Name: " + getName() + " | Level: " + getLevel()
                + " | Health: " + getHealth() + "/" + getMaxHealth()
                + " | Mana: " + mana + " | Power: " + calculatePower());
    }

    @Override
    public double calculatePower() {
       return (getLevel() * 8) + mana;
    }

    @Override
    public int attack(GameCharacter target) {
    if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (mana < 20) {
            System.out.println(getName() + " does not have enough mana to attack!");
            return 0;
        }
        int damage = (int) (calculatePower() / 3);
        mana -= 20;
        return target.takeDamage(damage);
    }

    @Override
    public int heal(GameCharacter target) {
        if(!isAlive() || target == null || !target.isAlive()){
            return 0;
        }
        if (mana < 15) {
            System.out.println(getName() + " does not have enough mana to heal!");
            return 0;
        }
        mana -= 15;
        int healAmount = getLevel() * 2;
        return target.restoreHealth(healAmount);
    }
    
}
