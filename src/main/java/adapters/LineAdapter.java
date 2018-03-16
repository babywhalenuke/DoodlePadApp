package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;
/**
 * @Author Jeff Pratt
 * @Date 3/16/2018
 * This class responsible for creating an adapter that implements IShape to render a Line.
 */
public class LineAdapter implements IShape {
    private Line line;
    private Color color;
    private boolean isFilled;

    /**
     * Parameterized Constructor.
     * @param line line object to store internally.
     * @param isFilled line is filled or not. true = filled, false = not filled.
     */
    public LineAdapter(Line line,boolean isFilled) {
        this.line = line;
        this.color = line.getColor();
        this.isFilled = isFilled;
    }

    /**
     * @param value thickness of shape
     * @return LineAdapter implementation of IShape
     */
    @Override
    public IShape setThickness(double value) {
        this.line.setThickness(value);
        return this;
    }

    /**
     * Set the color of shape.
     * @param value Color color of shape.
     * @return LineAdapter implementation of IShape
     */
    @Override
    public IShape setColor(Color value) {
        this.color = line.getColor();
        return this;
    }

    /**
     * Set boolean of LineAdapter is filled.
     * @param value true if filled, false if not filled
     * @return LineAdapter implementation of IShape
     */
    @Override
    public IShape setFilled(boolean value) {
        this.isFilled = value;
        return this;
    }

    /**
     * Get X coordinate of shape.
     * @return double, X coordinate of shape
     */
    @Override
    public double getXCoordinate() {
        return this.line.getX();
    }
    /**
     * Get Y coordinate of shape.
     * @return double, Y coordinate of shape
     */
    @Override
    public double getYCoordinate() {
        return this.line.getY();
    }
    /**
     * Get the thickness of the shape.
     * @return thickness of type double.
     */
    @Override
    public double getThickness() {
        return this.line.getThickness();
    }

    /**
     * Get the color of the shape.
     * @return LineAdapter color of type Color.
     */
    @Override
    public Color getColor() {
        return this.color;
    }
    /**
     * Get boolean for LineAdapter is filled or not. true = filled, false = not filled.
     * @return boolean LineAdapter is filled.
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
            graphics.strokeLine(this.getXCoordinate(),this.getYCoordinate(),this.getXCoordinate()+50,this.getYCoordinate()+50);
        }
        else{
            graphics.strokeLine(this.getXCoordinate(),this.getYCoordinate(),this.getXCoordinate()-50,this.getYCoordinate()+25);
        }
    }
}
