import nl.saxion.app.SaxionApp;

import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;
import utils.*;

public class BasicGame implements GameLoop {

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1024, 1024, 40);
    }

    public void init() {

    }

    public void loop() {
        SaxionApp.clear();
        SceneManager.getInstance().loop();
        MouseHandler.getInstance().afterupdate();
    }

    public void keyboardEvent(KeyboardEvent keyboardEvent) {

    }

    public void mouseEvent(MouseEvent mouseEvent) {
        MouseHandler.getInstance().update(mouseEvent);
    }
}






