package capaVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import capaEntidades.Electrodomesticos;
import capaEntidades.Lavarropas;
import capaEntidades.Television;

import java.awt.Color;

public class Ejecutable extends JFrame {

	/* Declaracion de variables */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/* Constructor Principal */	
	public Ejecutable() {
		
		  
		/*Clase ejecutable  */
		setTitle("ELECTROSYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ejecutable.class.getResource("/imagenes/mini005.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(100, 100, 533, 234);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setMargin(new Insets(2, 2, 2, 2));
		menuBar.setFont(new Font("Verdana", Font.PLAIN, 15));
		menuBar.setBounds(0, 0, 527, 33);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setFont(new Font("Verdana", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			}}
				);		
			
		
		mntmSalir.setFont(new Font("Verdana", Font.PLAIN, 15));
		mnNewMenu.add(mntmSalir);
		
		JMenu mnOpciones = new JMenu("  Opciones");
		mnOpciones.setFont(new Font("Verdana", Font.PLAIN, 18));
		menuBar.add(mnOpciones);
		
		JMenu mnNewMenu_1 = new JMenu("  Agregar ");
		
		mnNewMenu_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		mnOpciones.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("  Lavarropas");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				creaLavarropa();
			
			}});
		mntmNewMenuItem_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmTelevisin1 = new JMenuItem("  Televisi\u00F3n");
		mntmTelevisin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				creaTele();
			
			}});
		
		mntmTelevisin1.setFont(new Font("Verdana", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmTelevisin1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("  Listar");
		mnOpciones.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				creaLista();
				}});
		
		mntmNewMenuItem_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Martin\\Desktop\\fondo-madera-negro.jpg"));
		lblNewLabel.setBounds(0, 11, 517, 195);
		contentPane.add(lblNewLabel);
		
		
	}
	
	
	/* Abre ventana "AGREGAR LAVARROPAS" */
	public void creaLavarropa(){
		new agregarLavarropas(Ejecutable.this,true).setVisible(true);
	}
	
	/* Abre ventana "AGREGAR TELEVISOR" */
	public void creaTele(){
		 new agregarTelevisor(Ejecutable.this,true).setVisible(true);
	}
	
	/* Abre el "LISTADO" */
	public void creaLista(){
		new ListaR(Ejecutable.this,true).setVisible(true);
	}
	
	/* Metodo Principal */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				 Ejecutable frame = new Ejecutable();
				 frame.setVisible(true);
				 frame.setSize(533,239);
			      frame.setLocationRelativeTo(null);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	});
}
}
