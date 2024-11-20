package utils;

import nl.saxion.app.interaction.MouseEvent;

public final class MouseHandler {
    private static MouseHandler instance;

    private int mouseX, mouseY;
    private boolean clickleft;
    private boolean holdleft = false;

    public static MouseHandler getInstance() {
        if (instance == null)
            instance = new MouseHandler();

        return instance;
    }

    public void update(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
        if (mouseEvent.isLeftMouseButton() && !holdleft) {
            clickleft = true;
            holdleft = true;
        }
        if (mouseEvent.isMouseUp()){
            holdleft = false;
            clickleft = false;
        }
        if (mouseEvent.isMouseDragging())
            clickleft = false;
        if (clickleft)
            System.out.println(mouseX);
    }

    public boolean hovering(int targetX, int targetY, int width, int height) {
        return (targetX - width / 2 < mouseX &&
            targetX + width / 2 > mouseX &&
            targetY - height / 2 < mouseY &&
            targetY + height / 2 > mouseY);
    }

    public boolean clicked(int targetX, int targetY, int width, int height) {
        return hovering(targetX, targetY, width, height) && clickleft;
    }
}
