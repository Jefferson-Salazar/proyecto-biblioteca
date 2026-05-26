package main;

import ui.VentanaPrincipal;
import dominio.Material;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Material> materiales = new ArrayList<>();
        List<Usuario>  usuarios   = new ArrayList<>();

        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}