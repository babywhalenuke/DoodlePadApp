package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import shapes.Rectangle;
/**
 * @Author Jeff Pratt
 * @Date 3/16/2018
 * This class responsible for creating an adapter that implements IShape to render a Rectangle.
 */
public class RectangleAdapter implements IShape {
    private Rectangle rectangle;
    private Color color;
    private boolean isFilled;

    /**
     * Constructor for RectangleAdapter.
     * @param rectangle of type Rectangle that is passed to RectangleAdapter for instantiation.
     * @param isFilled boolean Rectangle should be filled. True is filled, false is no fill.
     */
    public RectangleAdapter(Rectangle rectangle, boolean isFilled){
        this.rectangle = rectangle;
        this.isFilled = isFilled;
        this.color = rectangle.getColor();
    }
    /**
     *Set the thickness of the shape.
     * @param value sets thickness value to double.
     * @return IShape return the RectangleAdapter instance of IShape.
     */
    @Override
    public IShape setThickness(double value) {
        rectangle.setThickness(value);
        return this;
    }
    /**
     * Set the color of the rectangle.
     * @param value color to set.
     * @return IShape return the RectangleAdapter instance of IShape
     */
    @Override
    public IShape setColor(Color value) {
        this.color = value;
        return this;
    }
    /**
     * Set the fill of the rectangle.
     * @param value the fill value of the rectangle.
     * @return IShape return the RectangleAdapter instance of IShape
     */
    @Override
    public IShape setFilled(boolean value) {
        this.isFilled = value;
        return this;
    }

    /**
     * Get the X coordinate of rectangle.
     * @return X coordinate - double.
     */
    @Override
    public double getXCoordinate() {
        return rectangle.getX();
    }
    /**
     * Get the Y coordinate of rectangle.
     * @return Y coordinate - double.
     */
    @Override
    public double getYCoordinate() {
        return rectangle.getY();
    }

    /**
     * Get the thickness of the rectangle.
     * @return thickness of type double.
     */
    @Override
    public double getThickness() {
        return rectangle.getThickness();
    }

    /**
     * Get the color of the circle.
     * @return circle color of type Color.
     */
    @Override
    public Color getColor() {
        return rectangle.getColor();
    }

    /**
     * Get boolean for rectangle is filled or not. true = filled, false = not filled.
     * @return boolean rectangle is filled.
     */
    @Override
    public boolean getFilled() {
        return isFilled;
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
            graphics.fillRect(this.getXCoordinate(),this.getYCoordinate(),rectangle.getWidth(),rectangle.getHeight());

        }
        else{
            graphics.strokeRect(this.getXCoordinate(),this.getYCoordinate(),rectangle.getWidth(),rectangle.getHeight());
        }

    }
}
