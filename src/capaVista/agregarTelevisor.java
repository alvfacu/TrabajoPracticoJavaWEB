package capaVista;

import java.awt.EventQueue;







import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;

import java.awt.Toolkit;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import capaEntidades.Electrodomesticos;
import capaEntidades.Lavarropas;
import capaEntidades.Television;
import capaLogica.Ejecuta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class agregarTelevisor extends JDialog {
	
	/* Declaracion de variables */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t6;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox con;
	float prec;
	float peso;
	char cons;
	float res;
	String col;
	boolean sinto;
	
	/* Primer constructor */
	
	public agregarTelevisor(JFrame hola, boolean modal) {
		
		super(hola,modal);
		setBounds(100, 100, 495, 556);
		this.setLocationRelativeTo(hola);
		setTitle("     Agregar Televisor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(agregarTelevisor.class.getResource("/imagenes/mini005.png")));
				this.setLocationRelativeTo(hola);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBounds(47, 11, 372, 59);
		contentPane.add(layeredPane);
		
		JLabel lblAgregarNuevoTelevisor = new JLabel("Agregar Televisor");
		lblAgregarNuevoTelevisor.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblAgregarNuevoTelevisor.setBounds(62, 11, 427, 37);
		layeredPane.add(lblAgregarNuevoTelevisor);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		layeredPane_1.setBounds(49, 81, 364, 375);
		contentPane.add(layeredPane_1);
		
		JLabel lblNewLabel = new JLabel("Precio Base");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 14, 174, 28);
		layeredPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 72, 99, 28);
		layeredPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consumo");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 123, 145, 33);
		layeredPane_1.add(lblNewLabel_2);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblColor.setBounds(17, 237, 99, 28);
		layeredPane_1.add(lblColor);
		
		JLabel lblNewLabel_4 = new JLabel("Resolucion");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 181, 161, 24);
		layeredPane_1.add(lblNewLabel_4);
		
		JLabel lblSintonizadorTdt = new JLabel("Sintonizador TDT");
		lblSintonizadorTdt.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSintonizadorTdt.setBounds(10, 283, 195, 59);
		layeredPane_1.add(lblSintonizadorTdt);
		
		t1 = new JTextField();
		t1.setFont(new Font("Verdana", Font.PLAIN, 15));
		t1.setBounds(140, 14, 130, 33);
		layeredPane_1.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Verdana", Font.PLAIN, 15));
		t2.setBounds(140, 69, 130, 33);
		layeredPane_1.add(t2);
		t2.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Verdana", Font.PLAIN, 15));
		t4.setBounds(140, 122, 130, 33);
		layeredPane_1.add(t4);
		t4.setColumns(10);
		
		t6 = new JTextField();
		t6.setFont(new Font("Verdana", Font.PLAIN, 15));
		t6.setBounds(140, 182, 130, 28);
		layeredPane_1.add(t6);
		t6.setColumns(10);
		
		
		String[] valores= new String[]{"NEGRO","BLANCO","AZUL","ROJO","GRIS" } ;
		 con = new JComboBox(valores);
		con.setFont(new Font("Verdana", Font.PLAIN, 15));
		con.setBounds(140, 231, 144, 41);
		layeredPane_1.add(con);
		
		ButtonGroup group = new ButtonGroup();
	    
	    JLayeredPane layeredPane_2 = new JLayeredPane();
	    layeredPane_2.setBounds(150, 293, 142, 40);
	    layeredPane_1.add(layeredPane_2);
	    
	    rdbtnNewRadioButton = new JRadioButton("SI");
	    rdbtnNewRadioButton.setBounds(7, 10, 54, 23);
	    layeredPane_2.add(rdbtnNewRadioButton);
	    rdbtnNewRadioButton.setFont(new Font("Verdana", Font.PLAIN, 15));
	    group.add(rdbtnNewRadioButton);
	    
	    rdbtnNewRadioButton_1 = new JRadioButton(" NO");
	    rdbtnNewRadioButton_1.setBounds(69, 10, 67, 23);
	    layeredPane_2.add(rdbtnNewRadioButton_1);
	    rdbtnNewRadioButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    group.add(rdbtnNewRadioButton_1);
	    
	    JLabel label = new JLabel("U$S");
	    label.setFont(new Font("Verdana", Font.PLAIN, 15));
	    label.setBounds(280, 24, 46, 20);
	    layeredPane_1.add(label);
	    
	    JLabel label_1 = new JLabel("Kg");
	    label_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    label_1.setBounds(280, 72, 46, 29);
	    layeredPane_1.add(label_1);
	    
	    
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				carga();
				cerrar();
			}
			}
		);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBounds(36, 467, 129, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_1.setBounds(175, 467, 135, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_2.setBounds(320, 467, 135, 34);
		contentPane.add(btnNewButton_2);
	}
	
	
	

	/**
	 * @wbp.parser.constructor
	 */
	public agregarTelevisor(ListaR hola, boolean modal, Television electroActual) {
	super(hola,modal);
	setBounds(100, 100, 495, 556);
	this.setLocationRelativeTo(hola);
	setTitle("Modificar Televisor");
	setIconImage(Toolkit.getDefaultToolkit().getImage(agregarTelevisor.class.getResource("/imagenes/mini005.png")));
			this.setLocationRelativeTo(hola);

	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.control);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLayeredPane layeredPane = new JLayeredPane();
	layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	layeredPane.setBounds(47, 11, 372, 59);
	contentPane.add(layeredPane);
	
	JLabel lblAgregarNuevoTelevisor = new JLabel("Modificar Televisor");
	lblAgregarNuevoTelevisor.setFont(new Font("Verdana", Font.PLAIN, 24));
	lblAgregarNuevoTelevisor.setBounds(62, 11, 427, 37);
	layeredPane.add(lblAgregarNuevoTelevisor);
	
	JLayeredPane layeredPane_1 = new JLayeredPane();
	layeredPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	layeredPane_1.setBounds(49, 81, 364, 375);
	contentPane.add(layeredPane_1);
	
	JLabel lblNewLabel = new JLabel("Precio Base");
	lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	lblNewLabel.setBounds(10, 14, 174, 28);
	layeredPane_1.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Peso");
	lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(10, 72, 99, 28);
	layeredPane_1.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Consumo");
	lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
	lblNewLabel_2.setBounds(10, 123, 145, 33);
	layeredPane_1.add(lblNewLabel_2);
	
	JLabel lblColor = new JLabel("Color");
	lblColor.setFont(new Font("Verdana", Font.PLAIN, 15));
	lblColor.setBounds(17, 237, 99, 28);
	layeredPane_1.add(lblColor);
	
	JLabel lblNewLabel_4 = new JLabel("Resolucion");
	lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 15));
	lblNewLabel_4.setBounds(10, 181, 161, 24);
	layeredPane_1.add(lblNewLabel_4);
	
	JLabel lblSintonizadorTdt = new JLabel("Sintonizador TDT");
	lblSintonizadorTdt.setFont(new Font("Verdana", Font.PLAIN, 15));
	lblSintonizadorTdt.setBounds(10, 283, 195, 59);
	layeredPane_1.add(lblSintonizadorTdt);
	
	t1 = new JTextField();
	t1.setFont(new Font("Verdana", Font.PLAIN, 15));
	t1.setBounds(140, 14, 130, 33);
	layeredPane_1.add(t1);
	t1.setColumns(10);
	
	t2 = new JTextField();
	t2.setFont(new Font("Verdana", Font.PLAIN, 15));
	t2.setBounds(140, 69, 130, 33);
	layeredPane_1.add(t2);
	t2.setColumns(10);
	
	t4 = new JTextField();
	t4.setFont(new Font("Verdana", Font.PLAIN, 15));
	t4.setBounds(140, 122, 130, 33);
	layeredPane_1.add(t4);
	t4.setColumns(10);
	
	t6 = new JTextField();
	t6.setFont(new Font("Verdana", Font.PLAIN, 15));
	t6.setBounds(140, 182, 130, 28);
	layeredPane_1.add(t6);
	t6.setColumns(10);
	
	
	String[] valores= new String[]{"NEGRO","BLANCO","AZUL","ROJO","GRIS" } ;
	 con = new JComboBox(valores);
	con.setFont(new Font("Verdana", Font.PLAIN, 15));
	con.setBounds(140, 231, 144, 41);
	layeredPane_1.add(con);
	
	ButtonGroup group = new ButtonGroup();
    
    JLayeredPane layeredPane_2 = new JLayeredPane();
    layeredPane_2.setBounds(150, 293, 142, 40);
    layeredPane_1.add(layeredPane_2);
    
    rdbtnNewRadioButton = new JRadioButton("SI");
    rdbtnNewRadioButton.setBounds(7, 10, 54, 23);
    layeredPane_2.add(rdbtnNewRadioButton);
    rdbtnNewRadioButton.setFont(new Font("Verdana", Font.PLAIN, 15));
    group.add(rdbtnNewRadioButton);
    
    rdbtnNewRadioButton_1 = new JRadioButton(" NO");
    rdbtnNewRadioButton_1.setBounds(69, 10, 67, 23);
    layeredPane_2.add(rdbtnNewRadioButton_1);
    rdbtnNewRadioButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
    group.add(rdbtnNewRadioButton_1);
    
    JLabel label = new JLabel("U$S");
    label.setFont(new Font("Verdana", Font.PLAIN, 15));
    label.setBounds(280, 24, 46, 20);
    layeredPane_1.add(label);
    
    JLabel label_1 = new JLabel("Kg");
    label_1.setFont(new Font("Verdana", Font.PLAIN, 15));
    label_1.setBounds(280, 72, 46, 29);
    layeredPane_1.add(label_1);
    
    
	JButton btnNewButton = new JButton("Confirmar");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			carga();
			cerrar();
		}
		}
	);
	btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
	btnNewButton.setBounds(36, 467, 129, 34);
	contentPane.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Cancelar");
	btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
	btnNewButton_1.setBounds(175, 467, 135, 34);
	contentPane.add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("Salir");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	});
	btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 15));
	btnNewButton_2.setBounds(320, 467, 135, 34);
	contentPane.add(btnNewButton_2);
	seteaValores(electroActual);
	
	}

	
	
	
	/* Setea los valores que le pasa la modificacion*/
	
	public void seteaValores(Television electroActual){
		t1.setText(Double.toString(electroActual.getPrecioBase()));
		t2.setText(Double.toString(electroActual.getPeso()));
		t4.setText(Character.toString(electroActual.getConsu().getConsumo()));
		t6.setText(Double.toString(electroActual.getResolucion()));
		if(electroActual.getTDT()=="Si"){rdbtnNewRadioButton.setSelected(true);;}
		else rdbtnNewRadioButton_1.setSelected(true);
	}
	
	/* MetodoparaConfirmarYPreguntarSiQuiereAgregarOTro */

	public void cerrar(){
		this.setVisible(false);
		int num = JOptionPane.showConfirmDialog(null, "¿Desea agregar un nuevo Televisor?", null, JOptionPane.YES_NO_OPTION);
		if(num==JOptionPane.YES_OPTION){limpiar(); this.setVisible(true);}
		else {this.setVisible(false);}
	}
	
	/* Setear en blanco */
	
	public void limpiar(){
	t1.setText(null);;
	t2.setText(null);;
	t4.setText(null);;
	t6.setText(null);;

	}
	
	/* Cargar los elementos */
	
	public void carga(){
		
		
		int num =1;
		try {
			prec = Float.parseFloat(t1.getText());
			peso = Float.parseFloat( t2.getText());
			String var = t4.getText(); 
			cons = var.charAt(0); 
			res = Float.parseFloat(t6.getText());
			col = (String)con.getSelectedItem(); 
			if(rdbtnNewRadioButton.isSelected()) 
			sinto = true;
			else  sinto= false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "¡Ingresa todos los valores!");
			num = 0;
			e.printStackTrace();
		} catch (NumberFormatException e){
			num=0;
			JOptionPane.showMessageDialog(null, "¡Ingresa todos los valores y de la forma correcta!");
		}
	
		if (num!=0) Ejecuta.agregaTelevisor(prec, peso, cons, res, col,sinto);} 

	
	/* Metodo Principal */

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
				agregarTelevisor frame = new agregarTelevisor(new JFrame(), true);
			
				frame.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
					}
					});
					frame.setVisible(true);
					}
					});
					}
	}