import java.util.ArrayList;
import java.util.List;

public class AncientTemple {
    private final List<Skills> skillsList;

    public AncientTemple(){
        skillsList = new ArrayList<>();
        addSkills();
    }
    private void addSkills() {
        skillsList.add(new Skills("Fireball", 20, 100, "burn", 5.0f, 5, 100));
        skillsList.add(new Skills("Inferno Bomb", 30, 150, "burn", 5.0f, 8, 150));
        skillsList.add(new Skills("Flame Surge", 40, 200, "burn", 5.0f, 12, 200));
    
        skillsList.add(new Skills("Ice Spike", 25, 120, "burst", 6.0f, 0.1f, 120));
        skillsList.add(new Skills("Frostbite", 35, 150, "burst", 6.0f, 0.1f, 150));
        skillsList.add(new Skills("Blizzard", 45, 180, "burst", 6.0f, 0.1f, 180));
    
        skillsList.add(new Skills("Lightning Bolt", 30, 130, "burn", 6.0f, 7, 130));
        skillsList.add(new Skills("Thunder Strike", 40, 180, "burn", 6.0f, 10, 180));
        skillsList.add(new Skills("Storm Fury", 50, 220, "burn", 6.0f, 15, 220));
    
        skillsList.add(new Skills("Gale Slash", 20, 110, "burst", 5.0f, 0.1f, 110));
        skillsList.add(new Skills("Cyclone Slash", 30, 140, "burst", 5.0f, 0.1f, 140));
        skillsList.add(new Skills("Tempest Fury", 40, 170, "burst", 5.0f, 0.1f, 170));
    
        skillsList.add(new Skills("Rock Throw", 25, 120, "burst", 6.0f, 0.1f, 120));
        skillsList.add(new Skills("Earthquake", 35, 160, "burst", 6.0f, 0.1f, 160));
        skillsList.add(new Skills("Tectonic Rage", 45, 200, "burst", 6.0f, 0.1f, 200));
    }
    public List<Skills> getSkillsList() {
        return skillsList;
    }

