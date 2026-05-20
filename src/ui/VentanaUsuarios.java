package ui;

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
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;

public class VentanaUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenido;
	
	// campos del formulario
	JTextField campoCarnet;
	JTextField campoNombre;
	JComboBox<String> comboRol;
	
	// tabla
	JTable tablaUsuarios;
	DefaultTableModel modeloTabla;

	public VentanaUsuarios() {
		
		setTitle("Usuarios");
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
		
		JLabel insignia = new JLabel("U");
		insignia.setOpaque(true);
		insignia.setBackground(new Color(52, 199, 160));
		insignia.setForeground(Color.WHITE);
		insignia.setFont(new Font("Segoe UI", Font.BOLD, 22));
		insignia.setHorizontalAlignment(SwingConstants.CENTER);
		insignia.setBounds(18, 14, 36, 36);
		panelCabecera.add(insignia);
		
		JLabel lblTitulo = new JLabel("GESTION DE USUARIOS");
		lblTitulo.setForeground(new Color(243, 244, 246));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setBounds(68, 18, 360, 28);
		panelCabecera.add(lblTitulo);
		
		JButton botonVolver = new JButton("< Volver");
		botonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVolver.setForeground(new Color(52, 199, 160));
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
		panelFormulario.setBounds(10, 78, 300, 480);
		contenido.add(panelFormulario);
		panelFormulario.setLayout(null);
		
		JPanel barraVerde = new JPanel();
		barraVerde.setBackground(new Color(52, 199, 160));
		barraVerde.setBounds(0, 0, 300, 4);
		panelFormulario.add(barraVerde);
		
		JLabel lblRegistrar = new JLabel("Registrar Usuario");
		lblRegistrar.setForeground(new Color(243, 244, 246));
		lblRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRegistrar.setBounds(15, 18, 200, 22);
		panelFormulario.add(lblRegistrar);
		
		// rol
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(new Color(110, 118, 135));
		lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblRol.setBounds(15, 54, 100, 16);
		panelFormulario.add(lblRol);
		
		comboRol = new JComboBox<>();
		comboRol.addItem("Estudiante");
		comboRol.addItem("Docente");
		comboRol.setBackground(new Color(10, 12, 16));
		comboRol.setForeground(new Color(243, 244, 246));
		comboRol.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboRol.setBounds(15, 72, 270, 28);
		panelFormulario.add(comboRol);
		
		// carnet
		JLabel lblCarnet = new JLabel("Carnet ");
		lblCarnet.setForeground(new Color(110, 118, 135));
		lblCarnet.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCarnet.setBounds(15, 114, 100, 16);
		panelFormulario.add(lblCarnet);
		
		campoCarnet = new JTextField();
		campoCarnet.setBackground(new Color(10, 12, 16));
		campoCarnet.setForeground(new Color(243, 244, 246));
		campoCarnet.setCaretColor(Color.WHITE);
		campoCarnet.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCarnet.setBounds(15, 132, 270, 28);
		panelFormulario.add(campoCarnet);
		
		// nombre
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setForeground(new Color(110, 118, 135));
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNombre.setBounds(15, 174, 100, 16);
		panelFormulario.add(lblNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(new Color(10, 12, 16));
		campoNombre.setForeground(new Color(243, 244, 246));
		campoNombre.setCaretColor(Color.WHITE);
		campoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoNombre.setBounds(15, 192, 270, 28);
		panelFormulario.add(campoNombre);
		// apellido
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(110, 118, 135));
		lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblApellido.setBounds(15, 234, 100, 16);
		panelFormulario.add(lblApellido);

		JTextField campoApellido = new JTextField();
		campoApellido.setBackground(new Color(10, 12, 16));
		campoApellido.setForeground(new Color(243, 244, 246));
		campoApellido.setCaretColor(Color.WHITE);
		campoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoApellido.setBounds(15, 252, 270, 28);
		panelFormulario.add(campoApellido);

		// telefono
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(110, 118, 135));
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblTelefono.setBounds(15, 294, 100, 16);
		panelFormulario.add(lblTelefono);

		JTextField campoTelefono = new JTextField();
		campoTelefono.setBackground(new Color(10, 12, 16));
		campoTelefono.setForeground(new Color(243, 244, 246));
		campoTelefono.setCaretColor(Color.WHITE);
		campoTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoTelefono.setBounds(15, 312, 270, 28);
		panelFormulario.add(campoTelefono);

		// correo
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(new Color(110, 118, 135));
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCorreo.setBounds(15, 354, 100, 16);
		panelFormulario.add(lblCorreo);

		JTextField campoCorreo = new JTextField();
		campoCorreo.setBackground(new Color(10, 12, 16));
		campoCorreo.setForeground(new Color(243, 244, 246));
		campoCorreo.setCaretColor(Color.WHITE);
		campoCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCorreo.setBounds(15, 372, 270, 28);
		panelFormulario.add(campoCorreo);
		
		JButton botonAgregar = new JButton("AGREGAR");
		botonAgregar.addActionListener(e -> {

		    String carnet = campoCarnet.getText();
		    String nombre = campoNombre.getText();
		    String apellido = campoApellido.getText();
		    String telefono = campoTelefono.getText();
		    String correo = campoCorreo.getText();

		   String rol = comboRol.getSelectedItem().toString();

		   modeloTabla.addRow(new Object[] {
				    carnet,
				    rol,
				    nombre,
				    apellido,
				    telefono,
				    correo,
				    0
				});

		    // Limpiar campos
		    campoCarnet.setText("");
		    campoNombre.setText("");
		    comboRol.setSelectedIndex(0);
		    campoApellido.setText("");
		    campoTelefono.setText("");
		    campoCorreo.setText("");
		});
		
		botonAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAgregar.setForeground(Color.WHITE);
		botonAgregar.setBackground(new Color(52, 199, 160));
		botonAgregar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonAgregar.setFocusPainted(false);
		botonAgregar.setBorderPainted(false);
		botonAgregar.setBounds(15, 430, 270, 36);
		panelFormulario.add(botonAgregar);
		
		// panel tabla derecho
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(18, 22, 30));
		panelTabla.setBounds(322, 78, 660, 480);
		contenido.add(panelTabla);
		panelTabla.setLayout(null);
		
		JPanel barraVerde2 = new JPanel();
		barraVerde2.setBackground(new Color(52, 199, 160));
		barraVerde2.setBounds(0, 0, 660, 4);
		panelTabla.add(barraVerde2);
		
		JLabel lblLista = new JLabel("Lista de usuarios");
		lblLista.setForeground(new Color(243, 244, 246));
		lblLista.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLista.setBounds(15, 16, 260, 22);
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
		botonBuscar.setBackground(new Color(52, 199, 160));
		botonBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botonBuscar.setFocusPainted(false);
		botonBuscar.setBorderPainted(false);
		botonBuscar.setBounds(515, 50, 130, 26);
		panelTabla.add(botonBuscar);
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Carnet");
		modeloTabla.addColumn("Rol");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellido");
		modeloTabla.addColumn("Telefono");
		modeloTabla.addColumn("Correo");
		modeloTabla.addColumn("Prestamos activos");
		
		tablaUsuarios = new JTable(modeloTabla);
		tablaUsuarios.setBackground(new Color(10, 12, 16));
		tablaUsuarios.setForeground(new Color(200, 204, 212));
		tablaUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaUsuarios.setRowHeight(26);
		tablaUsuarios.setGridColor(new Color(28, 34, 46));
		tablaUsuarios.setSelectionBackground(new Color(52, 199, 160));
		tablaUsuarios.getTableHeader().setBackground(new Color(18, 22, 30));
		tablaUsuarios.getTableHeader().setForeground(new Color(110, 118, 135));
		tablaUsuarios.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		scroll.getViewport().setBackground(new Color(10, 12, 16));
		scroll.setBorder(null);
		scroll.setBounds(15, 90, 630, 370);
		panelTabla.add(scroll);
		
	}
}