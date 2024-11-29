package GameObjects;
import nl.saxion.app.SaxionApp;
import utils.*;

public class SceneSwitchButton extends GameObject {
    private final int sceneIndex;
    private final String imageFile;
    public SceneSwitchButton(int x, int y, int width, int height, String imageFile, int sceneIndex) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sceneIndex = sceneIndex;
        this.imageFile = imageFile;
    }

    public void init(){
    }

    public void loop() {
        SaxionApp.drawImage(imageFile,x - width / 2, y - height / 2, width, height);
        if (MouseHandler.getInstance().clicked(x, y, width, height)){
            if (sceneIndex == -1)
                SaxionApp.quit();
            else
                SceneManager.getInstance().switchScene(sceneIndex);
        }
    }
}
