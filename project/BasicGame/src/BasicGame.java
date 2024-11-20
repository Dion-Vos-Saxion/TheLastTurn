import nl.saxion.app.SaxionApp;

import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;
import utils.MouseHandler;
import utils.SceneManager;

public class BasicGame implements GameLoop {

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 1000, 40);
    }

    public SceneManager sceneManager;

    @Override
    public void init() {
        sceneManager = new SceneManager();
    }

    @Override
    public void loop() {
        sceneManager.loop();
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        MouseHandler.getInstance().update(mouseEvent);
    }
}





