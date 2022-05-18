package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
/**
* Ventana para visualiar la ayuda
* @author Grupo 4 
*/
public class ayudaF extends Login implements Runnable, ActionListener {

	/**
	 * asignar variables
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Panel1;
	private JPanel panelarriba;
	protected JLabel lbl;
	protected JLabel lblFechaexacta;
	private int año;
	private int mes;
	private int dia;
	private String hora, minutos, segundos, ampm;
	@SuppressWarnings("unused")
	private Calendar calendario;
	private Thread h1;

	protected JLabel lblnombre;
	protected JLabel lblapellidos;
	protected JLabel lblr;
	protected String nombre;
	protected String apellido;
	protected String roles;
	protected JLabel lblroles;
	protected String numemple;

	private JLabel lblN;
	protected JLabel lblNumemple;
	private JMenuBar menuBar;
	private JMenu Ventanas, Ayuda;
	private JMenuItem Vehiculos, Clientes, Empleados, Ordenes, Menu ,ayuda;
	protected JLabel lblImagen;
	private JPanel panel;
	private JButton btnVolver;
	/**
	 * Create the frame.
	 * 
	 * @param ayudaF
	 * @throws SQLException
	 */
	public ayudaF() {
		setForeground(Color.WHITE);
		setTitle("RekordAutoak - Vehiculos Ayuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 795);

		menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);

		Ventanas = new JMenu("Menu");
		menuBar.add(Ventanas);

		Vehiculos = new JMenuItem("Vehiculos");
		Vehiculos.addActionListener(this);
		Ventanas.add(Vehiculos);

		Clientes = new JMenuItem("Clientes");
		Clientes.addActionListener(this);
		Ventanas.add(Clientes);
		

		
		
		Empleados = new JMenuItem("Empleados");
		Empleados.addActionListener(this);
		Ventanas.add(Empleados);

		Ordenes = new JMenuItem("Ordenes");
		Ordenes.addActionListener(this);
		Ventanas.add(Ordenes);

		Menu = new JMenuItem("Menu");
		Menu.addActionListener(this);
		Ventanas.add(Menu);

		Ayuda = new JMenu("Ayuda");
		menuBar.add(Ayuda);
		
		ayuda = new JMenuItem("Ayuda");
		ayuda.addActionListener(this);
		Ayuda.add(ayuda);

		Panel1 = new JPanel();
		Panel1.setBackground(Color.GRAY);
		Panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel1);
		Panel1.setLayout(new BorderLayout(0, 0));

		panelarriba = new JPanel();
		panelarriba.setBackground(Color.GRAY);
		Panel1.add(panelarriba, BorderLayout.NORTH);
		GridBagLayout gbl_panelarriba = new GridBagLayout();
		gbl_panelarriba.columnWidths = new int[] { 0, 0, -15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelarriba.rowHeights = new int[] { 0, 0 };
		gbl_panelarriba.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelarriba.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelarriba.setLayout(gbl_panelarriba);
		
	

		lbl = new JLabel();
		lbl.setIcon(new ImageIcon(ayudaF.class.getResource("/resources/user-png-icon.png")));
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.anchor = GridBagConstraints.WEST;
		gbc_lbl.insets = new Insets(0, 0, 0, 5);
		gbc_lbl.gridx = 1;
		gbc_lbl.gridy = 0;
		panelarriba.add(lbl, gbc_lbl);

		lblnombre = new JLabel();
		lblnombre.setForeground(Color.WHITE);
		lblnombre.setBackground(Color.WHITE);
		lblnombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblnombre = new GridBagConstraints();
		gbc_lblnombre.anchor = GridBagConstraints.WEST;
		gbc_lblnombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblnombre.gridx = 2;
		gbc_lblnombre.gridy = 0;
		panelarriba.add(lblnombre, gbc_lblnombre);

		lblapellidos = new JLabel();
		lblapellidos.setForeground(Color.WHITE);
		lblapellidos.setBackground(Color.WHITE);
		lblapellidos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblapellidos = new GridBagConstraints();
		gbc_lblapellidos.anchor = GridBagConstraints.WEST;
		gbc_lblapellidos.insets = new Insets(0, 0, 0, 5);
		gbc_lblapellidos.gridx = 3;
		gbc_lblapellidos.gridy = 0;
		panelarriba.add(lblapellidos, gbc_lblapellidos);

		lblr = new JLabel();
		lblr.setForeground(Color.WHITE);
		lblr.setIcon(new ImageIcon(ayudaF.class.getResource("/resources/rola.png")));
		lblr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblr = new GridBagConstraints();
		gbc_lblr.anchor = GridBagConstraints.WEST;
		gbc_lblr.insets = new Insets(0, 0, 0, 5);
		gbc_lblr.gridx = 5;
		gbc_lblr.gridy = 0;
		panelarriba.add(lblr, gbc_lblr);

		lblroles = new JLabel();
		lblroles.setForeground(Color.WHITE);
		lblroles.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblroles = new GridBagConstraints();
		gbc_lblroles.insets = new Insets(0, 0, 0, 5);
		gbc_lblroles.gridx = 6;
		gbc_lblroles.gridy = 0;
		panelarriba.add(lblroles, gbc_lblroles);

		lblN = new JLabel("   N\u00BAEmpleado: ");
		lblN.setForeground(Color.WHITE);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.insets = new Insets(0, 0, 0, 5);
		gbc_lblN.gridx = 8;
		gbc_lblN.gridy = 0;
		panelarriba.add(lblN, gbc_lblN);

		lblNumemple = new JLabel();
		lblNumemple.setForeground(Color.WHITE);
		lblNumemple.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNumemple = new GridBagConstraints();
		gbc_lblNumemple.insets = new Insets(0, 0, 0, 5);
		gbc_lblNumemple.gridx = 9;
		gbc_lblNumemple.gridy = 0;
		panelarriba.add(lblNumemple, gbc_lblNumemple);

		lblFechaexacta = new JLabel();
		lblFechaexacta.setForeground(Color.WHITE);
		lblFechaexacta.setBackground(Color.WHITE);
		lblFechaexacta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblFechaexacta = new GridBagConstraints();
		gbc_lblFechaexacta.anchor = GridBagConstraints.EAST;
		gbc_lblFechaexacta.gridx = 21;
		gbc_lblFechaexacta.gridy = 0;
		panelarriba.add(lblFechaexacta, gbc_lblFechaexacta);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Panel1.add(lblImagen, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		Panel1.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 5, 0);
		gbc_btnVolver.gridx = 0;
		gbc_btnVolver.gridy = 1;
		panel.add(btnVolver, gbc_btnVolver);

		// creo el vector para los datos de la tabla
	
		btnVolver.addActionListener(this);

		h1 = new Thread(this);
		h1.start();
		setLocationRelativeTo(null);
		setVisible(true);
		run();

	

	}
	
	
	/**
	 * FECHA ASIGNAR VALORES
	 */
	public void fecahactual() {

		Calendar calendario = Calendar.getInstance();
		Date fechaHoraActual = new Date();

		año = calendario.get(Calendar.YEAR);
		mes = calendario.get(Calendar.MONTH);
		mes++;
		dia = calendario.get(Calendar.DAY_OF_MONTH);

		calendario.setTime(fechaHoraActual);
		ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

		if (ampm.equals("PM")) {
			int h = calendario.get(Calendar.HOUR_OF_DAY);
			hora = h > 9 ? "" + h : "0" + h;
		} else {
			hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
					: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		}
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
	}
	/**
	 * Tener la fecha dinamica
	 */
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == h1) {
			fecahactual();
			lblFechaexacta.setText(
					dia + " / " + mes + " / " + año + "     " + hora + ":" + minutos + ":" + segundos + " " + ampm);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}


	/**+
	 * 
	 * 
	 * @param textField 
	 * @return si el campo esta vacio mostrar error o si esta lleno
	 */
	@SuppressWarnings("unused")
	private boolean verificarCampos(JTextField textField) {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo debe ser rellenado", "Error", JOptionPane.ERROR_MESSAGE);
			textField.requestFocus();
			return false;
		}
		return true;
	}
	/**+
	 * 
	 * 
	 * @param textField 
	 * @return si el campo esta vacio mostrar error o si esta lleno
	 */
	@SuppressWarnings("unused")
	private boolean verificarCamposborrar(JTextField textField) {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos para borrar", "ERROR",
					JOptionPane.ERROR_MESSAGE, null);
			return false;
		}
		return true;
	}

	/**
	 * accion de botones
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		String emple = lblNumemple.getText();
		int numeroroles = Integer.valueOf(emple);

		if (numeroroles >= 10000 && numeroroles <= 29999) {

			  if (boton == Clientes) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();
				Clientes vmClientes = new Clientes();
				vmClientes.setVisible(true);
				vmClientes.lblNumemple.setText(numemple);
				vmClientes.lblnombre.setText(nombre);
				vmClientes.lblapellidos.setText(apellido);
				vmClientes.lblroles.setText(roles);

				vmClientes.btnAgregar.setEnabled(false);
				vmClientes.btnBorrar.setEnabled(false);
				vmClientes.btnModifiacar.setEnabled(false);
				vmClientes.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Empleados) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				EmpleadosRM vm = new EmpleadosRM();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Ordenes) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Ordenes vm = new Ordenes();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Vehiculos) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Vehiculos vm = new Vehiculos();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnVaciar.setEnabled(false);

				this.dispose();

			}else if (boton == Menu) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Menu vm = new Menu();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);


				this.dispose();

			

			}

		}else if (numeroroles >= 30000 && numeroroles <= 49999) {

			if (boton == Clientes) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();
				Clientes vmClientes = new Clientes();
				vmClientes.setVisible(true);
				vmClientes.lblNumemple.setText(numemple);
				vmClientes.lblnombre.setText(nombre);
				vmClientes.lblapellidos.setText(apellido);
				vmClientes.lblroles.setText(roles);
				vmClientes.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Empleados) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				EmpleadosRM vm = new EmpleadosRM();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Ordenes) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Ordenes vm = new Ordenes();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Vehiculos) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Vehiculos vm = new Vehiculos();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

				this.dispose();

			}else if (boton == Menu) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Menu vm = new Menu();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);


				this.dispose();

			}

		} else if (numeroroles >= 50000 && numeroroles <= 69999) {
				if (boton == Clientes) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();
				Clientes vmClientes = new Clientes();
				vmClientes.setVisible(true);
				vmClientes.lblNumemple.setText(numemple);
				vmClientes.lblnombre.setText(nombre);
				vmClientes.lblapellidos.setText(apellido);
				vmClientes.lblroles.setText(roles);
				this.dispose();

			} else if (boton == Empleados) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Empleados vm = new Empleados();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				this.dispose();

			} else if (boton == Ordenes) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Ordenes vm = new Ordenes();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				this.dispose();

			} else if (boton == Vehiculos) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Vehiculos vm = new Vehiculos();
				vm.setVisible(true);
				vm.lblNumemple.setText(numemple);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				this.dispose();

			}else if (boton == Menu) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Menu vm = new Menu();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);


				this.dispose();

			}
		} else if (numeroroles == 90000) {


			  if (boton == Clientes) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();
				Clientes vmClientes = new Clientes();
				vmClientes.setVisible(true);
				vmClientes.lblNumemple.setText(numemple);
				vmClientes.lblnombre.setText(nombre);
				vmClientes.lblapellidos.setText(apellido);
				vmClientes.lblroles.setText(roles);

				vmClientes.btnAgregar.setEnabled(false);
				vmClientes.btnBorrar.setEnabled(false);
				vmClientes.btnModifiacar.setEnabled(false);
				vmClientes.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Empleados) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				EmpleadosJefe vm = new EmpleadosJefe();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				this.dispose();

			} else if (boton == Ordenes) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Ordenes vm = new Ordenes();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

				this.dispose();

			} else if (boton == Vehiculos) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Vehiculos vm = new Vehiculos();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

				this.dispose();

			}else if (boton == Menu) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Menu vm = new Menu();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);


				this.dispose();

			}
		}
		if (boton == ayuda) {
			
			JOptionPane.showMessageDialog(this,
					"Ya estas en la ventana Ayuda",
					"AYUDA", JOptionPane.INFORMATION_MESSAGE);	
			
		}
		if(boton == btnVolver) {
			if (numeroroles >= 10000 && numeroroles <= 29999) {

				
					nombre = lblnombre.getText();
					apellido = lblapellidos.getText();
					roles = lblroles.getText();
					numemple = lblNumemple.getText();

					Vehiculos vm = new Vehiculos();
					vm.setVisible(true);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellido);
					vm.lblroles.setText(roles);
					vm.lblNumemple.setText(numemple);

					vm.btnVaciar.setEnabled(false);

					this.dispose();

				


			}else if (numeroroles >= 30000 && numeroroles <= 49999) {

			
					nombre = lblnombre.getText();
					apellido = lblapellidos.getText();
					roles = lblroles.getText();
					numemple = lblNumemple.getText();

					Vehiculos vm = new Vehiculos();
					vm.setVisible(true);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellido);
					vm.lblroles.setText(roles);
					vm.lblNumemple.setText(numemple);

					vm.btnAgregar.setEnabled(false);
					vm.btnBorrar.setEnabled(false);
					vm.btnModifiacar.setEnabled(false);
					vm.btnVaciar.setEnabled(false);

					this.dispose();

				

			} else if (numeroroles >= 50000 && numeroroles <= 69999) {
					
				
					nombre = lblnombre.getText();
					apellido = lblapellidos.getText();
					roles = lblroles.getText();
					numemple = lblNumemple.getText();

					Vehiculos vm = new Vehiculos();
					vm.setVisible(true);
					vm.lblNumemple.setText(numemple);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellido);
					vm.lblroles.setText(roles);
					this.dispose();

				
			} else if (numeroroles == 90000) {


				  

					
					nombre = lblnombre.getText();
					apellido = lblapellidos.getText();
					roles = lblroles.getText();
					numemple = lblNumemple.getText();

					Vehiculos vm = new Vehiculos();
					vm.setVisible(true);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellido);
					vm.lblroles.setText(roles);
					vm.lblNumemple.setText(numemple);

					vm.btnAgregar.setEnabled(false);
					vm.btnBorrar.setEnabled(false);
					vm.btnModifiacar.setEnabled(false);
					vm.btnVaciar.setEnabled(false);

					this.dispose();

				
			}
		}
	}


}	