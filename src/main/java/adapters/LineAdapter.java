package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineAdapter implements IShape {
    @Override
    public IShape setThickness(double value) {
        return null;
    }

    @Override
    public IShape setColor(Color value) {
        return null;
    }

    @Override
    public IShape setFilled(boolean value) {
        return null;
    }

    @Override
    public double getXCoordinate() {
        return 0;
    }

    @Override
    public double getYCoordinate() {
        return 0;
    }

    @Override
    public double getThickness() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public boolean getFilled() {
        return false;
    }

    @Override
    public void drawShape(GraphicsContext graphics) {

    }
}
