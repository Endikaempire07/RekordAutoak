package Ventanas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Ventanas.Clientes;
import Ventanas.Ordenes;
/**
*
* @author Grupo 4 
*/
public class LogsOrdendetrabajo {
 // registrar nueva orden de trabajo
	/**
	 * 
	 * 
	 * @param nuevaorden
	 */
	public static void logCrearorden(Ordenes nuevaorden) {
		File dir = new File("C:\\Rekordautoak\\Logs");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String id = nuevaorden.getOrden();
		//formato de fecha
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   
		//bufers
		File f;
		FileWriter fw;
		PrintWriter pw;
		BufferedWriter bw;
		try {
			//escribir en archivo
			f = new File("C:\\Rekordautoak\\Logs\\logCrearorden.txt");
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
			bw = new BufferedWriter(pw);

			bw.write("una nueva orden con id: "+id + " ha sido creada a las " + "yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
			bw.newLine();
		
		
			bw.close();
			pw.close();
			fw.close();
			
		}
		catch (IOException e) {
			System.out.println("error");
		}
		
	}
	
//registrar cambios en orden de tabajo
	/**
	 * 
	 * 
	 * @param nuevaorden
	 */
	public static void logmodorden(Ordenes nuevaorden) {
		File dir = new File("C:\\Rekordautoak\\Logs");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String id = nuevaorden.getOrden();
		//formato de fecha
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   
		//bufers
		File f;
		FileWriter fw;
		PrintWriter pw;
		BufferedWriter bw;
		try {
			//escribir en archivo
			f = new File("C:\\Rekordautoak\\Logs\\logmodorden.txt");
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
			bw = new BufferedWriter(pw);

			bw.write("la orden con id: "+id + " ha sido modificada a las " + "yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
			bw.newLine();
		
		
			bw.close();
			pw.close();
			fw.close();
			
		}
		catch (IOException e) {
			System.out.println("error");
		}
		
	}
	
//registrar fanializacion de orden
	/**
	 * 
	 * 
	 * @param nuevaorden
	 */
	public static void logfinorden(Ordenes nuevaorden) {
		File dir = new File("C:\\Rekordautoak\\Logs");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String id = nuevaorden.getOrden();
		//formato de fecha
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   
		//bufers
		File f;
		FileWriter fw;
		PrintWriter pw;
		BufferedWriter bw;
		try {
			//escribir en archivo
			f = new File("C:\\Rekordautoak\\Logs\\logfinorden.txt");
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
			bw = new BufferedWriter(pw);

			bw.write("la orden con id: "+id + " ha sido finalizada a las " + "yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
			bw.newLine();
		
		
			bw.close();
			pw.close();
			fw.close();
			
		}
		catch (IOException e) {
			System.out.println("error");
		}
		
	}
//registrar fanializacion de orden
	/**
	 * 
	 * 
	 * @param id
	 */
	public static void imprimirfactura(String id) {
		File dir = new File("C:\\Rekordautoak\\Logs");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		//formato de fecha
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   
		//bufers
		File f;
		FileWriter fw;
		PrintWriter pw;
		BufferedWriter bw;
		try {
			//escribir en archivo
			f = new File("C:\\Rekordautoak\\Logs\\loggenfacturas.txt");
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
			bw = new BufferedWriter(pw);

			bw.write("Se ha generado una factura con id: "+id + " ha sido finalizada a las " + "yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
			bw.newLine();
		
		
			bw.close();
			pw.close();
			fw.close();
			
		}
		catch (IOException e) {
			System.out.println("error");
		}
		
	}
}
