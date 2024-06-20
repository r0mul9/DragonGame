public abstract class Characters implements Fight {

    private String name;
    private int health;
    private int gold;
    private int agility;
    private int experience;
    private int strength;

    public Characters(String name, int health, int gold, int agility, int experience, int strength) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.agility = agility;
        this.experience = experience;
        this.strength = strength;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    @Override
    public int attack() {
        if (getRandomValue() < 10 & agility * 3 > getRandomValue()) {
            System.out.println("КРИТ!");
            return strength * 2;
        } else if (agility * 3 > getRandomValue()) return strength;
        else return 0;

    }

    @Override
    public String toString() {
        return (name + " здоровье: " + health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


}
