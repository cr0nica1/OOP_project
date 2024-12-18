import java.util.List;

public class Skills {
    private String skillName;
    private int MPcost;
    private int skillPower;
    private String skillEffect;
    private float skillRange;
    private float skillDuration;
    private int price; 


    public Skills(String skillName, int MPcost, int skillPower, String skillEffect,float skillRange, float skillDuration, int price) {
        this.skillName = skillName;
        this.MPcost = MPcost;
        this.skillPower = skillPower;
        this.skillEffect = skillEffect;
        this.skillRange = skillRange;
        this.skillDuration = skillDuration;
        this.price = price;
    }
    @Override
        public String toString(){
            return "SKill{name='" + skillName + "', MPcost='" + MPcost + "', price=" + price +
                ", effect='" + skillEffect + "', range=" + skillRange +
                ", duration='" + skillDuration + "'}";
        }

        // Getters and Setters
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getMPcost() {
        return MPcost;
    }

    public void setMPcost(int MPcost) {
        this.MPcost = MPcost;
    }
    public int getSkillPower() {
        return skillPower;
    }

    public void setSkillPower(int skillPower) {
        this.skillPower = skillPower;
    }

    public String getSkillEffect() {
        return skillEffect;
    }

    public void setSkillEffect(String skillEffect) {
        this.skillEffect = skillEffect;
    }
    
    public float getSkillRange() {
        return skillRange;
    }

    public void setSkillRange(float skillRange) {
        this.skillRange = skillRange;
    }
    
    public float getSkillDuration() {
        return skillDuration;
    }

    public void setSkillDuration(float skillDuration) {
        this.skillDuration = skillDuration;
    }

    public int getPrice() { 
        return price; 
    }

    public void setPrice(int price) { 
        this.price = price; 
    }

        //skill casting method
    public String castSkill(Player player, List<Monster> monsters) {
        if (player.getMP() < this.MPcost) {
            return "You do not have enough MP to cast this skill.";
        }

        player.setMP(player.getMP()-MPcost);// tru MP


        Monster Target = null;
        if (Target == null) {
            return "No monsters within range to cast the skill.";
        }

        // Apply damage and effect to the primary target
        int damage=this.skillPower - Target.getDefense();
        if (damage>0) {
            Target.setHP(Target.getHP()-damage);
            System.out.println("Player " + player.getName() + "dealt "+ damage + " dameges!");
        }
        
        System.out.println("Casting " + skillName + " on " + Target.getName() + "! Dealt " + damage + " damage.\n");

        // Apply reduced damage to other monsters within skillZone
        
    return null;
    }
}
   



