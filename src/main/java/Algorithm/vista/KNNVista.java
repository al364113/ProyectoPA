package Algorithm.vista;

import Algorithm.controlador.KNNControllerInterface;
import Algorithm.modelo.KNN.KNNModelInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        ObservableList distancias = FXCollections.observableArrayList("Euclidean", "Manhattan");
        ComboBox comboDistancias = new ComboBox<>(distancias);
        //comboDistancias.setOnAction(actionEvent -> controlador.); //TODO

        TextField textField = new TextField("New Point");
        Label label = new Label("label");
        Button estimate = new Button("Estimate");
        estimate.setOnAction(actionEvent -> controlador.estimateLine(textField.getText()));

        VBox vBox = new VBox(bOpenFile, comboDistancias, textField, estimate);


        //Izquierda
        ObservableList posGrafic = FXCollections.observableArrayList("sepal length", "sepal with", "petal length", "petal with");
        ComboBox comboPosGrafic = new ComboBox<>(posGrafic);

        //Centro
        titulo = new Label();


        ObservableList posGraficB = FXCollections.observableArrayList("sepal length", "sepal with", "petal length", "petal with");
        ComboBox comboPosGraficB = new ComboBox<>(posGraficB);


        HBox hBox = new HBox(comboPosGrafic, vBox);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();


    }

    public void cambiaTextoI (String text){

    }
    public void cambiaTextoD (String text){

    }
}
