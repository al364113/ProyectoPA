import Algorithm.controlador.Controlador;
import Algorithm.modelo.KNN.KNNModel;
import Algorithm.vista.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controlador controlador = new Controlador();
        KNNModel modelo = new KNNModel();
        Vista vista = new Vista(primaryStage);

        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModel(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}
