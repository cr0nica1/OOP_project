import java.util.List;

public class Skills {
    private String skillName;
    private int MPcost;
    private int skillPower;
    private String skillEffect;
    private float skillDuration;
  
    
    
    public Skills(String skillName, int MPcost, float skillRange,float skillZone, int skillPower, String skillEffect, float skillDuration){
        this.skillName=skillName;
        this.MPcost = MPcost;
        this.skillPower = skillPower;
        this.skillEffect = skillEffect;
        this.skillDuration = skillDuration;
        
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

    public float getSkillDuration() {
        return skillDuration;
    }

    public void setSkillDuration(float skillDuration) {
        this.skillDuration = skillDuration;
    }
    
        //skill casting method
    public String castSkill(Player player, List<Monster> monsters) {
        if (player.getMP() < this.MPcost) {
            return "You do not have enough MP to cast this skill.";
        }

        player.setMP(player.getMP()-MPcost);// Deduct MP cost

        // Find the monster with the highest HP within skillRange
        Monster Target = null;
        

        if (Target == null) {
            return "No monsters within range to cast the skill.";
        }

        // Apply damage and effect to the primary target
        Target.takeDamage(skillPower); //monster with highest HP taken 100% of skillPower
        
        
        System.out.println("Casting " + skillName + " on " + Target.getName() + "! Dealt " + skillPower + " damage.\n");

        // Apply reduced damage to other monsters within skillZone
        
    }
}
   



