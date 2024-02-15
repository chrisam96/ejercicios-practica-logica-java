package JuegoGato;

import java.security.SecureRandom;
import java.util.Scanner;

public class Juego {
	//PROPIEDADES
	//Matriz del Juego
	private static String [][] matriz = new String[3][3];
	//Contador del turno
	private static int contador = 0;
	//Scanner para leer la posicion de inserción
	private static Scanner scan = new Scanner(System.in);	
	//Randomizer para tirar en un lugar
	private static SecureRandom rand =  new SecureRandom(); 	
	//Posiciones usadas por el usuario
	private static int x=0, y=0;
	
	//METODOS
	//Metodo que verifica quien gano
	public static boolean checador () {
		if(contador > 4) {
			//Checando las filas
			for (int i = 0; i < matriz.length; i++) {
				if (matriz[i][0].equals("X") && matriz[i][1].equals("X") && matriz[i][2].equals("X") ) {					
					System.out.println("X GANA");					
					return true;
				}				
				else if (matriz[i][0].equals("O") && matriz[i][1].equals("O") && matriz[i][2].equals("O") ) {
					System.out.println("O GANA");
					return true;
				}
			}
			
			//Checando las columnas
			for (int i = 0; i < matriz.length; i++) {
				if (matriz[0][i].equals("X") && matriz[1][i].equals("X") && matriz[2][i].equals("X") ) {					
					System.out.println("X GANA");
					return true;
				}				
				else if (matriz[0][i].equals("O") && matriz[1][i].equals("O") && matriz[2][i].equals("O") ) {					
					System.out.println("O GANA");
					return true;
				}
			}
			
			//Checando la diagonal izquierda
			if (matriz[0][0].equals("X") && matriz[1][1].equals("X") && matriz[2][2].equals("X") ) {				
				System.out.println("X GANA");
				return true;
			}				
			else if (matriz[0][0].equals("O") && matriz[1][1].equals("O") && matriz[2][2].equals("O") ) {				
				System.out.println("O GANA");
				return true;
			}
			
			//Checando la diagonal derecha
			if (matriz[0][2].equals("X") && matriz[1][1].equals("X") && matriz[2][0].equals("X") ) {				
				System.out.println("X GANA");
				return true;
			}				
			else if (matriz[0][2].equals("O") && matriz[1][1].equals("O") && matriz[2][2].equals("O") ) {				
				System.out.println("O GANA");
				return true;
			}
			
			//Si no entro en ninguna combinacion ganadora => false
			return false;
		}
		return false;
	}
	
	//Metodo para checar si la casilla esta ocupada o no
	public static boolean verificarCasillaOcupada(int x, int y) {
		if (/*matriz[x][y] == null ||*/ matriz[x][y].equalsIgnoreCase("")) {
			return true;
		}
		System.out.println("Casilla ocupada - ["+x+"]["+y+"]");
		return false;
	}
	
	//Metodo para imprimir el tablero
	public static void imprimirTablero() {
		System.out.println("Turno #"+contador);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				String txt = matriz[i][j]; 
				if (txt.equals("")) { txt = " "; }
				
				// Quitado operador ternario por ser más verboso
				//txt = ( matriz[i][j].equals("") ) ? " " : matriz[i][j] ;
				System.out.print("|" + txt + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Metodo para rellenar el tablero con espacios en blanco
	public static void prellenarTablero() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = "";			
			}			
		}
	}
	
	//Metodo para recibir la jugada del jugador
	public static void tiradaJugador() {
		
		//Ciclo para la tirada del jugador
		do {
			System.out.print("Ingrese la posición (X) de la fila de su tirada: ");
			x = scan.nextInt();//Integer.parseInt(scan.nextLine());
			
			System.out.print("Ingrese la posición (Y) de la columna de su tirada: ");
			y = scan.nextInt();
			
			System.out.println();
		}while(!verificarCasillaOcupada(x, y));
		matriz[x][y] = "X";
	}
	
	//Metodo para decidir la jugada de la CPU 
	public static void tiradaCPU() {
		//Ciclo máquina
		do {
			x = rand.nextInt(3);
			y = rand.nextInt(3);
		} while (!verificarCasillaOcupada(x, y));
		System.out.println("Jugada CPU - x:"+x+" y:"+y);
		matriz[x][y] = "O";
	}
	
	//Metodo para saber el turno dentro del juego
	public static void decisionDelTurno(int turno) {
		if((turno % 2) == 1) { 
			tiradaJugador(); 
		} else
		{ 
			tiradaCPU(); 
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		//Scanner para leer la posicion de inserción
		Scanner scan = new Scanner(System.in);
		
		//Randomizer para tirar en un lugar
		SecureRandom rand =  new SecureRandom(); 
		*/
		
		//Posiciones usadas por el usuario
		int /*x=0, y=0,*/ opc=0;
		
		//Activar tablero
		prellenarTablero();
		
		//Menu del juego
		while(true) {
			System.out.print("¿Quien deberia empezar primero?\n"
					+ "\tPresione 1 para jugador\n"
					+ "\tPresione 2 para CPU\n"
					+ "Otra opcion sera ignorada\n"
					+ "Respuesta:");
			opc = scan.nextInt();
			if (opc == 1 || opc == 2) {				
				break;
			}
			System.out.println();
		}
		
		System.out.println();
		
		//Ciclo del juego
		while(contador < 10) {					
			/*
			//Ciclo para la tirada del jugador
			do {
				System.out.print("Ingrese la posición (X) de la fila de su tirada: ");
				x = scan.nextInt();//Integer.parseInt(scan.nextLine());
				
				System.out.print("Ingrese la posición (Y) de la columna de su tirada: ");
				y = scan.nextInt();
				
				System.out.println();
			}while(!verificarCasillaOcupada(x, y));
			matriz[x][y] = "X";
			*/
			decisionDelTurno(opc+contador);
			
			//Da paso al siguiente turno
			contador++;
			imprimirTablero();
			//Verifica quién ganó
			if(checador()) { break; }
			
			/*
			//Ciclo máquina
			do {
				x = rand.nextInt(3);
				y = rand.nextInt(3);
			} while (!verificarCasillaOcupada(x, y));
			System.out.println("Jugada CPU - x:"+x+" y:"+y);
			matriz[x][y] = "O";
			*/
			decisionDelTurno(opc+contador);
			
			//Da paso al siguiente turno
			contador++;
			imprimirTablero();
			//Verifica quién ganó			
			if(checador()) { break; }
		}
		
		if (contador == 10) {
			System.out.println("EMPATE");
		}
		
	}

}
