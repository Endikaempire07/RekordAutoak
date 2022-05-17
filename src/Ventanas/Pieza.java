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


public class Pieza extends Login implements Runnable, ActionListener, ListSelectionListener {

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
	private JLabel lblPieza;
	private JLabel lblNombre;
	private JLabel lblPrecioCompra;
	private JLabel lblPvp;
	private JLabel lblMarca;
	private JLabel lblStock;
	private JLabel lblestado;
	protected JTextField txtPieza;
	protected JTextField txtStock;
	protected JTextField txtPrecioC;
	protected JTextField txtPvp;
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
	public int numeroroles;

	private int filaseleccionada;

	boolean modificado = false;

	private String Piezam;
	private String Marcam;
	private String Nombrem;
	private int Stockm;
	private Double PVPm;
	private Double PrecioCm;
	private String Estadom;
	private String StockM; 	
	private String PrecioM;
	private String PvpM;


	private String Piezai;
	private String Marcai;
	private String Nombrei;
	private int Stocki;
	private Double PVPi;
	private Double PrecioCi;
	private String Estadoi;
	private String stocki; 	
	private String precioi;
	private String pvpi;
	
	private String stock; 	
	private String precio;
	private String pvp;
	private String Pieza;
	private String Marca;
	private String Nombre;
	private int Stock;
	private Double PVP;
	private Double PrecioC;
	private String Estado;
	
	
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
	protected JComboBox<String> cmbEstado;
	private JPanel panel_4;
	private JButton btnCerrarSesion;
	protected JTextField txtMarca;
	protected JTextField txtNombre;
	private String FechNacI;
	private JButton btnSumnistro;
	

	/**
	 * Create the frame.
	 * 
	 * @param login
	 * @throws SQLException
	 */
	public Pieza() {
		setForeground(Color.WHITE);
		setTitle("RekordAutoak - Piezas");
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
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
		gbc_lblNIf.insets = new Insets(0, 0, 0, 5);
		gbc_lblNIf.gridx = 1;
		gbc_lblNIf.gridy = 7;
		panel.add(lblNIf, gbc_lblNIf);

		lblNIFem = new JLabel("89526899S");
		lblNIFem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNIFem.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNIFem = new GridBagConstraints();
		gbc_lblNIFem.anchor = GridBagConstraints.WEST;
		gbc_lblNIFem.gridx = 2;
		gbc_lblNIFem.gridy = 7;
		panel.add(lblNIFem, gbc_lblNIFem);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 115, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		lblNewLabel_19 = new JLabel("Datos Pieza:");
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 1;
		gbc_lblNewLabel_19.gridy = 1;
		panel_1.add(lblNewLabel_19, gbc_lblNewLabel_19);

		lblPieza = new JLabel("Id Pieza");
		lblPieza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPieza.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPieza = new GridBagConstraints();
		gbc_lblPieza.anchor = GridBagConstraints.WEST;
		gbc_lblPieza.insets = new Insets(0, 0, 5, 5);
		gbc_lblPieza.gridx = 1;
		gbc_lblPieza.gridy = 2;
		panel_1.add(lblPieza, gbc_lblPieza);

		txtPieza = new JTextField();
		GridBagConstraints gbc_txtPieza = new GridBagConstraints();
		gbc_txtPieza.insets = new Insets(0, 0, 5, 5);
		gbc_txtPieza.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPieza.gridx = 2;
		gbc_txtPieza.gridy = 2;
		panel_1.add(txtPieza, gbc_txtPieza);
		txtPieza.setColumns(10);

		lblPvp = new JLabel("Pvp");
		lblPvp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPvp.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPvp = new GridBagConstraints();
		gbc_lblPvp.anchor = GridBagConstraints.WEST;
		gbc_lblPvp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPvp.gridx = 3;
		gbc_lblPvp.gridy = 2;
		panel_1.add(lblPvp, gbc_lblPvp);

		txtPvp = new JTextField();
		GridBagConstraints gbc_txtPvp = new GridBagConstraints();
		gbc_txtPvp.insets = new Insets(0, 0, 5, 0);
		gbc_txtPvp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPvp.gridx = 4;
		gbc_txtPvp.gridy = 2;
		panel_1.add(txtPvp, gbc_txtPvp);
		txtPvp.setColumns(10);

		lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.WEST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 3;
		panel_1.add(lblMarca, gbc_lblMarca);

		txtMarca = new JTextField();
		GridBagConstraints gbc_txtMarca = new GridBagConstraints();
		gbc_txtMarca.insets = new Insets(0, 0, 5, 5);
		gbc_txtMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMarca.gridx = 2;
		gbc_txtMarca.gridy = 3;
		panel_1.add(txtMarca, gbc_txtMarca);
		txtMarca.setColumns(10);

		lblPrecioCompra = new JLabel("Precio Compra");
		lblPrecioCompra.setForeground(Color.WHITE);
		lblPrecioCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrecioCompra = new GridBagConstraints();
		gbc_lblPrecioCompra.anchor = GridBagConstraints.WEST;
		gbc_lblPrecioCompra.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioCompra.gridx = 3;
		gbc_lblPrecioCompra.gridy = 3;
		panel_1.add(lblPrecioCompra, gbc_lblPrecioCompra);

		txtPrecioC = new JTextField();
		GridBagConstraints gbc_txtPrecioC = new GridBagConstraints();
		gbc_txtPrecioC.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrecioC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecioC.gridx = 4;
		gbc_txtPrecioC.gridy = 3;
		panel_1.add(txtPrecioC, gbc_txtPrecioC);
		txtPrecioC.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		panel_1.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 4;
		panel_1.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblestado = new JLabel("Estado\r\n");
		lblestado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestado.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblestado = new GridBagConstraints();
		gbc_lblestado.anchor = GridBagConstraints.WEST;
		gbc_lblestado.insets = new Insets(0, 0, 5, 5);
		gbc_lblestado.gridx = 3;
		gbc_lblestado.gridy = 4;
		panel_1.add(lblestado, gbc_lblestado);

		cmbEstado = new JComboBox<String>();
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cmbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEstado.gridx = 4;
		gbc_cmbEstado.gridy = 4;
		panel_1.add(cmbEstado, gbc_cmbEstado);
		
		cmbEstado.addItem("activo");
		cmbEstado.addItem("inactivo");

		lblStock = new JLabel("Stock");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.anchor = GridBagConstraints.WEST;
		gbc_lblStock.insets = new Insets(0, 0, 0, 5);
		gbc_lblStock.gridx = 1;
		gbc_lblStock.gridy = 5;
		panel_1.add(lblStock, gbc_lblStock);

		txtStock = new JTextField();
		GridBagConstraints gbc_txtStock = new GridBagConstraints();
		gbc_txtStock.insets = new Insets(0, 0, 0, 5);
		gbc_txtStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStock.gridx = 2;
		gbc_txtStock.gridy = 5;
		panel_1.add(txtStock, gbc_txtStock);
		txtStock.setColumns(10);
		txtStock.addKeyListener((KeyListener) new KeyAdapter() {
	           public void keyTyped(KeyEvent e) {
	              char caracter = e.getKeyChar();

	              // verificar si la tecla pulsada no es un dígito
	              if (caracter < '0' || caracter > '9') {
	                 e.consume();  // ignorar el evento de teclado
	              }
	           }
	        });
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

		lblNewLabel_8 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 1;
		panel_3.add(lblNewLabel_8, gbc_lblNewLabel_8);

		btnAgregar = new JButton("Agregar Pieza");
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

		btnModifiacar = new JButton("Modificar Pieza");
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

		btnBorrar = new JButton("Borrar Pieza");
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

		btnVaciar = new JButton("Vaciar Pieza");
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
		lbl.setIcon(new ImageIcon(Pieza.class.getResource("/resources/user-png-icon.png")));
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
		lblr.setIcon(new ImageIcon(Pieza.class.getResource("/resources/rola.png")));
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
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);
		
		btnSumnistro = new JButton("Solicitar Pieza");
		GridBagConstraints gbc_btnSumnistro = new GridBagConstraints();
		gbc_btnSumnistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnSumnistro.gridx = 1;
		gbc_btnSumnistro.gridy = 0;
		panel_4.add(btnSumnistro, gbc_btnSumnistro);

		btnCerrarSesion = new JButton("Cerrar Sesion");
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.anchor = GridBagConstraints.EAST;
		gbc_btnCerrarSesion.gridwidth = 25;
		gbc_btnCerrarSesion.gridx = 2;
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
		btnSumnistro.addActionListener(this);
	
	}

	public void tabladatos() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.pieza;");

			ResultSetMetaData metadatos = rs.getMetaData();
			int numeroColumnas = metadatos.getColumnCount();

			Vector<String> columnas = new Vector<String>();
			for (int i = 1; i <= numeroColumnas; i++) {
				columnas.add(metadatos.getColumnLabel(i));
			}

			// cabeceras de las columnas
			Vector<String> nombresColumnas = new Vector<String>();
			nombresColumnas.add("Id Pieza");
			nombresColumnas.add("Marca");
			nombresColumnas.add("Nombre");
			nombresColumnas.add("Stock");
			nombresColumnas.add("Pvp");
			nombresColumnas.add("Precio De La Compra");
			nombresColumnas.add("Estado");

			dtmTabla = new DefaultTableModel();
			dtmTabla.setColumnIdentifiers(nombresColumnas);

			while (rs.next()) {
				Vector<String> fila = new Vector<String>();

				fila.add(rs.getString("idPieza"));
				fila.add(rs.getString("marca"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("stock"));
				fila.add(rs.getString("pvp"));
				fila.add(rs.getString("precioCompra"));
				fila.add(rs.getString("estado"));
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

	public void insertarPieza() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();

			String consulta = "Insert into rekordautoak.pieza VALUES('" + Piezai + "','" + Marcai + "','" + Nombrei
					+ "'," + Stocki +" ," + PVPi + "," + PrecioCi + ",'" + Estadoi + "');";
			st.executeUpdate(consulta);
			modificado = true;
			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			//si inserto correctamente en la base de datos

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

	private void vaciarCliente() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			consulta = "DELETE from rekordautoak.pieza ;";
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

	public void eliminarCliente() {
		try {
			// CONECTO LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			String Pieza;

			Pieza = txtPieza.getText();

			consulta = "DELETE from pieza  WHERE idPieza='" + Pieza + "';";
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

	public void modificarPieza() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();

			
			String consulta = "UPDATE pieza SET marca='" + Marcam + "' , nombre='" + Nombrem + "' , stock ="
					+ Stockm + " , pvp =" + PVPm + ", precioCompra = " + PrecioCm + ", estado = '"
					+ Estadom +  "'  WHERE idPieza = '" + Piezam + "';";

			st.executeUpdate(consulta);

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();

			if (Marca != Marcam) {
				dtmTabla.setValueAt(Marcam, filaseleccionada, 1);

			}
			if (Nombre != Nombrem) {
				dtmTabla.setValueAt(Nombrem, filaseleccionada, 2);

			}
			if (stock != StockM) {
				dtmTabla.setValueAt(StockM, filaseleccionada, 3);

			}
			if (pvp != PvpM) {
				dtmTabla.setValueAt(PvpM, filaseleccionada, 4);

			}
			if (precio != PrecioM) {
				dtmTabla.setValueAt(PrecioM, filaseleccionada, 5);

			}
			if (Estado != Estadom) {
				dtmTabla.setValueAt(Estadom, filaseleccionada, 6);

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

			} else if (boton == btnSumnistro) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Suministra vm = new Suministra();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
			
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

			} else if (boton == btnSumnistro) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Suministra vm = new Suministra();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				vm.btnBorrar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
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

			} else if (boton == btnSumnistro) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Suministra vm = new Suministra();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
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

			} else if (boton == btnSumnistro) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Suministra vm = new Suministra();
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

		if (boton == btnAgregar) {
			if (verificarCampos(txtPieza)) {
				Piezai = txtPieza.getText();
				if (Piezai.matches("[P]{1,1}[0-9]{5,5}")) {

				if (verificarCampos(txtMarca)) {
					Marcai = txtMarca.getText();
					if (Marcai.matches("[a-zA-Z]{2,64}")) {

					
					if (verificarCampos(txtNombre)) {
						Nombrei = txtNombre.getText();
						if (Nombrei.matches("[a-zA-Z]{2,64}")) {

						if (verificarCampos(txtStock)) {
							Stocki = Integer.parseInt(txtStock.getText());
							stocki = String.valueOf(Stocki); 
							if (stocki.matches("[0-9]{1,10}")) {

							if (verificarCampos(txtPvp)) {
								PVPi = Double.parseDouble(txtPvp.getText());
								pvpi = String.valueOf(PVPi); 
								if (pvpi.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {

								if (verificarCampos(txtPrecioC)) {
									PrecioCi = Double.parseDouble(txtPrecioC.getText());
									precioi = String.valueOf(PrecioCi); 
									if (precioi.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {
	
										Estadoi = (String) cmbEstado.getSelectedItem();
											insertarPieza();
											if (modificado) {
												Vector<String> fila = new Vector<String>();
												fila.add(Piezai);
												fila.add(Marcai);
												fila.add(Nombrei);
												fila.add(stocki);
												fila.add(pvpi);
												fila.add(precioi);
												fila.add(Estadoi);
												dtmTabla.addRow(fila);
	
												modificado = false;
												JOptionPane.showMessageDialog(this,
														(String) "La Pieza con Id pieza " + Piezai
																+ " se a insertado correctamente",
														"Pieza Insertada", JOptionPane.INFORMATION_MESSAGE, null);	
										
											} 
									}else {
										JOptionPane
										.showMessageDialog(
												this,
												(String) "Error. El Precio "
														+ precioi
														+ " es erroneo debe ser numeros maximo 10 y minimo de 1 decimal y luego con un minimo de 0 y maximo 2 caracteres despues de la coma",
												"ERROR",
												JOptionPane.ERROR_MESSAGE,
												null);
								txtPrecioC
										.requestFocus();

							}
						}
					} else {
						JOptionPane
								.showMessageDialog(
										this,
										(String) "Error. El PVP "
												+ PVPi
												+ " es erroneo debe ser numeros maximo 10 y minimo de 1 decimal y luego con un minimo de 0 y maximo 2 caracteres despues de la coma",
										"ERROR",
										JOptionPane.ERROR_MESSAGE,
										null);
						txtPvp
								.requestFocus();

					}
				}
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								(String) "Error. El Stock "
										+ Stocki
										+ " es erroneo debe ser numeros maximo 10 y minimo de 1 decimal ",
								"ERROR",
								JOptionPane.ERROR_MESSAGE,
								null);
				txtStock.requestFocus();

			}
		}
	} else {
		JOptionPane.showMessageDialog(this,
				(String) "Error. El nombre "
						+ Nombrei
						+ " es erroneo debe ser  minimo 2 y maximo de 64 caracteres",
				"ERROR",
				JOptionPane.ERROR_MESSAGE,
				null);
		txtNombre.requestFocus();

	}
}
} else {
JOptionPane.showMessageDialog(this,
		(String) "Error. La marca "
				+ Marcai
				+ " es erroneo debe ser  minimo 2 y maximo de 64 caracteres",
		"ERROR", JOptionPane.ERROR_MESSAGE,
		null);
txtMarca.requestFocus();

}
	}
	}
	else {
		JOptionPane.showMessageDialog(this,
				(String) "Error. El id Pieza "
						+ Piezai
						+ " es erroneo debe  empezar con P y despues 5 caracteres de numeros.",
				"ERROR", JOptionPane.ERROR_MESSAGE,
				null);
		txtPieza.requestFocus();

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
				eliminarCliente();
				txtPieza.setText("");
				txtNombre.setText("");
				txtPvp.setText("");
				txtPrecioC.setText("");
				txtStock.setText("");
				txtMarca.setText("");

			}
		} else if (boton == btnModifiacar) {
			filaseleccionada = table.getSelectedRow();
			if (filaseleccionada < 0) {
				// si no tenemos nada selccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para Modificar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);

			} else {

				if (verificarCampos(txtPieza)) {
					Piezam = txtPieza.getText();
					if (Piezam.matches("[P]{1,1}[0-9]{5,5}")) {

					if (verificarCampos(txtMarca)) {
						Marcam = txtMarca.getText();
						if (Marcam.matches("[a-zA-Z]{2,64}")) {

						
						if (verificarCampos(txtNombre)) {
							Nombrem = txtNombre.getText();
							if (Nombrem.matches("[a-zA-Z]{2,64}")) {

							if (verificarCampos(txtStock)) {
								Stockm = Integer.parseInt(txtStock.getText());
								StockM = String.valueOf(Stockm); 
								if (StockM.matches("[0-9]{1,10}")) {
									if (verificarCampos(txtPvp)) {
										PVPm = Double.parseDouble(txtPvp.getText());
										PvpM = String.valueOf(PVPm); 
										if (PvpM.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {

											if (verificarCampos(txtPrecioC)) {
												PrecioCm = Double.parseDouble(txtPrecioC.getText());
												PrecioM = String.valueOf(PrecioCm); 
												if (PrecioM.matches("[0-9]{0,10}\\.[0-9]{0,2}")) {
				
											Estadom = (String) cmbEstado.getSelectedItem();
											filaseleccionada = table.convertRowIndexToModel(filaseleccionada);

							
										Pieza =  (String) table.getValueAt(filaseleccionada, 0);
										Marca =  (String) table.getValueAt(filaseleccionada, 1);
										Nombre = (String) table.getValueAt(filaseleccionada, 2);
										stock =	 (String) table.getValueAt(filaseleccionada, 3);
										pvp =    (String) table.getValueAt(filaseleccionada, 4);
										precio =(String) table.getValueAt(filaseleccionada, 5);
										Estado = (String) table.getValueAt(filaseleccionada, 6);

										if (Pieza.equals(Piezam)) {
											modificarPieza();
											JOptionPane.showMessageDialog(this,
													(String) "La Pieza con Id pieza " + Piezam
															+ " se a modificado correctamente",
													"Pieza Modificada", JOptionPane.INFORMATION_MESSAGE, null);	
										
										} else

											JOptionPane.showMessageDialog(this,
													(String) "Error. La pieza no se puede modificar se pondra el dato correcto automaticamente",
													"ERROR", JOptionPane.ERROR_MESSAGE, null);
										txtPieza.setText(Pieza);
									
										 
									}else {
												JOptionPane
														.showMessageDialog(
																this,
																(String) "Error. El Precio "
																		+ PrecioM
																		+ " es erroneo debe ser numeros maximo 10 y minimo de 1 decimal y luego con un minimo de 0 y maximo 2 caracteres despues de la coma",
																"ERROR",
																JOptionPane.ERROR_MESSAGE,
																null);
												txtPrecioC
														.requestFocus();

											}
										}
									} else {
										JOptionPane
												.showMessageDialog(
														this,
														(String) "Error. El PVP "
																+ PvpM
																+ " es erroneo debe ser numeros maximo 10 y minimo de 1 decimal y luego con un minimo de 0 y maximo 2 caracteres despues de la coma",
														"ERROR",
														JOptionPane.ERROR_MESSAGE,
														null);
										txtPvp
												.requestFocus();

									}
								}
							} else {
								JOptionPane
										.showMessageDialog(
												this,
												(String) "Error. El Stock "
														+ StockM
														+ " es erroneo debe ser numeros maximo 10 y minimo de 1 decimal ",
												"ERROR",
												JOptionPane.ERROR_MESSAGE,
												null);
								txtStock.requestFocus();

							}
						}
					} else {
						JOptionPane.showMessageDialog(this,
								(String) "Error. El nombre "
										+ Nombrem
										+ " es erroneo debe ser  minimo 2 y maximo de 64 caracteres",
								"ERROR",
								JOptionPane.ERROR_MESSAGE,
								null);
						txtNombre.requestFocus();

					}
				}
			} else {
				JOptionPane.showMessageDialog(this,
						(String) "Error. La marca "
								+ Marcam
								+ " es erroneo debe ser  minimo 2 y maximo de 64 caracteres",
						"ERROR", JOptionPane.ERROR_MESSAGE,
						null);
				txtMarca.requestFocus();

			}
					}
					}
					else {
						JOptionPane.showMessageDialog(this,
								(String) "Error. El id Pieza "
										+ Piezam
										+ " es erroneo debe  empezar con P y despues 5 caracteres de numeros.",
								"ERROR", JOptionPane.ERROR_MESSAGE,
								null);
						txtPieza.requestFocus();

					}
			}
			// lo inserto tambien en la tabla
			}
		} else if (boton == btnVaciar) {

			if (dtmTabla.getRowCount() != 0) {
				vaciarCliente();
				if (modificado) {

					txtPieza.setText("");
					txtNombre.setText("");
					txtPvp.setText("");
					txtPrecioC.setText("");
					txtStock.setText("");
					txtMarca.setText("");

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
			txtPieza.setText(String.valueOf(table.getValueAt(seleccion, 0)));
			txtMarca.setText(String.valueOf(table.getValueAt(seleccion, 1)));
			txtNombre.setText(String.valueOf(table.getValueAt(seleccion, 2)));
			txtStock.setText(String.valueOf(table.getValueAt(seleccion, 3)));
			txtPvp.setText(String.valueOf(table.getValueAt(seleccion, 4)));
			txtPrecioC.setText(String.valueOf(table.getValueAt(seleccion, 5)));
			Codactual = (String) table.getValueAt(seleccion, 6);
			cmbEstado.setSelectedItem(Codactual);

		}

	}

}
