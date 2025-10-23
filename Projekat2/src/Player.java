class Player {

    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private int health;

    public Player(String name, int x, int y, int width, int height, int health) {
        this.name = (name == null || name.trim().isEmpty()) ? "nepoznat" : name.trim();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
    }

    public String getname() {
        return name;
    }

    public int gethealth() {
        return health;
    }

    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    public int getwidth() {
    	return width;
    }
    public int getheight() {
    	return height;
    }

    @Override
    public String toString() {
        return "Igrac " + name + " je na poziciji " + x + ";" + y + ", sirine " + width + ", visine " + height + " i ima " + health + " health-a.";
    }
}
