package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

/**
 * @Author Jeff Pratt
 * @Date 3/16/2018
 * This class responsible for creating an adapter that implements IShape to render a triangle.
 */
public class TriangleAdapter implements IShape {
    public static final int TRIANGLE_WIDTH = 50;
    public static final int TRIANGLE_HEIGHT = 50;
    private Triangle triangle;
    private Color color;
    private boolean isFilled;

    /**
     * Constructor for TriangleAdapter.
     * @param triangle of type Triangle that is passed to TriangleAdapter for instantiation.
     * @param isFilled boolean triangle should be filled. True is filled, false is no fill.
     */
    public TriangleAdapter(Triangle triangle, boolean isFilled){
        this.triangle = triangle;
        this.color = triangle.getColor();
        this.isFilled = isFilled;
    }

    /**
     *Set the thickness of the Triangle
     * @param value sets thickness value to double.
     * @return IShape return the Triangle instance of IShape.
     */
    @Override
    public IShape setThickness(double value) {
        triangle.setThickness(value);
        return this;
    }

    /**
     * Set the color of the triangle.
     * @param value color to set.
     * @return IShape return the Triangle instance of IShape
     */
    @Override
    public IShape setColor(Color value) {
        this.color = value;
        return this;
    }

    /**
     * Set the fill of the triangle.
     * @param value the fill value of the triangle.
     * @return IShape return the Triangle instance of IShape
     */
    @Override
    public IShape setFilled(boolean value) {
        this.isFilled = value;
        return this;
    }

    /**
     * Get the X coordinate of triangle.
     * @return X coordinate - double.
     */
    @Override
    public double getXCoordinate() {
        return triangle.getX();
    }

    /**
     * Get the Y coordinate of triangle.
     * @return Y coordinate - double.
     */
    @Override
    public double getYCoordinate() {
        return triangle.getY();
    }

    /**
     * Get the thickness of the triangle.
     * @return thickness of type double.
     */
    @Override
    public double getThickness() {
        return triangle.getThickness();
    }

    /**
     * Get the color of the triangle.
     * @return triangle color of type Color.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Get boolean for triangle is filled or not. true = filled, false = not filled.
     * @return boolean triangle is filled.
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
            double[] xvals ={this.getXCoordinate(),this.getXCoordinate()+50,this.getXCoordinate()+100,this.getXCoordinate()};
            double[] yvals ={this.getYCoordinate(), this.getYCoordinate()-50,this.getYCoordinate(),this.getYCoordinate()};
            graphics.fillPolygon(xvals,yvals,4);
        }
        else{
            graphics.strokeLine(this.getXCoordinate(),this.getYCoordinate(),this.getXCoordinate()+50,this.getYCoordinate()-50);
            graphics.strokeLine(this.getXCoordinate()+50,this.getYCoordinate()-50,this.getXCoordinate()+100,this.getYCoordinate());
            graphics.strokeLine(this.getXCoordinate(),this.getYCoordinate(),this.getXCoordinate()+100,this.getYCoordinate());
        }
    }
}
