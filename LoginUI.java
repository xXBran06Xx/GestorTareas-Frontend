package frontend;

import backend.LoginService;

import javax.swing.*;

public class LoginUI {
    private LoginService loginService;

    public LoginUI(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean mostrar() {
        String usuario = JOptionPane.showInputDialog("Usuario:");
        String pass = JOptionPane.showInputDialog("Contraseña:");

        if (loginService.autenticar(usuario, pass)) {
            JOptionPane.showMessageDialog(null, "Login exitoso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            return false;
        }
    }
}
