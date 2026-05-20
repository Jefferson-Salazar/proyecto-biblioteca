package ui;

import dominio.Libro;
import dominio.Material;
import dominio.Revista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaMateriales extends JFrame {

    private static final long serialVersionUID = 1L;

    //Datos 
    private List<Material> materiales = new ArrayList<>();
    private DefaultTableModel modeloTabla;

    //Componentes
    private JTable tabla;
    private JTextField campoBuscar;
    private JTextField campoCodigo, campoTitulo, campoAutor, campoAnio, campoCopias, campoExtra;
    private JComboBox<String> comboTipo;
    private JLabel labelExtra;

    public VentanaMateriales() {
        setTitle("Catálogo de Materiales");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // no cierra todo el programa
        setBounds(100, 100, 1000, 600);
        setLocationRelativeTo(null);

        JPanel contenido = new JPanel();
        contenido.setBackground(new Color(10, 12, 16));
        contenido.setBorder(new EmptyBorder(0, 0, 0, 0));
        contenido.setLayout(null);
        setContentPane(contenido);

        // ── CABECERA ───────────────────────────────────────
        JPanel cabecera = new JPanel();
        cabecera.setBackground(new Color(14, 17, 24));
        cabecera.setBounds(0, 0, 1000, 60);
        cabecera.setLayout(null);
        contenido.add(cabecera);

        JLabel lblTitulo = new JLabel("CATÁLOGO DE MATERIALES");
        lblTitulo.setForeground(new Color(243, 244, 246));
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setBounds(20, 15, 400, 30);
        cabecera.add(lblTitulo);

        // ── BUSCADOR ───────────────────────────────────────
        campoBuscar = new JTextField();
        campoBuscar.setBackground(new Color(18, 22, 30));
        campoBuscar.setForeground(new Color(243, 244, 246));
        campoBuscar.setCaretColor(Color.WHITE);
        campoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        campoBuscar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 45, 60)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        campoBuscar.setBounds(20, 75, 300, 34);
        contenido.add(campoBuscar);

        JButton btnBuscar = crearBoton("BUSCAR", new Color(99, 130, 255));
        btnBuscar.setBounds(330, 75, 100, 34);
        contenido.add(btnBuscar);

        //TABLA
        String[] columnas = {"Código", "Tipo", "Título", "Autor", "Año", "Disponibles", "Total"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int row, int col) { return false; }
        };

        tabla = new JTable(modeloTabla);
        tabla.setBackground(new Color(18, 22, 30));
        tabla.setForeground(new Color(220, 220, 220));
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setRowHeight(28);
        tabla.getTableHeader().setBackground(new Color(14, 17, 24));
        tabla.getTableHeader().setForeground(new Color(99, 130, 255));
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabla.setSelectionBackground(new Color(40, 50, 80));
        tabla.setGridColor(new Color(30, 35, 50));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 125, 590, 430);
        scroll.getViewport().setBackground(new Color(18, 22, 30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(40, 45, 60)));
        contenido.add(scroll);

        //FORMULARIO
        JPanel panelForm = new JPanel();
        panelForm.setBackground(new Color(18, 22, 30));
        panelForm.setBounds(630, 75, 350, 480);
        panelForm.setLayout(null);
        panelForm.setBorder(BorderFactory.createLineBorder(new Color(40, 45, 60)));
        contenido.add(panelForm);

        JLabel lblForm = new JLabel("REGISTRAR MATERIAL");
        lblForm.setForeground(new Color(99, 130, 255));
        lblForm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblForm.setBounds(15, 15, 320, 22);
        panelForm.add(lblForm);

        // Tipo
        comboTipo = new JComboBox<>(new String[]{"Libro", "Revista"});
        comboTipo.setBounds(15, 50, 320, 30);
        estilizarCombo(comboTipo);
        panelForm.add(comboTipo);

        // Campos
        campoCodigo  = crearCampo(panelForm, "Código",    95);
        campoTitulo  = crearCampo(panelForm, "Título",   145);
        campoAutor   = crearCampo(panelForm, "Autor",    195);
        campoAnio    = crearCampo(panelForm, "Año",      245);
        campoCopias  = crearCampo(panelForm, "Copias",   295);

        // Campo extra (ISBN o Edición según tipo)
        labelExtra = new JLabel("ISBN");
        labelExtra.setForeground(new Color(110, 118, 135));
        labelExtra.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        labelExtra.setBounds(15, 345, 320, 16);
        panelForm.add(labelExtra);

        campoExtra = new JTextField();
        estilizarCampo(campoExtra);
        campoExtra.setBounds(15, 363, 320, 30);
        panelForm.add(campoExtra);

        // Botones
        JButton btnRegistrar = crearBoton("REGISTRAR", new Color(99, 130, 255));
        btnRegistrar.setBounds(15, 415, 148, 38);
        panelForm.add(btnRegistrar);

        JButton btnLimpiar = crearBoton("LIMPIAR", new Color(40, 45, 60));
        btnLimpiar.setBounds(173, 415, 162, 38);
        panelForm.add(btnLimpiar);

        //ACCIONES
        comboTipo.addActionListener(e -> {
            boolean esLibro = comboTipo.getSelectedItem().equals("Libro");
            labelExtra.setText(esLibro ? "ISBN" : "Número de Edición");
        });

        btnRegistrar.addActionListener(e -> registrarMaterial());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnBuscar.addActionListener(e -> buscarMaterial());
    }

    //Lógica

    private void registrarMaterial() {
        try {
            String codigo  = campoCodigo.getText().trim();
            String titulo  = campoTitulo.getText().trim();
            String autor   = campoAutor.getText().trim();
            int anio       = Integer.parseInt(campoAnio.getText().trim());
            int copias     = Integer.parseInt(campoCopias.getText().trim());
            String extra   = campoExtra.getText().trim();

            // Validar código único
            for (Material m : materiales) {
                if (m.getCodigo().equalsIgnoreCase(codigo)) {
                    JOptionPane.showMessageDialog(this,
                            "Ya existe un material con ese código.",
                            "Código duplicado", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            Material nuevo;
            if (comboTipo.getSelectedItem().equals("Libro")) {
                nuevo = new Libro(codigo, titulo, autor, anio, copias, extra, "");
            } else {
                int edicion = extra.isEmpty() ? 1 : Integer.parseInt(extra);
                nuevo = new Revista(codigo, titulo, autor, anio, copias, edicion);
            }

            materiales.add(nuevo);
            agregarFilaTabla(nuevo);
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Material registrado correctamente.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Año y Copias deben ser números válidos.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarFilaTabla(Material m) {
        String tipo = (m instanceof Libro) ? "Libro" : "Revista";
        modeloTabla.addRow(new Object[]{
                m.getCodigo(), tipo, m.getTitulo(), m.getAutor(),
                m.getAnio(), m.getCopiasDisponibles(), m.getTotalCopias()
        });
    }

    private void buscarMaterial() {
        String filtro = campoBuscar.getText().trim().toLowerCase();
        modeloTabla.setRowCount(0);
        for (Material m : materiales) {
            if (m.getCodigo().toLowerCase().contains(filtro)
                    || m.getTitulo().toLowerCase().contains(filtro)) {
                agregarFilaTabla(m);
            }
        }
    }

    private void limpiarFormulario() {
        campoCodigo.setText("");
        campoTitulo.setText("");
        campoAutor.setText("");
        campoAnio.setText("");
        campoCopias.setText("");
        campoExtra.setText("");
        comboTipo.setSelectedIndex(0);
    }

    //Helpers de UI

    private JTextField crearCampo(JPanel panel, String etiqueta, int y) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setForeground(new Color(110, 118, 135));
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lbl.setBounds(15, y, 320, 16);
        panel.add(lbl);

        JTextField campo = new JTextField();
        estilizarCampo(campo);
        campo.setBounds(15, y + 18, 320, 30);
        panel.add(campo);
        return campo;
    }

    private void estilizarCampo(JTextField campo) {
        campo.setBackground(new Color(10, 12, 16));
        campo.setForeground(new Color(243, 244, 246));
        campo.setCaretColor(Color.WHITE);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 45, 60)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
    }

    private void estilizarCombo(JComboBox<String> combo) {
        combo.setBackground(new Color(10, 12, 16));
        combo.setForeground(new Color(243, 244, 246));
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }

    private JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }
}