package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import shapes.Rectangle;

public class RectangleAdapter implements IShape {
    private Rectangle rectangle;
    private Color color;
    private boolean isFilled;


    public RectangleAdapter(Rectangle rectangle, boolean isFilled){
        this.rectangle = rectangle;
        this.isFilled = isFilled;
        this.color = rectangle.getColor();
    }

    @Override
    public IShape setThickness(double value) {
        rectangle.setThickness(value);
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
        return rectangle.getX();
    }

    @Override
    public double getYCoordinate() {
        return rectangle.getY();
    }

    @Override
    public double getThickness() {
        return rectangle.getThickness();
    }

    @Override
    public Color getColor() {
        return rectangle.getColor();
    }

    @Override
    public boolean getFilled() {
        return isFilled;
    }

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
