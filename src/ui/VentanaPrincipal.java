package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import dominio.Material;
import dominio.Usuario;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private List<Material> materiales = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setTitle("Sistema de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 12, 16));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// CABECERA
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(14, 17, 24));
		panelCabecera.setBounds(0, 0, 1000, 80);
		contentPane.add(panelCabecera);
		panelCabecera.setLayout(null);

		JLabel lblTitulo = new JLabel("SISTEMA DE BIBLIOTECA");
		lblTitulo.setForeground(new Color(243, 244, 246));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblTitulo.setBounds(20, 21, 420, 38);
		panelCabecera.add(lblTitulo);

		// TARJETA 1 - MATERIALES
		JPanel tarjeta1 = new JPanel();
		tarjeta1.setBackground(new Color(18, 22, 30));
		tarjeta1.setBounds(100, 140, 230, 310);
		contentPane.add(tarjeta1);
		tarjeta1.setLayout(null);

		JPanel barra1 = new JPanel();
		barra1.setBackground(new Color(99, 130, 255));
		barra1.setBounds(0, 0, 230, 4);
		tarjeta1.add(barra1);

		JLabel icono1 = new JLabel("M");
		icono1.setOpaque(true);
		icono1.setBackground(new Color(99, 130, 255));
		icono1.setForeground(Color.WHITE);
		icono1.setFont(new Font("Segoe UI", Font.BOLD, 50));
		icono1.setHorizontalAlignment(SwingConstants.CENTER);
		icono1.setBounds(65, 34, 100, 100);
		tarjeta1.add(icono1);

		JLabel tituloMateriales = new JLabel("MATERIALES");
		tituloMateriales.setForeground(new Color(243, 244, 246));
		tituloMateriales.setFont(new Font("Segoe UI", Font.BOLD, 16));
		tituloMateriales.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMateriales.setBounds(10, 148, 210, 26);
		tarjeta1.add(tituloMateriales);

		JLabel descripcionMateriales = new JLabel("<html><center>Gestiona el catalogo de libros y materiales</center></html>");
		descripcionMateriales.setForeground(new Color(110, 118, 135));
		descripcionMateriales.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		descripcionMateriales.setHorizontalAlignment(SwingConstants.CENTER);
		descripcionMateriales.setBounds(10, 178, 210, 40);
		tarjeta1.add(descripcionMateriales);

		JButton botonMateriales = new JButton("ACCEDER");
		botonMateriales.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonMateriales.setForeground(Color.WHITE);
		botonMateriales.setBackground(new Color(99, 130, 255));
		botonMateriales.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonMateriales.setFocusPainted(false);
		botonMateriales.setBorderPainted(false);
		botonMateriales.setBounds(30, 256, 170, 38);
		tarjeta1.add(botonMateriales);

		// TARJETA 2 - USUARIOS
		JPanel tarjeta2 = new JPanel();
		tarjeta2.setBackground(new Color(18, 22, 30));
		tarjeta2.setBounds(385, 140, 230, 310);
		contentPane.add(tarjeta2);
		tarjeta2.setLayout(null);

		JPanel barra2 = new JPanel();
		barra2.setBackground(new Color(52, 199, 160));
		barra2.setBounds(0, 0, 230, 4);
		tarjeta2.add(barra2);

		JLabel icono2 = new JLabel("U");
		icono2.setOpaque(true);
		icono2.setBackground(new Color(52, 199, 160));
		icono2.setForeground(Color.WHITE);
		icono2.setFont(new Font("Segoe UI", Font.BOLD, 50));
		icono2.setHorizontalAlignment(SwingConstants.CENTER);
		icono2.setBounds(65, 34, 100, 100);
		tarjeta2.add(icono2);

		JLabel tituloUsuarios = new JLabel("USUARIOS");
		tituloUsuarios.setForeground(new Color(243, 244, 246));
		tituloUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 16));
		tituloUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		tituloUsuarios.setBounds(10, 148, 210, 26);
		tarjeta2.add(tituloUsuarios);

		JLabel descripcionUsuarios = new JLabel("<html><center>Administra estudiantes y docentes del sistema</center></html>");
		descripcionUsuarios.setForeground(new Color(110, 118, 135));
		descripcionUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		descripcionUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		descripcionUsuarios.setBounds(10, 178, 210, 40);
		tarjeta2.add(descripcionUsuarios);

		JButton botonUsuarios = new JButton("ACCEDER");
		botonUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonUsuarios.setForeground(Color.WHITE);
		botonUsuarios.setBackground(new Color(52, 199, 160));
		botonUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonUsuarios.setFocusPainted(false);
		botonUsuarios.setBorderPainted(false);
		botonUsuarios.setBounds(30, 256, 170, 38);
		tarjeta2.add(botonUsuarios);

		// TARJETA 3 - PRESTAMOS
		JPanel tarjeta3 = new JPanel();
		tarjeta3.setBackground(new Color(18, 22, 30));
		tarjeta3.setBounds(670, 140, 230, 310);
		contentPane.add(tarjeta3);
		tarjeta3.setLayout(null);

		JPanel barra3 = new JPanel();
		barra3.setBackground(new Color(255, 168, 77));
		barra3.setBounds(0, 0, 230, 4);
		tarjeta3.add(barra3);

		JLabel icono3 = new JLabel("P");
		icono3.setOpaque(true);
		icono3.setBackground(new Color(255, 168, 77));
		icono3.setForeground(Color.WHITE);
		icono3.setFont(new Font("Segoe UI", Font.BOLD, 50));
		icono3.setHorizontalAlignment(SwingConstants.CENTER);
		icono3.setBounds(65, 34, 100, 100);
		tarjeta3.add(icono3);

		JLabel tituloPrestamos = new JLabel("PRESTAMOS");
		tituloPrestamos.setForeground(new Color(243, 244, 246));
		tituloPrestamos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		tituloPrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPrestamos.setBounds(10, 148, 210, 26);
		tarjeta3.add(tituloPrestamos);

		JLabel descripcionPrestamos = new JLabel("<html><center>Registra prestamos y devoluciones</center></html>");
		descripcionPrestamos.setForeground(new Color(110, 118, 135));
		descripcionPrestamos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		descripcionPrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		descripcionPrestamos.setBounds(10, 178, 210, 40);
		tarjeta3.add(descripcionPrestamos);

		JButton botonPrestamos = new JButton("ACCEDER");
		botonPrestamos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonPrestamos.setForeground(Color.WHITE);
		botonPrestamos.setBackground(new Color(255, 168, 77));
		botonPrestamos.setFont(new Font("Segoe UI", Font.BOLD, 13));
		botonPrestamos.setFocusPainted(false);
		botonPrestamos.setBorderPainted(false);
		botonPrestamos.setBounds(30, 256, 170, 38);
		tarjeta3.add(botonPrestamos);

		// FUNCIONALIDADES ORIGINALES (listas compartidas entre ventanas)
		botonMateriales.addActionListener(e -> {
			new VentanaMateriales(materiales).setVisible(true);
		});

		botonUsuarios.addActionListener(e -> {
			new VentanaUsuarios(usuarios).setVisible(true);
		});

		botonPrestamos.addActionListener(e -> {
			new VentanaPrestamos(materiales, usuarios).setVisible(true);
		});
	}
}