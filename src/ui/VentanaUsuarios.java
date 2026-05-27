package ui;

import dominio.Estudiante;

import dominio.Docente;
import dominio.Usuario;
import dominio.Prestamo;
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


public class VentanaUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenido;
	

	private List<Usuario> usuarios;
	private List<Prestamo> listaPrestamos;

	// campos del formulario
	JComboBox<String> comboCarrera;
	JComboBox<String> comboSemestre;

	JLabel lblCarrera;
	JLabel lblSemestre;

	
	JTextField campoCarnet;
	JTextField campoNombre;
	JTextField campoApellido;
	JTextField campoTelefono;
	JTextField campoCorreo;
	JComboBox<String> comboRol;
	


	
	// tabla

	JTable tablaUsuarios;
	DefaultTableModel modeloTabla;

	public VentanaUsuarios(List<Usuario> usuarios,
            List<Prestamo> listaPrestamos) {

this.usuarios = usuarios;
this.listaPrestamos = listaPrestamos;
		
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 760);
		setLocationRelativeTo(null);
		
		contenido = new JPanel();
		contenido.setBackground(new Color(10, 12, 16));
		contenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenido);
		contenido.setLayout(null);
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(14, 17, 24));
		panelCabecera.setBounds(0, 0, 2000, 65);
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
		
		JLabel lblTitulo = new JLabel("GESTIÓN DE USUARIOS");
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
		botonVolver.setBounds(1100, 18, 200, 28);
		panelCabecera.add(botonVolver);
		
		botonVolver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(new Color(18, 22, 30));

		panelFormulario.setBounds(10, 78, 300, 620);

		contenido.add(panelFormulario);
		panelFormulario.setLayout(null);
		
		JPanel barraVerde = new JPanel();
		barraVerde.setBackground(new Color(52, 199, 160));
		barraVerde.setBounds(0, 0, 300, 4);
		panelFormulario.add(barraVerde);
		
		JLabel lblRegistrar = new JLabel("Registrar Usuario");
		lblRegistrar.setForeground(new Color(243, 244, 246));
		lblRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRegistrar.setBounds(15, 14, 200, 22);
		panelFormulario.add(lblRegistrar);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(new Color(110, 118, 135));
		lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblRol.setBounds(15, 44, 100, 16);
		panelFormulario.add(lblRol);
		
		comboRol = new JComboBox<>();
		comboRol.addItem("Estudiante");
		comboRol.addItem("Docente");
		comboRol.setBackground(new Color(10, 12, 16));
		comboRol.setForeground(new Color(243, 244, 246));
		comboRol.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboRol.setBounds(15, 61, 270, 26);
		panelFormulario.add(comboRol);
		

		JLabel lblCarnet = new JLabel("Carnet");
		comboRol.addActionListener(e -> {

			

			    String rol = comboRol.getSelectedItem().toString();

			    if (rol.equals("Estudiante")) {

			        lblCarrera.setText("Carrera");
			        lblSemestre.setVisible(true);
			        comboSemestre.setVisible(true);

			    } else {

			        lblCarrera.setText("Departamento");

			        lblSemestre.setVisible(false);
			        comboSemestre.setVisible(false);
			    }
			});
		
		
		
		// carnet
		

		lblCarnet.setForeground(new Color(110, 118, 135));
		lblCarnet.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCarnet.setBounds(15, 100, 100, 16);
		panelFormulario.add(lblCarnet);
		
		campoCarnet = new JTextField();
		campoCarnet.setBackground(new Color(10, 12, 16));
		campoCarnet.setForeground(new Color(243, 244, 246));
		campoCarnet.setCaretColor(Color.WHITE);
		campoCarnet.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCarnet.setBounds(15, 117, 270, 26);
		panelFormulario.add(campoCarnet);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(110, 118, 135));
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNombre.setBounds(15, 156, 100, 16);
		panelFormulario.add(lblNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(new Color(10, 12, 16));
		campoNombre.setForeground(new Color(243, 244, 246));
		campoNombre.setCaretColor(Color.WHITE);
		campoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoNombre.setBounds(15, 173, 270, 26);
		panelFormulario.add(campoNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(110, 118, 135));
		lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblApellido.setBounds(15, 212, 100, 16);
		panelFormulario.add(lblApellido);

		campoApellido = new JTextField();
		campoApellido.setBackground(new Color(10, 12, 16));
		campoApellido.setForeground(new Color(243, 244, 246));
		campoApellido.setCaretColor(Color.WHITE);
		campoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoApellido.setBounds(15, 229, 270, 26);
		panelFormulario.add(campoApellido);

		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setForeground(new Color(110, 118, 135));
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblTelefono.setBounds(15, 268, 100, 16);
		panelFormulario.add(lblTelefono);

		campoTelefono = new JTextField();
		campoTelefono.setBackground(new Color(10, 12, 16));
		campoTelefono.setForeground(new Color(243, 244, 246));
		campoTelefono.setCaretColor(Color.WHITE);
		campoTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoTelefono.setBounds(15, 285, 270, 26);
		panelFormulario.add(campoTelefono);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(new Color(110, 118, 135));
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCorreo.setBounds(15, 324, 100, 16);
		panelFormulario.add(lblCorreo);

		campoCorreo = new JTextField();
		campoCorreo.setBackground(new Color(10, 12, 16));
		campoCorreo.setForeground(new Color(243, 244, 246));
		campoCorreo.setCaretColor(Color.WHITE);
		campoCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCorreo.setBounds(15, 341, 270, 26);
		panelFormulario.add(campoCorreo);


		JButton botonAgregar = new JButton("AGREGAR");

		
		
		lblCarrera = new JLabel("Carrera");
		lblCarrera .setForeground(new Color(110, 118, 135));
		lblCarrera .setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCarrera.setBounds(15, 385, 120, 16);
		panelFormulario.add(lblCarrera );

		String[] carreras = {
				"Ingeniería en Sistemas",
			    "Ingeniería Civil",
			    "Ingeniería Industrial",
			    "Medicina",
			    "Derecho",
			    "Arquitectura",
			    "Administración de Empresas",
			    "Contaduría Pública",
			    "Psicología",
			    "Diseño Gráfico"
			    
			};

			comboCarrera = new JComboBox<>(carreras);
			comboCarrera.setBackground(new Color(10, 12, 16));
			comboCarrera.setForeground(new Color(243, 244, 246));
			comboCarrera.setBounds(15, 402, 270, 28);
			panelFormulario.add(comboCarrera);

		
		lblSemestre = new JLabel("Semestre");
		lblSemestre.setForeground(new Color(110, 118, 135));
		lblSemestre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblSemestre.setBounds(15, 445, 120, 16);
		panelFormulario.add(lblSemestre);

		String[] semestres = {
			    "1","2","3","4","5","6","7","8","9","10"
			};

			comboSemestre = new JComboBox<>(semestres);
			comboSemestre.setBackground(new Color(10, 12, 16));
			comboSemestre.setForeground(new Color(243, 244, 246));
			comboSemestre.setBounds(15, 462, 270, 28);
			panelFormulario.add(comboSemestre);
		
		
		botonAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAgregar.setForeground(Color.WHITE);
		botonAgregar.setBackground(new Color(52, 199, 160));
		botonAgregar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonAgregar.setFocusPainted(false);
		botonAgregar.setBorderPainted(false);

		// BOTON AGREGAR
		botonAgregar.setBounds(15, 530, 130, 40);
		panelFormulario.add(botonAgregar);

		// BOTON LIMPIAR
		JButton botonLimpiar = new JButton("LIMPIAR");
		botonLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonLimpiar.setForeground(Color.WHITE);
		botonLimpiar.setBackground(new Color(52, 199, 160));
		botonLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonLimpiar.setFocusPainted(false);
		botonLimpiar.setBorderPainted(false);
		botonLimpiar.setBounds(155, 530, 130, 40);

		panelFormulario.add(botonLimpiar);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(18, 22, 30));
		panelTabla.setBounds(322, 78, 900, 620);

		contenido.add(panelTabla);
		panelTabla.setLayout(null);
		
		JPanel barraVerde2 = new JPanel();
		barraVerde2.setBackground(new Color(52, 199, 160));
		barraVerde2.setBounds(0, 0, 900, 4);
		panelTabla.add(barraVerde2);
		
		JLabel lblLista = new JLabel("Lista de usuarios");
		lblLista.setForeground(new Color(243, 244, 246));
		lblLista.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLista.setBounds(15, 16, 260, 22);
		panelTabla.add(lblLista);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(new Color(110, 118, 135));
		lblBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblBuscar.setBounds(45, 55, 100, 25);

		panelTabla.add(lblBuscar);
		
		JTextField campoBuscar = new JTextField();
		campoBuscar.setBackground(new Color(10, 12, 16));
		campoBuscar.setForeground(new Color(243, 244, 246));
		campoBuscar.setCaretColor(Color.WHITE);
		campoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoBuscar.setBounds(100, 52, 580, 32);
		panelTabla.add(campoBuscar);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setBackground(new Color(52, 199, 160));
		botonBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botonBuscar.setFocusPainted(false);
		botonBuscar.setBorderPainted(false);
		botonBuscar.setBounds(700, 52, 180, 32);
		panelTabla.add(botonBuscar);
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Carnet");
		modeloTabla.addColumn("Rol");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellido");
		modeloTabla.addColumn("Teléfono");
		modeloTabla.addColumn("Correo");
		modeloTabla.addColumn("Carrera/Departamento");
		modeloTabla.addColumn("Semestre");
		modeloTabla.addColumn("Préstamo Activo");
		
		tablaUsuarios = new JTable(modeloTabla) {
			public boolean isCellEditable(int row, int col) { return false; }
		};
		tablaUsuarios.setBackground(new Color(10, 12, 16));
		tablaUsuarios.setForeground(new Color(200, 204, 212));
		tablaUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaUsuarios.setRowHeight(26);
		tablaUsuarios.setGridColor(new Color(28, 34, 46));
		tablaUsuarios.setSelectionBackground(new Color(52, 199, 160));
		tablaUsuarios.getTableHeader().setBackground(new Color(18, 22, 30));
		tablaUsuarios.getTableHeader().setForeground(new Color(110, 118, 135));
		tablaUsuarios.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
		tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(85);  
		tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(80);  
		tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(100); 
		tablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100); 
		tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(90);  
		tablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(100); 
		tablaUsuarios.getColumnModel().getColumn(6).setPreferredWidth(140); 
		tablaUsuarios.getColumnModel().getColumn(7).setPreferredWidth(80); 
		tablaUsuarios.getColumnModel().getColumn(8).setPreferredWidth(110); 
		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		scroll.getViewport().setBackground(new Color(10, 12, 16));
		scroll.setBorder(null);
		scroll.setBounds(15, 105, 885, 450);
		panelTabla.add(scroll);

		botonAgregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				registrarUsuario();
			}
		});

		botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				campoCarnet.setText("");
				campoNombre.setText("");
				campoApellido.setText("");
				campoTelefono.setText("");
				campoCorreo.setText("");
				comboRol.setSelectedIndex(0);
				comboCarrera.setSelectedIndex(0);
				comboSemestre.setSelectedIndex(0);
			}
		});

		botonBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				buscarUsuario(campoBuscar.getText().trim().toLowerCase());
			}
			
		});
		modeloTabla.setRowCount(0);
		for (Usuario u : usuarios) {
		    agregarFilaTabla(u);
		}
	}
	
	

	private void registrarUsuario() {
		try {
			String carnet = campoCarnet.getText().trim();
			String nombre = campoNombre.getText().trim();
			String apellido = campoApellido.getText().trim();
			String telefono = campoTelefono.getText().trim();
			String correo = campoCorreo.getText().trim();
			String rol = comboRol.getSelectedItem().toString();

			if(carnet.isEmpty() ||
			   nombre.isEmpty() ||
			   apellido.isEmpty() ||
			   telefono.isEmpty() ||
			   correo.isEmpty() ||
			   comboCarrera.getSelectedItem() == null ||
			    (rol.equals("Estudiante") &&
			     comboSemestre.getSelectedItem() == null)) {
			    JOptionPane.showMessageDialog(
			        this,
			        "Todos los campos son obligatorios",
			        "Error",
			        JOptionPane.ERROR_MESSAGE
			    );

			    return;
			}
			
			for (Usuario u : usuarios) {
				if (u.getCarnet().equalsIgnoreCase(carnet)) {
					JOptionPane.showMessageDialog(this,
						"Ya existe un usuario con ese carnet.",
						"Carnet duplicado", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

			Usuario nuevo;

			if (rol.equals("Estudiante")) {

				String carrera = comboCarrera.getSelectedItem().toString();

				int semestre = Integer.parseInt(comboSemestre.getSelectedItem().toString());
				
			    

			    nuevo = new Estudiante(
			    	    nombre,
			    	    apellido,
			    	    carnet,
			    	    telefono,
			    	    correo,
			    	    carrera,
			    	    semestre
			    	
			    );

			} else {

				String departamento = comboCarrera.getSelectedItem().toString();

			    nuevo = new Docente(
			    	    nombre,
			    	    apellido,
			    	    carnet,
			    	    telefono,
			    	    correo,
			    	    departamento
			    	
			    );
			}

			usuarios.add(nuevo);
			agregarFilaTabla(nuevo);

			campoCarnet.setText("");
			campoNombre.setText("");
			campoApellido.setText("");
			campoTelefono.setText("");
			campoCorreo.setText("");
			comboRol.setSelectedIndex(0);

			JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");

		} catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(this,
				ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void agregarFilaTabla(Usuario u) {

	    String rol;

	    if (u instanceof Estudiante) {
	        rol = "Estudiante";
	    } else {
	        rol = "Docente";
	    }

	    String carreraDepartamento = "";
	    String semestre = "";

	    if (u instanceof Estudiante) {

	        Estudiante est = (Estudiante) u;

	        carreraDepartamento = est.getCarrera();
	        semestre = String.valueOf(est.getSemestre());

	    } else if (u instanceof Docente) {

	        Docente doc = (Docente) u;

	        carreraDepartamento = doc.getDepartamento();
	    }

	    String prestamoActivo = "No";

	    for (Prestamo p : listaPrestamos) {

	        if (p.getUsuario().getCarnet()
	                .equalsIgnoreCase(u.getCarnet())
	                && !p.isDevuelto()) {

	            prestamoActivo = "Sí";
	            break;
	        }
	    }

	    modeloTabla.addRow(new Object[]{
	        u.getCarnet(),
	        rol,
	        u.getNombre(),
	        u.getApellido(),
	        u.getTelefono(),
	        u.getCorreo(),
	        carreraDepartamento,
	        semestre,
	        prestamoActivo
	    });
	}

	public void actualizarTabla() {

	    modeloTabla.setRowCount(0);

	    for (Usuario u : usuarios) {
	        agregarFilaTabla(u);
	    }
	}
	private void buscarUsuario(String filtro) {
	    modeloTabla.setRowCount(0);

	    // Si el campo está vacío, muestra todos
	    if (filtro.isEmpty()) {
	        for (Usuario u : usuarios) agregarFilaTabla(u);
	        return;
	    }

	    boolean encontro = false;

	    for (Usuario u : usuarios) {
	        if (u.getCarnet().toLowerCase().contains(filtro)
	                || u.getNombre().toLowerCase().contains(filtro)
	                || u.getApellido().toLowerCase().contains(filtro)) {
	            agregarFilaTabla(u);
	            encontro = true;
	        }
	    }

	    if (!encontro) {
	        JOptionPane.showMessageDialog(this,
	                "No se encontraron coincidencias para: \"" + filtro + "\"",
	                "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	private boolean tienePrestamoActivo(Usuario usuario) {

	    for (Prestamo p : listaPrestamos) {
	        boolean mismoUsuario =
	                p.getUsuario().getCarnet()
	                .trim()
	                .equalsIgnoreCase(usuario.getCarnet().trim());

	        // préstamo activo
	        boolean activo = !p.isDevuelto();

	        if (mismoUsuario && activo) {
	            return true;
	        }
	    }

	    return false;
	}
}