import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    public boolean collision(Player p, Enemy e) {
        return p.getX() < e.getX() + e.getwidth() &&
               p.getX() + p.getwidth() > e.getX() &&
               p.getY() < e.getY() + e.getheight() &&
               p.getY() + p.getheight() > e.getY();
    }

    public void reduceHealth(Player p, Enemy e) {
        int oldHealth = p.gethealth();
        int newHealth = Math.max(0, oldHealth - e.getdamage());
        try {
            java.lang.reflect.Field healthField = Player.class.getDeclaredField("health");
            healthField.setAccessible(true);
            healthField.set(p, newHealth);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        eventLog.add("Igrača je udario " + e.gettype() +
                   " sa " + e.getdamage() + " demage-a. Novi health je " + newHealth);
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add("Dodat je enemy " + e);
    }

    public ArrayList<Enemy> findByType(String text) {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (e.gettype().toLowerCase().contains(text.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Enemy> collidingEnemies() {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (collision(player, e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void handleCollisions() {
        for (Enemy e : collidingEnemies()) {
            reduceHealth(player, e);
        }
    }

    public static void main(String[] args) {

        Player player = new Player("Petar", 10, 5, 32, 32, 85);
        Game game = new Game(player);

        Enemy e1 = new Enemy("Luka", 15, 10, 16, 16, 20);
        game.addEnemy(e1);

        String input = "Goblin;12,5;16x16;20";
        String[] parts = input.split(";");
        String type = parts[0];
        String[] pos = parts[1].split(",");
        String[] size = parts[2].split("x");
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);
        int width = Integer.parseInt(size[0]);
        int height = Integer.parseInt(size[1]);
        int damage = Integer.parseInt(parts[3]);
        Enemy e2 = new Enemy(type, x, y, width, height, damage);
        game.addEnemy(e2);

        System.out.println("Svi neprijatelji:");
        for (Enemy e : game.enemies) {
            System.out.println(e);
        }

        System.out.println("\nPretraga po tipu 'gob'...");
        for (Enemy e : game.findByType("gob")) {
            System.out.println(e);
        }

        System.out.println("\nPlayer prije sudara: " + player);
        game.handleCollisions();
        System.out.println("Player posle sudara: " + player);

        System.out.println("\nEvent-ovi:");
        for (String ev : game.eventLog) {
            System.out.println(ev);
        }
    }
}

// Radili: Luka Cirovic 24/024 FIST i  Petar Kazic 24/026 FIST