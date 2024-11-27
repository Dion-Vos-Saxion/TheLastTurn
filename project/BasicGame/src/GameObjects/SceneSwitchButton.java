package GameObjects;
import nl.saxion.app.SaxionApp;
import utils.GameObject;
import utils.MouseHandler;
import utils.SceneManager;

public class SceneSwitchButton extends GameObject {
    private int sceneIndex;
    private String imageFile;
    public SceneSwitchButton(int x, int y, int width, int height, String imageFile, int sceneIndex) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sceneIndex = sceneIndex;
        this.imageFile = imageFile;
    }

    public void loop() {
        SaxionApp.drawImage(imageFile,x - width / 2, y - height / 2, width, height);

        if (MouseHandler.getInstance().clicked(x, y, width, height))
            SceneManager.getInstance().switchScene(sceneIndex);
    }
}
