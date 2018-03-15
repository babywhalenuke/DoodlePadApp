package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

public class TriangleAdapter implements IShape {
    public static final int TRIANGLE_WIDTH = 50;
    public static final int TRIANGLE_HEIGHT = 50;
    private Triangle triangle;
    private Color color;
    private boolean isFilled;

    public void TriangleAdapter(Triangle triangle){
        this.triangle = triangle;
    }

    @Override
    public IShape setThickness(double value) {
        triangle.setThickness(value);
        return this;
    }

    @Override
    public IShape setColor(Color value) {
        this.color = value;
        return this;
    }

    @Override
    public IShape setFilled(boolean value) {
        this.isFilled = value;
        return this;
    }

    @Override
    public double getXCoordinate() {
        return triangle.getX();
    }

    @Override
    public double getYCoordinate() {
        return triangle.getY();
    }

    @Override
    public double getThickness() {
        return triangle.getThickness();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean getFilled() {
        return isFilled;
    }

    @Override
    public void drawShape(GraphicsContext graphics) {
        Triangle triangle = new Triangle(getXCoordinate(),getYCoordinate(), TRIANGLE_WIDTH, TRIANGLE_HEIGHT,getThickness(),getColor());


    }
}
