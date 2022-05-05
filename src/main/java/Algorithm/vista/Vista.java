package Algorithm.vista;

import Algorithm.controlador.ControladorInterfaceForVista;
import Algorithm.modelo.ModeloInterfaceForVista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.*;


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
        bOpenFile.setOnAction(actionEvent ->  controlador.leeRuta());

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
        ObservableList posGraficY = FXCollections.observableArrayList();
        comboPosGraficY = new ComboBox<>(posGraficY);
        comboPosGraficY.setOnAction(actionEvent -> controlador.cambiaY());


        //Centro
        ObservableList posGraficX = FXCollections.observableArrayList();
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


    public void defineGrafica(){


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

}

