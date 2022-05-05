package Algorithm.vista;

import Algorithm.controlador.KNNControllerInterface;
import Algorithm.modelo.KNN.KNNModelInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.*;

import javax.swing.*;
import java.io.File;
import java.util.Observable;


public class KNNVista implements KNNVistaInterface {
    private KNNControllerInterface controlador;
    private KNNModelInterface modelo;
    private final Stage stage;
    final FileChooser fileChooser = new FileChooser();

    String texto = " .vs ";
    Label titulo;

    public KNNVista(final Stage stage) {
        this.stage = stage;
    }

    public void setModelo(KNNModelInterface modelo) {
        this.modelo = modelo;
    }

    public void setControlador(KNNControllerInterface controlador) {
        this.controlador = controlador;
    }

    public void creaGUI() {

        //Derecha
        Button bOpenFile = new Button("Open file");
        bOpenFile.setOnAction(actionEvent ->  controlador.leeRuta(fileChooser.showOpenDialog(stage).toPath().toString()));

        ObservableList distancias = FXCollections.observableArrayList("EUCLIDEAN", "MANHATTAN");
        ComboBox comboDistancias = new ComboBox<>(distancias);
        comboDistancias.getSelectionModel().selectFirst();
        comboDistancias.setDisable(true);
        comboDistancias.setOnAction(actionEvent -> controlador.);

        TextField textField = new TextField("New Point");

        Label label = new Label("Label");
        label.setDisable(true);

        Button estimate = new Button("Estimate");
        estimate.setOnAction(actionEvent -> controlador.estimateLine(textField.getText()));

        VBox vBoxD = new VBox(bOpenFile, comboDistancias, textField, label, estimate);
        vBoxD.setAlignment(Pos.CENTER_LEFT);


        //Izquierda
        ObservableList posGrafic = FXCollections.observableArrayList();
        ComboBox comboPosGrafic = new ComboBox<>(posGrafic);


        //Centro
        ObservableList posGraficB = FXCollections.observableArrayList();
        ComboBox comboPosGraficB = new ComboBox<>(posGraficB);

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(5.0);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");
        yAxis.setLowerBound(0.0);
        yAxis.setUpperBound(5.0);

        ScatterChart scatter = new ScatterChart(xAxis,yAxis);


        VBox vBoxC = new VBox(scatter,comboPosGraficB);
        vBoxC.setAlignment(Pos.CENTER);



       //Union final
        HBox hBox = new HBox(comboPosGrafic,vBoxC, vBoxD);
        hBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();

    }

    public void cambiaTituloI (String text){

    }
    public void cambiaTituloD (String text){

    }

    public void muestraTitulo (){

    }

    public void definePosGrafic(){

    }

    public void defineLabel(){

    }

    public void activaDistancias(){

    }

    public void defineGrafica(){

    }
}
