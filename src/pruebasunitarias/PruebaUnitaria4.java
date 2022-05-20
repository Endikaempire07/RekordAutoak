package pruebasunitarias;

import org.junit.jupiter.api.Test;
/**
 * 
 * 
 * @author Endika
 *
 */
public class PruebaUnitaria4  {

	@Test

		 void sumartest1(){
			int a = 30;
			int b = 6;
			int expected = 5;
			int resultadoOptenido;
			resultadoOptenido = a / b;
			if (expected == resultadoOptenido ) {
				System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");		}
		
		}
			@Test

		 void sumartest2(){
			int a = 54;
			int b = 6;
			int expected = 9;
			int resultadoOptenido;
			resultadoOptenido = a / b;
			if (expected == resultadoOptenido ) {
				System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");
			}
			
		}
	
}
