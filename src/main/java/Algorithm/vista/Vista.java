package Algorithm.vista;

import Algorithm.controlador.ControladorInterfaceForVista;
import Algorithm.modelo.ModeloInterfaceForVista;
import Excepciones.DifferentFieldNumberInRawException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Vista implements VistaInterfaceForControlador, VistaInterfaceForModelo {
    private ControladorInterfaceForVista controlador;
    private ModeloInterfaceForVista modelo;
    private final Stage stage;
    final FileChooser fileChooser = new FileChooser();
    private Label label;
    private TextField textField;
    private ComboBox comboPosGraficX;
    private ComboBox comboPosGraficY;
    private ComboBox comboDistancias;
    private ScatterChart scatter;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private ObservableList posGraficY;
    private ObservableList posGraficX;


    public Vista(final Stage stage) {
        this.stage = stage;
    }

    public void setModelo(ModeloInterfaceForVista modelo) {
        this.modelo = modelo;
    }

    public void setControlador(ControladorInterfaceForVista controlador) {
        this.controlador = controlador;
    }

    public void creaGUI() {

        //Derecha
        Button bOpenFile = new Button("Open file");
        bOpenFile.setOnAction(actionEvent -> {
            try {
                controlador.creaGrafica();
            } catch (IOException | DifferentFieldNumberInRawException e) {
                e.printStackTrace(); //TODO
            }
        });

        ObservableList distancias = FXCollections.observableArrayList("EUCLIDEAN", "MANHATTAN");
        comboDistancias = new ComboBox<>(distancias);
        comboDistancias.getSelectionModel().selectFirst();
        comboDistancias.setDisable(true);
        comboDistancias.setOnAction(actionEvent -> controlador.cambioDistancias());

        textField = new TextField("New Point");

        label = new Label("Label");
        label.setDisable(true);

        Button estimate = new Button("Estimate");
        estimate.setOnAction(actionEvent -> controlador.estimateLine());

        VBox vBoxD = new VBox(bOpenFile, comboDistancias, textField, label, estimate);
        vBoxD.setAlignment(Pos.CENTER_LEFT);


        //Izquierda
        posGraficY = FXCollections.observableArrayList();
        comboPosGraficY = new ComboBox<>(posGraficY);
        comboPosGraficY.setOnAction(actionEvent -> controlador.cambiaY());


        //Centro
        posGraficX = FXCollections.observableArrayList();
        comboPosGraficX = new ComboBox<>(posGraficX);
        comboPosGraficX.setOnAction(actionEvent -> controlador.cambiaX());


        xAxis = new NumberAxis();
        xAxis.setLabel("X");
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(5.0);

        yAxis = new NumberAxis();
        yAxis.setLabel("Y");
        yAxis.setLowerBound(0.0);
        yAxis.setUpperBound(5.0);

        scatter = new ScatterChart(xAxis,yAxis);


        VBox vBoxC = new VBox(scatter,comboPosGraficX);
        vBoxC.setAlignment(Pos.CENTER);



       //Union final
        HBox hBox = new HBox(comboPosGraficY,vBoxC, vBoxD);
        hBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox);

        stage.setScene(scene);
        stage.show();

    }


    public void defineLabel(String text){
        label=new Label(text);
        label.setDisable(false);
    }

    public void cambiaTitulo(String textI, String textD) {
        scatter.setTitle(textI+" vs. "+textD);
        xAxis.setLabel(textD);
        yAxis.setLabel(textI);
    }


    public void defineGrafica(ArrayList ejes, List<List<Double>> datos, List<String> etiquetas){
        defineEjes(ejes);
        activaDistancias();
        montaEjes(datos,etiquetas);
    }

    public String getRuta(){
        return fileChooser.showOpenDialog(stage).toPath().toString();
    }

    public String getNuevosDatos(){
        return textField.getText();
    }

    public String getX(){
        return comboPosGraficX.getSelectionModel().getSelectedItem().toString();
    }

    public String getY(){
        return comboPosGraficY.getSelectionModel().getSelectedItem().toString();
    }

    public String getTipoDist(){
        return comboDistancias.getSelectionModel().getSelectedItem().toString();
    }


    private void activaDistancias(){
        comboDistancias.setDisable(false );
    }

    private void defineEjes(ArrayList ejes){
        posGraficY.setAll(ejes);
        comboPosGraficY.getSelectionModel().select(0);
        yAxis.setLabel(getY());

        posGraficX.setAll(ejes);
        comboPosGraficX.getSelectionModel().select(1);
        xAxis.setLabel(getX());
        cambiaTitulo(getY(),getX());
    }

    private void montaEjes (List<List<Double>> datos, List<String> etiquetas){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Iris-setosa");


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Iris-versicolor");

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Iris-virginica");

        for (int i =0; i<datos.get(0).size(); i++) {
            if (etiquetas.get(i).equals("Iris-setosa")) {
                series1.getData().add(new XYChart.Data(datos.get(0).get(i), datos.get(1).get(i)));
            } else if (etiquetas.get(i).equals("Iris-versicolor")) {
                series2.getData().add(new XYChart.Data(datos.get(0).get(i), datos.get(1).get(i)));
            } else if (etiquetas.get(i).equals("Iris-virginica")) {
                series3.getData().add(new XYChart.Data(datos.get(0).get(i), datos.get(1).get(i)));
            }
        }

        scatter.getData().addAll(series1,series2,series3);

    }

}

