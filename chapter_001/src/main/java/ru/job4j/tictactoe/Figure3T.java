package ru.job4j.tictactoe;
import javafx.scene.shape.Rectangle;

/**
 *  Class Figure3T
 *  @author Assan Shynybayev
 *  @version  1.0
 *  @since 0.1
 */
public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    Figure3T() {
    }

    public Figure3T(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }
}

