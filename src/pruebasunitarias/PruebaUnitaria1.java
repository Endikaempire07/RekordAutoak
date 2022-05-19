package pruebasunitarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
/**
 * 
 * 
 * @author Endika
 *
 */
public class PruebaUnitaria1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtDatos;
	private JLabel lblNewLabel;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaUnitaria1 frame = new PruebaUnitaria1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaUnitaria1() {
		setTitle("VentanaLeernum1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("0");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Introduzca un n\u00FAmero entero");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtDatos = new JTextField();
		txtDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtDatos);
		txtDatos.setText("0");
		txtDatos.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		contentPane.add(btnAceptar, BorderLayout.CENTER);
		btnAceptar.addActionListener(this);
	}
	public void sumartest1(){
		int a = 5;
		int b = 6;
		int expected = 11;
		int resultadoOptenido;
		resultadoOptenido = a + b;
		if (expected == resultadoOptenido ) {
			System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");		}
	
	}
	public void sumartest2(){
		int a = 9;
		int b = 6;
		int expected = 15;
		int resultadoOptenido;
		resultadoOptenido = a + b;
		if (expected == resultadoOptenido ) {
			System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");
		}
		
	}
	public void testCompleto() {
		sumartest1();
		sumartest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		testCompleto();
	}
}
