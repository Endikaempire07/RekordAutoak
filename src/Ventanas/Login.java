package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;


import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.SystemColor;
import javax.swing.JComboBox;
/**
* Ventana para visualiar lA VENTANA login
* @author Grupo 4 
*/
public class Login extends JFrame implements Runnable, ActionListener, Serializable{

	/**
	 * 
	 * asignar variables
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel Panel1;
	private JPanel panel;
	private JPanel panel_1;

	private JPasswordField txtcontrasena;

	private JButton btnSalir;
	private JButton btnEntrar;

	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JLabel lblFechaexacta;
	private int año;
	private int mes;
	private int dia;
	private String hora, minutos, segundos, ampm;
	@SuppressWarnings("unused")
	private Calendar calendario;
	private Thread h1;
	private JLabel lblimg;
	private JComboBox<String> cmbUsuario;
	// variables numero
	protected String Usuario;
	private String Contrasena;
	protected String nombre;
	protected String apellidos;
	protected String roles;
	protected String numemple;
	private String usuarioCorrecto;
	private String contrasenaCorrecta;
	@SuppressWarnings("unused")
	private Login emple;
	protected ArrayList<Login> emple1=  new ArrayList<Login>();
	// Base de datos
	private ResultSet rs;
	private Connection conexion;
	/**
	 * 
	 * 
	 * @param args inicia desde aqui siempre
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 * @param Login	 
	 * @throws SQLException
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/resources/favicon.png")));
		setForeground(Color.WHITE);
		setTitle("RekordAutoak - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 473);
		Panel1 = new JPanel();
		Panel1.setBackground(Color.GRAY);
		Panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel1);
		Panel1.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		Panel1.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 250, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 65, 0, 51, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(Login.class.getResource("/resources/RAlogo.png")));
		GridBagConstraints gbc_lblimg = new GridBagConstraints();
		gbc_lblimg.gridheight = 3;
		gbc_lblimg.gridwidth = 7;
		gbc_lblimg.insets = new Insets(0, 0, 5, 0);
		gbc_lblimg.gridx = 0;
		gbc_lblimg.gridy = 0;
		panel.add(lblimg, gbc_lblimg);

		lblUsuario = new JLabel("Numero de empleado:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 3;
		panel.add(lblUsuario, gbc_lblUsuario);

		cmbUsuario = new JComboBox<String>();
		cmbUsuario.setForeground(SystemColor.desktop);
		GridBagConstraints gbc_cmbUsuario = new GridBagConstraints();
		gbc_cmbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_cmbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUsuario.gridx = 2;
		gbc_cmbUsuario.gridy = 3;
		panel.add(cmbUsuario, gbc_cmbUsuario);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.activeCaptionBorder);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.gridwidth = 3;
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEntrar.gridx = 4;
		gbc_btnEntrar.gridy = 3;
		panel.add(btnEntrar, gbc_btnEntrar);

		lblPassword = new JLabel("Contrase\u00F1a: ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 5;
		panel.add(lblPassword, gbc_lblPassword);

		txtcontrasena = new JPasswordField();
		txtcontrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_txtcontrasena = new GridBagConstraints();
		gbc_txtcontrasena.insets = new Insets(0, 0, 5, 5);
		gbc_txtcontrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcontrasena.gridx = 2;
		gbc_txtcontrasena.gridy = 5;
		panel.add(txtcontrasena, gbc_txtcontrasena);

		btnSalir = new JButton("  Salir ");
		btnSalir.setBackground(SystemColor.activeCaptionBorder);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalir.gridwidth = 3;
		gbc_btnSalir.gridx = 4;
		gbc_btnSalir.gridy = 5;
		panel.add(btnSalir, gbc_btnSalir);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		Panel1.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 240, 203, 180, 9, 0 };
		gbl_panel_1.rowHeights = new int[] { 21, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblFechaexacta = new JLabel();
		lblFechaexacta.setForeground(Color.WHITE);
		lblFechaexacta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFechaexacta.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFechaexacta = new GridBagConstraints();
		gbc_lblFechaexacta.gridwidth = 2;
		gbc_lblFechaexacta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaexacta.gridx = 2;
		gbc_lblFechaexacta.gridy = 0;
		panel_1.add(lblFechaexacta, gbc_lblFechaexacta);
		
		
		// para centrar la ventana

		h1 = new Thread(this);
		h1.start();
		setLocationRelativeTo(null);
		setVisible(true);
		
		// actionlistener
		btnSalir.addActionListener(this);
		btnEntrar.addActionListener(this);
		run();
		conectarbasededatos();
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
	 * 
	 * conexion con la base de datos
	 * 
	 */
	public void conectarbasededatos() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.empleado;");
			while (rs.next()) {
				cmbUsuario.addItem(rs.getString("id"));
			}
			
			
			st.close();
			rs.close();
			conexion.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, (String) "Error de conexion. La conexion no se ha realizado.", "ERROR",
					JOptionPane.ERROR_MESSAGE, null);

			btnSalir.setEnabled(false);
			btnEntrar.setEnabled(false);

			txtcontrasena.setEnabled(false);
			cmbUsuario.setEnabled(false);

		}
	}
	/**
	 * accion de botones
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		if (boton == btnEntrar) {
			
			try {
				// CONECTO LA BASE DE DATOS
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
				// creo una sentencia que pueda ir por delante y por detras
				Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				// selecciono todos lod regitros de la tabla alumnos
				Usuario = (String) cmbUsuario.getSelectedItem();
				rs = st.executeQuery("SELECT empleado.id,empleado.nombre,empleado.apellidos,empleado.password ,role.name FROM empleado, role WHERE empleado.idRole = role.id and empleado.id= "+Usuario+";");
				while (rs.next()) {
					usuarioCorrecto = (String) cmbUsuario.getSelectedItem();
					roles = rs.getString("name");
					nombre = rs.getString("nombre");
					apellidos = rs.getString("apellidos");
					contrasenaCorrecta = rs.getString("password");
				}
				
				st.close();
				rs.close();
				conexion.close();
				
				
				
				
			}catch (SQLException e1) {
				// si se produce una excepción SQL
				int errorcode = e1.getErrorCode();
				if (errorcode == 1062) {
					// si es un error de clave suplicada
					JOptionPane.showMessageDialog(this,
							(String) "Error Clave Duplicada. Ya existe un registro con esa clave.", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);

				
				}
			}
				
			// verificamos que la contraseña y el usuario se han iguales
			Usuario = (String) cmbUsuario.getSelectedItem();
			Contrasena = new String(txtcontrasena.getPassword());	
			
			if (!Usuario.equals(usuarioCorrecto) || !Contrasena.equals(contrasenaCorrecta)) {

				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");

			}
			else if (Usuario.equals(usuarioCorrecto) && Contrasena.equals(contrasenaCorrecta)) {

				if (roles.equals("Mecanico")) {
					JOptionPane.showMessageDialog(this, "Inicio de sesion Realizada, Bienvenido "+  nombre +" "+apellidos +" tenga un buen dia");
					Menu vm = new Menu();
					this.dispose();
					vm.setVisible(true);
					vm.lblNumemple.setText(Usuario);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellidos);					
					vm.lblroles.setText(roles);					

				} else if (roles.equals("Recepcionista")) {
					JOptionPane.showMessageDialog(this, "Inicio de sesion Realizada, Bienvenido "+  nombre +" "+apellidos +" tenga un buen dia");
					Menu vm = new Menu();
					this.dispose();
					vm.setVisible(true);
					vm.lblNumemple.setText(Usuario);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellidos);					
					vm.lblroles.setText(roles);					
	
				} else if (roles.equals("Administrador")) {
					JOptionPane.showMessageDialog(this, "Inicio de sesion Realizada, Bienvenido "+  nombre +" "+apellidos +" tenga un buen dia");
					Menu vm = new Menu();
					this.dispose();
					vm.setVisible(true);
					vm.lblNumemple.setText(Usuario);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellidos);					
					vm.lblroles.setText(roles);					

					

				} else if (roles.equals("Jefe")) {
					JOptionPane.showMessageDialog(this, "Inicio de sesion Realizada, Bienvenido "+  nombre +" "+apellidos +" tenga un buen dia");
					Menu vm = new Menu();
					this.setVisible(false);
					vm.setVisible(true);
					vm.lblNumemple.setText(Usuario);
					vm.lblnombre.setText(nombre);
					vm.lblapellidos.setText(apellidos);					
					vm.lblroles.setText(roles);					

				}
				
			}
		}else  if (boton == btnSalir) {
			System.exit(0);
		}
	
	}
	/**
	 * 
	 * 
	 * @param fg hacer que el campo de texto se seleccione
	 */
	public void focusGained(FocusEvent fg) {
		JTextComponent txt = (JTextComponent) fg.getSource();
		txt.select(0, txt.getText().length());
	}
	/**
	 * 
	 * 
	 * @param f1 hacer que el campo de texto se seleccione
	 */
	public void focusLost(FocusEvent fl) {
		JTextComponent txt = (JTextComponent) fl.getSource();
		txt.select(0, 0);
	}
}
