package matriz.rellena.espiral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatrizPrb {

	static int lados = 7; 	//Tamaño de la matriz cuadrada
	static int itG = 0; 	//Numero del ciclo de la iteracion 
	static int La = 0; 		//Tamaño del lado a escribir 
	static double Rm = 0;	//Número de rangos (intervalos)  que se debe escribir (de acuerdo al tamaño)
	static int M = 0;		//Número del intervalo mayor
	static int m = 0;		//Número del intervalo menor 
	
	//Ejes sobre los que va a escribir
	static int ejeX = 0;
	static int ejeY = 0;
	static int anti_ejeX = 0;
	static int anti_ejeY = 0;
	
	
	
	static List<Object> calculoDeTodosValoresLadoNorte() {
		/* NOTA SOBRE LOS DATOS
		 * 
		 * 0 	== Rm: Número de rangos (intervalos)  que se debe escribir 
		 * 1 	== La: Tamaño del lado a escribir
		 * 2-n 	== Intervalos que va a escribir (siendo 2 valores, M para Máx., m para mín.)
		 * 
		 */
		
		List<Object> valores = new ArrayList<>();
		
		//Setteando el valor de 'Rm'
		Rm =  Math.ceil(lados / 2);
		
		//Iniciando y seteando el valor de 'La'
		La = lados - 1;
		
		//Agregando Rm y La a 'valores'
		valores.add(Rm);
		valores.add(La);
		
		//Creando el ciclo For
		for (int i = 0; i < Rm; i++) {
			//System.out.println("La:" +  + " - [M:" +  + " - m:" +  + "]");
			La--;
		}				
		
		return null;
	}
	
	static int[] valoresLadoNorte(int lados, int itG)
	{
		System.out.println("lados:" + lados + " - itG:" + itG);
		int [] resul =  new int[2];
		
		resul[0] = lados - itG;		//Valor de 'M'
		resul[1] = lados - resul[0] - 1;//Valor de 'm'
		
		return resul;
	}	
	
	static int[] valoresLadoDerecha(int lados, int itG)
	{
		System.out.println("lados:" + lados + " - itG:" + itG);
		int [] resul =  new int[2];
		
		resul[0] = lados - itG;		//Valor de 'M'
		resul[1] = lados - resul[0];//Valor de 'm'
		
		return resul;
	}
		
	static int[] valoresLadoSur(int lados, int itG)
	{
		System.out.println("lados:" + lados + " - itG:" + itG);
		int [] resul =  new int[2];
		
		resul[0] = lados - itG;		//Valor de 'M'
		resul[1] = lados - resul[0];//Valor de 'm'
		
		return resul;
	}
	
	static int[] valoresLadoIzquierda(int lados, int itG)
	{
		System.out.println("lados:" + lados + " - itG:" + itG);
		int [] resul =  new int[2];
		
		resul[0] = lados - itG - 1;		//Valor de 'M'
		resul[1] = lados - resul[0] - 1;//Valor de 'm'
		
		return resul;
	}
	
	public static void main(String[] args) {
		//Creando la matriz
		int [][] matriz = new int[lados] [lados];
		
		//Aplicando el valor de "La"
		La = lados;		
		
		//Inicializando los ejes y anti_ejes
		ejeX = 0;				//Dir NORTE
		ejeY = 0;				//Dir DERECHA
		anti_ejeX = lados - 1;	//Dir SUR
		anti_ejeY = lados - 1;	//Dir IZQUIERDA
		
		//Iniciandolo el Número de ITeraciones Globales
		itG = 1;
		//Contador que rellenará la matriz ruta en forma espiral
		int cont = 1;
		//Declaracion del rango de valores a escribir
		int[] rango;
		
		//Creando el ciclo mayor 
		while(La > 0) {
			
			//FOR para los datos que se escriban hacia arriba - NORTE
			rango = valoresLadoNorte(lados, itG);
			M = rango[0];
			m = rango[1];
			System.out.println("NORTE\nLa: " + La + " - [M:" + M  + " - m:" + m + "]");
			
			for( ; M >= m; M--) {
				matriz[ejeX][M]=cont;
				System.out.println("matriz["+ejeX+"]["+M+"]:"+cont);
				cont++;
				//M--;		//Desplazamiento hacia ARRIBA/NORTE
			}
			
			//Incremento para moverse a la sig columna (hacia la derecha)
			ejeX++;
			
			//Reducción del Tamaño del lado a escribir
			La--;
			
			//Rompe el ciclo
			if (La == 0) {
				break;
			}
			
			//-------------------------------------------------
			
			//FOR para los datos que se escriban hacia DERECHA
			rango = valoresLadoDerecha(lados, itG);
			M = rango[0];
			m = rango[1];
			System.out.println("DERECHA\nLa: " + La + " - [M:" + M  + " - m:" + m + "]");			
			
			for( ; m <= M; m++) {
				matriz[m][ejeY] = cont;
				System.out.println("matriz["+m+"]["+ejeY+"]:"+cont);
				cont++;
			}
			
			//Incremento para moverse a la sig columna (hacia abajo)
			ejeY++;
			
			//FOR para los datos que se escriban hacia ABAJO/SUR
			rango = valoresLadoSur(lados, itG);
			M = rango[0];
			m = rango[1];
			System.out.println("Sur\nLa: " + La + " - [M:" + M  + " - m:" + m + "]");
			
			for( ; m <= M; m++) {
				matriz[anti_ejeX][m] = cont;
				System.out.println("matriz["+anti_ejeX+"]["+m+"]:"+cont);
				cont++;
			}

			//Incremento para moverse a la sig columna (hacia izquierda)
			anti_ejeX--;
			
			//Reducción
			La--;
			
			//Rompe el ciclo
			if(La == 0) {
				break;
			}			
			
			//-------------------------------------------------
			
			//FOR para los datos que se escriban hacia IZQUIERDA
			rango = valoresLadoIzquierda(lados, itG);
			M = rango[0];
			m = rango[1];
			System.out.println("Izquierda\nLa: " + La + " - [M:" + M  + " - m:" + m + "]");
			
			for( ; M >= m; M--) {
				matriz[M][anti_ejeY] = cont;
				System.out.println("matriz["+M+"]["+anti_ejeY+"]:"+cont);
				cont++;
			}

			//Incremento para moverse a la sig columna (hacia izquierda)
			anti_ejeY--;
			
			//Termina el ciclo y se incrementa ITG
			itG++;
		};
		
		/*System.out.println("\n\n\n\nMATRIZ DE COMPROBACION\n");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.println( "Matriz["+i+"]["+j+"]::"+matriz[i][j]);			
			}			
		}*/
		
		System.out.println("\n\n\n\nMATRIZ\n");
		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print( "Mtz["+x+"]["+y+"]::"+matriz[x][y] + "\t\t");				
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n\nMATRIZ ACOMODADA (empieza por la esq. sup. Izq.)\n");
		for (int x = 0; x < matriz.length; x++) {
			for (int y = matriz[x].length - 1; y >= 0; y--) {
				System.out.print( "Mtz["+x+"]["+y+"]::"+matriz[x][y] + "\t\t");				
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n\nMATRIZ ACOMODADA (empieza por la esq. inf. Der.)\n");
		for (int x = 0; x < matriz.length; x++) {
			for (int y = matriz[x].length - 1; y >= 0; y--) {
				System.out.print( "Mtz["+y+"]["+x+"]::"+matriz[y][x] + "\t\t");				
			}
			System.out.println();
		}

		System.out.println("\n\n\n\nMATRIZ ACOMODADA (empieza por la esq. inf. Izq.)\n");
		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print( "Mtz["+y+"]["+x+"]::"+matriz[y][x] + "\t\t");				
			}
			System.out.println();
		}
		
	}

}
