class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        health = maxHealth;
    }

    void takeDamage(int amount) {
        health = health - amount;

        if (health < 0) {
            health = 0;
        }

        System.out.println("Health: " + health);
    }

    void heal(int amount) {
        health = health + amount;

        if (health > maxHealth) {
            health = maxHealth;
        }

        System.out.println("Health: " + health);
    }

    int getHealth() {
        return health;
    }
}

public class W7APQ1 {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}