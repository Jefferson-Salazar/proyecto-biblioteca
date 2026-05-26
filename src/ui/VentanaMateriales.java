package ui;

import dominio.Libro;
import dominio.Material;
import dominio.Revista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.util.List;

public class VentanaMateriales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenido;

	// datos 
	private List<Material> materiales;
	private DefaultTableModel modeloTabla;

	// campos del formulario
	JTextField campoCodigo;
	JTextField campoTitulo;
	JTextField campoAutor;
	JTextField campoAño;
	JTextField campoCopias;
	JTextField campoExtra;
	JComboBox<String> comboTipo;
	JLabel labelExtra;

	// tabla y busqueda
	JTable tablaMateriales;
	JTextField campoBuscar;

	// CONSTRUCTOR MODIFICADO - RECIBE LA LISTA
	public VentanaMateriales(List<Material> materiales) {
		this.materiales = materiales;

		setTitle("Materiales");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);

		contenido = new JPanel();
		contenido.setBackground(new Color(10, 12, 16));
		contenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenido);
		contenido.setLayout(null);

		// cabecera
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(14, 17, 24));
		panelCabecera.setBounds(0, 0, 1000, 65);
		contenido.add(panelCabecera);
		panelCabecera.setLayout(null);

		JLabel insignia = new JLabel("M");
		insignia.setOpaque(true);
		insignia.setBackground(new Color(99, 130, 255));
		insignia.setForeground(Color.WHITE);
		insignia.setFont(new Font("Segoe UI", Font.BOLD, 22));
		insignia.setHorizontalAlignment(SwingConstants.CENTER);
		insignia.setBounds(18, 14, 36, 36);
		panelCabecera.add(insignia);

		JLabel lblTitulo = new JLabel("CATÁLOGO DE MATERIALES");
		lblTitulo.setForeground(new Color(243, 244, 246));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setBounds(68, 18, 380, 28);
		panelCabecera.add(lblTitulo);

		JButton botonVolver = new JButton("< Volver");
		botonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVolver.setForeground(new Color(99, 130, 255));
		botonVolver.setBackground(new Color(14, 17, 24));
		botonVolver.setFont(new Font("Segoe UI", Font.BOLD, 12));
		botonVolver.setFocusPainted(false);
		botonVolver.setBorderPainted(false);
		botonVolver.setBounds(870, 18, 100, 28);
		panelCabecera.add(botonVolver);

		botonVolver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
			}
		});

		// panel formulario izquierdo
		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(new Color(18, 22, 30));
		panelFormulario.setBounds(10, 78, 300, 490);
		contenido.add(panelFormulario);
		panelFormulario.setLayout(null);

		JPanel barraAzul = new JPanel();
		barraAzul.setBackground(new Color(99, 130, 255));
		barraAzul.setBounds(0, 0, 300, 4);
		panelFormulario.add(barraAzul);

		JLabel lblRegistrar = new JLabel("Registrar Material");
		lblRegistrar.setForeground(new Color(243, 244, 246));
		lblRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRegistrar.setBounds(15, 14, 200, 22);
		panelFormulario.add(lblRegistrar);

		// tipo
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(new Color(110, 118, 135));
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblTipo.setBounds(15, 44, 100, 16);
		panelFormulario.add(lblTipo);

		comboTipo = new JComboBox();
		comboTipo.addItem("Libro");
		comboTipo.addItem("Revista");
		comboTipo.setBackground(new Color(10, 12, 16));
		comboTipo.setForeground(new Color(243, 244, 246));
		comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboTipo.setBounds(15, 61, 270, 26);
		panelFormulario.add(comboTipo);

		// codigo
		JLabel lblCodigo = new JLabel("Código ");
		lblCodigo.setForeground(new Color(110, 118, 135));
		lblCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCodigo.setBounds(15, 100, 100, 16);
		panelFormulario.add(lblCodigo);

		campoCodigo = new JTextField();
		campoCodigo.setBackground(new Color(10, 12, 16));
		campoCodigo.setForeground(new Color(243, 244, 246));
		campoCodigo.setCaretColor(Color.WHITE);
		campoCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCodigo.setBounds(15, 117, 270, 26);
		panelFormulario.add(campoCodigo);

		// titulo
		JLabel lblTituloMat = new JLabel("Título ");
		lblTituloMat.setForeground(new Color(110, 118, 135));
		lblTituloMat.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblTituloMat.setBounds(15, 156, 100, 16);
		panelFormulario.add(lblTituloMat);

		campoTitulo = new JTextField();
		campoTitulo.setBackground(new Color(10, 12, 16));
		campoTitulo.setForeground(new Color(243, 244, 246));
		campoTitulo.setCaretColor(Color.WHITE);
		campoTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoTitulo.setBounds(15, 173, 270, 26);
		panelFormulario.add(campoTitulo);

		// autor
		JLabel lblAutor = new JLabel("Autor ");
		lblAutor.setForeground(new Color(110, 118, 135));
		lblAutor.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAutor.setBounds(15, 212, 100, 16);
		panelFormulario.add(lblAutor);

		campoAutor = new JTextField();
		campoAutor.setBackground(new Color(10, 12, 16));
		campoAutor.setForeground(new Color(243, 244, 246));
		campoAutor.setCaretColor(Color.WHITE);
		campoAutor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoAutor.setBounds(15, 229, 270, 26);
		panelFormulario.add(campoAutor);

		// anio
		JLabel lblAño = new JLabel("Año");
		lblAño.setForeground(new Color(110, 118, 135));
		lblAño.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAño.setBounds(15, 268, 100, 16);
		panelFormulario.add(lblAño);

		campoAño = new JTextField();
		campoAño.setBackground(new Color(10, 12, 16));
		campoAño.setForeground(new Color(243, 244, 246));
		campoAño.setCaretColor(Color.WHITE);
		campoAño.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoAño.setBounds(15, 285, 270, 26);
		panelFormulario.add(campoAño);

		// copias
		JLabel lblCopias = new JLabel("Copias ");
		lblCopias.setForeground(new Color(110, 118, 135));
		lblCopias.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCopias.setBounds(15, 324, 100, 16);
		panelFormulario.add(lblCopias);

		campoCopias = new JTextField();
		campoCopias.setBackground(new Color(10, 12, 16));
		campoCopias.setForeground(new Color(243, 244, 246));
		campoCopias.setCaretColor(Color.WHITE);
		campoCopias.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCopias.setBounds(15, 341, 270, 26);
		panelFormulario.add(campoCopias);

		// campo extra (ISBN o edicion segun tipo)
		labelExtra = new JLabel("ISBN");
		labelExtra.setForeground(new Color(110, 118, 135));
		labelExtra.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		labelExtra.setBounds(15, 380, 270, 16);
		panelFormulario.add(labelExtra);

		campoExtra = new JTextField();
		campoExtra.setBackground(new Color(10, 12, 16));
		campoExtra.setForeground(new Color(243, 244, 246));
		campoExtra.setCaretColor(Color.WHITE);
		campoExtra.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoExtra.setBounds(15, 397, 270, 26);
		panelFormulario.add(campoExtra);

		JButton botonAgregar = new JButton("AGREGAR");
		botonAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAgregar.setForeground(Color.WHITE);
		botonAgregar.setBackground(new Color(99, 130, 255));
		botonAgregar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonAgregar.setFocusPainted(false);
		botonAgregar.setBorderPainted(false);
		botonAgregar.setBounds(15, 436, 130, 34);
		panelFormulario.add(botonAgregar);

		JButton botonLimpiar = new JButton("LIMPIAR");
		botonLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonLimpiar.setForeground(new Color(180, 185, 195));
		botonLimpiar.setBackground(new Color(35, 40, 52));
		botonLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonLimpiar.setFocusPainted(false);
		botonLimpiar.setBorderPainted(false);
		botonLimpiar.setBounds(155, 436, 130, 34);
		panelFormulario.add(botonLimpiar);

		// panel tabla derecho
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(18, 22, 30));
		panelTabla.setBounds(322, 78, 660, 490);
		contenido.add(panelTabla);
		panelTabla.setLayout(null);

		JPanel barraAzul2 = new JPanel();
		barraAzul2.setBackground(new Color(99, 130, 255));
		barraAzul2.setBounds(0, 0, 660, 4);
		panelTabla.add(barraAzul2);

		JLabel lblLista = new JLabel("Lista de materiales");
		lblLista.setForeground(new Color(243, 244, 246));
		lblLista.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLista.setBounds(15, 16, 260, 22);
		panelTabla.add(lblLista);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(new Color(110, 118, 135));
		lblBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblBuscar.setBounds(15, 50, 60, 24);
		panelTabla.add(lblBuscar);

		campoBuscar = new JTextField();
		campoBuscar.setBackground(new Color(10, 12, 16));
		campoBuscar.setForeground(new Color(243, 244, 246));
		campoBuscar.setCaretColor(Color.WHITE);
		campoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoBuscar.setBounds(75, 50, 430, 26);
		panelTabla.add(campoBuscar);

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setBackground(new Color(99, 130, 255));
		botonBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botonBuscar.setFocusPainted(false);
		botonBuscar.setBorderPainted(false);
		botonBuscar.setBounds(515, 50, 130, 26);
		panelTabla.add(botonBuscar);

		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Codigo");
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("Titulo");
		modeloTabla.addColumn("Autor");
		modeloTabla.addColumn("Año");
		modeloTabla.addColumn("Disponibles");
		modeloTabla.addColumn("Total");

		tablaMateriales = new JTable(modeloTabla) {
			public boolean isCellEditable(int row, int col) { return false; }
		};
		tablaMateriales.setBackground(new Color(10, 12, 16));
		tablaMateriales.setForeground(new Color(200, 204, 212));
		tablaMateriales.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaMateriales.setRowHeight(26);
		tablaMateriales.setGridColor(new Color(28, 34, 46));
		tablaMateriales.setSelectionBackground(new Color(99, 130, 255));
		tablaMateriales.getTableHeader().setBackground(new Color(18, 22, 30));
		tablaMateriales.getTableHeader().setForeground(new Color(110, 118, 135));
		tablaMateriales.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));

		JScrollPane scroll = new JScrollPane(tablaMateriales);
		scroll.getViewport().setBackground(new Color(10, 12, 16));
		scroll.setBorder(null);
		scroll.setBounds(15, 90, 630, 385);
		panelTabla.add(scroll);

		// acciones
		comboTipo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				boolean esLibro = comboTipo.getSelectedItem().equals("Libro");
				labelExtra.setText(esLibro ? "ISBN" : "Número de Edición");
			}
		});

		botonAgregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				registrarMaterial();
			}
		});

		botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				campoCodigo.setText("");
				campoTitulo.setText("");
				campoAutor.setText("");
				campoAño.setText("");
				campoCopias.setText("");
				campoExtra.setText("");
				comboTipo.setSelectedIndex(0);
			}
		});

		botonBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				buscarMaterial();
			}
		});
	}

	private void registrarMaterial() {
		try {
			String codigo = campoCodigo.getText().trim();
			String titulo = campoTitulo.getText().trim();
			String autor = campoAutor.getText().trim();
			int anio = Integer.parseInt(campoAño.getText().trim());
			int copias = Integer.parseInt(campoCopias.getText().trim());
			String extra = campoExtra.getText().trim();

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

			campoCodigo.setText("");
			campoTitulo.setText("");
			campoAutor.setText("");
			campoAño.setText("");
			campoCopias.setText("");
			campoExtra.setText("");
			comboTipo.setSelectedIndex(0);

			JOptionPane.showMessageDialog(this, "Material registrado correctamente.");

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
					"Año y Copias deben ser numeros validos.",
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

	    // Si el campo está vacío, muestra todos
	    if (filtro.isEmpty()) {
	        for (Material m : materiales) agregarFilaTabla(m);
	        return;
	    }

	    boolean encontro = false;

	    for (Material m : materiales) {
	        if (m.getCodigo().toLowerCase().contains(filtro)
	                || m.getTitulo().toLowerCase().contains(filtro)) {
	            agregarFilaTabla(m);
	            encontro = true;
	        }
	    }

	    if (!encontro) {
	        JOptionPane.showMessageDialog(this,
	                "No se encontraron coincidencias para: \"" + campoBuscar.getText().trim() + "\"",
	                "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
}