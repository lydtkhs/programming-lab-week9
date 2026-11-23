package week9;

public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;
        setLevel(level);
        setMaxHealth(maxHealth);
        this.health = maxHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        if (level < 1 || level > 100) {
            System.out.println("Warning: Invalid level! Setting level to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        if (maxHealth <= 0) {
            System.out.println("Warning: Invalid maxHealth! Setting maxHealth to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    
    public boolean isAlive(){
        return health > 0;
    }
    
    public int takeDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        int actualDamage = Math.min(this.health, damage);
        this.health -= actualDamage;
        return actualDamage;
    }
    
    public int restoreHealth(int amount) {
        if (!isAlive()) {
            System.out.println(name + " is defeated and cannot be healed!");
            return 0;
        }
        if (amount < 0) {
            amount = 0;
        }
        int oldHealth = this.health;
        this.health = Math.min(this.maxHealth, this.health + amount);
        return this.health - oldHealth;
    }
    
    public abstract void getCharacterInfo();
    public abstract double calculatePower();
}
