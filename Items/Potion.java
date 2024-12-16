public class Potion extends Items {
    private int duration; // Thời gian tác dụng (giây)

    public Potion(String name, int price, String effect, int healthRestore, int duration, String rarity) {
        super(name, "Drug", price, effect, healthRestore, rarity);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String usingItems() {
        return "You used the " + getName() + ". Effect: " + getEffect() + " lasting for " + duration + " seconds.";
    }

    @Override
    public String toString() {
        return super.toString() + ", duration=" + duration;
    }
}
