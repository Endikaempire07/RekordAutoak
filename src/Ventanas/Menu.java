package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
/**
* Ventana para visualiar lA VENTANA Menu
* @author Grupo 4 
*/
public class Menu extends Login implements Runnable, ActionListener {

	/**
	 * 
	 * asignar variables
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Panel1;
	private JPanel panelcentral;
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
	private JLabel lblimg;
	
	protected JLabel lblnombre;
	protected JLabel lblapellidos;
	protected JLabel lblr;
	protected String nombre;
	protected String apellido;
	protected String roles;

	protected String numemple;

	protected JLabel lblroles;
	private JPanel panel;
	private JButton btnEmpleados;
	private JButton btnVehiculos;
	private JButton btnClientes;
	private JButton btnOrdenes;
	private JPanel panel_1;
	private JButton btnCerrarSesion;
	private JLabel lblN;
	protected JLabel lblNumemple;



	
	
	
	/**
	 * Create the frame.
	 * @param Menu 
	 */
	public Menu() {
		setForeground(Color.WHITE);
		setTitle("RekordAutoak -Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 463);
		Panel1 = new JPanel();
		Panel1.setBackground(Color.GRAY);
		Panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel1);
		Panel1.setLayout(new BorderLayout(0, 0));
		
		panelcentral = new JPanel();
		panelcentral.setBackground(Color.GRAY);
		Panel1.add(panelcentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelcentral = new GridBagLayout();
		gbl_panelcentral.columnWidths = new int[]{0, 0, 0, 0, 0, 70, 0};
		gbl_panelcentral.rowHeights = new int[]{24, 0, 0, 0, 0};
		gbl_panelcentral.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelcentral.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelcentral.setLayout(gbl_panelcentral);
		
		panelarriba = new JPanel();
		panelarriba.setBackground(Color.GRAY);
		Panel1.add(panelarriba, BorderLayout.NORTH);
		GridBagLayout gbl_panelarriba = new GridBagLayout();
		gbl_panelarriba.columnWidths = new int[]{0, -15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelarriba.rowHeights = new int[]{0, 0};
		gbl_panelarriba.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelarriba.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelarriba.setLayout(gbl_panelarriba);
		
		lbl = new JLabel();
		lbl.setIcon(new ImageIcon(Menu.class.getResource("/resources/user-png-icon.png")));
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.anchor = GridBagConstraints.WEST;
		gbc_lbl.insets = new Insets(0, 0, 0, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		panelarriba.add(lbl, gbc_lbl);
		
		lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(Menu.class.getResource("/resources/menulogo.png")));
		GridBagConstraints gbc_lblimg = new GridBagConstraints();
		gbc_lblimg.gridheight = 3;
		gbc_lblimg.gridwidth = 7;
		gbc_lblimg.insets = new Insets(0, 0, 5, 0);
		gbc_lblimg.gridx = 0;
		gbc_lblimg.gridy = 0;
		panelcentral.add(lblimg, gbc_lblimg);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 7;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		panelcentral.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBackground(SystemColor.activeCaptionBorder);
		btnEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 31));
		GridBagConstraints gbc_btnEmpleados = new GridBagConstraints();
		gbc_btnEmpleados.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmpleados.gridx = 0;
		gbc_btnEmpleados.gridy = 1;
		panel.add(btnEmpleados, gbc_btnEmpleados);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(SystemColor.activeCaptionBorder);
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.insets = new Insets(0, 0, 5, 0);
		gbc_btnClientes.gridx = 1;
		gbc_btnClientes.gridy = 1;
		panel.add(btnClientes, gbc_btnClientes);
		
		btnVehiculos = new JButton("Vehiculos");
		btnVehiculos.setBackground(SystemColor.activeCaptionBorder);
		btnVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 31));
		GridBagConstraints gbc_btnVehiculos = new GridBagConstraints();
		gbc_btnVehiculos.insets = new Insets(0, 0, 0, 5);
		gbc_btnVehiculos.gridx = 0;
		gbc_btnVehiculos.gridy = 2;
		panel.add(btnVehiculos, gbc_btnVehiculos);
		
		btnOrdenes = new JButton("Ordenes T");
		btnOrdenes.setBackground(SystemColor.activeCaptionBorder);
		btnOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		GridBagConstraints gbc_btnOrdenes = new GridBagConstraints();
		gbc_btnOrdenes.gridx = 1;
		gbc_btnOrdenes.gridy = 2;
		panel.add(btnOrdenes, gbc_btnOrdenes);
		
		lblnombre = new JLabel();
		lblnombre.setForeground(Color.WHITE);
		lblnombre.setBackground(Color.WHITE);
		lblnombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblnombre = new GridBagConstraints();
		gbc_lblnombre.anchor = GridBagConstraints.WEST;
		gbc_lblnombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblnombre.gridx = 1;
		gbc_lblnombre.gridy = 0;
		panelarriba.add(lblnombre, gbc_lblnombre);
		
		lblapellidos = new JLabel();
		lblapellidos.setForeground(Color.WHITE);
		lblapellidos.setBackground(Color.WHITE);
		lblapellidos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblapellidos = new GridBagConstraints();
		gbc_lblapellidos.anchor = GridBagConstraints.WEST;
		gbc_lblapellidos.insets = new Insets(0, 0, 0, 5);
		gbc_lblapellidos.gridx = 2;
		gbc_lblapellidos.gridy = 0;
		panelarriba.add(lblapellidos, gbc_lblapellidos);
		
		lblr = new JLabel();
		lblr.setForeground(Color.WHITE);
		lblr.setIcon(new ImageIcon(Menu.class.getResource("/resources/rola.png")));
		lblr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblr = new GridBagConstraints();
		gbc_lblr.anchor = GridBagConstraints.WEST;
		gbc_lblr.insets = new Insets(0, 0, 0, 5);
		gbc_lblr.gridx = 4;
		gbc_lblr.gridy = 0;
		panelarriba.add(lblr, gbc_lblr);
		
		lblroles = new JLabel();
		lblroles.setForeground(Color.WHITE);
		lblroles.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblroles = new GridBagConstraints();
		gbc_lblroles.insets = new Insets(0, 0, 0, 5);
		gbc_lblroles.gridx = 5;
		gbc_lblroles.gridy = 0;
		panelarriba.add(lblroles, gbc_lblroles);
		
		lblN = new JLabel("   N\u00BAEmpleado: ");
		lblN.setForeground(Color.WHITE);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.insets = new Insets(0, 0, 0, 5);
		gbc_lblN.gridx = 6;
		gbc_lblN.gridy = 0;
		panelarriba.add(lblN, gbc_lblN);
		
		lblNumemple = new JLabel();
		lblNumemple.setForeground(Color.WHITE);
		lblNumemple.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNumemple = new GridBagConstraints();
		gbc_lblNumemple.insets = new Insets(0, 0, 0, 5);
		gbc_lblNumemple.gridx = 7;
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
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		Panel1.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{300, 85, 0};
		gbl_panel_1.rowHeights = new int[]{21, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBackground(SystemColor.activeCaptionBorder);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.gridwidth = 2;
		gbc_btnCerrarSesion.anchor = GridBagConstraints.NORTH;
		gbc_btnCerrarSesion.gridx = 0;
		gbc_btnCerrarSesion.gridy = 0;
		panel_1.add(btnCerrarSesion, gbc_btnCerrarSesion);
		
		h1 = new Thread(this);
		h1.start();
		setLocationRelativeTo(null);
		setVisible(true);
		run();
		
		
		//actionListener
		btnCerrarSesion.addActionListener(this);
		btnClientes.addActionListener(this);
		btnEmpleados.addActionListener(this);
		btnOrdenes.addActionListener(this);
		btnVehiculos.addActionListener(this);

	}
	/**
	 * asignar los valores de la fecha
	 * 
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
	 * 
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
	/**
	 * accion de botones
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		
		String emple = lblNumemple.getText();   
		int numeroroles = Integer.parseInt(emple);   
			
		if(numeroroles >= 10000 && numeroroles <= 29999) {

			if(boton == btnCerrarSesion) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				JOptionPane.showMessageDialog(this, "Sesion Finalizada, Hasta la proxima "+  nombre +" "+apellido +" tenga un buen dia");
				Login vm = new Login();
				this.dispose();
				vm.setVisible(true);
				
			}else if(boton == btnClientes) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

				
			}else if(boton == btnEmpleados) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

				
			}else if(boton == btnOrdenes) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

			}else if(boton == btnVehiculos) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

			}
			
		}else if(numeroroles >= 30000 && numeroroles <= 49999 ) {

			if(boton == btnCerrarSesion) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				JOptionPane.showMessageDialog(this, "Sesion Finalizada, Hasta la proxima "+  nombre +" "+apellido +" tenga un buen dia");
				Login vm = new Login();
				this.dispose();
				vm.setVisible(true);
			
				
			}else if(boton == btnClientes) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();
				Clientes vmClientes = new Clientes();
				vmClientes.setVisible(true);
				vmClientes.lblNumemple.setText(numemple);
				vmClientes.lblnombre.setText(nombre);
				vmClientes.lblapellidos.setText(apellido);					
				vmClientes.lblroles.setText(roles);
				vmClientes.btnAgregar.setEnabled(true);
				vmClientes.btnBorrar.setEnabled(true);
				vmClientes.btnModifiacar.setEnabled(true);
				vmClientes.btnVaciar.setEnabled(false);
				this.dispose();

				
			}else if(boton == btnEmpleados) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				EmpleadosRM vm = new EmpleadosRM();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);					
				vm.lblroles.setText(roles);		
				vm.lblNumemple.setText(numemple);
				
				this.dispose();

			
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				
				
			}else if(boton == btnOrdenes) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Ordenes vm = new Ordenes();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);					
				vm.lblroles.setText(roles);		
				vm.lblNumemple.setText(numemple);
				vm.btnAgregar.setEnabled(true);
				vm.btnBorrar.setEnabled(true);
				vm.btnModifiacar.setEnabled(true);
				vm.btnVaciar.setEnabled(false);
				this.dispose();

				
			}else if(boton == btnVehiculos) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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
				
		}else if(numeroroles >= 50000 && numeroroles <= 69999) {

			if(boton == btnCerrarSesion) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				JOptionPane.showMessageDialog(this, "Sesion Finalizada, Hasta la proxima "+  nombre +" "+apellido +" tenga un buen dia");
				Login vm = new Login();
				this.dispose();
				vm.setVisible(true);
			
				
			}else if(boton == btnClientes) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();
				Clientes vmClientes = new Clientes();
				vmClientes.setVisible(true);
				vmClientes.lblNumemple.setText(numemple);
				vmClientes.lblnombre.setText(nombre);
				vmClientes.lblapellidos.setText(apellido);					
				vmClientes.lblroles.setText(roles);		
				this.dispose();

			
				
				
			}else if(boton == btnEmpleados) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

			
				Empleados vm = new Empleados();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);					
				vm.lblroles.setText(roles);		
				vm.lblNumemple.setText(numemple);
		
				this.dispose();

				
			}else if(boton == btnOrdenes) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Ordenes vm = new Ordenes();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);					
				vm.lblroles.setText(roles);	
				vm.lblNumemple.setText(numemple);
				
				this.dispose();

				
				
				
			}else if(boton == btnVehiculos) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Vehiculos vm = new Vehiculos();
				vm.setVisible(true);
				vm.lblNumemple.setText(numemple);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);					
				vm.lblroles.setText(roles);	
				this.dispose();

			}
		}else if(numeroroles == 90000) {
			
			if(boton == btnCerrarSesion) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
				JOptionPane.showMessageDialog(this, "Sesion Finalizada, Hasta la proxima "+  nombre +" "+apellido +" tenga un buen dia");
				Login vm = new Login();
				this.dispose();
				vm.setVisible(true);
			
				
			}else if(boton == btnClientes) {
				
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

			
			
			}else if(boton == btnEmpleados) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

				
			}else if(boton == btnOrdenes) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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

			}else if(boton == btnVehiculos) {
				nombre = lblnombre.getText();
				apellido =lblapellidos.getText();
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
