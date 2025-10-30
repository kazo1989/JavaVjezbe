class Player extends GameObject {
	
    private String name;
    private int health;

    public Player(int x, int y, int width, int height, String name, int health) {
    	super(x, y, height, width);
        this.name = (name == null || name.trim().isEmpty()) ? "nepoznat" : name.trim();
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
    
    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + x + ","+ y + ") " + width +"x" + height + " HP=" + 85;
    }
    	
}
