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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;

public class VentanaPrestamos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenido;
	
	// campos prestamo
	JTextField campoCarnetPrestamo;
	JTextField campoCodigoPrestamo;
	
	// campo devolucion
	JTextField campoIdDevolucion;
	
	// tabla
	JTable tablaPrestamos;
	DefaultTableModel modeloTabla;

	public VentanaPrestamos() {
		
		setTitle("Prestamos y Devoluciones");
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
		
		JLabel lblTitulo = new JLabel("PRESTAMOS Y DEVOLUCIONES");
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
		
		// panel izquierdo - formulario prestamo
		JPanel panelPrestamo = new JPanel();
		panelPrestamo.setBackground(new Color(18, 22, 30));
		panelPrestamo.setBounds(10, 78, 300, 222);
		contenido.add(panelPrestamo);
		panelPrestamo.setLayout(null);
		
		JPanel barraAmbar = new JPanel();
		barraAmbar.setBackground(new Color(255, 168, 77));
		barraAmbar.setBounds(0, 0, 300, 4);
		panelPrestamo.add(barraAmbar);
		
		JLabel lblNuevoPrestamo = new JLabel("Nuevo Prestamo");
		lblNuevoPrestamo.setForeground(new Color(243, 244, 246));
		lblNuevoPrestamo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNuevoPrestamo.setBounds(15, 18, 200, 22);
		panelPrestamo.add(lblNuevoPrestamo);
		
		JLabel lblCarnet = new JLabel("Carnet del usuario ");
		lblCarnet.setForeground(new Color(110, 118, 135));
		lblCarnet.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCarnet.setBounds(15, 54, 180, 16);
		panelPrestamo.add(lblCarnet);
		
		campoCarnetPrestamo = new JTextField();
		campoCarnetPrestamo.setBackground(new Color(10, 12, 16));
		campoCarnetPrestamo.setForeground(new Color(243, 244, 246));
		campoCarnetPrestamo.setCaretColor(Color.WHITE);
		campoCarnetPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCarnetPrestamo.setBounds(15, 72, 270, 28);
		panelPrestamo.add(campoCarnetPrestamo);
		
		JLabel lblCodigo = new JLabel("Codigo del material ");
		lblCodigo.setForeground(new Color(110, 118, 135));
		lblCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCodigo.setBounds(15, 114, 180, 16);
		panelPrestamo.add(lblCodigo);
		
		campoCodigoPrestamo = new JTextField();
		campoCodigoPrestamo.setBackground(new Color(10, 12, 16));
		campoCodigoPrestamo.setForeground(new Color(243, 244, 246));
		campoCodigoPrestamo.setCaretColor(Color.WHITE);
		campoCodigoPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoCodigoPrestamo.setBounds(15, 132, 270, 28);
		panelPrestamo.add(campoCodigoPrestamo);
		
		JButton botonPrestar = new JButton("PRESTAR");
		botonPrestar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonPrestar.setForeground(Color.WHITE);
		botonPrestar.setBackground(new Color(255, 168, 77));
		botonPrestar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonPrestar.setFocusPainted(false);
		botonPrestar.setBorderPainted(false);
		botonPrestar.setBounds(15, 176, 270, 36);
		panelPrestamo.add(botonPrestar);
		
		// panel izquierdo - formulario devolucion
		JPanel panelDevolucion = new JPanel();
		panelDevolucion.setBackground(new Color(18, 22, 30));
		panelDevolucion.setBounds(10, 312, 300, 150);
		contenido.add(panelDevolucion);
		panelDevolucion.setLayout(null);
		
		JPanel barraAmbar2 = new JPanel();
		barraAmbar2.setBackground(new Color(255, 168, 77));
		barraAmbar2.setBounds(0, 0, 300, 4);
		panelDevolucion.add(barraAmbar2);
		
		JLabel lblDevolucion = new JLabel("Registrar Devolucion");
		lblDevolucion.setForeground(new Color(243, 244, 246));
		lblDevolucion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDevolucion.setBounds(15, 18, 200, 22);
		panelDevolucion.add(lblDevolucion);
		
		JLabel lblIdPrestamo = new JLabel("ID del prestamo ");
		lblIdPrestamo.setForeground(new Color(110, 118, 135));
		lblIdPrestamo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblIdPrestamo.setBounds(15, 54, 180, 16);
		panelDevolucion.add(lblIdPrestamo);
		
		campoIdDevolucion = new JTextField();
		campoIdDevolucion.setBackground(new Color(10, 12, 16));
		campoIdDevolucion.setForeground(new Color(243, 244, 246));
		campoIdDevolucion.setCaretColor(Color.WHITE);
		campoIdDevolucion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		campoIdDevolucion.setBounds(15, 72, 270, 28);
		panelDevolucion.add(campoIdDevolucion);
		
		JButton botonDevolver = new JButton("DEVOLVER");
		botonDevolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonDevolver.setForeground(new Color(255, 255, 255));
		botonDevolver.setBackground(new Color(255, 168, 77));
		botonDevolver.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonDevolver.setFocusPainted(false);
		botonDevolver.setBorderPainted(false);
		botonDevolver.setBounds(15, 110, 270, 32);
		panelDevolucion.add(botonDevolver);
		
		// panel tabla derecho
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(18, 22, 30));
		panelTabla.setBounds(322, 78, 660, 480);
		contenido.add(panelTabla);
		panelTabla.setLayout(null);
		
		JPanel barraAmbar3 = new JPanel();
		barraAmbar3.setBackground(new Color(255, 168, 77));
		barraAmbar3.setBounds(0, 0, 660, 4);
		panelTabla.add(barraAmbar3);
		
		JLabel lblLista = new JLabel("Historial de prestamos");
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
		modeloTabla.addColumn("Codigo material");
		modeloTabla.addColumn("Fecha prestamo");
		modeloTabla.addColumn("Estado");
		
		tablaPrestamos = new JTable(modeloTabla);
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
		scroll.setBounds(15, 90, 630, 370);
		panelTabla.add(scroll);
		
	}
}