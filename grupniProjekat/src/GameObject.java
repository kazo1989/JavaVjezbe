// https://github.com/kazo1989/JavaVjezbe
// https://github.com/Cirkeza/JavaVjezbe
// Radili: Luka Cirovic 24/024 FIST i  Petar Kazic 24/026 FIST --- pise i na dnu

public class GameObject {
	
	
	
    private int x;
    private int y;
    private int width;
    private int height;

	    public GameObject(int x, int y, int width, int height) {
	        if (width <= 0 || height <= 0) {
	            System.out.println("Dimenzije moraju biti veće od nule.");
	        }
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }
	    
	    public int getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	    }

	    public int getY() {
	        return y;
	    }

	    public void setY(int y) {
	        this.y = y;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public void setWidth(int width) {
	        if (width <= 0) {
	        	System.out.println("Širina mora biti veća od nule.");
	        }
	        this.width = width;
	    }

	    public int getHeight() {
	        return height;
	    }

	    public void setHeight(int height) {
	        if (height <= 0) {
	        	System.out.println("Visina mora biti veća od nule.");
	        }
	        this.height = height;
	    }
	    
	    public boolean collision(Player p, Enemy e) {
	        return p.getX() < e.getX() + e.getwidth() &&
	               p.getX() + p.getwidth() > e.getX() &&
	               p.getY() < e.getY() + e.getheight() &&
	               p.getY() + p.getheight() > e.getY();
	    }
	    
	    @Override
	    public String toString() {
	        return ("GameObject @ (" + x + "," + y + ") " + width + "x" + height);
	    }
	    
}


