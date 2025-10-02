package frontend;

import backend.*;

public class MainApp {
    public static void main(String[] args) throws Exception {
        LoginService login = new LoginService();
        TaskManager manager = new TaskManager();
        ApiServer api = new ApiServer(manager);

        // Iniciar API en otro hilo
        new Thread(() -> {
            try {
                api.iniciar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        LoginUI loginUI = new LoginUI(login);
        if (loginUI.mostrar()) {
            TaskUI taskUI = new TaskUI(manager);
            taskUI.mostrarMenu();
        }
    }
}
