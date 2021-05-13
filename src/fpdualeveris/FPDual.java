package fpdualeveris;

import java.util.Scanner;

import variables.Developer;

/**
 * Desaf�o 1 - Java
 * 
 * @author aguerrre
 *
 */
public class FPDual {
	/**
	 * M�todo principal
	 * 
	 * @param args
	 */
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// La variable opci�n marcar� con qu� opci�n se trabaja.
		int opcion = 0;
		do {
			// Se imprime el men� con las opciones disponibles.
			System.out.println("\nElige una opci�n introduciendo el n�mero de la misma:\n1. Introducir empleado.\n2. Mostrar n�mero total de empleados.\n"
			        + "3. Mostrar ID de los empleados.\n4. Descontar d�as de vacaciones.\n5. Consultar d�as de vacaciones de los empleados.\n6. Salir.");
			try {
				// La opci�n elegida se guarda. Se realiza un parseo para evitar errores del objeto Scanner.
				opcion = Integer.parseInt(sc.nextLine());
				// Se trata la excepci�n si la hubiera, y se reinicia la opci�n a 0.
			} catch (Exception e) {
				System.out.println(e.toString());
				opcion = 0;
			}
			// Se eval�a qu� opci�n se ha elegido y seg�n �sta se ejecuta un m�todo u otro.
			switch (opcion) {
			case 1:
				variablesChallenge();
				break;
			case 2:
				printTotalEmployee();
				break;
			case 3:
				showEmployeesID();
				break;
			case 4:
				deductHolidayDays();
				break;
			case 5:
				showHolidayRemain();
				break;
			case 6:
				break;
			default:
				System.out.println("Opci�n no disponible.");
				break;
			}
		} while (opcion != 6);
		System.out.println("Has salido del programa.");
	}

	/**
	 * M�todo que muestra los d�as de vacaciones restantes de cada empleado.
	 */
	private static void showHolidayRemain() {
		System.out.println("Vacaciones restantes de cada empleado");
		for (Developer a : Developer.getEmployeeNumber()) {
			System.out.println("El empleado " + a.getName() + " tiene " + a.holidayRemain() + " d�as restantes.");
		}
	}

	/**
	 * M�todo para quitar d�as de vacaciones
	 */
	private static void deductHolidayDays() {
		// Se comprueba si el m�todo searchEmployeeByID() ha devuelto un objeto Developer o no
		Developer dev = searchEmployeeByID();
		if (dev != null) {
			int dias = 0;
			System.out.println("Introduce el n�mero de d�as de vacaciones a descontar:");
			try {
				// Los d�as elegidos se guardan. Se realiza un parseo para evitar errores del objeto Scanner.
				dias = Integer.parseInt(sc.nextLine());
				// Se trata la excepci�n si la hubiera, y se reinicia el n�mero de d�as a 0.
			} catch (Exception e) {
				System.out.println(e.toString());
				dias = 0;
			}
			// Se asignan el n�mero de d�as elegidos al objeto Developer
			dev.setHolidayUsed(dias);
		} else {
			System.out.println("No se ha seleccionado ning�n empleado.");
		}

	}

	/**
	 * M�todo para buscar objetos Developer seg�n su atributo ID
	 */
	private static Developer searchEmployeeByID() {
		// Se inicia el ID a 128 ya que no deben existir empleados con ID superior a 127.
		int id = 128;
		System.out.println("Introduce el ID del empleado que quieres deducir d�as de vacaciones:");
		try {
			// El ID elegido se guarda. Se realiza un parseo para evitar errores del objeto Scanner.
			id = Integer.parseInt(sc.nextLine());
			// Se trata la excepci�n si la hubiera, y se reinicia el ID a 128.
		} catch (Exception e) {
			System.out.println(e.toString());
			id = 128;
		}
		// Se hace una primera comprobaci�n sobre el propio ID y sobre el objeto que nos devuelve el m�todo de clase getDeveloperById(id)
		if ((id < 128 && id > 0) && Developer.getDeveloperByID(id) != null) {
			// Si se cumple, se devuelve el objeto Developer
			return Developer.getDeveloperByID(id);
		} else {
			// Si no, da un aviso, y devuelve null.
			System.out.println("El ID introducido es err�neo");
		}
		return null;
	}

	/**
	 * M�todo para imprimir un listado con el empleado y su ID
	 */
	private static void showEmployeesID() {
		System.out.println("ID de los empleados:");
		// El bucle obtiene cada Developer almacenado en la List
		for (Developer a : Developer.getEmployeeNumber()) {
			System.out.println("El empleado " + a.getName() + " tiene el ID " + a.getIdNumber() + ".");
		}
	}

	/**
	 * M�todo para imprimir el n�mero de empleados
	 */
	private static void printTotalEmployee() {
		// Se llama a la propiedad size de la Lista EMPLOYEE_NUMBER para saber cu�ntos empleados hay
		System.out.println("El n�mero total de empleados es: " + Developer.getEmployeeNumber().size());
	}

	/**
	 * M�todo para instanciar objetos de la clase Developer
	 */
	private static void variablesChallenge() {
		// Se introduce el nombre del nuevo empleado y se instancia un objeto.
		System.out.println("Introduce el nombre del nuevo empleado:");
		String name = sc.nextLine();
		new Developer(name);
	}

}
