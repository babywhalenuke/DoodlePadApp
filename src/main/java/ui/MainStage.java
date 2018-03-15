package ui;

import adapters.CircleAdapter;
import adapters.LineAdapter;
import adapters.RectangleAdapter;
import adapters.TriangleAdapter;
import drawing.IShape;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainStage extends Application {
    Scene homeScene;
    Canvas canvas;
    ToggleGroup toggleSelection;
    Slider thicknessSlider;
    ColorPicker colorPicker;
    CheckBox fillCheckBox;

    @Override
    public void start(Stage stage) throws Exception {
        homeScene = new Scene(getHomeBorderPaneWithControls(),800,500);
        stage.setScene(homeScene);
        stage.show();
    }

    public BorderPane getHomeBorderPaneWithControls(){
        BorderPane borderPane = new BorderPane();

        HBox controlBar = new HBox();
        controlBar.setPadding(new Insets(5));
        controlBar.setSpacing(10);
        controlBar.setAlignment(Pos.CENTER);
        controlBar.getChildren().addAll(getControls());
        borderPane.setTop(controlBar);
        borderPane.setCenter(getCanvas());

        return borderPane;
    }
    public List<Control> getControls(){

        ToggleGroup toggleGroup = new ToggleGroup();
        List<Control> controlList = new ArrayList<Control>();
        ToggleButton circleBtn = new ToggleButton("Circle");
        circleBtn.setGraphic(getShapeImageView("oval"));
        circleBtn.setToggleGroup(toggleGroup);
        controlList.add(circleBtn);

        ToggleButton rectangleBtn = new ToggleButton("Rectangle");
        rectangleBtn.setGraphic(getShapeImageView("rectangle"));
        rectangleBtn.setToggleGroup(toggleGroup);
        controlList.add(rectangleBtn);

        ToggleButton triangleBtn = new ToggleButton("Triangle");
        triangleBtn.setGraphic(getShapeImageView("triangle"));
        triangleBtn.setToggleGroup(toggleGroup);
        controlList.add(triangleBtn);

        ToggleButton lineBtn = new ToggleButton("Line");
        lineBtn.setGraphic(getShapeImageView("line"));
        lineBtn.setToggleGroup(toggleGroup);
        controlList.add(lineBtn);

        Label fillLbl = new Label("Fill");
        fillCheckBox = new CheckBox();

        controlList.add(fillCheckBox);
        controlList.add(fillLbl);

        toggleSelection = toggleGroup;

        colorPicker = new ColorPicker();
        controlList.add(colorPicker);

        TextField thicknessText = new TextField();
        thicknessText.setMinWidth(30);
        thicknessText.setMaxWidth(30);
        Label thicknessLbl = new Label("Thickness");
        thicknessSlider = new Slider();
        thicknessSlider.setShowTickLabels(true);
        thicknessSlider.setMin(1);
        thicknessSlider.setMax(10);
        thicknessSlider.setBlockIncrement(1);
        thicknessSlider.setMajorTickUnit(1);
        thicknessSlider.setMinorTickCount(1);
        thicknessSlider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                thicknessText.textProperty().setValue(String.valueOf((double) thicknessSlider.getValue()));
            }
        });

        controlList.add(thicknessLbl);
        controlList.add(thicknessText);
        controlList.add(thicknessSlider);

        return controlList;
    }

    public VBox getCanvas(){
        VBox box = new VBox();
        canvas = new Canvas(700,400);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(toggleSelection.getSelectedToggle() != null){
                    ToggleButton toggleButton = (ToggleButton) toggleSelection.getSelectedToggle();
                    IShape drawing = null;
                    if(toggleButton.getText() == "Rectangle"){
                        drawing = new RectangleAdapter(new Rectangle(event.getX(), event.getY(),50,50,thicknessSlider.getValue(), colorPicker.getValue()),fillCheckBox.isSelected());
                    }
                    else if(toggleButton.getText() == "Circle"){
                        drawing = new CircleAdapter(new Circle(50,event.getX(),event.getY(),thicknessSlider.getValue(),colorPicker.getValue()),fillCheckBox.isSelected());
                    }
                    else if(toggleButton.getText() == "Triangle"){
                        drawing = new TriangleAdapter(new Triangle(event.getX(),event.getY(),50,50,thicknessSlider.getValue(),colorPicker.getValue()),fillCheckBox.isSelected());
                    }
                    else if(toggleButton.getText() == "Line"){
                        drawing = new LineAdapter(new Line(event.getX(),event.getY(),event.getX()+50,event.getY()+50,thicknessSlider.getValue(), colorPicker.getValue()),fillCheckBox.isSelected());
                    }
                    drawing.drawShape(canvas.getGraphicsContext2D());
                }
            }
        });
        box.setStyle("-fx-background-color: #DCDCDC;");
        box.getChildren().add(canvas);
        return box;
    }

    public ImageView getShapeImageView(String shape){
        Image image = new Image(new File("images/"+shape+".png").toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(15);
        imageView.setFitWidth(15);
        return imageView;
    }



}
