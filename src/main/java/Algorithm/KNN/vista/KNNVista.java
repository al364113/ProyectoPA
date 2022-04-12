package Algorithm.KNN.vista;

import Algorithm.KNN.controlador.KNNController;
import Algorithm.KNN.controlador.KNNControllerInterface;
import Algorithm.KNN.modelo.KNNModelInterface;
import javafx.stage.Stage;


public class KNNVista implements KNNVistaInterface {
    private KNNControllerInterface controlador;
    private KNNModelInterface modelo;
    private Stage stage;

    public KNNVista(Stage stage){
        this.stage = stage;
    }

    public void creaGUI(){

    }

    public void setModelo(KNNModelInterface modelo){
        this.modelo = modelo;
    }

    public void setControlador(KNNControllerInterface controlador){
        this.controlador = controlador;
    }

}
