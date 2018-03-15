package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

public class LineAdapter implements IShape {

    private Line line;
    private Color color;
    private boolean isFilled;

    public LineAdapter(Line line,boolean isFilled) {
        this.line = line;
        this.color = line.getColor();
        this.isFilled = isFilled;
    }

    @Override
    public IShape setThickness(double value) {
        this.line.setThickness(value);
        return this;
    }

    @Override
    public IShape setColor(Color value) {
        this.color = line.getColor();
        return this;
    }

    @Override
    public IShape setFilled(boolean value) {
        this.isFilled = value;
        return this;
    }

    @Override
    public double getXCoordinate() {
        return this.line.getX();
    }

    @Override
    public double getYCoordinate() {
        return this.line.getY();
    }

    @Override
    public double getThickness() {
        return this.line.getThickness();
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
            graphics.strokeLine(this.getXCoordinate(),this.getYCoordinate(),this.getXCoordinate()+50,this.getYCoordinate()+50);
        }
        else{
            graphics.strokeLine(this.getXCoordinate(),this.getYCoordinate(),this.getXCoordinate()-50,this.getYCoordinate()+25);
        }
    }
}
