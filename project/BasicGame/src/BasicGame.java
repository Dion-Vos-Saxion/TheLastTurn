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

    public MouseHandler mouseHandler;
    public SceneManager sceneManager;

    @Override
    public void init() {
        sceneManager = new SceneManager();
        mouseHandler = new MouseHandler();
    }

    @Override
    public void loop() {
        SaxionApp.drawText("Hola", 200, 200, 50);
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        mouseHandler.update(mouseEvent);
    }
}






