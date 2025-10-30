class Enemy extends GameObject {
	
    private String type;
    private int health;
    private int damage;

    public Enemy(int x, int y, int width, int height, String type, int health) {
    	super(x, y, height, width);
        this.type = (type == null || type.trim().isEmpty()) ? "nepoznat" : type.trim();
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
        if (damage < 0) this.damage = 0;
        else if (damage > 100) this.damage = 100;
        else this.damage = damage;
    }
    
    public String gettype() {
        return type;
    }
    
    public int gethealth() {
        return health;
    }
    
    public int getdamage() {
        return damage;
    }
    
    @Override
    public String toString() {
        return "Player[" + type + "] @ (" + x + ","+ y + ") " + width +"x" + height + " HP=" + 85;
    }
    	
}