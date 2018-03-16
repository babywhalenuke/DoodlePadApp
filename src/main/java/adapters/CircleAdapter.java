package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

/**
 * @Author Jeff Pratt
 * @Date 3/16/2018
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
     * @param circle of type Circle that is passed to CircleAdapter for instantiation.
     * @param isFilled boolean circle should be filled. True is filled, false is no fill.
     */
    public CircleAdapter(Circle circle, boolean isFilled) {
        this.circle = circle;
        this.color = circle.getColor();
        this.isFilled = isFilled;
    }

    /**
     *Set the thickness of the Circle
     * @param value sets thickness value to double.
     * @return IShape return the Circle instance of IShape.
     */
    @Override
    public IShape setThickness(double value) {
        this.circle.setThickness(value);
        return this;
    }

    /**
     * Set the color of the circle.
     * @param value color to set.
     * @return IShape return the Circle instance of IShape
     */
    @Override
    public IShape setColor(Color value) {
        this.color = value;
        return this;
    }

    /**
     * Set the fill of the circle.
     * @param value the fill value of the circle.
     * @return IShape return the Circle instance of IShape
     */
    @Override
    public IShape setFilled(boolean value) {
        this.isFilled = value;
        return this;
    }

    /**
     * Get the X coordinate of circle.
     * @return X coordinate - double.
     */
    @Override
    public double getXCoordinate() {
        return this.circle.getX();
    }

    /**
     * Get the Y coordinate of circle.
     * @return Y coordinate - double.
     */
    @Override
    public double getYCoordinate() {
        return this.circle.getY();
    }

    /**
     * Get the thickness of the circle.
     * @return thickness of type double.
     */
    @Override
    public double getThickness() {
        return this.circle.getThickness();
    }

    /**
     * Get the color of the circle.
     * @return circle color of type Color.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Get boolean for circle is filled or not. true = filled, false = not filled.
     * @return boolean circle is filled.
     */
    @Override
    public boolean getFilled() {
        return this.isFilled;
    }

    /**
     * Draw the shape.
     * @param graphics GraphicsContext passed in from Canvas. @See Canvas
     */
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
