package Ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

/**
* Ventana para visualiar la factura
* @author Grupo 4 
*/
public class Factura extends JFrame implements ActionListener{
	private static final long serialVersionUID = 596395190344805803L;

	private JPanel panelPrincipal;

	private JLabel labelTelefonoCliente;
	private JLabel labelMatricula;
	public String id;
	/**
	 * Modelos de lista, p\u00fablico para poder agregar elementos desde la ventana anterior
	 */
	public DefaultTableModel dtmordendetrabajo = new DefaultTableModel();

	/**
	 * Etiquetas de texto, p\u00fablicas para poder cambiar el texto desde la ventana anterior
	 */
	protected JLabel lblNombreCliente,
	              lblDNI,
	              lblEmail,
	              lblDireccionCliente,
	              lblTelefonoCliente,
	              lblMatricula,
	              lblMarca,
	              lblFechaITV,
	              lblModelo,
	              lblTotalBase,
	              lblImporteIVA,
	              lblTotal,
	              lblNumeroFactura,
	              lblMecanico,
	              lblFecha;
	protected JTable tablarep;
	private JButton btnimprimir;
	private String ida;
	private String fecha;
	/**
	 * Abrir la ventana
	 * @param args Generado autom\u00e1ticamente
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factura frame = new Factura();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crear el JFrame
	 */
	public Factura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Factura.class.getResource("/resources/favicon.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Factura.class.getResource("/facturas/icono.png")));
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("RekordAutoak - Impresion Factura");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(Factura.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 918);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		
		btnimprimir = new JButton("Guardar como pdf");
		menuBar.add(btnimprimir);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.rowHeights = new int[] {94, 0, 164, 288, 0};
		gbl_panelPrincipal.columnWeights = new double[]{1.0};
		gbl_panelPrincipal.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		btnimprimir.addActionListener(this);
		
		JPanel panelDatosRKA = new JPanel();
		panelDatosRKA.setForeground(Color.BLACK);
		panelDatosRKA.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelDatosRKA = new GridBagConstraints();
		gbc_panelDatosRKA.anchor = GridBagConstraints.NORTH;
		gbc_panelDatosRKA.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatosRKA.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelDatosRKA.gridx = 0;
		gbc_panelDatosRKA.gridy = 1;
		panelPrincipal.add(panelDatosRKA, gbc_panelDatosRKA);
		GridBagLayout gbl_panelDatosRKA = new GridBagLayout();
		gbl_panelDatosRKA.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		gbl_panelDatosRKA.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panelDatosRKA.setLayout(gbl_panelDatosRKA);
		
		JLabel labelRKA = new JLabel("Rekord Autoak");
		labelRKA.setBackground(Color.WHITE);
		labelRKA.setForeground(Color.BLACK);
		labelRKA.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_labelRKA = new GridBagConstraints();
		gbc_labelRKA.fill = GridBagConstraints.BOTH;
		gbc_labelRKA.insets = new Insets(0, 0, 5, 5);
		gbc_labelRKA.gridx = 0;
		gbc_labelRKA.gridy = 0;
		panelDatosRKA.add(labelRKA, gbc_labelRKA);
		
		JLabel labelFactura = new JLabel("Factura");
		labelFactura.setForeground(Color.BLACK);
		labelFactura.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_labelFactura = new GridBagConstraints();
		gbc_labelFactura.fill = GridBagConstraints.BOTH;
		gbc_labelFactura.insets = new Insets(0, 0, 5, 0);
		gbc_labelFactura.gridx = 3;
		gbc_labelFactura.gridy = 0;
		panelDatosRKA.add(labelFactura, gbc_labelFactura);
		
		JLabel lblGaratTxominHiribidea = new JLabel("Garat Txomin Hiribidea, 6, 48004 Bilbo, Bizakaia");
		lblGaratTxominHiribidea.setForeground(Color.BLACK);
		lblGaratTxominHiribidea.setFont(new Font("Calibri", Font.BOLD, 15));
		lblGaratTxominHiribidea.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblGaratTxominHiribidea = new GridBagConstraints();
		gbc_lblGaratTxominHiribidea.anchor = GridBagConstraints.WEST;
		gbc_lblGaratTxominHiribidea.insets = new Insets(0, 0, 5, 5);
		gbc_lblGaratTxominHiribidea.gridx = 0;
		gbc_lblGaratTxominHiribidea.gridy = 1;
		panelDatosRKA.add(lblGaratTxominHiribidea, gbc_lblGaratTxominHiribidea);
		
		JLabel labelNombreCliente_4 = new JLabel("");
		labelNombreCliente_4.setForeground(Color.BLACK);
		labelNombreCliente_4.setFont(new Font("Calibri", Font.BOLD, 18));
		labelNombreCliente_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelNombreCliente_4 = new GridBagConstraints();
		gbc_labelNombreCliente_4.anchor = GridBagConstraints.WEST;
		gbc_labelNombreCliente_4.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombreCliente_4.gridx = 1;
		gbc_labelNombreCliente_4.gridy = 1;
		panelDatosRKA.add(labelNombreCliente_4, gbc_labelNombreCliente_4);
		
		JLabel lblContactorekordautoakcom = new JLabel("contacto@rekordautoak.com");
		lblContactorekordautoakcom.setForeground(Color.BLACK);
		lblContactorekordautoakcom.setFont(new Font("Calibri", Font.BOLD, 15));
		lblContactorekordautoakcom.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblContactorekordautoakcom = new GridBagConstraints();
		gbc_lblContactorekordautoakcom.anchor = GridBagConstraints.WEST;
		gbc_lblContactorekordautoakcom.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactorekordautoakcom.gridx = 0;
		gbc_lblContactorekordautoakcom.gridy = 2;
		panelDatosRKA.add(lblContactorekordautoakcom, gbc_lblContactorekordautoakcom);
		
		JLabel lbls = new JLabel("89526899S");
		lbls.setForeground(Color.BLACK);
		lbls.setFont(new Font("Calibri", Font.BOLD, 15));
		lbls.setBackground(Color.WHITE);
		GridBagConstraints gbc_lbls = new GridBagConstraints();
		gbc_lbls.anchor = GridBagConstraints.WEST;
		gbc_lbls.insets = new Insets(0, 0, 5, 5);
		gbc_lbls.gridx = 1;
		gbc_lbls.gridy = 2;
		panelDatosRKA.add(lbls, gbc_lbls);
		
		JLabel labelNumeroFactura = new JLabel("N\u00BA Factura:");
		labelNumeroFactura.setForeground(Color.BLACK);
		labelNumeroFactura.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelNumeroFactura = new GridBagConstraints();
		gbc_labelNumeroFactura.fill = GridBagConstraints.VERTICAL;
		gbc_labelNumeroFactura.anchor = GridBagConstraints.EAST;
		gbc_labelNumeroFactura.insets = new Insets(0, 0, 5, 5);
		gbc_labelNumeroFactura.gridx = 2;
		gbc_labelNumeroFactura.gridy = 2;
		panelDatosRKA.add(labelNumeroFactura, gbc_labelNumeroFactura);
		
		lblNumeroFactura = new JLabel("\"N\u00BA Factura\"");
		lblNumeroFactura.setForeground(Color.BLACK);
		lblNumeroFactura.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNumeroFactura = new GridBagConstraints();
		gbc_lblNumeroFactura.fill = GridBagConstraints.BOTH;
		gbc_lblNumeroFactura.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumeroFactura.gridx = 3;
		gbc_lblNumeroFactura.gridy = 2;
		panelDatosRKA.add(lblNumeroFactura, gbc_lblNumeroFactura);
		
		JLabel lblVizcaya = new JLabel("+34 666 777 888");
		lblVizcaya.setForeground(Color.BLACK);
		lblVizcaya.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVizcaya.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblVizcaya = new GridBagConstraints();
		gbc_lblVizcaya.anchor = GridBagConstraints.WEST;
		gbc_lblVizcaya.insets = new Insets(0, 0, 0, 5);
		gbc_lblVizcaya.gridx = 0;
		gbc_lblVizcaya.gridy = 3;
		panelDatosRKA.add(lblVizcaya, gbc_lblVizcaya);
		
		JLabel lblVizcaya_1 = new JLabel("Vizcaya");
		lblVizcaya_1.setForeground(Color.BLACK);
		lblVizcaya_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVizcaya_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblVizcaya_1 = new GridBagConstraints();
		gbc_lblVizcaya_1.anchor = GridBagConstraints.WEST;
		gbc_lblVizcaya_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblVizcaya_1.gridx = 1;
		gbc_lblVizcaya_1.gridy = 3;
		panelDatosRKA.add(lblVizcaya_1, gbc_lblVizcaya_1);
		
		JLabel labelFecha = new JLabel("Fecha:");
		labelFecha.setForeground(Color.BLACK);
		labelFecha.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelFecha = new GridBagConstraints();
		gbc_labelFecha.fill = GridBagConstraints.VERTICAL;
		gbc_labelFecha.anchor = GridBagConstraints.EAST;
		gbc_labelFecha.insets = new Insets(0, 0, 0, 5);
		gbc_labelFecha.gridx = 2;
		gbc_labelFecha.gridy = 3;
		panelDatosRKA.add(labelFecha, gbc_labelFecha);
		
		lblFecha = new JLabel("\"Fecha\"");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.fill = GridBagConstraints.BOTH;
		gbc_lblFecha.gridx = 3;
		gbc_lblFecha.gridy = 3;
		panelDatosRKA.add(lblFecha, gbc_lblFecha);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatos.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelDatos.anchor = GridBagConstraints.NORTH;
		gbc_panelDatos.gridx = 0;
		gbc_panelDatos.gridy = 2;
		panelPrincipal.add(panelDatos, gbc_panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[] {0, 242, 119, 117, 190, 0};
		gbl_panelDatos.rowHeights = new int[] {13, 0, 0, 0, 0, 0, 13};
		gbl_panelDatos.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE, 0.0};
		gbl_panelDatos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDatos.setLayout(gbl_panelDatos);
		
		JLabel labelCliente = new JLabel("Cliente");
		labelCliente.setBackground(Color.WHITE);
		labelCliente.setForeground(Color.BLACK);
		labelCliente.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_labelCliente = new GridBagConstraints();
		gbc_labelCliente.fill = GridBagConstraints.BOTH;
		gbc_labelCliente.insets = new Insets(0, 0, 5, 5);
		gbc_labelCliente.gridx = 0;
		gbc_labelCliente.gridy = 0;
		panelDatos.add(labelCliente, gbc_labelCliente);
		
		JLabel labelVehiculo = new JLabel("Veh\u00EDculo");
		labelVehiculo.setBackground(Color.WHITE);
		labelVehiculo.setForeground(Color.BLACK);
		labelVehiculo.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_labelVehiculo = new GridBagConstraints();
		gbc_labelVehiculo.fill = GridBagConstraints.BOTH;
		gbc_labelVehiculo.insets = new Insets(0, 0, 5, 5);
		gbc_labelVehiculo.gridx = 3;
		gbc_labelVehiculo.gridy = 0;
		panelDatos.add(labelVehiculo, gbc_labelVehiculo);
		
		JLabel labelNombreCliente = new JLabel("Nombre:");
		labelNombreCliente.setBackground(Color.WHITE);
		labelNombreCliente.setForeground(Color.BLACK);
		labelNombreCliente.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelNombreCliente = new GridBagConstraints();
		gbc_labelNombreCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombreCliente.gridx = 0;
		gbc_labelNombreCliente.gridy = 1;
		panelDatos.add(labelNombreCliente, gbc_labelNombreCliente);
		
		lblNombreCliente = new JLabel("\"Nombre\"");
		lblNombreCliente.setBackground(Color.WHITE);
		lblNombreCliente.setForeground(Color.BLACK);
		lblNombreCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.fill = GridBagConstraints.BOTH;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 1;
		gbc_lblNombreCliente.gridy = 1;
		panelDatos.add(lblNombreCliente, gbc_lblNombreCliente);
		
		labelMatricula = new JLabel("Matr\u00EDcula:");
		labelMatricula.setBackground(Color.WHITE);
		labelMatricula.setForeground(Color.BLACK);
		labelMatricula.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelMatricula = new GridBagConstraints();
		gbc_labelMatricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_labelMatricula.gridx = 3;
		gbc_labelMatricula.gridy = 1;
		panelDatos.add(labelMatricula, gbc_labelMatricula);
		
		lblMatricula = new JLabel("\"Matr\u00EDcula\"");
		lblMatricula.setBackground(Color.WHITE);
		lblMatricula.setForeground(Color.BLACK);
		lblMatricula.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMatricula = new GridBagConstraints();
		gbc_lblMatricula.fill = GridBagConstraints.BOTH;
		gbc_lblMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricula.gridx = 4;
		gbc_lblMatricula.gridy = 1;
		panelDatos.add(lblMatricula, gbc_lblMatricula);
		
		JLabel labelDNI = new JLabel("DNI:");
		labelDNI.setBackground(Color.WHITE);
		labelDNI.setForeground(Color.BLACK);
		labelDNI.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelDNI = new GridBagConstraints();
		gbc_labelDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDNI.insets = new Insets(0, 0, 5, 5);
		gbc_labelDNI.gridx = 0;
		gbc_labelDNI.gridy = 2;
		panelDatos.add(labelDNI, gbc_labelDNI);
		
		lblDNI = new JLabel("\"DNI\"");
		lblDNI.setBackground(Color.WHITE);
		lblDNI.setForeground(Color.BLACK);
		lblDNI.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.fill = GridBagConstraints.BOTH;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 1;
		gbc_lblDNI.gridy = 2;
		panelDatos.add(lblDNI, gbc_lblDNI);
		
		JLabel labelmarca = new JLabel("Marca:");
		labelmarca.setBackground(Color.WHITE);
		labelmarca.setForeground(Color.BLACK);
		labelmarca.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelmarca = new GridBagConstraints();
		gbc_labelmarca.fill = GridBagConstraints.BOTH;
		gbc_labelmarca.insets = new Insets(0, 0, 5, 5);
		gbc_labelmarca.gridx = 3;
		gbc_labelmarca.gridy = 2;
		panelDatos.add(labelmarca, gbc_labelmarca);
		
		lblMarca = new JLabel("\"Marca\"");
		lblMarca.setBackground(Color.WHITE);
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.fill = GridBagConstraints.BOTH;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 4;
		gbc_lblMarca.gridy = 2;
		panelDatos.add(lblMarca, gbc_lblMarca);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBackground(Color.WHITE);
		labelEmail.setFont(new Font("Calibri", Font.BOLD, 15));
		labelEmail.setForeground(Color.BLACK);
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 3;
		panelDatos.add(labelEmail, gbc_labelEmail);
		
		lblEmail = new JLabel("\"Email\"");
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		panelDatos.add(lblEmail, gbc_lblEmail);
		
		JLabel labelITVPasada = new JLabel("Modelo:");
		labelITVPasada.setBackground(Color.WHITE);
		labelITVPasada.setFont(new Font("Calibri", Font.BOLD, 15));
		labelITVPasada.setForeground(Color.BLACK);
		GridBagConstraints gbc_labelITVPasada = new GridBagConstraints();
		gbc_labelITVPasada.fill = GridBagConstraints.BOTH;
		gbc_labelITVPasada.insets = new Insets(0, 0, 5, 5);
		gbc_labelITVPasada.gridx = 3;
		gbc_labelITVPasada.gridy = 3;
		panelDatos.add(labelITVPasada, gbc_labelITVPasada);
		
		lblModelo = new JLabel("\"modelo\"");
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.fill = GridBagConstraints.BOTH;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 4;
		gbc_lblModelo.gridy = 3;
		panelDatos.add(lblModelo, gbc_lblModelo);
		
		JLabel labelDireccionCliente = new JLabel("Direcci\u00F3n:");
		labelDireccionCliente.setBackground(Color.WHITE);
		labelDireccionCliente.setFont(new Font("Calibri", Font.BOLD, 15));
		labelDireccionCliente.setForeground(Color.BLACK);
		GridBagConstraints gbc_labelDireccionCliente = new GridBagConstraints();
		gbc_labelDireccionCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDireccionCliente.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccionCliente.gridx = 0;
		gbc_labelDireccionCliente.gridy = 4;
		panelDatos.add(labelDireccionCliente, gbc_labelDireccionCliente);
		
		lblDireccionCliente = new JLabel("\"Direccion\"");
		lblDireccionCliente.setBackground(Color.WHITE);
		lblDireccionCliente.setForeground(Color.BLACK);
		lblDireccionCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDireccionCliente = new GridBagConstraints();
		gbc_lblDireccionCliente.fill = GridBagConstraints.BOTH;
		gbc_lblDireccionCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccionCliente.gridx = 1;
		gbc_lblDireccionCliente.gridy = 4;
		panelDatos.add(lblDireccionCliente, gbc_lblDireccionCliente);
		
		JLabel labelFechaITV = new JLabel("Fecha ITV:");
		labelFechaITV.setBackground(Color.WHITE);
		labelFechaITV.setForeground(Color.BLACK);
		labelFechaITV.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelFechaITV = new GridBagConstraints();
		gbc_labelFechaITV.fill = GridBagConstraints.BOTH;
		gbc_labelFechaITV.insets = new Insets(0, 0, 5, 5);
		gbc_labelFechaITV.gridx = 3;
		gbc_labelFechaITV.gridy = 4;
		panelDatos.add(labelFechaITV, gbc_labelFechaITV);
		
		lblFechaITV = new JLabel("\"Fecha ITV\"");
		lblFechaITV.setBackground(Color.WHITE);
		lblFechaITV.setForeground(Color.BLACK);
		lblFechaITV.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblFechaITV = new GridBagConstraints();
		gbc_lblFechaITV.fill = GridBagConstraints.BOTH;
		gbc_lblFechaITV.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaITV.gridx = 4;
		gbc_lblFechaITV.gridy = 4;
		panelDatos.add(lblFechaITV, gbc_lblFechaITV);
		
		labelTelefonoCliente = new JLabel("Tel\u00E9fono:");
		labelTelefonoCliente.setBackground(Color.WHITE);
		labelTelefonoCliente.setForeground(Color.BLACK);
		labelTelefonoCliente.setFont(new Font("Calibri", Font.BOLD, 15));
		GridBagConstraints gbc_labelTelefonoCliente = new GridBagConstraints();
		gbc_labelTelefonoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelTelefonoCliente.insets = new Insets(0, 0, 0, 5);
		gbc_labelTelefonoCliente.gridx = 0;
		gbc_labelTelefonoCliente.gridy = 5;
		panelDatos.add(labelTelefonoCliente, gbc_labelTelefonoCliente);
		
		lblTelefonoCliente = new JLabel("\"Tel\u00E9fono\"");
		lblTelefonoCliente.setBackground(Color.WHITE);
		lblTelefonoCliente.setForeground(Color.BLACK);
		lblTelefonoCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTelefonoCliente = new GridBagConstraints();
		gbc_lblTelefonoCliente.fill = GridBagConstraints.BOTH;
		gbc_lblTelefonoCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefonoCliente.gridx = 1;
		gbc_lblTelefonoCliente.gridy = 5;
		panelDatos.add(lblTelefonoCliente, gbc_lblTelefonoCliente);
		
		JPanel panelReparacion = new JPanel();
		panelReparacion.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelReparacion = new GridBagConstraints();
		gbc_panelReparacion.insets = new Insets(0, 0, 5, 0);
		gbc_panelReparacion.fill = GridBagConstraints.BOTH;
		gbc_panelReparacion.gridx = 0;
		gbc_panelReparacion.gridy = 3;
		panelPrincipal.add(panelReparacion, gbc_panelReparacion);
		GridBagLayout gbl_panelReparacion = new GridBagLayout();
		gbl_panelReparacion.columnWidths = new int[] {130, 171, 130, 130, 130, 0};
		gbl_panelReparacion.rowHeights = new int[]{0, 45, 330, 0};
		gbl_panelReparacion.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelReparacion.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelReparacion.setLayout(gbl_panelReparacion);
		
		JLabel labelDescripcion = new JLabel("Descripci\u00F3n");
		labelDescripcion.setBackground(Color.WHITE);
		labelDescripcion.setFont(new Font("Calibri", Font.BOLD, 20));
		labelDescripcion.setForeground(Color.BLACK);
		GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
		gbc_labelDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDescripcion.fill = GridBagConstraints.BOTH;
		gbc_labelDescripcion.gridx = 0;
		gbc_labelDescripcion.gridy = 0;
		panelReparacion.add(labelDescripcion, gbc_labelDescripcion);
		
		JLabel labelMecanico = new JLabel("Mec\u00E1nico:");
		labelMecanico.setBackground(Color.WHITE);
		labelMecanico.setForeground(Color.BLACK);
		labelMecanico.setFont(new Font("Calibri", Font.BOLD, 18));
		GridBagConstraints gbc_labelMecanico = new GridBagConstraints();
		gbc_labelMecanico.anchor = GridBagConstraints.EAST;
		gbc_labelMecanico.insets = new Insets(0, 0, 5, 5);
		gbc_labelMecanico.fill = GridBagConstraints.VERTICAL;
		gbc_labelMecanico.gridx = 3;
		gbc_labelMecanico.gridy = 0;
		panelReparacion.add(labelMecanico, gbc_labelMecanico);
		
		lblMecanico = new JLabel("\"Mecanico\"");
		lblMecanico.setBackground(Color.WHITE);
		lblMecanico.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMecanico.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblMecanico = new GridBagConstraints();
		gbc_lblMecanico.anchor = GridBagConstraints.WEST;
		gbc_lblMecanico.insets = new Insets(0, 0, 5, 0);
		gbc_lblMecanico.gridx = 4;
		gbc_lblMecanico.gridy = 0;
		panelReparacion.add(lblMecanico, gbc_lblMecanico);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panelReparacion.add(scrollPane, gbc_scrollPane);
		
		tablarep = new JTable();
		tablarep.setBackground(Color.WHITE);
		tablarep.setForeground(Color.BLACK);
		tablarep.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablarep);
		
	

		
		JPanel panelResumen = new JPanel();
		panelResumen.setForeground(Color.BLACK);
		panelResumen.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelResumen = new GridBagConstraints();
		gbc_panelResumen.fill = GridBagConstraints.BOTH;
		gbc_panelResumen.gridx = 0;
		gbc_panelResumen.gridy = 4;
		panelPrincipal.add(panelResumen, gbc_panelResumen);
		GridBagLayout gbl_panelResumen = new GridBagLayout();
		gbl_panelResumen.columnWidths = new int[] {611, 100, 0};
		gbl_panelResumen.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelResumen.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelResumen.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelResumen.setLayout(gbl_panelResumen);
		
		JLabel labelTotalBase = new JLabel("Total base:");
		labelTotalBase.setForeground(Color.BLACK);
		labelTotalBase.setFont(new Font("Calibri", Font.BOLD, 18));
		GridBagConstraints gbc_labelTotalBase = new GridBagConstraints();
		gbc_labelTotalBase.anchor = GridBagConstraints.EAST;
		gbc_labelTotalBase.insets = new Insets(0, 0, 5, 5);
		gbc_labelTotalBase.gridx = 0;
		gbc_labelTotalBase.gridy = 0;
		panelResumen.add(labelTotalBase, gbc_labelTotalBase);
		
		lblTotalBase = new JLabel("\"Total base\"");
		lblTotalBase.setForeground(Color.BLACK);
		lblTotalBase.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTotalBase = new GridBagConstraints();
		gbc_lblTotalBase.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalBase.gridx = 1;
		gbc_lblTotalBase.gridy = 0;
		panelResumen.add(lblTotalBase, gbc_lblTotalBase);
		
		JLabel labelIVA = new JLabel("I.V.A. %:");
		labelIVA.setForeground(Color.BLACK);
		labelIVA.setFont(new Font("Calibri", Font.BOLD, 18));
		GridBagConstraints gbc_labelIVA = new GridBagConstraints();
		gbc_labelIVA.insets = new Insets(0, 0, 5, 5);
		gbc_labelIVA.anchor = GridBagConstraints.EAST;
		gbc_labelIVA.gridx = 0;
		gbc_labelIVA.gridy = 1;
		panelResumen.add(labelIVA, gbc_labelIVA);
		
		JLabel label21 = new JLabel("21%");
		label21.setForeground(Color.BLACK);
		label21.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_label21 = new GridBagConstraints();
		gbc_label21.fill = GridBagConstraints.VERTICAL;
		gbc_label21.insets = new Insets(0, 0, 5, 0);
		gbc_label21.gridx = 1;
		gbc_label21.gridy = 1;
		panelResumen.add(label21, gbc_label21);
		
		JLabel labelImporteIVA = new JLabel("Importe I.V.A. :");
		labelImporteIVA.setForeground(Color.BLACK);
		labelImporteIVA.setFont(new Font("Calibri", Font.BOLD, 18));
		GridBagConstraints gbc_labelImporteIVA = new GridBagConstraints();
		gbc_labelImporteIVA.anchor = GridBagConstraints.EAST;
		gbc_labelImporteIVA.insets = new Insets(0, 0, 5, 5);
		gbc_labelImporteIVA.gridx = 0;
		gbc_labelImporteIVA.gridy = 2;
		panelResumen.add(labelImporteIVA, gbc_labelImporteIVA);
		
		lblImporteIVA = new JLabel("\"Importe I.V.A.\"");
		lblImporteIVA.setForeground(Color.BLACK);
		lblImporteIVA.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gbc_lblImporteIVA = new GridBagConstraints();
		gbc_lblImporteIVA.insets = new Insets(0, 0, 5, 0);
		gbc_lblImporteIVA.gridx = 1;
		gbc_lblImporteIVA.gridy = 2;
		panelResumen.add(lblImporteIVA, gbc_lblImporteIVA);
		
		JLabel labelTotal = new JLabel("Total:");
		labelTotal.setForeground(Color.BLACK);
		labelTotal.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_labelTotal = new GridBagConstraints();
		gbc_labelTotal.insets = new Insets(0, 0, 0, 5);
		gbc_labelTotal.anchor = GridBagConstraints.EAST;
		gbc_labelTotal.fill = GridBagConstraints.VERTICAL;
		gbc_labelTotal.gridx = 0;
		gbc_labelTotal.gridy = 3;
		panelResumen.add(labelTotal, gbc_labelTotal);
		
		lblTotal = new JLabel("\"Total\"");
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Calibri", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.fill = GridBagConstraints.VERTICAL;
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 3;
		panelResumen.add(lblTotal, gbc_lblTotal);
	
		
		 
		 
	}
	
	public void pagada() {
		
		
		

			try {
				// CONECTO LA BASE DE DATOS
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/rekordautoak", "root", "");
				// creo una sentencia que pueda ir por delante y por detras
				Statement st = conexion.createStatement();
				
				
				ida =lblNumeroFactura.getText();

				String consulta = "UPDATE factura SET pagada ='pagada' WHERE IdFactura ='"+ida+"';";

				st.executeUpdate(consulta);

				// cierro el Statement
				st.close();
				// cierro la conexion
				conexion.close();

				

			} catch (SQLException e) {
				// si se produce una excepción SQL
				@SuppressWarnings("unused")
				int errorcode = e.getErrorCode();

				JOptionPane.showMessageDialog(this, (String) "Error SQL Numero " + e.getErrorCode() + ":" + e.getMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE, null);
			}

		
	}
/**
 * accion del boton
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object botonPulsado = e.getSource();
		
		if(botonPulsado == btnimprimir) {
			

			ida =lblNumeroFactura.getText();
			btnimprimir.setVisible(false);
			java.awt.Image image = Imprimirpdf.getImageFromPanel(panelPrincipal);
			String filename = "C:\\Rekordautoak\\Facturas\\id_"+ida+"_factura.pdf";
			Imprimirpdf.printToPDF(image,filename);
			JOptionPane.showMessageDialog(this, (String) "factura generada con exito", "Guardado en carpeta facturas",
					JOptionPane.INFORMATION_MESSAGE, null);
			btnimprimir.setVisible(true);
			
			pagada();
			
			this.dispose();


			
		}
		
		
		
		
	}
	
}