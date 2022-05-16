package javafx.vista;

import javafx.controlador.ControladorInterfaceForVista;
import javafx.modelo.ModeloInterfaceForVista;
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
    private  List<String> etiquetas;
    private boolean boolY =false;
    private boolean boolX =false;
    Button estimate;


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
                e.printStackTrace();
            }
        });

        ObservableList distancias = FXCollections.observableArrayList("EUCLIDEAN", "MANHATTAN");
        comboDistancias = new ComboBox<>(distancias);
        comboDistancias.setDisable(true);
        comboDistancias.setOnAction(actionEvent -> controlador.cambioDistancias());
        comboDistancias.getSelectionModel().selectFirst();


        textField = new TextField("New Point");

        label = new Label("Label");
        label.setDisable(true);

        estimate = new Button("Estimate");
        estimate.setDisable(true);
        estimate.setOnAction(actionEvent -> controlador.estimateLine());

        VBox vBoxD = new VBox(bOpenFile, comboDistancias, textField, label, estimate);
        vBoxD.setAlignment(Pos.CENTER_LEFT);


        //Izquierda
        posGraficY = FXCollections.observableArrayList();
        comboPosGraficY = new ComboBox<>(posGraficY);
        comboPosGraficY.setOnAction(actionEvent -> controlador.cambiaEjes());


        //Centro
        posGraficX = FXCollections.observableArrayList();
        comboPosGraficX = new ComboBox<>(posGraficX);
        comboPosGraficX.setOnAction(actionEvent -> controlador.cambiaEjes());


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


    public void defineGrafica(ArrayList ejes, List<List<Double>> datos, List<String> etiquetas){
        posGraficY.setAll(ejes);
        comboPosGraficY.getSelectionModel().select(0);
        boolY=true;
        posGraficX.setAll(ejes);
        comboPosGraficX.getSelectionModel().select(1);
        boolX=true;
        modificaEjes();
        activaDistancias();
        this.etiquetas=etiquetas;
        montaEjes(datos,etiquetas);
    }

    public void actualizaGrafica(List<List<Double>> datos){
        montaEjes(datos,etiquetas);
        modificaEjes();
    }

    //Devuelve la ruta del archivo
    public String getRuta(){
        return fileChooser.showOpenDialog(stage).toPath().toString();
    }

    public String getPunto(){
        return textField.getText();
    }

    public String getX(){
        return comboPosGraficX.getSelectionModel().getSelectedItem().toString();
    }

    public String getY() {
        return comboPosGraficY.getSelectionModel().getSelectedItem().toString();
    }
    public String getTipoDist(){
        return comboDistancias.getSelectionModel().getSelectedItem().toString();
    }

    //Comprueba si los ejes X e Y están seleccionados
    public boolean getBooleanXY(){
        boolean ret=false;
        if (boolY && boolX) ret=true;
        return ret;
    }


    private void activaDistancias(){
        comboDistancias.setDisable(false);
        estimate.setDisable(false);
    }

    //Modifica los nombres de los ejes
    private void modificaEjes(){
        yAxis.setLabel(getY());
        xAxis.setLabel(getX());
        scatter.setTitle(getY()+" vs. "+getX());
    }

    public void nuevoPunto(Double coord1, Double coord2, String etiqueta){
        anyadePunto(coord1, coord2);
        modificaEtiqueta(etiqueta);
    }


    private void anyadePunto(Double coord1, Double coord2){
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Punto-nuevo");
        series4.getData().setAll(new XYChart.Data(coord1, coord2));
        scatter.getData().set(3,series4);
    }

    private void modificaEtiqueta(String etiqueta){
        label.setDisable(false);
        label.setText(etiqueta);
    }

    private void montaEjes (List<List<Double>> datos, List<String> etiquetas){

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Iris-setosa");


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Iris-versicolor");

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Iris-virginica");

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Punto-nuevo");

        for (int i =0; i<datos.get(0).size(); i++) {
            if (etiquetas.get(i).equals("Iris-setosa")) {
                series1.getData().add(new XYChart.Data(datos.get(0).get(i), datos.get(1).get(i)));
            } else if (etiquetas.get(i).equals("Iris-versicolor")) {
                series2.getData().add(new XYChart.Data(datos.get(0).get(i), datos.get(1).get(i)));
            } else if (etiquetas.get(i).equals("Iris-virginica")) {
                series3.getData().add(new XYChart.Data(datos.get(0).get(i), datos.get(1).get(i)));
            }
        }
        scatter.getData().setAll(series1,series2,series3, series4);

    }




}

