class Enemy {
    private String type;
    private int x, y;
    private int width, height;
    private int damage;

    public Enemy(String type, int x, int y, int width, int height, int damage) {
        if (type == null || type.isEmpty()) type = "nepoznat";
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        if (damage < 0) damage = 0;
        if (damage > 100) damage = 100;
        this.damage = damage;
    }

    public String gettype() {
        return type;
    }

    public int getdamage() {
        return damage;
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
        return "Enemy tipa " + type + " je na poziciji " + x + ";" + y + ", sirine " + width + ", visine " + height + " i damage-a " + damage;
    }
}
