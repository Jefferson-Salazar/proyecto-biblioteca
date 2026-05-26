package ui;

import dominio.Estudiante;
import dominio.Material;
import dominio.Prestamo;
import dominio.Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class VentanaPrestamos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenido;

	// datos compartidos que vienen de las otras ventanas
	private List<Material> materiales;
	private List<Usuario> usuarios;

	// lista propia de prestamos
	private List<Prestamo> listaPrestamos;
	private int contadorId = 1;

	// combos prestamo
	JComboBox<String> comboUsuarios;
	JComboBox<String> comboMateriales;

	// campo devolucion
	JTextField campoIdDevolucion;

	// tabla
	JTable tablaPrestamos;
	DefaultTableModel modeloTabla;

	// recibe las listas de materiales y usuarios para buscar en ellas
	public VentanaPrestamos(List<Material> listaMateriales, List<Usuario> listaUsuarios, List<Prestamo> listaPrestamosExistentes) {
	    this.materiales     = listaMateriales;
	    this.usuarios       = listaUsuarios;
	    this.listaPrestamos = listaPrestamosExistentes;

		setTitle("Préstamos y Devoluciones");
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

		JLabel insignia = new JLabel("P");
		insignia.setOpaque(true);
		insignia.setBackground(new Color(255, 168, 77));
		insignia.setForeground(Color.WHITE);
		insignia.setFont(new Font("Segoe UI", Font.BOLD, 22));
		insignia.setHorizontalAlignment(SwingConstants.CENTER);
		insignia.setBounds(18, 14, 36, 36);
		panelCabecera.add(insignia);

		JLabel lblTitulo = new JLabel("PRÉSTAMOS Y DEVOLUCIONES");
		lblTitulo.setForeground(new Color(243, 244, 246));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setBounds(68, 18, 400, 28);
		panelCabecera.add(lblTitulo);

		JButton botonVolver = new JButton("< Volver");
		botonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVolver.setForeground(new Color(255, 168, 77));
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

		// panel formulario prestamo
		JPanel panelPrestamo = new JPanel();
		panelPrestamo.setBackground(new Color(18, 22, 30));
		panelPrestamo.setBounds(10, 78, 300, 210);
		contenido.add(panelPrestamo);
		panelPrestamo.setLayout(null);

		JPanel barraAmbar = new JPanel();
		barraAmbar.setBackground(new Color(255, 168, 77));
		barraAmbar.setBounds(0, 0, 300, 4);
		panelPrestamo.add(barraAmbar);

		JLabel lblNuevoPrestamo = new JLabel("Nuevo Préstamo");
		lblNuevoPrestamo.setForeground(new Color(243, 244, 246));
		lblNuevoPrestamo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNuevoPrestamo.setBounds(15, 14, 200, 22);
		panelPrestamo.add(lblNuevoPrestamo);

		JLabel lblUsuario = new JLabel("Usuario *");
		lblUsuario.setForeground(new Color(110, 118, 135));
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblUsuario.setBounds(15, 44, 180, 16);
		panelPrestamo.add(lblUsuario);

		comboUsuarios = new JComboBox<>();
		comboUsuarios.setBackground(new Color(10, 12, 16));
		comboUsuarios.setForeground(new Color(243, 244, 246));
		comboUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboUsuarios.setBounds(15, 61, 270, 26);
		panelPrestamo.add(comboUsuarios);

		// cargar usuarios en el combo
		for (Usuario u : usuarios) {
		    comboUsuarios.addItem(u.getCarnet() + " - " + u.getNombre() + " " + u.getApellido());
		}

		JLabel lblMaterial = new JLabel("Material *");
		lblMaterial.setForeground(new Color(110, 118, 135));
		lblMaterial.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblMaterial.setBounds(15, 100, 180, 16);
		panelPrestamo.add(lblMaterial);

		comboMateriales = new JComboBox<>();
		comboMateriales.setBackground(new Color(10, 12, 16));
		comboMateriales.setForeground(new Color(243, 244, 246));
		comboMateriales.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboMateriales.setBounds(15, 117, 270, 26);
		panelPrestamo.add(comboMateriales);

		// cargar materiales disponibles en el combo
		for (Material m : materiales) {
		    comboMateriales.addItem(m.getCodigo() + " - " + m.getTitulo());
		}

		JButton botonPrestar = new JButton("PRESTAR");
		botonPrestar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonPrestar.setForeground(Color.WHITE);
		botonPrestar.setBackground(new Color(255, 168, 77));
		botonPrestar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonPrestar.setFocusPainted(false);
		botonPrestar.setBorderPainted(false);
		botonPrestar.setBounds(15, 162, 130, 34);
		panelPrestamo.add(botonPrestar);

		JButton botonLimpiarPrestamo = new JButton("LIMPIAR");
		botonLimpiarPrestamo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonLimpiarPrestamo.setForeground(new Color(180, 185, 195));
		botonLimpiarPrestamo.setBackground(new Color(35, 40, 52));
		botonLimpiarPrestamo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonLimpiarPrestamo.setFocusPainted(false);
		botonLimpiarPrestamo.setBorderPainted(false);
		botonLimpiarPrestamo.setBounds(155, 162, 130, 34);
		panelPrestamo.add(botonLimpiarPrestamo);

		// panel formulario devolucion
		JPanel panelDevolucion = new JPanel();
		panelDevolucion.setBackground(new Color(18, 22, 30));
		panelDevolucion.setBounds(10, 300, 300, 140);
		contenido.add(panelDevolucion);
		panelDevolucion.setLayout(null);

		JPanel barraAmbar2 = new JPanel();
		barraAmbar2.setBackground(new Color(255, 168, 77));
		barraAmbar2.setBounds(0, 0, 300, 4);
		panelDevolucion.add(barraAmbar2);

		JLabel lblDevolucion = new JLabel("Registrar Devolución");
		lblDevolucion.setForeground(new Color(243, 244, 246));
		lblDevolucion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDevolucion.setBounds(15, 14, 200, 22);
		panelDevolucion.add(lblDevolucion);

		JLabel lblIdPrestamo = new JLabel("ID del préstamo *");
		lblIdPrestamo.setForeground(new Color(110, 118, 135));
		lblIdPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblIdPrestamo.setBounds(15, 44, 180, 16);
		panelDevolucion.add(lblIdPrestamo);

		campoIdDevolucion = new JTextField();
		campoIdDevolucion.setBackground(new Color(10, 12, 16));
		campoIdDevolucion.setForeground(new Color(243, 244, 246));
		campoIdDevolucion.setCaretColor(Color.WHITE);
		campoIdDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoIdDevolucion.setBounds(15, 61, 270, 26);
		panelDevolucion.add(campoIdDevolucion);

		JButton botonDevolver = new JButton("DEVOLVER");
		botonDevolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonDevolver.setForeground(Color.WHITE);
		botonDevolver.setBackground(new Color(255, 168, 77));
		botonDevolver.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonDevolver.setFocusPainted(false);
		botonDevolver.setBorderPainted(false);
		botonDevolver.setBounds(15, 96, 270, 34);
		panelDevolucion.add(botonDevolver);

		// panel tabla derecho
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(18, 22, 30));
		panelTabla.setBounds(322, 78, 660, 490);
		contenido.add(panelTabla);
		panelTabla.setLayout(null);

		JPanel barraAmbar3 = new JPanel();
		barraAmbar3.setBackground(new Color(255, 168, 77));
		barraAmbar3.setBounds(0, 0, 660, 4);
		panelTabla.add(barraAmbar3);

		JLabel lblLista = new JLabel("Historial de préstamos");
		lblLista.setForeground(new Color(243, 244, 246));
		lblLista.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLista.setBounds(15, 16, 280, 22);
		panelTabla.add(lblLista);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(new Color(110, 118, 135));
		lblBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblBuscar.setBounds(15, 50, 60, 24);
		panelTabla.add(lblBuscar);

		JTextField campoBuscar = new JTextField();
		campoBuscar.setBackground(new Color(10, 12, 16));
		campoBuscar.setForeground(new Color(243, 244, 246));
		campoBuscar.setCaretColor(Color.WHITE);
		campoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoBuscar.setBounds(75, 50, 430, 26);
		panelTabla.add(campoBuscar);

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setBackground(new Color(255, 168, 77));
		botonBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botonBuscar.setFocusPainted(false);
		botonBuscar.setBorderPainted(false);
		botonBuscar.setBounds(515, 50, 130, 26);
		panelTabla.add(botonBuscar);

		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Carnet");
		modeloTabla.addColumn("Usuario");
		modeloTabla.addColumn("Código material");
		modeloTabla.addColumn("Título");
		modeloTabla.addColumn("Fecha");
		modeloTabla.addColumn("Estado");

		tablaPrestamos = new JTable(modeloTabla) {
			public boolean isCellEditable(int row, int col) { return false; }
		};
		tablaPrestamos.setBackground(new Color(10, 12, 16));
		tablaPrestamos.setForeground(new Color(200, 204, 212));
		tablaPrestamos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaPrestamos.setRowHeight(26);
		tablaPrestamos.setGridColor(new Color(28, 34, 46));
		tablaPrestamos.setSelectionBackground(new Color(255, 168, 77));
		tablaPrestamos.getTableHeader().setBackground(new Color(18, 22, 30));
		tablaPrestamos.getTableHeader().setForeground(new Color(110, 118, 135));
		tablaPrestamos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));

		JScrollPane scroll = new JScrollPane(tablaPrestamos);
		scroll.getViewport().setBackground(new Color(10, 12, 16));
		scroll.setBorder(null);
		scroll.setBounds(15, 90, 630, 385);
		panelTabla.add(scroll);

		// acciones
		botonPrestar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				registrarPrestamo();
			}
		});

		botonLimpiarPrestamo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				comboUsuarios.setSelectedIndex(0);
				comboMateriales.setSelectedIndex(0);
			}
		});

		botonDevolver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				registrarDevolucion();
			}
		});

		botonBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				buscarPrestamo(campoBuscar.getText().trim().toLowerCase());
			}
		});
	}

	private void registrarPrestamo() {
	    if (comboUsuarios.getItemCount() == 0 || comboMateriales.getItemCount() == 0) {
	        JOptionPane.showMessageDialog(this,
	            "No hay usuarios o materiales registrados.",
	            "Sin datos", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // extraer carnet y código del texto seleccionado
	    String itemUsuario   = comboUsuarios.getSelectedItem().toString();
	    String itemMaterial  = comboMateriales.getSelectedItem().toString();
	    String carnet = itemUsuario.split(" - ")[0].trim();
	    String codigo = itemMaterial.split(" - ")[0].trim();

	    // buscar usuario
	    Usuario usuario = null;
	    for (Usuario u : usuarios) {
	        if (u.getCarnet().equalsIgnoreCase(carnet)) {
	            usuario = u;
	            break;
	        }
	    }

	    // buscar material
	    Material material = null;
	    for (Material m : materiales) {
	        if (m.getCodigo().equalsIgnoreCase(codigo)) {
	            material = m;
	            break;
	        }
	    }

	    // validar prestamo activo
	    for (Prestamo p : listaPrestamos) {
	        if (p.getUsuario().getCarnet().equalsIgnoreCase(carnet) && !p.isDevuelto()) {
	            JOptionPane.showMessageDialog(this,
	                "Este usuario ya tiene un préstamo activo.",
	                "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	    }

	    // validar disponibilidad
	    if (!material.estaDisponible()) {
	        JOptionPane.showMessageDialog(this,
	            "El material no tiene copias disponibles.",
	            "Sin disponibilidad", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // realizar prestamo
	    material.prestar();
	    String fecha = LocalDate.now().toString();
	    String id = "P" + String.format("%03d", contadorId++);
	    Prestamo nuevo = new Prestamo(id, usuario, material, fecha);
	    listaPrestamos.add(nuevo);

	    modeloTabla.addRow(new Object[]{
	        id,
	        usuario.getCarnet(),
	        usuario.getNombre() + " " + usuario.getApellido(),
	        material.getCodigo(),
	        material.getTitulo(),
	        fecha,
	        "Activo"
	    });

	    comboUsuarios.setSelectedIndex(0);
	    comboMateriales.setSelectedIndex(0);
	    JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente.");
	}



	private void registrarDevolucion() {
		String id = campoIdDevolucion.getText().trim();

		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(this,
				"Ingresa el ID del préstamo.",
				"Campo vacío", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// buscar prestamo
		Prestamo prestamo = null;
		for (Prestamo p : listaPrestamos) {
			if (p.getId().equalsIgnoreCase(id)) {
				prestamo = p;
				break;
			}
		}

		if (prestamo == null) {
			JOptionPane.showMessageDialog(this,
				"No existe un préstamo con ese ID.",
				"No encontrado", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (prestamo.isDevuelto()) {
			JOptionPane.showMessageDialog(this,
				"Este préstamo ya fue devuelto.",
				"Ya devuelto", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// realizar devolucion
		prestamo.devolver();

		// actualizar estado en la tabla
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			if (modeloTabla.getValueAt(i, 0).toString().equalsIgnoreCase(id)) {
				modeloTabla.setValueAt("Devuelto", i, 6);
				break;
			}
		}

		campoIdDevolucion.setText("");
		JOptionPane.showMessageDialog(this, "Devolución registrada correctamente.");
	}

	private void buscarPrestamo(String filtro) {
	    modeloTabla.setRowCount(0);

	    // Si el campo está vacío, muestra todos
	    if (filtro.isEmpty()) {
	        for (Prestamo p : listaPrestamos) {
	            modeloTabla.addRow(new Object[]{
	                p.getId(),
	                p.getUsuario().getCarnet(),
	                p.getUsuario().getNombre() + " " + p.getUsuario().getApellido(),
	                p.getMaterial().getCodigo(),
	                p.getMaterial().getTitulo(),
	                p.getFechaPrestamo(),
	                p.isDevuelto() ? "Devuelto" : "Activo"
	            });
	        }
	        return;
	    }

	    boolean encontro = false;

	    for (Prestamo p : listaPrestamos) {
	        if (p.getId().toLowerCase().contains(filtro)
	                || p.getUsuario().getCarnet().toLowerCase().contains(filtro)
	                || p.getMaterial().getCodigo().toLowerCase().contains(filtro)) {
	            modeloTabla.addRow(new Object[]{
	                p.getId(),
	                p.getUsuario().getCarnet(),
	                p.getUsuario().getNombre() + " " + p.getUsuario().getApellido(),
	                p.getMaterial().getCodigo(),
	                p.getMaterial().getTitulo(),
	                p.getFechaPrestamo(),
	                p.isDevuelto() ? "Devuelto" : "Activo"
	            });
	            encontro = true;
	        }
	    }

	    if (!encontro) {
	        JOptionPane.showMessageDialog(this,
	                "No se encontraron coincidencias para: \"" + filtro + "\"",
	                "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
}