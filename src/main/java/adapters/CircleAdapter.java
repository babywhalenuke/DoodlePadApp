package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

/**
 * This class responsible for creating an adapter that implements IShape to render a circle.
 */
public class CircleAdapter implements IShape {
    public static final int CIRCLE_WIDTH = 20;
    public static final int CIRCLE_HEIGHT = 20;
    private Circle circle;
    private Color color;
    private boolean isFilled;

    /**
     * Constructor for CircleAdapter.
     * @param circle
     * @param isFilled
     */
    public CircleAdapter(Circle circle, boolean isFilled) {
        this.circle = circle;
        this.color = circle.getColor();
        this.isFilled = isFilled;
    }

    @Override
    public IShape setThickness(double value) {
        this.circle.setThickness(value);
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
        return this.circle.getX();
    }

    @Override
    public double getYCoordinate() {
        return this.circle.getY();
    }

    @Override
    public double getThickness() {
        return this.circle.getThickness();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean getFilled() {
        return this.isFilled;
    }

    @Override
    public void drawShape(GraphicsContext graphics) {
        graphics.setStroke(getColor());
        graphics.setLineWidth(getThickness());

        if(this.getFilled() == true){
            graphics.setFill(this.getColor());
            graphics.fillOval(this.getXCoordinate(),this.getYCoordinate(), CIRCLE_WIDTH, CIRCLE_HEIGHT);
        }
        else{
            graphics.strokeOval(this.getXCoordinate(),this.getYCoordinate(),CIRCLE_WIDTH, CIRCLE_HEIGHT);
        }
    }
}
