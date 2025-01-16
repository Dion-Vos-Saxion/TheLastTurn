package GameObjects;
import nl.saxion.app.SaxionApp;
import utils.GameObject;

public class GameImage extends GameObject {

    String image;
    public String name;

    public GameImage(int x, int y, int width, int height, String image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public GameImage(int x, int y, int width, int height, String image, String name) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height;
        this.image = image;
        this.name = name;
    }

    public void init(){
    }

    public void loop(){
    }

    public void draw() {
        SaxionApp.drawImage(image,x - width / 2, y - height / 2, width, height);
    }
}
