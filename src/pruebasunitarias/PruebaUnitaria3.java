package pruebasunitarias;

import org.junit.jupiter.api.Test;


public class PruebaUnitaria3 {
	@Test

		 void sumartest1(){
			int a = 6;
			int b = 5;
			int expected = 1;
			int resultadoOptenido;
			resultadoOptenido = a - b;
			if (expected == resultadoOptenido ) {
				System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");		}
		
		}
		@Test

		 void sumartest2(){
			int a = 9;
			int b = 6;
			int expected = 3;
			int resultadoOptenido;
			resultadoOptenido = a - b;
			if (expected == resultadoOptenido ) {
				System.out.println(expected +"  expected  "+ resultadoOptenido +"  resultadoOptenido  ");
			}
			
		}


}
