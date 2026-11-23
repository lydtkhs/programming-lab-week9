package week9;

public class Main {

    public static void main(String[] args) {
    
        Team team = new Team();

        Warrior w1 = new Warrior("Arthur", 10, 150, 20);
        Mage m1 = new Mage("Merlin", 12, 100, 60);
        Healer h1 = new Healer("Elena", 8, 90, 25);

        team.addCharacter(w1);
        team.addCharacter(m1);
        team.addCharacter(h1);

        System.out.println("\n--- Testing Invalid Inputs ---");
        team.addCharacter(new Warrior("Arthur", 5, 100, 10));
        Warrior invalidChar = new Warrior("Buggy", 150, -50, 10);
        invalidChar.getCharacterInfo();

        Warrior boss = new Warrior("Golem", 15, 300, 30);

        System.out.println("\n--- Initial Status ---");
        team.displayTeam();
        boss.getCharacterInfo();

        for (int round = 1; round <= 2; round++) {
            System.out.println("\n=== ROUND " + round + " ===");
            team.attackAll(boss);
            if (boss.isAlive()) {
                int dmg1 = boss.attack(w1);
                System.out.println(boss.getName() + " attacked " + w1.getName() + " for " + dmg1 + " damage.");
                int dmg2 = boss.attack(m1);
                System.out.println(boss.getName() + " attacked " + m1.getName() + " for " + dmg2 + " damage.");
            }
            team.healTeam();
        }

        System.out.println("\n--- Search, Remove & Final Display ---");
        GameCharacter searched = team.findByName("Merlin");
        if (searched != null) {
            System.out.print("Found: ");
            searched.getCharacterInfo();
        }

        team.removeCharacter("Elena");
        team.displayTeam();
    }
}
    

