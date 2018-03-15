package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import shapes.Triangle;


public class TriangleAdapter implements IShape {
    public static final int TRIANGLE_WIDTH = 50;
    public static final int TRIANGLE_HEIGHT = 50;
    private Triangle triangle;
    private Color color;
    private boolean isFilled;

    public TriangleAdapter(Triangle triangle, boolean isFilled){
        this.triangle = triangle;
        this.color = triangle.getColor();
        this.isFilled = isFilled;
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
