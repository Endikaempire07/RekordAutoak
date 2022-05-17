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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.awt.GridLayout;
import java.awt.Dimension;

public class Reparaciones extends Login implements Runnable, ActionListener, ListSelectionListener {

	/**
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
	private JLabel lblReparacion;
	private JLabel lbldescripcion;
	protected JTextField txtReparacion;
	private JPanel panel_2;
	private JPanel panel_3;
	protected JButton btnAgregar;
	protected JButton btnModifiacar;
	protected JButton btnBorrar;
	protected JButton btnVaciar;
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
	private String Codactual2;
	public int numeroroles;

	private int filaseleccionada;

	boolean modificado = false;

	private String Reparacionm;
	private String Ordenm;
	private String Serviciom;
	private String Piezam;
	private String PrecioHm;
	private String Cantidadm;
	private int Cantm;
	private Double Preciom;

	private String ReparacionI;
	private String OrdenI;
	private String ServicioI;
	private String PiezaI;
	private String PrecioHI;
	private String CantidadI;
	private int CantI;
	private Double PrecioI;
	
	private String Reparacion;
	private String Orden;
	private String Servicio;
	private String Pieza;
	private String PrecioH;
	private String Cantidad;
	private int Cant;
	private Double Precio;

	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	private Icon modificar;
	private JLabel lblNewLabel_7;
	private JScrollPane scrollTabla_2;
	private JTable table_1;
	private JPanel panel_4;
	private JButton btnCerrarSesion;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_15;
	private JLabel lblSevicio;
	private JLabel lblPieza;
	private JLabel lblNewLabel_16;
	private JLabel lblsasa;
	protected JTextField txtPrecioH;
	protected JTextField txtCantidad;
	
	
	protected JComboBox<String> cmbOrden;
	protected JComboBox<String> cmbServicio;
	protected JComboBox <String>cmbPieza;

	/**
	 * Create the frame.
	 * 
	 * @param login
	 * @throws SQLException
	 */
	public Reparaciones() {
		setForeground(Color.WHITE);
		setTitle("RekordAutoak - Reparaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 550);

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
		gbl_panel.columnWidths = new int[] { 0, 0, 291, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel_6 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		lblNewLabel_1 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblEmpresa = new JLabel("Datos Empresa: ");
		lblEmpresa.setForeground(Color.WHITE);
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
		gbc_lblEmpresa.gridwidth = 2;
		gbc_lblEmpresa.anchor = GridBagConstraints.WEST;
		gbc_lblEmpresa.insets = new Insets(0, 0, 5, 0);
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
		gbc_lblNombreempresa.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreempresa.gridx = 2;
		gbc_lblNombreempresa.gridy = 2;
		panel.add(lblNombreempresa, gbc_lblNombreempresa);

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
		gbc_lbldirec.insets = new Insets(0, 0, 5, 0);
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
		gbc_lblprovi.insets = new Insets(0, 0, 5, 0);
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
		gbc_lblphone.insets = new Insets(0, 0, 5, 0);
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
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_14.gridx = 2;
		gbc_lblNewLabel_14.gridy = 6;
		panel.add(lblNewLabel_14, gbc_lblNewLabel_14);

		lblNIf = new JLabel("NIF");
		lblNIf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNIf.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNIf = new GridBagConstraints();
		gbc_lblNIf.anchor = GridBagConstraints.WEST;
		gbc_lblNIf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNIf.gridx = 1;
		gbc_lblNIf.gridy = 7;
		panel.add(lblNIf, gbc_lblNIf);

		lblNIFem = new JLabel("89526899S");
		lblNIFem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNIFem.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNIFem = new GridBagConstraints();
		gbc_lblNIFem.insets = new Insets(0, 0, 5, 0);
		gbc_lblNIFem.anchor = GridBagConstraints.WEST;
		gbc_lblNIFem.gridx = 2;
		gbc_lblNIFem.gridy = 7;
		panel.add(lblNIFem, gbc_lblNIFem);

		lblNewLabel_13 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 8;
		panel.add(lblNewLabel_13, gbc_lblNewLabel_13);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 115, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel_7 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);

		lblNewLabel_2 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblNewLabel_3 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblNewLabel_19 = new JLabel("Datos  Reparacion:");
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 1;
		gbc_lblNewLabel_19.gridy = 1;
		panel_1.add(lblNewLabel_19, gbc_lblNewLabel_19);

		lblNewLabel_12 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 4;
		gbc_lblNewLabel_12.gridy = 1;
		panel_1.add(lblNewLabel_12, gbc_lblNewLabel_12);

		lblReparacion = new JLabel("Id Reparacion");
		lblReparacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReparacion.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblReparacion = new GridBagConstraints();
		gbc_lblReparacion.anchor = GridBagConstraints.WEST;
		gbc_lblReparacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblReparacion.gridx = 1;
		gbc_lblReparacion.gridy = 2;
		panel_1.add(lblReparacion, gbc_lblReparacion);

		txtReparacion = new JTextField();
		GridBagConstraints gbc_txtReparacion = new GridBagConstraints();
		gbc_txtReparacion.insets = new Insets(0, 0, 5, 5);
		gbc_txtReparacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtReparacion.gridx = 2;
		gbc_txtReparacion.gridy = 2;
		panel_1.add(txtReparacion, gbc_txtReparacion);
		txtReparacion.setColumns(10);
		
		lblPieza = new JLabel("Pieza");
		lblPieza.setForeground(Color.WHITE);
		lblPieza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPieza = new GridBagConstraints();
		gbc_lblPieza.anchor = GridBagConstraints.WEST;
		gbc_lblPieza.insets = new Insets(0, 0, 5, 5);
		gbc_lblPieza.gridx = 4;
		gbc_lblPieza.gridy = 2;
		panel_1.add(lblPieza, gbc_lblPieza);
		
		cmbPieza = new JComboBox<String>();
		GridBagConstraints gbc_cmbPieza = new GridBagConstraints();
		gbc_cmbPieza.insets = new Insets(0, 0, 5, 0);
		gbc_cmbPieza.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPieza.gridx = 5;
		gbc_cmbPieza.gridy = 2;
		panel_1.add(cmbPieza, gbc_cmbPieza);

		lbldescripcion = new JLabel("Orden");
		lbldescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldescripcion.setForeground(Color.WHITE);
		GridBagConstraints gbc_lbldescripcion = new GridBagConstraints();
		gbc_lbldescripcion.anchor = GridBagConstraints.WEST;
		gbc_lbldescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lbldescripcion.gridx = 1;
		gbc_lbldescripcion.gridy = 3;
		panel_1.add(lbldescripcion, gbc_lbldescripcion);
		
		cmbOrden = new JComboBox<String>();
		GridBagConstraints gbc_cmbOrden = new GridBagConstraints();
		gbc_cmbOrden.insets = new Insets(0, 0, 5, 5);
		gbc_cmbOrden.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbOrden.gridx = 2;
		gbc_cmbOrden.gridy = 3;
		panel_1.add(cmbOrden, gbc_cmbOrden);
		
		lblNewLabel_16 = new JLabel("Precio Historico");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 4;
		gbc_lblNewLabel_16.gridy = 3;
		panel_1.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		txtPrecioH = new JTextField();
		GridBagConstraints gbc_txtPrecioH = new GridBagConstraints();
		gbc_txtPrecioH.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrecioH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecioH.gridx = 5;
		gbc_txtPrecioH.gridy = 3;
		panel_1.add(txtPrecioH, gbc_txtPrecioH);
		txtPrecioH.setColumns(10);
		
		lblSevicio = new JLabel("Servicio");
		lblSevicio.setForeground(Color.WHITE);
		lblSevicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSevicio = new GridBagConstraints();
		gbc_lblSevicio.anchor = GridBagConstraints.WEST;
		gbc_lblSevicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblSevicio.gridx = 1;
		gbc_lblSevicio.gridy = 4;
		panel_1.add(lblSevicio, gbc_lblSevicio);
		
		cmbServicio = new JComboBox<String>();
		GridBagConstraints gbc_cmbServicio = new GridBagConstraints();
		gbc_cmbServicio.insets = new Insets(0, 0, 5, 5);
		gbc_cmbServicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbServicio.gridx = 2;
		gbc_cmbServicio.gridy = 4;
		panel_1.add(cmbServicio, gbc_cmbServicio);
		
		lblsasa = new JLabel("Cantidad");
		lblsasa.setForeground(Color.WHITE);
		lblsasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblsasa = new GridBagConstraints();
		gbc_lblsasa.anchor = GridBagConstraints.WEST;
		gbc_lblsasa.insets = new Insets(0, 0, 5, 5);
		gbc_lblsasa.gridx = 4;
		gbc_lblsasa.gridy = 4;
		panel_1.add(lblsasa, gbc_lblsasa);
		
		txtCantidad = new JTextField();
		GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
		gbc_txtCantidad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidad.gridx = 5;
		gbc_txtCantidad.gridy = 4;
		panel_1.add(txtCantidad, gbc_txtCantidad);
		txtCantidad.setColumns(10);
		txtCantidad.addKeyListener((KeyListener) new KeyAdapter() {
	           public void keyTyped(KeyEvent e) {
		              char caracter = e.getKeyChar();

		              // verificar si la tecla pulsada no es un dígito
		              if (caracter < '0' || caracter > '9') {
		                 e.consume();  // ignorar el evento de teclado
		              }
		           }
		        });
		lblNewLabel_15 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_15.gridx = 1;
		gbc_lblNewLabel_15.gridy = 6;
		panel_1.add(lblNewLabel_15, gbc_lblNewLabel_15);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panelcentral.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_2.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 83, 0, 85, 0, 85, 0, 85, 85, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 21, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNewLabel_4 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 0;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);

		lblNewLabel_8 = new JLabel("  ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 1;
		panel_3.add(lblNewLabel_8, gbc_lblNewLabel_8);

		btnAgregar = new JButton("Agregar Reparacion");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 1;
		panel_3.add(btnAgregar, gbc_btnAgregar);

		lblNewLabel_9 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 1;
		panel_3.add(lblNewLabel_9, gbc_lblNewLabel_9);

		btnModifiacar = new JButton("Modificar Reparacion");
		GridBagConstraints gbc_btnModifiacar = new GridBagConstraints();
		gbc_btnModifiacar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnModifiacar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifiacar.gridx = 3;
		gbc_btnModifiacar.gridy = 1;
		panel_3.add(btnModifiacar, gbc_btnModifiacar);

		lblNewLabel_10 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 1;
		panel_3.add(lblNewLabel_10, gbc_lblNewLabel_10);

		btnBorrar = new JButton("Borrar Reparacion");
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 5;
		gbc_btnBorrar.gridy = 1;
		panel_3.add(btnBorrar, gbc_btnBorrar);

		lblNewLabel_11 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 6;
		gbc_lblNewLabel_11.gridy = 1;
		panel_3.add(lblNewLabel_11, gbc_lblNewLabel_11);

		btnVaciar = new JButton("Vaciar Reparacion");
		GridBagConstraints gbc_btnVaciar = new GridBagConstraints();
		gbc_btnVaciar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVaciar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnVaciar.gridx = 7;
		gbc_btnVaciar.gridy = 1;
		panel_3.add(btnVaciar, gbc_btnVaciar);

		lblNewLabel_5 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 2;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);

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
		lbl.setIcon(new ImageIcon(Reparaciones.class.getResource("/resources/user-png-icon.png")));
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
		lblr.setIcon(new ImageIcon(Reparaciones.class.getResource("/resources/rola.png")));
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

		panel_4 = new JPanel();
		panel_4.setForeground(Color.WHITE);
		panel_4.setBackground(Color.GRAY);
		Panel1.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		btnCerrarSesion = new JButton("Cerrar Sesion");
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrarSesion.anchor = GridBagConstraints.EAST;
		gbc_btnCerrarSesion.gridwidth = 27;
		gbc_btnCerrarSesion.gridx = 1;
		gbc_btnCerrarSesion.gridy = 0;
		panel_4.add(btnCerrarSesion, gbc_btnCerrarSesion);

		// creo el vector para los datos de la tabla
		datosTabla = new Vector<Vector<String>>();

		tabladatos();

		h1 = new Thread(this);
		h1.start();
		setLocationRelativeTo(null);
		setVisible(true);
		run();

		// actionlsitener

		modificar = new ImageIcon("src/resources/ayuda.png");

		btnAgregar.addActionListener(this);
		btnModifiacar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnVaciar.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
	}

	public void tabladatos() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.reparacion;");

			ResultSetMetaData metadatos = rs.getMetaData();
			int numeroColumnas = metadatos.getColumnCount();

			Vector<String> columnas = new Vector<String>();
			for (int i = 1; i <= numeroColumnas; i++) {
				columnas.add(metadatos.getColumnLabel(i));
			}

			// cabeceras de las columnas
			Vector<String> nombresColumnas = new Vector<String>();
			nombresColumnas.add("Id Reparacion");
			nombresColumnas.add("Id Orden");
			nombresColumnas.add("Id Servicio");
			nombresColumnas.add("Id Pieza");
			nombresColumnas.add("Precio Historico");
			nombresColumnas.add("Cantidad");

			dtmTabla = new DefaultTableModel();
			dtmTabla.setColumnIdentifiers(nombresColumnas);

			while (rs.next()) {
				Vector<String> fila = new Vector<String>();

				fila.add(rs.getString("idReparacion"));
				fila.add(rs.getString("idOrden"));
				fila.add(rs.getString("idServicio"));
				fila.add(rs.getString("idPieza"));
				fila.add(rs.getString("precioHistorico"));
				fila.add(rs.getString("cantidad"));
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
			tabladatos1();
			tabladatos2();
			tabladatos3();

			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			// podemos poner un filtro por grupo para sacar solo los alumnos de 1DW3
			st.close();
			rs.close();
			conexion.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

		}
		// creo el default model de la tabla

		// para que ordene por la primera columna (dni en este caso) en Ascendente

	}
	public void tabladatos1() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.servicio;");

			
			while (rs.next()) {

				cmbServicio.addItem(rs.getString("idServicio"));
			

			}

			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			// podemos poner un filtro por grupo para sacar solo los alumnos de 1DW3
			st.close();
			rs.close();
			conexion.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

		}
		// creo el default model de la tabla

		// para que ordene por la primera columna (dni en este caso) en Ascendente

	}
	public void tabladatos2() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.pieza;");

			
			while (rs.next()) {

				cmbPieza.addItem(rs.getString("idPieza"));
			

			}

			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			// podemos poner un filtro por grupo para sacar solo los alumnos de 1DW3
			st.close();
			rs.close();
			conexion.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

		}
		// creo el default model de la tabla

		// para que ordene por la primera columna (dni en este caso) en Ascendente

	}public void tabladatos3() {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.ordentrabajo;");

			
			while (rs.next()) {

				cmbOrden.addItem(rs.getString("idOrden"));
			

			}

			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			// podemos poner un filtro por grupo para sacar solo los alumnos de 1DW3
			st.close();
			rs.close();
			conexion.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

		}
		// creo el default model de la tabla

		// para que ordene por la primera columna (dni en este caso) en Ascendente

	}
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

	public void insertarReparacion() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
	
			String consulta = "Insert into rekordautoak.reparacion VALUES('" + ReparacionI + "','" + OrdenI + "','"+ ServicioI + "','"+ PiezaI + "',"+  PrecioI+ ","+ CantI + ");";
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

	private boolean verificarCampos(JTextField textField) {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo debe ser rellenado", "Error", JOptionPane.ERROR_MESSAGE);
			textField.requestFocus();
			return false;
		}
		return true;
	}

	private void vaciarReparacion() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			consulta = "DELETE from rekordautoak.reparacion ;";
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

	public void eliminarReparacion() {
		try {
			// CONECTO LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			String REPA;

			REPA = txtReparacion.getText();
			

			consulta = "DELETE from reparacion  WHERE idReparacion='" + REPA + "';";
			st.executeUpdate(consulta);
			modificado = true;

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			// si borro correctamente en la base de datos
			// lo borro tambien en la tabla
			dtmTabla.removeRow(filaseleccionada);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, (String) "Error, no hay ningún elemento seleccionado", "Error",
					JOptionPane.INFORMATION_MESSAGE, null);

		}

	}

	@SuppressWarnings("unused")
	private boolean verificarCamposborrar(JTextField textField) {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos para borrar", "ERROR",
					JOptionPane.ERROR_MESSAGE, null);
			return false;
		}
		return true;
	}

	public void modificarReparacion() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
		
			String consulta = "UPDATE reparacion SET idServicio='" + Serviciom + "', idPieza = '" + Piezam
					+"', precioHistorico = '" + Preciom+"', cantidad = '" + Cantm+ "'  WHERE idReparacion = '" + Reparacionm + "';";

			st.executeUpdate(consulta);

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			if (Servicio != Serviciom) {
				dtmTabla.setValueAt(Serviciom, filaseleccionada, 2);

			}
			if (Pieza != Piezam) {
				dtmTabla.setValueAt(Piezam, filaseleccionada, 3);

			}	if (PrecioH != PrecioHm) {
				dtmTabla.setValueAt(PrecioHm, filaseleccionada, 4);

			}	if (Cantidad != Cantidadm) {
				dtmTabla.setValueAt(Cantidadm, filaseleccionada, 5);

			}

		} catch (SQLException e) {
			// si se produce una excepción SQL
			@SuppressWarnings("unused")
			int errorcode = e.getErrorCode();

			JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
					"ERROR", JOptionPane.ERROR_MESSAGE, null);

		}

	}

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

				ayudaC vm = new ayudaC();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				this.dispose();

				vm.lblImagen.setIcon(new ImageIcon(ayudaC.class.getResource("/resources/ayudaC.png")));

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

				ayudaC vm = new ayudaC();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaC.class.getResource("/resources/ayudaC.png")));

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

				ayudaC vm = new ayudaC();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaC.class.getResource("/resources/ayudaC.png")));

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

				ayudaO vm = new ayudaO();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.lblImagen.setIcon(new ImageIcon(ayudaC.class.getResource("/resources/ayudaC.png")));

				this.dispose();

			}
		}

		if (boton == btnAgregar) {
			if (verificarCampos(txtReparacion)) {
				ReparacionI = txtReparacion.getText();
				if (ReparacionI.matches("[R]{1,1}[0-9]{5,5}")) {

				if (verificarCampos(txtPrecioH)) {
					PrecioHI = txtPrecioH.getText();
					if (PrecioHI.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {

					PrecioI = Double.parseDouble(PrecioHI);
						
						if (verificarCampos(txtCantidad)) {
							CantidadI = txtCantidad.getText();
							if (CantidadI.matches("[0-9]{1,10}")) {

							CantI = Integer.parseInt(CantidadI);
							OrdenI = (String) cmbOrden.getSelectedItem();
							PiezaI = (String) cmbPieza.getSelectedItem();
							ServicioI = (String) cmbServicio.getSelectedItem();
							
							insertarReparacion();
							if (modificado) {
								Vector<String> fila = new Vector<String>();
								fila.add(ReparacionI);
								fila.add(OrdenI);
								fila.add(ServicioI);
								fila.add(PiezaI);
								fila.add(PrecioHI);
								fila.add(CantidadI);
								dtmTabla.addRow(fila);
		
								modificado = false;
								JOptionPane.showMessageDialog(this,
										(String) "La Reparacion con Id Reparacion " + ReparacionI
												+ " se a insertado correctamente",
										"Reparacion Insertada", JOptionPane.INFORMATION_MESSAGE, null);	
								}
							}else {
								
								JOptionPane
								.showMessageDialog(
										this,
										(String) "Error. La cantidad "
												+ CantidadI
												+ " es erroneo debe ser  minimo 1 y maximo de 10 caracteres tipo numero",
										"ERROR",
										JOptionPane.ERROR_MESSAGE,
										null);
								txtCantidad.requestFocus();

								}
							}
					
				} else {
					JOptionPane.showMessageDialog(this,
							(String) "Error. El trimpo de hora " + PrecioHI
									+ " es erroneo debe ser numeros maximo 10 y minimo de 3 decimales y luego con un minimo de 0 y maximo 2 caracteres despues de la coma",
							"ERROR", JOptionPane.ERROR_MESSAGE, null);
					txtPrecioH.requestFocus();

				}

			}
			} else {
				JOptionPane.showMessageDialog(this,
						(String) "Error. El id Reparacion " + ReparacionI
								+ " es erroneo debe  dos caracteres de letras y despues 3 caracteres de numeros.",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);
				txtReparacion.requestFocus();

			}

		}	

			// lo inserto tambien en la tabla

		} else if (boton == btnBorrar) {
			// Seleccionamos la fila
			filaseleccionada = table.getSelectedRow();
			if (filaseleccionada < 0) {
				// si no tenemos nada selccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);

			} else {
				// convertimos la fila seleccionada al valor real del dtm
				filaseleccionada = table.convertRowIndexToModel(filaseleccionada);
				eliminarReparacion();
				txtReparacion.setText("");
				txtPrecioH.setText("");
				txtCantidad.setText("");

			}
		} else if (boton == btnModifiacar) {
			filaseleccionada = table.getSelectedRow();
			if (filaseleccionada < 0) {
				// si no tenemos nada selccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para Modificar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);

			} else {

				if (verificarCampos(txtReparacion)) {
					Reparacionm = txtReparacion.getText();
					if (Reparacionm.matches("[A-Z]{1,1}[0-9]{5,5}")) {

					if (verificarCampos(txtPrecioH)) {
						PrecioHm = txtPrecioH.getText();
						if (PrecioHm.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {

						Preciom = Double.parseDouble(PrecioHI);
							
							if (verificarCampos(txtCantidad)) {
								Cantidadm = txtCantidad.getText();
								if (Cantidadm.matches("[0-9]{1,10}")) {
							Cantm = Integer.parseInt(Cantidadm);
							Ordenm = (String) cmbOrden.getSelectedItem();
							Piezam = (String) cmbPieza.getSelectedItem();
							Serviciom = (String) cmbServicio.getSelectedItem();

					filaseleccionada = table.convertRowIndexToModel(filaseleccionada);

					Reparacion = (String) table.getValueAt(filaseleccionada, 0);
					Orden = (String) table.getValueAt(filaseleccionada, 2);
					Servicio = (String) table.getValueAt(filaseleccionada, 2);
					Pieza = (String) table.getValueAt(filaseleccionada, 2);
					PrecioH = (String) table.getValueAt(filaseleccionada, 1);
					Cantidad = (String) table.getValueAt(filaseleccionada, 2);
					
					if (Reparacion.equals(Reparacionm)) {
						modificarReparacion();
						
						JOptionPane.showMessageDialog(this,
								(String) "La Reparacion con Id Reparacion " + Reparacionm
										+ " se a modificado correctamente",
								"Reparacion Modificada", JOptionPane.INFORMATION_MESSAGE, null);	
						
					}
							
								}else {
								
								JOptionPane
								.showMessageDialog(
										this,
										(String) "Error. La cantidad "
												+ Cantidadm
												+ " es erroneo debe ser  minimo 1 y maximo de 10 caracteres tipo numero",
										"ERROR",
										JOptionPane.ERROR_MESSAGE,
										null);
								txtCantidad.requestFocus();

								}
							}
					
				} else {
					JOptionPane.showMessageDialog(this,
							(String) "Error. El trimpo de hora " + PrecioHm
									+ " es erroneo debe ser numeros maximo 10 y minimo de 3 decimales y luego con un minimo de 0 y maximo 2 caracteres despues de la coma",
							"ERROR", JOptionPane.ERROR_MESSAGE, null);
					txtPrecioH.requestFocus();

				}

			}
			} else {
				JOptionPane.showMessageDialog(this,
						(String) "Error. El id Reparacion " + Reparacionm
								+ " es erroneo debe  dos caracteres de letras y despues 3 caracteres de numeros.",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);
				txtReparacion.requestFocus();

			}

		}	

			// lo inserto tambien en la tabla

		
		

	}	

		// lo inserto tambien en la tabla

	} else if (boton == btnVaciar) {

			if (dtmTabla.getRowCount() != 0) {
				vaciarReparacion();
				if (modificado) {

					txtReparacion.setText("");
					txtPrecioH.setText("");
					txtCantidad.setText("");

					dtmTabla.setRowCount(0);
					modificado = false;
				}

			} else {

				JOptionPane.showMessageDialog(this, (String) "Error. La tabla esta vacia", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {

		int seleccion = table.getSelectedRow();
		if (!lse.getValueIsAdjusting() && seleccion != -1) {
			txtReparacion.setText(String.valueOf(table.getValueAt(seleccion, 0)));
			Codactual = (String) table.getValueAt(seleccion, 1);
			cmbOrden.setSelectedItem(Codactual);
			Codactual1 = (String) table.getValueAt(seleccion, 2);
			cmbServicio.setSelectedItem(Codactual);
			Codactual2 = (String) table.getValueAt(seleccion, 3);
			cmbPieza.setSelectedItem(Codactual);
			txtPrecioH.setText(String.valueOf(table.getValueAt(seleccion, 4)));
			txtCantidad.setText(String.valueOf(table.getValueAt(seleccion, 5)));

		}

	}

}
