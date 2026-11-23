package week9;
import java.util.ArrayList;

public class Team {
    private ArrayList<GameCharacter> characters = new ArrayList<>();
    
    public void addCharacter(GameCharacter c){
        if(c == null){
            return;
        }
        for(GameCharacter existing : characters){
            if(existing.getName().equalsIgnoreCase(c.getName())){
                System.out.println("\"Error: A character with the name " + c.getName() + " already exists in the team!");
                return;
            }
        }
        characters.add(c);
        System.out.println(c.getName() + " added to the team");
    }
    
    public GameCharacter findByName(String name) {
        for (GameCharacter c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
    
    public void removeCharacter(String name){
        GameCharacter found = findByName(name);
        if(found != null){
            characters.remove(found);
            System.out.println(name + " removed from the team.");
        } else {
            System.out.println("Character '" + name + "' not found.");
        }
    }
    
    public void attackAll(GameCharacter target){
        for(GameCharacter c : characters){
            if(c.isAlive() && c instanceof Attacker){
                int dealt =((Attacker) c).attack(target);
                System.out.println(c.getName() + " attacked " + target.getName() + " for " + dealt + " damage.");
            }
        }
    }
    
    public void healTeam(){
        for(GameCharacter c : characters){
            if(c.isAlive() && c instanceof Supporter){
                GameCharacter lowestMember = null;
                double minRatio = Double.MAX_VALUE;
                
                for(GameCharacter member : characters){
                    if(member.isAlive()){
                        double ratio = (double) member.getHealth() / member.getMaxHealth();
                        if (ratio < minRatio){
                            minRatio = ratio;
                            lowestMember = member;
                        }
                    }
                }
                
                if(lowestMember != null){
                    int healed = ((Supporter) c).heal(lowestMember);
                    System.out.println(c.getName() + " healed " + lowestMember.getName() + " for " + healed + " HP.");
                }
            }
        }
    }
    
    public double getTotalPower(){
        double total = 0;
        for(GameCharacter c : characters){
            if(c.isAlive()){
                total += c.calculatePower();
            }
        }
        return total;
    }
    
    public void displayTeam(){
        System.out.println("--- TEAM ROSTER ---");
        for (GameCharacter c : characters) {
            c.getCharacterInfo();
        }
        System.out.println("Total Alive Team Power: " + getTotalPower());
    }
}
