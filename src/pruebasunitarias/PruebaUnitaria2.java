package pruebasunitarias;

import org.junit.jupiter.api.Test;

public class PruebaUnitaria2  {


	@Test

		 void sumartest1(){
			int a = 5;
			int b = 6;
			int expected = 30;
			int resultadoOptenido;
			resultadoOptenido = a * b;
			if (expected == resultadoOptenido ) {
				System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");		}
		
		}
	@Test

		 void sumartest2(){
			int a = 9;
			int b = 6;
			int expected = 54;
			int resultadoOptenido;
			resultadoOptenido = a * b;
			if (expected == resultadoOptenido ) {
				System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");
			}
			
		}

}
