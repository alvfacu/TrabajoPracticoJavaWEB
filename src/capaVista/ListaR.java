package capaVista;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import modeloTabla.ModeloTabla;
import capaEntidades.*;
import capaLogica.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Toolkit;

import capaLogica.Ejecuta;

public class ListaR extends JDialog {

	/* Declaración de Variables */ 
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ModeloTabla model;
	private JTextField ranMin;
	private JTextField ranMax;
	private Character[] letras = {' ','A','B','C','D','E','F'};
	private JComboBox cmbConsumo;
	private JButton btnListar;
	private	JButton btnNewButton_1;
	private JButton btnNewButton;
	
	/* Constructor de ListaR */
	
	public ListaR(JFrame hola, boolean modal) {
		
		super(hola,modal);
		setTitle("Listar Productos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaR.class.getResource("/imagenes/mini005.png")));
		setBounds(100, 100, 754, 479);
		this.setLocationRelativeTo(hola);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 119, 738, 324);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 604, 675, 38);
		getContentPane().add(panel);
		
		ranMin = new JTextField();
		ranMin.setFont(new Font("Verdana", Font.PLAIN, 22));
		ranMin.setBounds(103, 10, 92, 26);
		getContentPane().add(ranMin);
		ranMin.setColumns(10);
		
		ranMax = new JTextField();
		ranMax.setFont(new Font("Verdana", Font.PLAIN, 22));
		ranMax.setBounds(103, 38, 92, 26);
		getContentPane().add(ranMax);
		ranMax.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ran Min");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		lblNewLabel.setBounds(6, 13, 86, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ran Max");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(7, 40, 92, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(205, 13, 46, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("$");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(205, 41, 46, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Consumo");
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(8, 70, 101, 26);
		getContentPane().add(lblNewLabel_4);
		
		cmbConsumo = new JComboBox(letras);
		cmbConsumo.setBounds(103, 75, 92, 20);
		getContentPane().add(cmbConsumo);
		
		btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Eliminar();
			}	
	});
		
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 9));
		btnNewButton.setBounds(487, 85, 89, 23);
		getContentPane().add(btnNewButton);
		
	    btnNewButton_1 = new JButton("Modificar");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	Modificar();
	    	}
	    });
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 9));
		btnNewButton_1.setBounds(376, 85, 101, 23);
		getContentPane().add(btnNewButton_1);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar();
				if(model.getDataSource().size() == 0)
				{
					JOptionPane.showMessageDialog(null, "No se encontraron electrodomesticos según los criterios ingresados.", "Atención", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);
				}	
			}
		});
		btnListar.setBounds(277, 86, 89, 23);
		getContentPane().add(btnListar);
		ranMin.setText("0");
		ranMax.setText("1000");	
	
	}
	
	/* Metodo del Boton Listar */
	
	public void Listar() {
		
		try
		{		
			model = new ModeloTabla(ranMin.getText(),ranMax.getText(),(Character)cmbConsumo.getSelectedItem());
			table.setModel(model);
			for(int i = 0; i < model.getColumnCount(); i++)
			{
				table.getColumnModel().getColumn(i).setResizable(false);
			}
		}
		catch (NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(null, "Verifique que los números ingresados como mínimo y máximo sean válidos.", "Error en el formato de números.", JOptionPane.ERROR_MESSAGE);
		}
	}	

	/* Metodo del Boton Modificar */
	
	public void Modificar(){
	try {
		int row = table.getSelectedRow();
	Electrodomesticos electroActual = model.getDataSource().get(row);
	if (electroActual instanceof capaEntidades.Lavarropas){new agregarLavarropas(ListaR.this,true,(Lavarropas)electroActual).setVisible(true);;}
	else if  (electroActual instanceof capaEntidades.Television){ new agregarTelevisor(ListaR.this,true,(Television)electroActual).setVisible(true);;}

	/*Aca no se como hacer para que no me elimine si me apreta cancelar "PREGUNTAR" */
	
	Ejecuta.eliminarElec(electroActual);
	Listar();
	}catch(ArrayIndexOutOfBoundsException e){ JOptionPane.showMessageDialog(null, "Por favor Seleccione un elemento!");}
}
	
	/* Metodo del Boton Eliminar */

	public void Eliminar(){
	btnNewButton.setEnabled(false);
	try{
	int row = table.getSelectedRow();
	Electrodomesticos electroActual = model.getDataSource().get(row);
	Ejecuta.eliminarElec(electroActual);
	Listar();
	btnNewButton.setEnabled(true);			

	}catch(ArrayIndexOutOfBoundsException ne){
		JOptionPane.showMessageDialog(null, "No hay ningun elemento Seleccionado");
		btnNewButton.setEnabled(true);			
		}
}

	/* Metodo Main */
	
	public static void main(String[] args) {
	ListaR frame = new ListaR(new JFrame(), true);
	frame.addWindowListener(new java.awt.event.WindowAdapter() {

		public void windowClosing(java.awt.event.WindowEvent e) {
		System.exit(0);
		}
		});
		frame.setVisible(true);
}

}
