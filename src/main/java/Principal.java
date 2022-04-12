import Algorithm.KNN.controlador.KNNController;
import Algorithm.KNN.modelo.KNNModel;
import Algorithm.KNN.vista.KNNVista;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        KNNController controlador = new KNNController();
        KNNModel modelo = new KNNModel();
        KNNVista vista = new KNNVista(primaryStage);

        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModel(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}
