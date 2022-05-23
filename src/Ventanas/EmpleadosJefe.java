package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPasswordField;
/**
* Ventana para visualiar la empleados jefe
* @author Grupo 4 
*/
public class EmpleadosJefe extends Login implements Runnable, ActionListener, ListSelectionListener {

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
	private JMenuItem Vehiculos, Clientes, Empleados, Ordenes, Menu, ayuda;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNIf;
	private JLabel lblTelefono;
	private JLabel lblMail;
	private JLabel lblDireccion;
	private JLabel lblProvincia;
	private JLabel lblNombreEm;
	private JLabel lblEmpresa;
	private JLabel lblNombreempresa;
	private JLabel lbldirec;
	private JLabel lblprovi;
	private JLabel lblphone;
	private JLabel lblNewLabel_14;
	private JLabel lblNIFem;
	private JPanel panel_1;
	private JLabel lblNewLabel_19;
	private JLabel lblDni;
	private JLabel lblNombrecli;
	private JLabel lblCorreo;
	private JLabel lblApellidos;
	private JLabel lblEstado;
	private JLabel lbltele;
	private JLabel lbldir;
	private JLabel lblfecha;
	private JTextField txtDni;
	private JTextField txtFechaAlta;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JComboBox<String> cmbEstado;
	private JPanel panel_2;
	private JPanel panel_3;
	protected JButton btnAgregar;
	protected JButton btnModifiacar;
	protected JButton btnBorrar;
	protected JButton btnVaciar;
	private JPanel panel_4;
	private JButton btnCerrarSesion;
	// Base de datos
	private ResultSet rs;
	private Connection conexion;
	// DefaultTableModel
	private DefaultTableModel dtmTabla;
	// cuerpo de la tabla
	@SuppressWarnings("unused")
	private Vector<Vector<String>> datosTabla;
	@SuppressWarnings("unused")
	private Vector<String> nombresColumnas;
	private JTable table;
	private String Codactual;
	private String Codactual1;

	private int filaseleccionada;

	boolean modificado = false;

	private String dnim;
	private String estadom;
	private String nombrem;
	private String apellidom;
	private String correom;
	private String direccionm;
	private String fechaAltam;
	private String telefonom;
	private String FechaAlta;
	private String Idm;
	private String rolm;
	private String Contram;
	private String DniJm;
	private String Salariom;
	private String FechNacm;
	private String Comisionm;
	private String TEmpleadom;

	private String dniI;
	private String estadoI;
	private String nombreI;
	private String apellidosI;
	private String correoI;
	private String telefonoI;
	private String direccionI;
	private String fechaAltaI;
	private String IdI;
	private String rolI;
	private String ContraI;
	private String DniJI;
	private String SalarioI;
	private String FechNacI;
	private String ComisionI;
	private String TEmpleadoI;

	private String Dni;
	private String Estado;
	private String Nombre;
	private String Apellido;
	private String Correo;
	private String Telefono;
	private String Direccion;
	private String Id;
	private String rol;
	private String Contra;
	private String DniJ;
	private String Salario;
	private String FechNac;
	private String Comision;
	private String TEmpleado;

	private JLabel lblid;
	private JLabel lblFN;
	protected JTextField txtId;
	private JTextField txtFechNac;
	private JComboBox<String> cmbEmpleado;
	private JLabel lblTE;
	protected JLabel lblsalario;
	protected JLabel lblComision;
	private JLabel lblRol;
	private JLabel lbldnij;
	private JTextField txtrol;
	private JTextField txtDniJ;
	protected JTextField txtSalario;
	protected JTextField txtComision;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	protected int numeroroles;
	protected String Usuario;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Create the frame.
	 * 
	 * @param EmpleadosJefe
	 * @throws SQLException
	 */
	public EmpleadosJefe() {
		setForeground(Color.WHITE);
		setTitle("RekordAutoak - Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 836);

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

		panelcentral = new JPanel();
		panelcentral.setBackground(Color.GRAY);
		Panel1.add(panelcentral, BorderLayout.CENTER);
		panelcentral.setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setBackground(Color.LIGHT_GRAY);
		panelcentral.add(splitPane, BorderLayout.NORTH);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 291, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel_12 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 0;
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);

		lblNewLabel_10 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 1;
		panel.add(lblNewLabel_10, gbc_lblNewLabel_10);

		lblEmpresa = new JLabel("Datos Empresa: ");
		lblEmpresa.setForeground(Color.WHITE);
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
		gbc_lblEmpresa.gridwidth = 2;
		gbc_lblEmpresa.anchor = GridBagConstraints.WEST;
		gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpresa.gridx = 1;
		gbc_lblEmpresa.gridy = 1;
		panel.add(lblEmpresa, gbc_lblEmpresa);

		lblNombreEm = new JLabel("Nombre       ");
		lblNombreEm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreEm.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNombreEm = new GridBagConstraints();
		gbc_lblNombreEm.anchor = GridBagConstraints.WEST;
		gbc_lblNombreEm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEm.gridx = 1;
		gbc_lblNombreEm.gridy = 2;
		panel.add(lblNombreEm, gbc_lblNombreEm);

		lblNombreempresa = new JLabel("Rekord Autoak");
		lblNombreempresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreempresa.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNombreempresa = new GridBagConstraints();
		gbc_lblNombreempresa.anchor = GridBagConstraints.WEST;
		gbc_lblNombreempresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreempresa.gridx = 2;
		gbc_lblNombreempresa.gridy = 2;
		panel.add(lblNombreempresa, gbc_lblNombreempresa);

		lblNewLabel_11 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 3;
		gbc_lblNewLabel_11.gridy = 2;
		panel.add(lblNewLabel_11, gbc_lblNewLabel_11);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.WEST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 3;
		panel.add(lblDireccion, gbc_lblDireccion);

		lbldirec = new JLabel("Garat Txomin Hiribidea, 6, 48004 Bilbo, Bizakaia");
		lbldirec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldirec.setForeground(Color.WHITE);
		GridBagConstraints gbc_lbldirec = new GridBagConstraints();
		gbc_lbldirec.anchor = GridBagConstraints.WEST;
		gbc_lbldirec.insets = new Insets(0, 0, 5, 5);
		gbc_lbldirec.gridx = 2;
		gbc_lbldirec.gridy = 3;
		panel.add(lbldirec, gbc_lbldirec);

		lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvincia.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.anchor = GridBagConstraints.WEST;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 4;
		panel.add(lblProvincia, gbc_lblProvincia);

		lblprovi = new JLabel("Vizcaya");
		lblprovi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblprovi.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblprovi = new GridBagConstraints();
		gbc_lblprovi.anchor = GridBagConstraints.WEST;
		gbc_lblprovi.insets = new Insets(0, 0, 5, 5);
		gbc_lblprovi.gridx = 2;
		gbc_lblprovi.gridy = 4;
		panel.add(lblprovi, gbc_lblprovi);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 5;
		panel.add(lblTelefono, gbc_lblTelefono);

		lblphone = new JLabel("+34 666 777 888");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblphone.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblphone = new GridBagConstraints();
		gbc_lblphone.anchor = GridBagConstraints.WEST;
		gbc_lblphone.insets = new Insets(0, 0, 5, 5);
		gbc_lblphone.gridx = 2;
		gbc_lblphone.gridy = 5;
		panel.add(lblphone, gbc_lblphone);

		lblMail = new JLabel("Correo");
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 6;
		panel.add(lblMail, gbc_lblMail);

		lblNewLabel_14 = new JLabel("contacto@rekordautoak.com");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 2;
		gbc_lblNewLabel_14.gridy = 6;
		panel.add(lblNewLabel_14, gbc_lblNewLabel_14);

		lblNIf = new JLabel("NIF");
		lblNIf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNIf.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNIf = new GridBagConstraints();
		gbc_lblNIf.anchor = GridBagConstraints.WEST;
		gbc_lblNIf.insets = new Insets(0, 0, 0, 5);
		gbc_lblNIf.gridx = 1;
		gbc_lblNIf.gridy = 7;
		panel.add(lblNIf, gbc_lblNIf);

		lblNIFem = new JLabel("89526899S");
		lblNIFem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNIFem.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNIFem = new GridBagConstraints();
		gbc_lblNIFem.insets = new Insets(0, 0, 0, 5);
		gbc_lblNIFem.anchor = GridBagConstraints.WEST;
		gbc_lblNIFem.gridx = 2;
		gbc_lblNIFem.gridy = 7;
		panel.add(lblNIFem, gbc_lblNIFem);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 115, 169, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel_8 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 0;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);

		lblNewLabel_19 = new JLabel("Datos Empleados:");
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 1;
		gbc_lblNewLabel_19.gridy = 1;
		panel_1.add(lblNewLabel_19, gbc_lblNewLabel_19);

		lblNewLabel_7 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);

		lblid = new JLabel("Id");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblid.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.anchor = GridBagConstraints.WEST;
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.gridx = 1;
		gbc_lblid.gridy = 2;
		panel_1.add(lblid, gbc_lblid);

		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 2;
		panel_1.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		lblFN = new JLabel("Fecha Nacimiento");
		lblFN.setForeground(Color.WHITE);
		lblFN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFN = new GridBagConstraints();
		gbc_lblFN.anchor = GridBagConstraints.WEST;
		gbc_lblFN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFN.gridx = 4;
		gbc_lblFN.gridy = 2;
		panel_1.add(lblFN, gbc_lblFN);

		txtFechNac = new JTextField();
		GridBagConstraints gbc_txtFechNac = new GridBagConstraints();
		gbc_txtFechNac.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechNac.gridx = 5;
		gbc_txtFechNac.gridy = 2;
		panel_1.add(txtFechNac, gbc_txtFechNac);
		txtFechNac.setColumns(10);

		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 3;
		panel_1.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 3;
		panel_1.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);

		lblRol = new JLabel("Rol");
		lblRol.setForeground(Color.WHITE);
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.WEST;
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 4;
		gbc_lblRol.gridy = 3;
		panel_1.add(lblRol, gbc_lblRol);

		txtrol = new JTextField();
		GridBagConstraints gbc_txtrol = new GridBagConstraints();
		gbc_txtrol.insets = new Insets(0, 0, 5, 0);
		gbc_txtrol.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtrol.gridx = 5;
		gbc_txtrol.gridy = 3;
		panel_1.add(txtrol, gbc_txtrol);
		txtrol.setColumns(10);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 4;
		panel_1.add(lblCorreo, gbc_lblCorreo);

		txtCorreo = new JTextField();
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 4;
		panel_1.add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);

		lblTE = new JLabel("Tipo Empleado");
		lblTE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTE.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTE = new GridBagConstraints();
		gbc_lblTE.insets = new Insets(0, 0, 5, 5);
		gbc_lblTE.anchor = GridBagConstraints.WEST;
		gbc_lblTE.gridx = 4;
		gbc_lblTE.gridy = 4;
		panel_1.add(lblTE, gbc_lblTE);

		cmbEmpleado = new JComboBox<String>();
		GridBagConstraints gbc_cmbEmpleado = new GridBagConstraints();
		gbc_cmbEmpleado.insets = new Insets(0, 0, 5, 0);
		gbc_cmbEmpleado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEmpleado.gridx = 5;
		gbc_cmbEmpleado.gridy = 4;
		panel_1.add(cmbEmpleado, gbc_cmbEmpleado);

		cmbEmpleado.addItem("Mecanico");
		cmbEmpleado.addItem("Recepcionista");
		cmbEmpleado.addItem("Administrador");
		cmbEmpleado.addItem("Jefe");

		lbldnij = new JLabel("Dni Jefe");
		lbldnij.setForeground(Color.WHITE);
		lbldnij.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbldnij = new GridBagConstraints();
		gbc_lbldnij.anchor = GridBagConstraints.WEST;
		gbc_lbldnij.insets = new Insets(0, 0, 5, 5);
		gbc_lbldnij.gridx = 1;
		gbc_lbldnij.gridy = 5;
		panel_1.add(lbldnij, gbc_lbldnij);

		txtDniJ = new JTextField();
		GridBagConstraints gbc_txtDniJ = new GridBagConstraints();
		gbc_txtDniJ.insets = new Insets(0, 0, 5, 5);
		gbc_txtDniJ.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDniJ.gridx = 2;
		gbc_txtDniJ.gridy = 5;
		panel_1.add(txtDniJ, gbc_txtDniJ);
		txtDniJ.setColumns(10);

		lbldir = new JLabel("Direccion");
		lbldir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldir.setForeground(Color.WHITE);
		GridBagConstraints gbc_lbldir = new GridBagConstraints();
		gbc_lbldir.anchor = GridBagConstraints.WEST;
		gbc_lbldir.insets = new Insets(0, 0, 5, 5);
		gbc_lbldir.gridx = 4;
		gbc_lbldir.gridy = 5;
		panel_1.add(lbldir, gbc_lbldir);

		txtDireccion = new JTextField();
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 5;
		gbc_txtDireccion.gridy = 5;
		panel_1.add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);

		lbltele = new JLabel("Telefono");
		lbltele.setForeground(Color.WHITE);
		lbltele.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbltele = new GridBagConstraints();
		gbc_lbltele.anchor = GridBagConstraints.WEST;
		gbc_lbltele.insets = new Insets(0, 0, 5, 5);
		gbc_lbltele.gridx = 1;
		gbc_lbltele.gridy = 6;
		panel_1.add(lbltele, gbc_lbltele);

		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 2;
		gbc_txtTelefono.gridy = 6;
		panel_1.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);

		lblfecha = new JLabel("Fecha de Alta");
		lblfecha.setForeground(Color.WHITE);
		lblfecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblfecha = new GridBagConstraints();
		gbc_lblfecha.anchor = GridBagConstraints.WEST;
		gbc_lblfecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblfecha.gridx = 4;
		gbc_lblfecha.gridy = 6;
		panel_1.add(lblfecha, gbc_lblfecha);

		txtFechaAlta = new JTextField();
		GridBagConstraints gbc_txtFechaAlta = new GridBagConstraints();
		gbc_txtFechaAlta.anchor = GridBagConstraints.NORTH;
		gbc_txtFechaAlta.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaAlta.gridx = 5;
		gbc_txtFechaAlta.gridy = 6;
		panel_1.add(txtFechaAlta, gbc_txtFechaAlta);
		txtFechaAlta.setColumns(10);

		lblNombrecli = new JLabel("Nombre");
		lblNombrecli.setForeground(Color.WHITE);
		lblNombrecli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombrecli = new GridBagConstraints();
		gbc_lblNombrecli.anchor = GridBagConstraints.WEST;
		gbc_lblNombrecli.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombrecli.gridx = 1;
		gbc_lblNombrecli.gridy = 7;
		panel_1.add(lblNombrecli, gbc_lblNombrecli);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 7;
		panel_1.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 4;
		gbc_lblEstado.gridy = 7;
		panel_1.add(lblEstado, gbc_lblEstado);

		cmbEstado = new JComboBox<String>();
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cmbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEstado.gridx = 5;
		gbc_cmbEstado.gridy = 7;
		panel_1.add(cmbEstado, gbc_cmbEstado);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 8;
		panel_1.add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 2;
		gbc_txtApellidos.gridy = 8;
		panel_1.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);

		lblComision = new JLabel("Comision");
		lblComision.setForeground(Color.WHITE);
		lblComision.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblComision = new GridBagConstraints();
		gbc_lblComision.anchor = GridBagConstraints.WEST;
		gbc_lblComision.insets = new Insets(0, 0, 5, 5);
		gbc_lblComision.gridx = 4;
		gbc_lblComision.gridy = 8;
		panel_1.add(lblComision, gbc_lblComision);

		txtComision = new JTextField();
		GridBagConstraints gbc_txtComision = new GridBagConstraints();
		gbc_txtComision.insets = new Insets(0, 0, 5, 0);
		gbc_txtComision.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtComision.gridx = 5;
		gbc_txtComision.gridy = 8;
		panel_1.add(txtComision, gbc_txtComision);
		txtComision.setColumns(10);

		lblsalario = new JLabel("Salario Base");
		lblsalario.setForeground(Color.WHITE);
		lblsalario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblsalario = new GridBagConstraints();
		gbc_lblsalario.anchor = GridBagConstraints.WEST;
		gbc_lblsalario.insets = new Insets(0, 0, 5, 5);
		gbc_lblsalario.gridx = 1;
		gbc_lblsalario.gridy = 9;
		panel_1.add(lblsalario, gbc_lblsalario);

		txtSalario = new JTextField();
		GridBagConstraints gbc_txtSalario = new GridBagConstraints();
		gbc_txtSalario.insets = new Insets(0, 0, 5, 5);
		gbc_txtSalario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSalario.gridx = 2;
		gbc_txtSalario.gridy = 9;
		panel_1.add(txtSalario, gbc_txtSalario);
		txtSalario.setColumns(10);

		lblNewLabel_9 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 10;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);

		cmbEstado.addItem("activo");
		cmbEstado.addItem("inactivo");

		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panelcentral.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_2.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 83, 0, 85, 0, 85, 0, 85, 85, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 21, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNewLabel_1 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel_2 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);

		btnAgregar = new JButton("Agregar Empleado");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 1;
		panel_3.add(btnAgregar, gbc_btnAgregar);

		// actionlsitener

		btnAgregar.addActionListener(this);

		lblNewLabel_3 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);

		btnModifiacar = new JButton("Modificar Empleado");
		GridBagConstraints gbc_btnModifiacar = new GridBagConstraints();
		gbc_btnModifiacar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnModifiacar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifiacar.gridx = 3;
		gbc_btnModifiacar.gridy = 1;
		panel_3.add(btnModifiacar, gbc_btnModifiacar);
		btnModifiacar.addActionListener(this);

		lblNewLabel_4 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 1;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);

		btnBorrar = new JButton("Borrar Empleado");
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 5;
		gbc_btnBorrar.gridy = 1;
		panel_3.add(btnBorrar, gbc_btnBorrar);
		btnBorrar.addActionListener(this);

		lblNewLabel_5 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 1;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);

		btnVaciar = new JButton("Vaciar Empleado");
		GridBagConstraints gbc_btnVaciar = new GridBagConstraints();
		gbc_btnVaciar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVaciar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnVaciar.gridx = 7;
		gbc_btnVaciar.gridy = 1;
		panel_3.add(btnVaciar, gbc_btnVaciar);

		lblNewLabel_13 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 2;
		panel_3.add(lblNewLabel_13, gbc_lblNewLabel_13);
		btnVaciar.addActionListener(this);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_2.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		btnCerrarSesion = new JButton("Cerrar Sesion");
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.anchor = GridBagConstraints.EAST;
		gbc_btnCerrarSesion.gridwidth = 33;
		gbc_btnCerrarSesion.gridx = 0;
		gbc_btnCerrarSesion.gridy = 0;
		panel_4.add(btnCerrarSesion, gbc_btnCerrarSesion);
		btnCerrarSesion.addActionListener(this);

		panelarriba = new JPanel();
		panelarriba.setBackground(Color.GRAY);
		Panel1.add(panelarriba, BorderLayout.NORTH);
		GridBagLayout gbl_panelarriba = new GridBagLayout();
		gbl_panelarriba.columnWidths = new int[] { 0, 0, -15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panelarriba.rowHeights = new int[] { 0, 0 };
		gbl_panelarriba.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelarriba.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelarriba.setLayout(gbl_panelarriba);

		lblNewLabel = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelarriba.add(lblNewLabel, gbc_lblNewLabel);

		lbl = new JLabel();
		lbl.setIcon(new ImageIcon(EmpleadosJefe.class.getResource("/resources/user-png-icon.png")));
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
		lblr.setIcon(new ImageIcon(EmpleadosJefe.class.getResource("/resources/rola.png")));
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

		// creo el vector para los datos de la tabla
		datosTabla = new Vector<Vector<String>>();
		tabladatos();
		h1 = new Thread(this);
		h1.start();
		setLocationRelativeTo(null);
		setVisible(true);
		run();

	}
	/**
	 * 
	 * conexion con la base de datos
	 * 
	 */
	public void tabladatos() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = st.executeQuery("SELECT * FROM rekordautoak.empleado;");

			// cabeceras de las columnas
			Vector<String> nombresColumnas = new Vector<String>();

			nombresColumnas.add("id");
			nombresColumnas.add("dniEmple");
			nombresColumnas.add("dniJefe");
			nombresColumnas.add("email");
			nombresColumnas.add("telefono");
			nombresColumnas.add("salBase");
			nombresColumnas.add("comision");
			nombresColumnas.add("nombre");
			nombresColumnas.add("apellidos");
			nombresColumnas.add("fecNac");
			nombresColumnas.add("direccion");
			nombresColumnas.add("tipoEmpleado");
			nombresColumnas.add("fecAltaContrato");
			nombresColumnas.add("estado");
			nombresColumnas.add("idRole");

			dtmTabla = new DefaultTableModel(datosTabla, nombresColumnas){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
				// hago que todas las celdas de la tabla NO sean editables
				return false;
				}
			};
			dtmTabla.setColumnIdentifiers(nombresColumnas);
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();

				fila.add(rs.getString("id"));
				fila.add(rs.getString("dniEmple"));
				fila.add(rs.getString("dniJefe"));
				fila.add(rs.getString("email"));
				fila.add(rs.getString("telefono"));
				fila.add(rs.getString("salBase"));
				fila.add(rs.getString("comision"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("apellidos"));
				fila.add(rs.getString("fecNac"));
				fila.add(rs.getString("direccion"));
				fila.add(rs.getString("tipoEmpleado"));
				fila.add(rs.getString("fecAltaContrato"));
				fila.add(rs.getString("estado"));
				fila.add(rs.getString("idRole"));

				dtmTabla.addRow(fila);

			}

			table = new JTable(dtmTabla);
			table.setBackground(Color.LIGHT_GRAY);
			table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			table.setFont(new Font("Tahoma", Font.BOLD, 14));
			table.setForeground(Color.BLACK);
			table.setRowHeight(20);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.getSelectionModel().addListSelectionListener(this);
			
			// ordenaciÃ³n
			table.setAutoCreateRowSorter(true);
			TableRowSorter<TableModel> metodoOrdenacion = new TableRowSorter<TableModel>(dtmTabla);

			table.setRowSorter(metodoOrdenacion);
			List<RowSorter.SortKey> sortKeys = new ArrayList<>();

			int columnaOrdenacion = 0;
			sortKeys.add(new RowSorter.SortKey(columnaOrdenacion, SortOrder.ASCENDING));
			metodoOrdenacion.setSortKeys(sortKeys);
			metodoOrdenacion.sort();

			JScrollPane scrollTabla = new JScrollPane();
			scrollTabla.setForeground(Color.BLACK);
			scrollTabla.setBackground(Color.LIGHT_GRAY);
			scrollTabla.setViewportView(table);
			panel_2.add(scrollTabla);

			st.close();
			rs.close();
			conexion.close();
			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			// podemos poner un filtro por grupo para sacar solo los alumnos de 1DW3

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

		}
		// creo el default model de la tabla

		// para que ordene por la primera columna (dni en este caso) en Ascendente

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
	 * insertar EMPLEADO en la base de datos y en la tabla
	 * 
	 */
	public void insertarEmpleado() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();

			String consulta = "Insert into rekordautoak.empleado VALUES('" + IdI + "','" + dniI + "','" + DniJI + "','"
					+ correoI + "','" + ContraI + "','" + telefonoI + "','" + SalarioI + "','" + ComisionI + "','"
					+ nombreI + "','" + apellidosI + "','" + FechNacI + "','" + direccionI + "','" + TEmpleadoI + "','"
					+ fechaAltaI + "','" + estadoI + "','" + rolI + "');";
			st.executeUpdate(consulta);
			modificado = true;
			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			// si inserto correctamente en la base de datos

		} catch (SQLException e) {
			// si se produce una excepción SQL
			int errorcode = e.getErrorCode();
			if (errorcode == 1062) {
				// si es un error de clave suplicada
				JOptionPane.showMessageDialog(this,
						(String) "Error Clave Duplicada. Ya existe un registro con esa clave.", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);

			} else {

				JOptionPane.showMessageDialog(this,
						(String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(), "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}
	/** 
	 * @param textField 
	 * @return si el campo esta vacio mostrar error o si esta lleno
	 */

	private boolean verificarCampos(JTextField textField) {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo debe ser rellenado", "Error", JOptionPane.ERROR_MESSAGE);
			textField.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 
	 * vaciar empleados de la base de datos y el programa
	 */
	private void vaciarEmpleado() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			consulta = "DELETE from rekordautoak.empleado ;";
			st.executeUpdate(consulta);
			modificado = true;

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			// si borro correctamente en la base de datos
			// lo borro tambien en la tabla

		} catch (SQLException e) {
			@SuppressWarnings("unused")
			int errorcode = e.getErrorCode();

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);
		}

	}
	/**
	 * 
	 * eliminiar el empleado seleccionada de la base de datos y el programa 
	 * 
	 * 
	 */
	public void eliminarEmpleado() {
		try {
			// CONECTO LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			String idemple;

			idemple = txtId.getText();

			consulta = "DELETE from empleado  WHERE id='" + idemple + "';";
			st.executeUpdate(consulta);
			modificado = true;

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();
			JOptionPane.showMessageDialog(this,
					(String) "Se a borrado el empleado seleccionada " +idemple+ " ",
					"Borrado", JOptionPane.INFORMATION_MESSAGE, null);
			// si borro correctamente en la base de datos
			// lo borro tambien en la tabla
			dtmTabla.removeRow(filaseleccionada);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, (String) "Error, no hay ningún elemento seleccionado", "Error",
					JOptionPane.INFORMATION_MESSAGE, null);

		}

	}

/** 
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
	 * 
	 * Modificar el empleado seleccionada en la tabla y modificar datos
	 * 
	 */
	public void modificarEmpleado() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();

			String consulta = "UPDATE cliente SET id='" + Idm + "' , dniJefe='" + DniJm + "' , email ='" + correom
					+ "' , password ='" + Contram + "', telefono = '" + telefonom + "', salBase = '" + Salariom
					+ "', comision = '" + Comisionm + "' , nombre='" + nombrem + "' , apellidos='" + apellidom
					+ "' , fecNac='" + FechNacm + "' , direccion='" + direccionm + "', tipoEmpleado='" + TEmpleadom
					+ "', fecAltaContrato='" + fechaAltam + "', estado='" + estadom + "', idRole='" + rolm
					+ "' WHERE dniEmple = '" + Dni + "';";

			st.executeUpdate(consulta);

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			if (Id != estadom) {
				dtmTabla.setValueAt(Idm, filaseleccionada, 0);

			}
			if (DniJ != DniJm) {
				dtmTabla.setValueAt(DniJm, filaseleccionada, 2);

			}
			if (Correo != correom) {
				dtmTabla.setValueAt(correom, filaseleccionada, 3);

			}
			if (Contra != Contram) {
				dtmTabla.setValueAt(Contram, filaseleccionada, 4);

			}
			if (Telefono != telefonom) {
				dtmTabla.setValueAt(telefonom, filaseleccionada, 5);

			}
			if (Salario != Salariom) {
				dtmTabla.setValueAt(Salariom, filaseleccionada, 6);

			}
			if (Comision != Comisionm) {
				dtmTabla.setValueAt(Comisionm, filaseleccionada, 7);

			}
			if (Nombre != nombrem) {
				dtmTabla.setValueAt(nombrem, filaseleccionada, 8);

			}
			if (Apellido != apellidom) {
				dtmTabla.setValueAt(apellidom, filaseleccionada, 9);

			}
			if (FechNac != FechNacm) {
				dtmTabla.setValueAt(FechNacm, filaseleccionada, 10);

			}
			if (Direccion != direccionm) {
				dtmTabla.setValueAt(direccionm, filaseleccionada, 11);

			}
			if (TEmpleado != TEmpleadom) {
				dtmTabla.setValueAt(TEmpleadom, filaseleccionada, 12);

			}
			if (FechaAlta != fechaAltam) {
				dtmTabla.setValueAt(fechaAltam, filaseleccionada, 13);

			}
			if (Estado != estadom) {
				dtmTabla.setValueAt(estadom, filaseleccionada, 14);

			}
			if (rol != rolm) {
				dtmTabla.setValueAt(rolm, filaseleccionada, 15);

			}

		} catch (SQLException e) {
			// si se produce una excepción SQL
			@SuppressWarnings("unused")
			int errorcode = e.getErrorCode();

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

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
		int numeroroles = Integer.valueOf(emple);

		if (numeroroles >= 10000 && numeroroles <= 29999) {

			if (boton == btnCerrarSesion) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				JOptionPane.showMessageDialog(this,
						"Sesion Finalizada, Hasta la proxima " + nombre + " " + apellido + " tenga un buen dia");
				Login vm = new Login();
				vm.setVisible(true);
				this.dispose();

			} else if (boton == Clientes) {

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

			} else if (boton == Menu) {
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

			} else if (boton == ayuda) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				ayudaE vm = new ayudaE();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaE.class.getResource("/resources/empleados_bueno.png")));

				this.dispose();
			}

		}

		else if (numeroroles >= 30000 && numeroroles <= 49999) {

			if (boton == btnCerrarSesion) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				JOptionPane.showMessageDialog(this,
						"Sesion Finalizada, Hasta la proxima " + nombre + " " + apellido + " tenga un buen dia");
				Login vm = new Login();
				vm.setVisible(true);
				this.dispose();

			} else if (boton == Clientes) {

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

			} else if (boton == Menu) {
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

			} else if (boton == ayuda) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				ayudaE vm = new ayudaE();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaE.class.getResource("/resources/empleados_bueno.png")));

				this.dispose();
			}

		} else if (numeroroles >= 50000 && numeroroles <= 69999) {

			if (boton == btnCerrarSesion) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				JOptionPane.showMessageDialog(this,
						"Sesion Finalizada, Hasta la proxima " + nombre + " " + apellido + " tenga un buen dia");
				Login vm = new Login();
				vm.setVisible(true);

				this.dispose();

			} else if (boton == Clientes) {

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
				vm.lbl.setVisible(true);
				vm.setVisible(true);

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

			} else if (boton == Menu) {
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

			} else if (boton == ayuda) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				ayudaE vm = new ayudaE();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaE.class.getResource("/resources/empleados_bueno.png")));

				this.dispose();
			}
		} else if (numeroroles == 90000) {

			if (boton == btnCerrarSesion) {

				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				JOptionPane.showMessageDialog(this,
						"Sesion Finalizada, Hasta la proxima " + nombre + " " + apellido + " tenga un buen dia");
				Login vm = new Login();
				vm.setVisible(true);
				this.dispose();

			} else if (boton == Clientes) {

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

			} else if (boton == Menu) {
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

			} else if (boton == ayuda) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				ayudaE vm = new ayudaE();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaE.class.getResource("/resources/empleados_bueno.png")));

				this.dispose();
			}
		}

		if (boton == btnAgregar)  {

			if (verificarCampos(txtId)) {
				IdI = txtId.getText();

				if (IdI.matches("[0-9]{5,5}")) {

					if (verificarCampos(txtDni)) {
						dniI = txtDni.getText();
						if (dniI.matches("[0-9]{7,8}[A-Za-z]")) {

							if (verificarCampos(txtDniJ)) {
								DniJI = txtDniJ.getText();
								if (DniJI.matches("[0-9]{7,8}[A-Za-z]")) {

									if (verificarCampos(txtCorreo)) {
										correoI = txtCorreo.getText();
										if (correoI.matches(
												"[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}")) {

													if (verificarCampos(txtSalario)) {
														SalarioI = txtSalario.getText();
														if (SalarioI.matches("[0-9]{3,10}\\.[0-9]{0,2}")) {

															if (verificarCampos(txtComision)) {
																ComisionI = txtComision.getText();
																if (ComisionI.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {

																	if (verificarCampos(txtTelefono)) {
																		telefonoI = txtTelefono.getText();
																		if (telefonoI.matches("[0-9+]{8,12}")) {

																			if (verificarCampos(txtNombre)) {
																				nombreI = txtNombre.getText();
																				if (nombreI.matches("[a-zA-Z]{2,64}")) {

																					if (verificarCampos(txtApellidos)) {
																						apellidosI = txtApellidos
																								.getText();
																						if (apellidosI.matches(
																								"[a-zA-Z]{2,128}")) {

																							if (verificarCampos(
																									txtFechNac)) {
																								FechNacI = txtFechNac
																										.getText();
																								if (FechNacI.matches(
																										"^\\d{4}-\\d{2}-\\d{2}$")) {

																									if (verificarCampos(
																											txtDireccion)) {
																										direccionI = txtDireccion
																												.getText();
																										if (direccionI
																												.matches(
																														"[a-zA-Z0-9_ ]{1,255}")) {

																											if (verificarCampos(
																													txtFechaAlta)) {
																												fechaAltaI = txtFechaAlta
																														.getText();
																												if (fechaAltaI
																														.matches(
																																"^\\d{4}-\\d{2}-\\d{2}$")) {
																													TEmpleadoI = (String) cmbEmpleado
																															.getSelectedItem();

																													if (TEmpleadoI == "Mecanico") {

																														txtrol.setText(
																																"1");

																													}
																													if (TEmpleadoI == "Recepcionista") {

																														txtrol.setText(
																																"2");

																													}
																													if (TEmpleadoI == "Administrador") {

																														txtrol.setText(
																																"3");

																													}
																													if (TEmpleadoI == "Jefe") {

																														txtrol.setText(
																																"4");

																													}

																													rolI = txtrol
																															.getText();
																													estadoI = (String) cmbEstado
																															.getSelectedItem();

																													insertarEmpleado();
																													if (modificado) {

																														Vector<String> fila = new Vector<String>();
																														fila.add(
																																IdI);
																														fila.add(
																																dniI);
																														fila.add(
																																DniJ);
																														fila.add(
																																correoI);
																														fila.add(
																																ContraI);
																														fila.add(
																																telefonoI);
																														fila.add(
																																SalarioI);
																														fila.add(
																																ComisionI);
																														fila.add(
																																nombreI);
																														fila.add(
																																apellidosI);
																														fila.add(
																																FechNacI);
																														fila.add(
																																direccionI);
																														fila.add(
																																TEmpleadoI);
																														fila.add(
																																fechaAltaI);
																														fila.add(
																																estadoI);
																														fila.add(
																																rolI);

																														dtmTabla.addRow(
																																fila);

																														modificado = false;
																														JOptionPane.showMessageDialog(this,
																																(String) "El Empleado con ID " + IdI
																																		+ " se a insertado correctamente",
																																"Empleado Insertado", JOptionPane.INFORMATION_MESSAGE, null);	
																													}
																												} else {
																													JOptionPane
																															.showMessageDialog(
																																	this,
																																	(String) "Error. La fecha "
																																			+ fechaAltaI
																																			+ " es erroneo debe ser una fecha tipo YYYY-MM-DD",
																																	"ERROR",
																																	JOptionPane.ERROR_MESSAGE,
																																	null);
																													txtFechaAlta
																															.requestFocus();

																												}
																											}
																										} else {
																											JOptionPane
																													.showMessageDialog(
																															this,
																															(String) "Error. La direccion "
																																	+ direccionI
																																	+ " es erroneo debe ser minimo de 1 y maximo 255 caracteres",
																															"ERROR",
																															JOptionPane.ERROR_MESSAGE,
																															null);
																											txtDireccion
																													.requestFocus();

																										}
																									}
																								} else {
																									JOptionPane
																											.showMessageDialog(
																													this,
																													(String) "Error. La fecha "
																															+ FechNacI
																															+ " es erroneo debe ser una fecha tipo YYYY-MM-DD",
																													"ERROR",
																													JOptionPane.ERROR_MESSAGE,
																													null);
																									txtFechNac
																											.requestFocus();

																								}
																							}
																						} else {
																							JOptionPane
																									.showMessageDialog(
																											this,
																											(String) "Error. El apellido "
																													+ apellidosI
																													+ " es erroneo debe ser  minimo 2 y maximo de 128 caracteres",
																											"ERROR",
																											JOptionPane.ERROR_MESSAGE,
																											null);
																							txtApellidos.requestFocus();

																						}
																					}
																				} else {
																					JOptionPane.showMessageDialog(this,
																							(String) "Error. El nombre "
																									+ nombreI
																									+ " es erroneo debe ser  minimo 2 y maximo de 64 caracteres",
																							"ERROR",
																							JOptionPane.ERROR_MESSAGE,
																							null);
																					txtNombre.requestFocus();

																				}
																			}
																		} else {
																			JOptionPane.showMessageDialog(this,
																					(String) "Error. El telefono "
																							+ telefonoI
																							+ " es erroneo debe ser numeros  y minimo de 8 y maximo 12 caracteres",
																					"ERROR", JOptionPane.ERROR_MESSAGE,
																					null);
																			txtTelefono.requestFocus();

																		}
																	}
																} else {
																	JOptionPane.showMessageDialog(this,
																			(String) "Error. La comision " + ComisionI
																					+ " es erroneo debe ser numeros  y minimo de 0 y maximo 10 caracteres",
																			"ERROR", JOptionPane.ERROR_MESSAGE, null);
																	txtComision.requestFocus();

																}
															}
														} else {
															JOptionPane.showMessageDialog(this,
																	(String) "Error. El salario " + SalarioI
																			+ " es erroneo debe ser numeros  y minimo de 3 y maximo 10 caracteres",
																	"ERROR", JOptionPane.ERROR_MESSAGE, null);
															txtSalario.requestFocus();

												}																				
											}
										} else {
											JOptionPane.showMessageDialog(this,
													(String) "Error. El Correo " + correoI
															+ " es erroneo debe tener yyyyyy@ssss.zzzz",
													"ERROR", JOptionPane.ERROR_MESSAGE, null);
											txtCorreo.requestFocus();

										}
									}
								} else {
									JOptionPane.showMessageDialog(this,
											(String) "Error. El dni JEFE " + DniJI
													+ " es erroneo debe ser 7 o 8 numeros y alfinal una letra",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
									txtDniJ.requestFocus();

								}
							}
						} else {
							JOptionPane.showMessageDialog(this,
									(String) "Error. El dni " + dniI
											+ " es erroneo debe ser 7 o 8 numeros y alfinal una letra",
									"ERROR", JOptionPane.ERROR_MESSAGE, null);
							txtDni.requestFocus();

						}
					}
				} else {
					JOptionPane.showMessageDialog(this,
							(String) "Error. El id " + IdI
									+ " es erroneo debe ser numeros y maximo y minimo de 5 caracteres",
							"ERROR", JOptionPane.ERROR_MESSAGE, null);
					txtId.requestFocus();

				}

			}

			// lo inserto tambien en la tabla

		}else if (boton == btnBorrar) {
			// Seleccionamos la fila
			filaseleccionada = table.getSelectedRow();
			if (filaseleccionada < 0) {
				// si no tenemos nada selccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);

			} else {
				// convertimos la fila seleccionada al valor real del dtm
				filaseleccionada = table.convertRowIndexToModel(filaseleccionada);
				eliminarEmpleado();
				txtDni.setText("");
				txtNombre.setText("");
				txtApellidos.setText("");
				txtCorreo.setText("");
				txtTelefono.setText("");
				txtDireccion.setText("");
				txtFechaAlta.setText("");
				txtComision.setText("");
				txtDniJ.setText("");
				txtrol.setText("");
				txtSalario.setText("");
				txtFechNac.setText("");
				txtId.setText("");

			}
		} else if (boton == btnModifiacar) {

			filaseleccionada = table.getSelectedRow();
			if (filaseleccionada < 0) {
				// si no tenemos nada selccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para Modificar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);

			} else {

				if (verificarCampos(txtId)) {
					Idm = txtId.getText();

					if (Idm.matches("[0-9]{5,5}")) {

						if (verificarCampos(txtDni)) {
							dnim = txtDni.getText();
							if (dnim.matches("[0-9]{7,8}[A-Za-z]")) {

								if (verificarCampos(txtDniJ)) {
									DniJm = txtDniJ.getText();
									if (DniJm.matches("[0-9]{7,8}[A-Za-z]")) {

										if (verificarCampos(txtCorreo)) {
											correom = txtCorreo.getText();
											if (correom.matches(
													"[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}")) {

												if (verificarCampos(txtSalario)) {
													Salariom = txtSalario.getText();
													if (Salariom.matches("[0-9]{3,10}\\.[0-9]{0,2}")) {

														if (verificarCampos(txtComision)) {
															Comisionm = txtComision.getText();
															if (Comisionm.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {

																if (verificarCampos(txtTelefono)) {
																	telefonom = txtTelefono.getText();
																	if (telefonom.matches("[0-9+]{8,12}")) {

																		if (verificarCampos(txtNombre)) {
																			nombrem = txtNombre.getText();
																			if (nombrem.matches("[a-zA-Z]{2,64}")) {

																				if (verificarCampos(txtApellidos)) {
																					apellidom = txtApellidos.getText();
																					if (apellidom.matches(
																							"[a-zA-Z]{2,128}")) {

																						if (verificarCampos(
																								txtFechNac)) {
																							FechNacm = txtFechNac
																									.getText();
																							if (FechNacm.matches(
																									"^\\d{4}-\\d{2}-\\d{2}$")) {

																								if (verificarCampos(
																										txtDireccion)) {
																									direccionm = txtDireccion
																											.getText();
																									if (direccionm
																											.matches(
																													"[a-zA-Z0-9_ ]{1,255}")) {

																										if (verificarCampos(
																												txtFechaAlta)) {
																											fechaAltam = txtFechaAlta
																													.getText();
																											if (fechaAltam
																													.matches(
																															"^\\d{4}-\\d{2}-\\d{2}$")) {
																												TEmpleadom = (String) cmbEmpleado
																														.getSelectedItem();

																												if (TEmpleadom == "Mecanico") {

																													txtrol.setText(
																															"1");

																												}
																												if (TEmpleadom == "Recepcionista") {

																													txtrol.setText(
																															"2");

																												}
																												if (TEmpleadom == "Administrador") {

																													txtrol.setText(
																															"3");

																												}
																												if (TEmpleadom == "Jefe") {

																													txtrol.setText(
																															"4");

																												}
																												filaseleccionada = table
																														.convertRowIndexToModel(
																																filaseleccionada);

																												rolm = txtrol
																														.getText();
																												TEmpleadom = (String) cmbEmpleado
																														.getSelectedItem();
																												estadom = (String) cmbEstado
																														.getSelectedItem();
																												Id = (String) table
																														.getValueAt(
																																filaseleccionada,
																																0);
																												Dni = (String) table
																														.getValueAt(
																																filaseleccionada,
																																1);
																												DniJ = (String) table
																														.getValueAt(
																																filaseleccionada,
																																2);
																												Correo = (String) table
																														.getValueAt(
																																filaseleccionada,
																																3);
																												Contra = (String) table
																														.getValueAt(
																																filaseleccionada,
																																4);
																												Telefono = (String) table
																														.getValueAt(
																																filaseleccionada,
																																5);
																												Salario = (String) table
																														.getValueAt(
																																filaseleccionada,
																																6);
																												Comision = (String) table
																														.getValueAt(
																																filaseleccionada,
																																7);
																												Nombre = (String) table
																														.getValueAt(
																																filaseleccionada,
																																8);
																												Apellido = (String) table
																														.getValueAt(
																																filaseleccionada,
																																9);
																												FechNac = (String) table
																														.getValueAt(
																																filaseleccionada,
																																10);
																												Direccion = (String) table
																														.getValueAt(
																																filaseleccionada,
																																11);
																												TEmpleado = (String) table
																														.getValueAt(
																																filaseleccionada,
																																12);
																												FechaAlta = (String) table
																														.getValueAt(
																																filaseleccionada,
																																13);
																												Estado = (String) table
																														.getValueAt(
																																filaseleccionada,
																																14);
																												rol = (String) table
																														.getValueAt(
																																filaseleccionada,
																																15);

																												if (dnim.equals(
																														Dni)) {
																													modificarEmpleado();
																													JOptionPane.showMessageDialog(this,
																															(String) "El Empleado con ID " + Idm
																																	+ " se a modifiacado correctamente",
																															"Empleado Modificado", JOptionPane.INFORMATION_MESSAGE, null);			
																											
																												} else {

																													JOptionPane
																															.showMessageDialog(
																																	this,
																																	(String) "Error. El dni no se puede modificar se pondra el dato correcto automaticamente",
																																	"ERROR",
																																	JOptionPane.ERROR_MESSAGE,
																																	null);
																													txtDni.setText(
																															Dni);
																												}
																											
																									}

																									else {
																										JOptionPane
																												.showMessageDialog(
																														this,
																														(String) "Error. La fecha"
																																+ fechaAltam
																																+ " es erroneo debe ser una fecha tipo YYYY-MM-DD",
																														"ERROR",
																														JOptionPane.ERROR_MESSAGE,
																														null);
																										txtFechaAlta
																												.requestFocus();

																									}
																								}
																									}else {
																									JOptionPane
																											.showMessageDialog(
																													this,
																													(String) "Error. La direccion"
																															+ direccionm
																															+ " es erroneo debe ser minimo de 1 y maximo 255 caracteres",
																													"ERROR",
																													JOptionPane.ERROR_MESSAGE,
																													null);
																									txtDireccion
																											.requestFocus();

																								}
																							}
																						} else {
																							JOptionPane
																									.showMessageDialog(
																											this,
																											(String) "Error. La fecha"
																													+ FechNacm
																													+ " es erroneo debe ser una fecha tipo YYYY-MM-DD",
																											"ERROR",
																											JOptionPane.ERROR_MESSAGE,
																											null);
																							txtFechNac.requestFocus();

																						}
																					}
																				} else {
																					JOptionPane.showMessageDialog(this,
																							(String) "Error. El apellido"
																									+ apellidom
																									+ " es erroneo debe ser  minimo 2 y maximo de 128 caracteres",
																							"ERROR",
																							JOptionPane.ERROR_MESSAGE,
																							null);
																					txtApellidos.requestFocus();

																				}
																			}
																		} else {
																			JOptionPane.showMessageDialog(this,
																					(String) "Error. El nombre"
																							+ nombrem
																							+ " es erroneo debe ser  minimo 2 y maximo de 64 caracteres",
																					"ERROR", JOptionPane.ERROR_MESSAGE,
																					null);
																			txtNombre.requestFocus();

																		}
																	}
																} else {
																	JOptionPane.showMessageDialog(this,
																			(String) "Error. El telefono" + telefonom
																					+ " es erroneo debe ser numeros  y minimo de 8 y maximo 12 caracteres",
																			"ERROR", JOptionPane.ERROR_MESSAGE, null);
																	txtTelefono.requestFocus();

																}
															}
														} else {
															JOptionPane.showMessageDialog(this,
																	(String) "Error. La comision" + Comisionm
																			+ " es erroneo debe ser numeros  y minimo de 0 y maximo 10 caracteres",
																	"ERROR", JOptionPane.ERROR_MESSAGE, null);
															txtComision.requestFocus();

														}
													}
												} else {
													JOptionPane.showMessageDialog(this, (String) "Error. El salario"
															+ Salariom
															+ " es erroneo debe ser numeros  y minimo de 3 y maximo 10 caracteres",
															"ERROR", JOptionPane.ERROR_MESSAGE, null);
													txtSalario.requestFocus();

												}
											}

										} else {
											JOptionPane.showMessageDialog(this,
													(String) "Error. El Correo" + correom
															+ " es erroneo debe tener yyyyyy@ssss.zzzz",
													"ERROR", JOptionPane.ERROR_MESSAGE, null);
											txtCorreo.requestFocus();

										}
									}
								} else {
									JOptionPane.showMessageDialog(this,
											(String) "Error. El dni JEFE " + DniJm
													+ " es erroneo debe ser 7 o 8 numeros y alfinal una letra",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
									txtDniJ.requestFocus();

								}
							}
						} else {
							JOptionPane.showMessageDialog(this,
									(String) "Error. El dni " + dnim
											+ " es erroneo debe ser 7 o 8 numeros y alfinal una letra",
									"ERROR", JOptionPane.ERROR_MESSAGE, null);
							txtDni.requestFocus();

						}
					}
				} else {
					JOptionPane.showMessageDialog(this,
							(String) "Error. El id " + Idm
									+ " es erroneo debe ser numeros y maximo y minimo de 5 caracteres",
							"ERROR", JOptionPane.ERROR_MESSAGE, null);
					txtId.requestFocus();

					}
				}	
			}
		} else if (boton == btnVaciar) {

			if (dtmTabla.getRowCount() != 0) {
				vaciarEmpleado();
				if (modificado) {
					JOptionPane.showMessageDialog(this,
							(String) "Se a vaciado la tabla",
							"Vaciada", JOptionPane.INFORMATION_MESSAGE, null);
					txtDni.setText("");
					txtNombre.setText("");
					txtApellidos.setText("");
					txtCorreo.setText("");
					txtTelefono.setText("");
					txtDireccion.setText("");
					txtFechaAlta.setText("");
					txtComision.setText("");
					txtDniJ.setText("");
					txtrol.setText("");
					txtSalario.setText("");
					txtFechNac.setText("");
					txtId.setText("");

					dtmTabla.setRowCount(0);
					modificado = false;
				}

			} else {

				JOptionPane.showMessageDialog(this, (String) "Error. La tabla esta vacia", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}
	/**
	 * 
	 * Seleccion de la tabla
	 * 
	 */

	@Override
	public void valueChanged(ListSelectionEvent lse) {

		int seleccion = table.getSelectedRow();
		if (!lse.getValueIsAdjusting() && seleccion != -1) {
			txtId.setText(String.valueOf(table.getValueAt(seleccion, 0)));
			txtDni.setText(String.valueOf(table.getValueAt(seleccion, 1)));
			txtDniJ.setText(String.valueOf(table.getValueAt(seleccion, 2)));
			txtCorreo.setText(String.valueOf(table.getValueAt(seleccion, 3)));
			txtTelefono.setText(String.valueOf(table.getValueAt(seleccion, 4)));
			txtSalario.setText(String.valueOf(table.getValueAt(seleccion, 5)));
			txtComision.setText(String.valueOf(table.getValueAt(seleccion, 6)));
			txtNombre.setText(String.valueOf(table.getValueAt(seleccion, 7)));
			txtApellidos.setText(String.valueOf(table.getValueAt(seleccion, 8)));
			txtFechNac.setText(String.valueOf(table.getValueAt(seleccion, 9)));
			txtDireccion.setText(String.valueOf(table.getValueAt(seleccion, 10)));
			Codactual = (String) table.getValueAt(seleccion, 11);
			cmbEmpleado.setSelectedItem(Codactual);
			txtFechaAlta.setText(String.valueOf(table.getValueAt(seleccion, 12)));
			Codactual1 = (String) table.getValueAt(seleccion, 13);
			cmbEstado.setSelectedItem(Codactual1);
			txtrol.setText(String.valueOf(table.getValueAt(seleccion, 14)));
		}
	}

}
