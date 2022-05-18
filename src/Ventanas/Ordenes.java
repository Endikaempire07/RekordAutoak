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
import java.awt.Component;
/**
* Ventana para visualiar lA VENTANA Ordenes
* @author Grupo 4 
*/
public class Ordenes extends Login implements Runnable, ActionListener, ListSelectionListener {

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
	private JLabel lblOrden;
	private JLabel lblEmple;
	private JLabel lblTiempo;
	private JLabel lblFecIni;
	private JLabel lblMatricula;
	private JLabel lblEstado;
	private JLabel lblestado;
	private JTextField txtOrden;
	private JTextField txtTiempoHoras;
	private JTextField txtFechaFin;
	private JComboBox<String> cmbMatricula;
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

	private String ordenm;
	private String matriculam;
	private String empleadom;
	private String fechiniciom;
	private String fechfinm;
	private String tiempohorasm;
	private int tiempohorM;
	private String descTrabajom;
	private String estadom;

	private String orden;
	private String matricula;
	private String empleado;
	private String fechinicio;
	private String fechfin;
	private String tiempohoras;
	private String descTrabajo;
	private String estado;

	private String ordenI;
	private String matriculaI;
	private String empleadoI;
	private String fechinicioI;
	private String fechfinI;
	private int tiempohorI;
	private String tiempohorasI;
	private String descTrabajoI;
	private String estadoI;

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

	private JComboBox<String> cmbEstado;
	private JComboBox<String> cmbEmpleado;

	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JPanel panel_4;

	private JTextField txtDescTrabajo;

	private JButton btnServicio;

	private JLabel lblNewLabel_15;
	private JLabel lblFecIni_1;
	private JTextField txtFechaInicio;
	private JButton btnPieza;
	private JButton btnCerrarSesion;
	private JButton btnReparacion;
	private JButton btnFactura;

	/**
	 * Create the frame.
	 * 
	 * @param Ordenes
	 * @throws SQLException
	 */
	public Ordenes() {
		setForeground(Color.WHITE);
		setTitle("RekordAutoak - Ordenes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 934);

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

		lblNewLabel_6 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		lblNewLabel_1 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel_12 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 3;
		gbc_lblNewLabel_12.gridy = 0;
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);

		lblEmpresa = new JLabel("Datos Empresa: ");
		lblEmpresa.setForeground(Color.WHITE);
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
		gbc_lblEmpresa.gridwidth = 3;
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
		gbc_lblNombreempresa.insets = new Insets(0, 0, 5, 5);
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
		gbl_panel_1.columnWidths = new int[] { 0, 115, 149, 0, 0, 140, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		lblNewLabel_13 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 3;
		gbc_lblNewLabel_13.gridy = 0;
		panel_1.add(lblNewLabel_13, gbc_lblNewLabel_13);

		lblNewLabel_3 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblNewLabel_19 = new JLabel("Datos Ordenes:");
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 1;
		gbc_lblNewLabel_19.gridy = 1;
		panel_1.add(lblNewLabel_19, gbc_lblNewLabel_19);

		lblOrden = new JLabel("Id Orden");
		lblOrden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrden.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblOrden = new GridBagConstraints();
		gbc_lblOrden.anchor = GridBagConstraints.WEST;
		gbc_lblOrden.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrden.gridx = 1;
		gbc_lblOrden.gridy = 2;
		panel_1.add(lblOrden, gbc_lblOrden);

		txtOrden = new JTextField();
		GridBagConstraints gbc_txtOrden = new GridBagConstraints();
		gbc_txtOrden.insets = new Insets(0, 0, 5, 5);
		gbc_txtOrden.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrden.gridx = 2;
		gbc_txtOrden.gridy = 2;
		panel_1.add(txtOrden, gbc_txtOrden);
		txtOrden.setColumns(10);

		lblFecIni_1 = new JLabel("Fehca Fin");
		lblFecIni_1.setForeground(Color.WHITE);
		lblFecIni_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFecIni_1 = new GridBagConstraints();
		gbc_lblFecIni_1.anchor = GridBagConstraints.WEST;
		gbc_lblFecIni_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecIni_1.gridx = 4;
		gbc_lblFecIni_1.gridy = 2;
		panel_1.add(lblFecIni_1, gbc_lblFecIni_1);

		txtFechaFin = new JTextField();
		GridBagConstraints gbc_txtFechaFin = new GridBagConstraints();
		gbc_txtFechaFin.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaFin.gridx = 5;
		gbc_txtFechaFin.gridy = 2;
		panel_1.add(txtFechaFin, gbc_txtFechaFin);
		txtFechaFin.setColumns(10);

		lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMatricula = new GridBagConstraints();
		gbc_lblMatricula.anchor = GridBagConstraints.WEST;
		gbc_lblMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricula.gridx = 1;
		gbc_lblMatricula.gridy = 3;
		panel_1.add(lblMatricula, gbc_lblMatricula);

		cmbMatricula = new JComboBox<String>();
		GridBagConstraints gbc_cmbMatricula = new GridBagConstraints();
		gbc_cmbMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_cmbMatricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbMatricula.gridx = 2;
		gbc_cmbMatricula.gridy = 3;
		panel_1.add(cmbMatricula, gbc_cmbMatricula);

		lblTiempo = new JLabel("Tiempo Horas");
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTiempo = new GridBagConstraints();
		gbc_lblTiempo.anchor = GridBagConstraints.WEST;
		gbc_lblTiempo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempo.gridx = 4;
		gbc_lblTiempo.gridy = 3;
		panel_1.add(lblTiempo, gbc_lblTiempo);

		txtTiempoHoras = new JTextField();
		txtTiempoHoras.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_txtTiempoHoras = new GridBagConstraints();
		gbc_txtTiempoHoras.insets = new Insets(0, 0, 5, 0);
		gbc_txtTiempoHoras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTiempoHoras.gridx = 5;
		gbc_txtTiempoHoras.gridy = 3;
		panel_1.add(txtTiempoHoras, gbc_txtTiempoHoras);
		txtTiempoHoras.setColumns(10);
		txtTiempoHoras.addKeyListener((KeyListener) new KeyAdapter() {
	           public void keyTyped(KeyEvent e) {
	              char caracter = e.getKeyChar();

	              // verificar si la tecla pulsada no es un dígito
	              if (caracter < '0' || caracter > '9') {
	                 e.consume();  // ignorar el evento de teclado
	              }
	           }
	        });

		lblEmple = new JLabel("Id Empleado");
		lblEmple.setForeground(Color.WHITE);
		lblEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmple = new GridBagConstraints();
		gbc_lblEmple.anchor = GridBagConstraints.WEST;
		gbc_lblEmple.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmple.gridx = 1;
		gbc_lblEmple.gridy = 4;
		panel_1.add(lblEmple, gbc_lblEmple);

		cmbEmpleado = new JComboBox<String>();
		GridBagConstraints gbc_cmbEmpleado = new GridBagConstraints();
		gbc_cmbEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEmpleado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEmpleado.gridx = 2;
		gbc_cmbEmpleado.gridy = 4;
		panel_1.add(cmbEmpleado, gbc_cmbEmpleado);

		lblEstado = new JLabel("Descripcion Trabajo");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 4;
		gbc_lblEstado.gridy = 4;
		panel_1.add(lblEstado, gbc_lblEstado);

		txtDescTrabajo = new JTextField();
		GridBagConstraints gbc_txtDescTrabajo = new GridBagConstraints();
		gbc_txtDescTrabajo.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescTrabajo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescTrabajo.gridx = 5;
		gbc_txtDescTrabajo.gridy = 4;
		panel_1.add(txtDescTrabajo, gbc_txtDescTrabajo);
		txtDescTrabajo.setColumns(10);

		lblFecIni = new JLabel("Fehca Inicio");
		lblFecIni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecIni.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblFecIni = new GridBagConstraints();
		gbc_lblFecIni.anchor = GridBagConstraints.WEST;
		gbc_lblFecIni.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecIni.gridx = 1;
		gbc_lblFecIni.gridy = 5;
		panel_1.add(lblFecIni, gbc_lblFecIni);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		GridBagConstraints gbc_txtFechaInicio = new GridBagConstraints();
		gbc_txtFechaInicio.insets = new Insets(0, 0, 0, 5);
		gbc_txtFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaInicio.gridx = 2;
		gbc_txtFechaInicio.gridy = 5;
		panel_1.add(txtFechaInicio, gbc_txtFechaInicio);

		lblestado = new JLabel("Id Estado\r\n");
		lblestado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestado.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblestado = new GridBagConstraints();
		gbc_lblestado.anchor = GridBagConstraints.WEST;
		gbc_lblestado.insets = new Insets(0, 0, 0, 5);
		gbc_lblestado.gridx = 4;
		gbc_lblestado.gridy = 5;
		panel_1.add(lblestado, gbc_lblestado);

		cmbEstado = new JComboBox<String>();
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEstado.gridx = 5;
		gbc_cmbEstado.gridy = 5;
		panel_1.add(cmbEstado, gbc_cmbEstado);

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

		btnAgregar = new JButton("Agregar Ordenes");
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

		btnModifiacar = new JButton("Modificar Ordenes");
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

		btnBorrar = new JButton("Borrar Ordenes");
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

		btnVaciar = new JButton("Vaciar Ordenes");
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
		lbl.setIcon(new ImageIcon(Ordenes.class.getResource("/resources/user-png-icon.png")));
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
		lblr.setIcon(new ImageIcon(Ordenes.class.getResource("/resources/rola.png")));
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
		panel_4.setBackground(Color.GRAY);
		Panel1.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 59, 57, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 60, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		lblNewLabel_15 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 0;
		panel_4.add(lblNewLabel_15, gbc_lblNewLabel_15);

		btnServicio = new JButton("Servicos");
		GridBagConstraints gbc_btnServicio = new GridBagConstraints();
		gbc_btnServicio.gridwidth = 8;
		gbc_btnServicio.insets = new Insets(0, 0, 0, 5);
		gbc_btnServicio.gridx = 1;
		gbc_btnServicio.gridy = 0;
		panel_4.add(btnServicio, gbc_btnServicio);
		
		btnPieza = new JButton("Pieza");
		GridBagConstraints gbc_btnPieza = new GridBagConstraints();
		gbc_btnPieza.gridwidth = 8;
		gbc_btnPieza.insets = new Insets(0, 0, 0, 5);
		gbc_btnPieza.gridx = 9;
		gbc_btnPieza.gridy = 0;
		panel_4.add(btnPieza, gbc_btnPieza);
		
		btnFactura = new JButton("Factura");
		GridBagConstraints gbc_btnFactura = new GridBagConstraints();
		gbc_btnFactura.gridwidth = 4;
		gbc_btnFactura.insets = new Insets(0, 0, 0, 5);
		gbc_btnFactura.gridx = 25;
		gbc_btnFactura.gridy = 0;
		panel_4.add(btnFactura, gbc_btnFactura);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.gridwidth = 4;
		gbc_btnCerrarSesion.gridx = 29;
		gbc_btnCerrarSesion.gridy = 0;
		panel_4.add(btnCerrarSesion, gbc_btnCerrarSesion);
				
				btnReparacion = new JButton("Reparacion");
				GridBagConstraints gbc_btnReparacion = new GridBagConstraints();
				gbc_btnReparacion.gridwidth = 8;
				gbc_btnReparacion.insets = new Insets(0, 0, 0, 5);
				gbc_btnReparacion.gridx = 17;
				gbc_btnReparacion.gridy = 0;
				panel_4.add(btnReparacion, gbc_btnReparacion);

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
		btnServicio.addActionListener(this);
		btnReparacion.addActionListener(this);
		btnPieza.addActionListener(this);
		btnFactura.addActionListener(this);


		

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
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.ordentrabajo");

			ResultSetMetaData metadatos = rs.getMetaData();
			int numeroColumnas = metadatos.getColumnCount();

			Vector<String> columnas = new Vector<String>();
			for (int i = 1; i <= numeroColumnas; i++) {
				columnas.add(metadatos.getColumnLabel(i));
			}

			// cabeceras de las columnas
			Vector<String> nombresColumnas = new Vector<String>();
			nombresColumnas.add("IdOrden");
			nombresColumnas.add("Matricula");
			nombresColumnas.add("IdEmple");
			nombresColumnas.add("FecInicio");
			nombresColumnas.add("FecFin");
			nombresColumnas.add("TiempoHoras");
			nombresColumnas.add("DescTrabajo");
			nombresColumnas.add("Estado");

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

				fila.add(rs.getString("idOrden"));
				fila.add(rs.getString("matricula"));
				fila.add(rs.getString("idEmple"));
				fila.add(rs.getString("fecInicio"));
				fila.add(rs.getString("fecFin"));
				fila.add(rs.getString("tiempoHoras"));
				fila.add(rs.getString("descTrabajo"));
				fila.add(rs.getString("estado"));
				dtmTabla.addRow(fila);

			}
			tabladatosEmple();
			tabladatosVehiculo();
			tabladatosEstado();

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
	/**
	 * 
	 * conexion con la base de datos con los empleados
	 * 
	 */ 
	public void tabladatosEmple() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.empleado;");
			while (rs.next()) {
				cmbEmpleado.addItem(rs.getString("id"));
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
	/**
	 * 
	 * conexion con la base de datos con vehiculos
	 * 
	 */
	public void tabladatosVehiculo() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.vehiculo;");

			while (rs.next()) {
				cmbMatricula.addItem(rs.getString("matricula"));

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
	/**
	 * 
	 * conexion con la base de datos con ordenes
	 * 
	 */
	public void tabladatosEstado() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// selecciono todos lod regitros de la tabla alumnos
			rs = st.executeQuery("SELECT * FROM rekordautoak.ordenTrabajo;");

			while (rs.next()) {
				cmbEstado.addItem(rs.getString("estado"));

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
	 * insertar ordenes en la base de datos y en la tabla
	 * 
	 */
	public void insertarOrdenes() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			
		
			
			
			String consulta = "Insert into rekordautoak.ordenTrabajo VALUES('" + ordenI + "','" + matriculaI + "','" + empleadoI
			+ "','" + fechinicioI + "'," + fechfinI + "," + tiempohorI + ",'"+ descTrabajoI +
			"','"+estadoI+ "');";
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
	 * vaciar ordenes de la base de datos y el programa
	 */
	private void vaciarOrdenes() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			consulta = "DELETE from rekordautoak.ordenTrabajo ;";
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
	 * eliminiar el orden seleccionada de la base de datos y el programa 
	 * 
	 * 
	 */
	public void eliminarOrdenes() {
		try {
			// CONECTO LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();
			String consulta;
			String orden;

			orden = txtOrden.getText();

			consulta = "DELETE from rekordautoak.ordenTrabajo  WHERE idOrden='" + orden + "';";
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
	public void modificarOrdenes() {
		try {
			// CONECTO LA BASE DE DATOS
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
			// creo una sentencia que pueda ir por delante y por detras
			Statement st = conexion.createStatement();

			// UPDATE `cliente` SET
			// `estado`='inactivo',`nombre`='jorge',`apellidos`='ape',`email`='sss@sss.es',`telefono`='123456789',`direccion`='Arrieta',`fecAlta`='2022/04/12'
			// WHERE 1
			String consulta = "UPDATE ordenTrabajo SET fecFin='" + fechfinm + "' , tiempoHoras ="
					+ tiempohorM + " , descTrabajo ='" + descTrabajom +"' , estado = '" + estadom +"'WHERE idOrden='" + orden + "';";
			
		
			st.executeUpdate(consulta);

			// cierro el Statement
			st.close();
			// cierro la conexion
			conexion.close();
	
			if (fechfin != fechfinm) {
				dtmTabla.setValueAt(fechfinm, filaseleccionada, 4);

			}
			if (tiempohoras != tiempohorasm) {
				dtmTabla.setValueAt(tiempohorasm, filaseleccionada, 5);

			}
			if (descTrabajo != descTrabajom) {
				dtmTabla.setValueAt(descTrabajom, filaseleccionada, 6);

			}
			if (estado != estadom) {
				dtmTabla.setValueAt(estadom, filaseleccionada, 7);

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

				Empleados vm = new Empleados();
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

				ayudaO vm = new ayudaO();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				this.dispose();

				vm.lblImagen.setIcon(new ImageIcon(ayudaO.class.getResource("/resources/ordenes_bueno.png")));

			}else if (boton == btnPieza) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Pieza vm = new Pieza();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

				vm.txtPrecioC.setEnabled(false);
				vm.txtMarca.setEnabled(false);
				vm.txtNombre.setEnabled(false);
				vm.txtPieza.setEnabled(false);
				vm.txtPvp.setEnabled(false);
				vm.txtStock.setEnabled(false);
				vm.cmbEstado.setEnabled(false);



				
				this.dispose();

			}else if (boton == btnServicio) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Servicios vm = new Servicios();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnBorrar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

			
				


				
				this.dispose();

			}else if (boton == btnReparacion) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Reparaciones vm = new Reparaciones();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnBorrar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

			
			

				



				
				this.dispose();

			}else if (boton == btnFactura) {
				
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Facturas vm = new Facturas();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				vm.btnImprimir.setEnabled(false);




				
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

				Empleados vm = new Empleados();
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

				ayudaO vm = new ayudaO();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				this.dispose();

				vm.lblImagen.setIcon(new ImageIcon(ayudaO.class.getResource("/resources/ordenes_bueno.png")));

			}else if (boton == btnPieza) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Pieza vm = new Pieza();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

				vm.txtPrecioC.setEnabled(false);
				vm.txtMarca.setEnabled(false);
				vm.txtNombre.setEnabled(false);
				vm.txtPieza.setEnabled(false);
				vm.txtPvp.setEnabled(false);
				vm.txtStock.setEnabled(false);
				vm.cmbEstado.setEnabled(false);



				
				this.dispose();

			}else if (boton == btnServicio) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Servicios vm = new Servicios();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
			
				vm.btnBorrar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

			
				vm.txDescripcion.setEnabled(false);
				vm.txtReparacion.setEnabled(false);
				vm.cmbEstado.setEnabled(false);



				
				this.dispose();

			}else if (boton == btnReparacion) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Reparaciones vm = new Reparaciones();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnBorrar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				



				
				this.dispose();

			}else if (boton == btnFactura) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Facturas vm = new Facturas();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnImprimir.setEnabled(false);




				
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

				ayudaO vm = new ayudaO();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);

				this.dispose();

				vm.lblImagen.setIcon(new ImageIcon(ayudaO.class.getResource("/resources/ordenes_bueno.png")));

			}else if (boton == btnPieza) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Pieza vm = new Pieza();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				



				
				this.dispose();

			}else if (boton == btnServicio) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Servicios vm = new Servicios();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				


				
				this.dispose();

			}else if (boton == btnReparacion) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Reparaciones vm = new Reparaciones();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				


				
				this.dispose();

			}else if (boton == btnFactura) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Facturas vm = new Facturas();
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

				Empleados vm = new Empleados();
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

			}else if (boton == ayuda) {
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

				this.dispose();

				vm.lblImagen.setIcon(new ImageIcon(ayudaO.class.getResource("/resources/ordenes_bueno.png")));

			} else if (boton == btnPieza) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Pieza vm = new Pieza();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

				vm.txtPrecioC.setEnabled(false);
				vm.txtMarca.setEnabled(false);
				vm.txtNombre.setEnabled(false);
				vm.txtPieza.setEnabled(false);
				vm.txtPvp.setEnabled(false);
				vm.txtStock.setEnabled(false);
				vm.cmbEstado.setEnabled(false);



				
				this.dispose();

			}else if (boton == btnServicio) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Servicios vm = new Servicios();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

			
				vm.txDescripcion.setEnabled(false);
				vm.txtReparacion.setEnabled(false);
				vm.cmbEstado.setEnabled(false);



				
				this.dispose();

			}else if (boton == btnReparacion) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Reparaciones vm = new Reparaciones();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);

			
				vm.txtReparacion.setEnabled(false);
				vm.txtPrecioH.setEnabled(false);
				vm.txtCantidad.setEnabled(false);
				
				vm.cmbOrden.setEnabled(false);
				vm.cmbServicio.setEnabled(false);
				vm.cmbPieza.setEnabled(false);

				



				
				this.dispose();

			}else if (boton == btnFactura) {
				nombre = lblnombre.getText();
				apellido = lblapellidos.getText();
				roles = lblroles.getText();
				numemple = lblNumemple.getText();

				Facturas vm = new Facturas();
				vm.setVisible(true);
				vm.lblnombre.setText(nombre);
				vm.lblapellidos.setText(apellido);
				vm.lblroles.setText(roles);
				vm.lblNumemple.setText(numemple);
				
				vm.btnAgregar.setEnabled(false);
				vm.btnBorrar.setEnabled(false);
				vm.btnModifiacar.setEnabled(false);
				vm.btnVaciar.setEnabled(false);
				vm.btnImprimir.setEnabled(false);




				
				this.dispose();
			}
		}

		if (boton == btnAgregar) {
			
			if (verificarCampos(txtOrden)) {
				ordenI = txtOrden.getText();
				if (ordenI.matches("[OT]{1,2}[0-9]{4,4}")) {

				if (verificarCampos(txtFechaInicio)) {
					fechinicioI = txtFechaInicio.getText();
					if (fechinicioI
							.matches(
									"^\\d{4}-\\d{2}-\\d{2}$")) {
						
						fechfinI = txtFechaFin.getText();
						if (fechfinI.equals("")){
							fechfinI = null;
						}
							
						if (verificarCampos(txtTiempoHoras)) {
							
							tiempohorI = Integer.parseInt(txtTiempoHoras.getText());
							 tiempohorasI =  txtTiempoHoras.getText();

							if (tiempohorasI.matches("[0-9]{1,2}")) {
								
								
							if (verificarCampos(txtDescTrabajo)) {
								descTrabajoI = txtDescTrabajo.getText();
								if (descTrabajoI
										.matches(
												"[a-zA-Z0-9_ ]{1,255}")) {

								
								descTrabajoI = txtDescTrabajo.getText();
								matriculaI = (String) cmbMatricula.getSelectedItem();
								empleadoI = (String) cmbEmpleado.getSelectedItem();
								estadoI = (String) cmbEstado.getSelectedItem();
										insertarOrdenes();
										if (modificado) {

											Vector<String> fila = new Vector<String>();
											fila.add(ordenI);
											fila.add(matriculaI);
											fila.add(empleadoI);
											fila.add(fechinicioI);
											fila.add(fechfinI);
											fila.add(tiempohorasI);
											fila.add(descTrabajoI);
											fila.add(estadoI);
											dtmTabla.addRow(fila);

											modificado = false;

											JOptionPane.showMessageDialog(this,
													(String) "La orden con Id Orden " + ordenI
															+ " se a insertado correctamente",
													"Orden Insertada", JOptionPane.INFORMATION_MESSAGE, null);	
										}

								} else {
									JOptionPane.showMessageDialog(this,
											(String) "Error. La descripcion " + descTrabajoI
													+ " es erroneo puede llevar numeros y letras con un maximo de 255 y un minimo de 1 caracter",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
									txtDescTrabajo.requestFocus();

								}
								}
								
							} else {
								JOptionPane.showMessageDialog(this,
										(String) "Error. El tiemmpo de hora " + tiempohorasI
												+ " es erroneo debe ser numeros maximo 2 y minimo de 1 decimales ",
										"ERROR", JOptionPane.ERROR_MESSAGE, null);
								txtTiempoHoras.requestFocus();

							}

						
						} 
					
					
				} else {
					JOptionPane.showMessageDialog(this,
							(String) "Error. La fecha inicio " + fechinicioI
									+ " es erroneo debe ser una fecha tipo YYYY/MM/DD",
							"ERROR", JOptionPane.ERROR_MESSAGE, null);
					txtFechaInicio.requestFocus();

				}

			
			}
				}	 else {
								JOptionPane.showMessageDialog(this,
										(String) "Error. El id orden " + ordenI
										+ " es erroneo debe  empezar con OT y despues 4 caracteres de numeros.",
										"ERROR", JOptionPane.INFORMATION_MESSAGE, null);
								txtOrden.requestFocus();

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
				eliminarOrdenes();
				txtFechaInicio.setText("");
				txtDescTrabajo.setText("");
				txtFechaFin.setText("");
				txtTiempoHoras.setText("");
				txtDescTrabajo.setText("");
			}
		} else if (boton == btnModifiacar) {
			filaseleccionada = table.getSelectedRow();
			if (filaseleccionada < 0) {
				// si no tenemos nada selccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para Modificar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);

			} else {


				
				if (verificarCampos(txtOrden)) {
					ordenm = txtOrden.getText();
					if (ordenm.matches("[OT]{2,2}[0-9]{4,4}")) {

					if (verificarCampos(txtFechaInicio)) {
						fechiniciom = txtFechaInicio.getText();
						if (fechiniciom
								.matches(
										"^\\d{4}-\\d{2}-\\d{2}$")) {
							if (verificarCampos(txtFechaInicio)) {
							fechfinm = txtFechaFin.getText();
							if (fechfinm.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
								
							if (verificarCampos(txtTiempoHoras)) {
								tiempohorM = Integer.parseInt(txtTiempoHoras.getText());
								tiempohorasm = txtTiempoHoras.getText();
								if (tiempohorasm.matches("[0-9]{1,2}")) {

								if (verificarCampos(txtDescTrabajo)) {
									descTrabajom = txtDescTrabajo.getText();
									if (descTrabajom
											.matches(
													"[a-zA-Z0-9_ ]{1,255}")) {

									
								descTrabajom = txtDescTrabajo.getText();
								filaseleccionada = table.convertRowIndexToModel(filaseleccionada);

								matriculam = (String) cmbMatricula.getSelectedItem();
								empleadom = (String) cmbEmpleado.getSelectedItem();
								estadom = (String) cmbEstado.getSelectedItem();
								
								
									orden = (String) table.getValueAt(filaseleccionada, 0);
									matricula = (String) table.getValueAt(filaseleccionada, 1);
									empleado = (String) table.getValueAt(filaseleccionada, 2);
									fechinicio = (String) table.getValueAt(filaseleccionada, 3);
									fechfin = (String) table.getValueAt(filaseleccionada, 4);
									tiempohoras = (String) table.getValueAt(filaseleccionada, 5);
									descTrabajo = (String) table.getValueAt(filaseleccionada, 6);
									estado = (String) table.getValueAt(filaseleccionada, 7);

									if (ordenm.equals(orden) && matriculam.equals(matricula) && empleadom.equals(empleado) && fechiniciom.equals(fechinicio)) {
										modificarOrdenes();
										
										modificado = false;

										JOptionPane.showMessageDialog(this,
												(String) "La orden con Id Orden " + ordenm
														+ " se a modificado correctamente",
												"Orden Modificada", JOptionPane.INFORMATION_MESSAGE, null);	
									}else{
										
										if(orden != ordenm){
											JOptionPane.showMessageDialog(this,
											(String) "Error. El id de la orden de trabajo no se puede modificar se pondra el dato correcto automaticamente",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
											
											txtOrden.setText(orden);


										}
										if(matricula != matriculam){
											JOptionPane.showMessageDialog(this,
											(String) "Error. La Matricula no se puede modificar se pondra el dato correcto automaticamente",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
											
											cmbMatricula.setSelectedItem(matricula);

										
										}
										if(empleado != empleadom){
											JOptionPane.showMessageDialog(this,
											(String) "Error. El empleado no se puede modificar se pondra el dato correcto automaticamente",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
											
											cmbEmpleado.setSelectedItem(empleado);


										
										
									}if(fechinicio != fechiniciom){
										JOptionPane.showMessageDialog(this,
										(String) "Error. La fecha de inicio  no se puede modificar se pondra el dato correcto automaticamente",
										"ERROR", JOptionPane.ERROR_MESSAGE, null);
										
										txtFechaInicio.setText(fechinicio);

									}
									}
									
									} else {
										JOptionPane.showMessageDialog(this,
												(String) "Error. La descripcion " + descTrabajom
														+ " es erroneo puede llevar numeros y letras con un maximo de 255 y un minimo de 1 caracter",
												"ERROR", JOptionPane.ERROR_MESSAGE, null);
										txtDescTrabajo.requestFocus();

									}
									}

								}
								 else {
									JOptionPane.showMessageDialog(this,
											(String) "Error. El tiempo de hora " + tiempohorasm
													+ " es erroneo debe ser numeros maximo 2 y minimo de 1 decimal ",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
									txtTiempoHoras.requestFocus();

								}
							}
							
							} else {
								JOptionPane.showMessageDialog(this,
										(String) "Error. La fecha fin " + fechfinm
										+ " es erroneo debe ser una fecha tipo YYYY-MM-DD",
										"ERROR", JOptionPane.ERROR_MESSAGE, null);
								txtFechaFin.requestFocus();

							}
							}
						
						
					} else {
						JOptionPane.showMessageDialog(this,
								(String) "Error. La fecha inicio " + fechiniciom
										+ " es erroneo debe ser una fecha tipo YYYY/MM/DD",
								"ERROR", JOptionPane.ERROR_MESSAGE, null);
						txtFechaInicio.requestFocus();

					}

				
				}
					}	 else {
									JOptionPane.showMessageDialog(this,
											(String) "Error. El id orden " + ordenm
											+ " es erroneo debe  empezar con OT y despues 4 caracteres de numeros.",
											"ERROR", JOptionPane.ERROR_MESSAGE, null);
									txtOrden.requestFocus();

								}

							}	
				// lo inserto tambien en la tabla

			
			}
		}else if (boton == btnVaciar) {

			if (dtmTabla.getRowCount() != 0) {
				vaciarOrdenes();
				if (modificado) {
					
					txtFechaInicio.setText("");
					txtDescTrabajo.setText("");
					txtFechaFin.setText("");
					txtTiempoHoras.setText("");
					txtDescTrabajo.setText("");

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

			txtOrden.setText(String.valueOf(table.getValueAt(seleccion, 0)));
			Codactual = (String) table.getValueAt(seleccion, 1);
			cmbMatricula.setSelectedItem(Codactual);
			Codactual1 = (String) table.getValueAt(seleccion, 2);
			cmbEmpleado.setSelectedItem(Codactual1);
			txtFechaInicio.setText(String.valueOf(table.getValueAt(seleccion, 3)));
			txtFechaFin.setText(String.valueOf(table.getValueAt(seleccion, 4)));
			txtTiempoHoras.setText(String.valueOf(table.getValueAt(seleccion, 5)));
			txtDescTrabajo.setText(String.valueOf(table.getValueAt(seleccion, 6)));
			Codactual2 = (String) table.getValueAt(seleccion, 7);
			cmbEstado.setSelectedItem(Codactual2);

		}

	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}
	
}
