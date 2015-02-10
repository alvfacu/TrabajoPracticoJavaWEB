package capaVista;

import capaEntidades.Lavarropas;
import capaLogica.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.util.ArrayList;

public class agregarLavarropas extends JDialog {

	/* Declaracion de variables */
	
	private static final long serialVersionUID = 1L;
	private  JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private static agregarLavarropas frame;
	@SuppressWarnings("rawtypes")
	private JComboBox con;
	float prec ;
	float peso;
	float car ;
	char cons ; 
	String col ;
	Lavarropas electroActual;
	
	/* Primer constructor, con el JFRAME, Y BOOLEAN) */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public agregarLavarropas(JFrame hola, boolean modal) {
		super(hola,modal);
		setBounds(100, 100, 509, 457);
		this.setLocationRelativeTo(hola);
		setTitle("Agregar Lavarropas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(agregarLavarropas.class.getResource("/imagenes/mini005.png")));

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(32, 178, 170)));
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(new Color(255, 240, 245));
		layeredPane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		
		String[] valores = capaLogica.Ejecuta.getColores();
		con = new JComboBox(valores);
		con.setFont(new Font("Verdana", Font.PLAIN, 15));
		con.setBounds(104, 191, 105, 25);
		layeredPane.add(con);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recibedatos();	
				cerrar();
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton_2.setBackground(new Color(230, 230, 250));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Precio Base");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 26, 125, 30);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 67, 105, 26);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Carga");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 104, 105, 30);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Consumo");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(9, 141, 120, 30);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Color");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 186, 96, 30);
		layeredPane.add(lblNewLabel_5);
		
		t1 = new JTextField();
		t1.setFont(new Font("Verdana", Font.PLAIN, 15));
		t1.setBounds(104, 29, 87, 27);
		layeredPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Verdana", Font.PLAIN, 15));
		t2.setBounds(104, 70, 87, 25);
		layeredPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Verdana", Font.PLAIN, 15));
		t3.setBounds(104, 104, 87, 25);
		layeredPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Verdana", Font.PLAIN, 15));
		t4.setBounds(104, 145, 87, 25);
		layeredPane.add(t4);
		t4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("U$S");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(201, 31, 46, 20);
		layeredPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kg");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(201, 66, 46, 29);
		layeredPane.add(lblNewLabel_7);
		
		JLabel lblAgregarNuevoLavarropas = new JLabel("Agregar Lavarropas");
		lblAgregarNuevoLavarropas.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblAgregarNuevoLavarropas.setBounds(56, 11, 395, 31);
		layeredPane_1.add(lblAgregarNuevoLavarropas);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
	/* Metodo para modificar un Lavarropas */
	
	/**
	 * @wbp.parser.constructor
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public agregarLavarropas(ListaR hola, boolean modal,Lavarropas electroActual) {
		
		super(hola,modal);
		setBounds(100, 100, 509, 457);
		this.setLocationRelativeTo(hola);
		setTitle("Modificar Lavarropas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(agregarLavarropas.class.getResource("/imagenes/mini005.png")));

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(32, 178, 170)));
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(new Color(255, 240, 245));
		layeredPane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		String[] valores= new String[]{"NEGRO","BLANCO","AZUL","ROJO","GRIS" } ;
		con = new JComboBox(valores);
		con.setFont(new Font("Verdana", Font.PLAIN, 15));
		con.setBounds(104, 191, 105, 25);
		layeredPane.add(con);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recibedatos();	
				cerrar();
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton_2.setBackground(new Color(230, 230, 250));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Precio Base");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 26, 125, 30);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 67, 105, 26);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Carga");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 104, 105, 30);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Consumo");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(9, 141, 120, 30);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Color");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 186, 96, 30);
		layeredPane.add(lblNewLabel_5);
		
		t1 = new JTextField();
		t1.setFont(new Font("Verdana", Font.PLAIN, 15));
		t1.setBounds(104, 29, 87, 27);
		layeredPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Verdana", Font.PLAIN, 15));
		t2.setBounds(104, 70, 87, 25);
		layeredPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Verdana", Font.PLAIN, 15));
		t3.setBounds(104, 104, 87, 25);
		layeredPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Verdana", Font.PLAIN, 15));
		t4.setBounds(104, 145, 87, 25);
		layeredPane.add(t4);
		t4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("U$S");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(201, 31, 46, 20);
		layeredPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kg");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(201, 66, 46, 29);
		layeredPane.add(lblNewLabel_7);
		
		JLabel lblAgregarNuevoLavarropas = new JLabel("Modificar Lavarropas");
		lblAgregarNuevoLavarropas.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblAgregarNuevoLavarropas.setBounds(56, 11, 395, 31);
		layeredPane_1.add(lblAgregarNuevoLavarropas);
		contentPane.setLayout(gl_contentPane);
		
		seteaDatos(electroActual);
	}

	
	/* CerrarLuegoDeCargarUnLavarropas */
	
	private void seteaDatos(Lavarropas electro) {
		
		t1.setText(Double.toString(electro.getPrecioBase()));
		t2.setText(Double.toString(electro.getPeso()));
		t3.setText(Double.toString(electro.getCarga()));
		t4.setText(Character.toString(electro.getConsu().getConsumo()));
	}



	public void cerrar(){
		this.setVisible(false);
		int num = JOptionPane.showConfirmDialog(null, "¿Desea agregar un nuevo Lavarropas?", null, JOptionPane.YES_NO_OPTION);
		if(num==JOptionPane.YES_OPTION){limpiar(); this.setVisible(true);}
		else {this.setVisible(false);}
	}
	
	
	/* Carga De datos */ 
	
	private void recibedatos() {
		
		int num = 1;
		try{	
		 prec = Float.parseFloat(t1.getText());
		 peso =  Float.parseFloat( t2.getText());
		 car =  Float.parseFloat(t3.getText()); ;
		 cons  = t4.getText().charAt(0); 
		 col = (String)con.getSelectedItem(); 
	} catch (NullPointerException e) {
		JOptionPane.showMessageDialog(null, "¡Ingresa todos los valores!");
		 num = 0;
		e.printStackTrace();
	} catch (NumberFormatException e){
		JOptionPane.showMessageDialog(null, "¡Ingresa todos los valores y de la forma correcta!");
		num =0;
	}
		if (num !=0) Ejecuta.agregaLavarropas(prec, peso, car, cons, col);
		
	}
	
	/* Metodo para limpiar la tabla */
	
	private void limpiar(){
		this.t1.setText(null);
		this.t2.setText(null);
		this.t3.setText(null);
		this.t4.setText(null);
	}
	
	
		
	
	
	/* Metodo principal */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				frame = new agregarLavarropas(new JFrame(), true);
				frame.setSize(594, 457);
			    frame.setLocationRelativeTo(null);

			    
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
