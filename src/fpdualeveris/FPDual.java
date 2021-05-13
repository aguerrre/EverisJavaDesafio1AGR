package fpdualeveris;

import java.util.Scanner;

import variables.Developer;

/**
 * Desafío 1 - Java
 * 
 * @author aguerrre
 *
 */
public class FPDual {
	/**
	 * Método principal
	 * 
	 * @param args
	 */
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// La variable opción marcará con qué opción se trabaja.
		int opcion = 0;
		do {
			// Se imprime el menú con las opciones disponibles.
			System.out.println("\nElige una opción introduciendo el número de la misma:\n1. Introducir empleado.\n2. Mostrar número total de empleados.\n"
			        + "3. Mostrar ID de los empleados.\n4. Descontar días de vacaciones.\n5. Consultar días de vacaciones de los empleados.\n6. Salir.");
			try {
				// La opción elegida se guarda. Se realiza un parseo para evitar errores del objeto Scanner.
				opcion = Integer.parseInt(sc.nextLine());
				// Se trata la excepción si la hubiera, y se reinicia la opción a 0.
			} catch (Exception e) {
				System.out.println(e.toString());
				opcion = 0;
			}
			// Se evalúa qué opción se ha elegido y según ésta se ejecuta un método u otro.
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
				System.out.println("Opción no disponible.");
				break;
			}
		} while (opcion != 6);
		System.out.println("Has salido del programa.");
	}

	/**
	 * Método que muestra los días de vacaciones restantes de cada empleado.
	 */
	private static void showHolidayRemain() {
		System.out.println("Vacaciones restantes de cada empleado");
		for (Developer a : Developer.getEmployeeNumber()) {
			System.out.println("El empleado " + a.getName() + " tiene " + a.holidayRemain() + " días restantes.");
		}
	}

	/**
	 * Método para quitar días de vacaciones
	 */
	private static void deductHolidayDays() {
		// Se comprueba si el método searchEmployeeByID() ha devuelto un objeto Developer o no
		Developer dev = searchEmployeeByID();
		if (dev != null) {
			int dias = 0;
			System.out.println("Introduce el número de días de vacaciones a descontar:");
			try {
				// Los días elegidos se guardan. Se realiza un parseo para evitar errores del objeto Scanner.
				dias = Integer.parseInt(sc.nextLine());
				// Se trata la excepción si la hubiera, y se reinicia el número de días a 0.
			} catch (Exception e) {
				System.out.println(e.toString());
				dias = 0;
			}
			// Se asignan el número de días elegidos al objeto Developer
			dev.setHolidayUsed(dias);
		} else {
			System.out.println("No se ha seleccionado ningún empleado.");
		}

	}

	/**
	 * Método para buscar objetos Developer según su atributo ID
	 */
	private static Developer searchEmployeeByID() {
		// Se inicia el ID a 128 ya que no deben existir empleados con ID superior a 127.
		int id = 128;
		System.out.println("Introduce el ID del empleado que quieres deducir días de vacaciones:");
		try {
			// El ID elegido se guarda. Se realiza un parseo para evitar errores del objeto Scanner.
			id = Integer.parseInt(sc.nextLine());
			// Se trata la excepción si la hubiera, y se reinicia el ID a 128.
		} catch (Exception e) {
			System.out.println(e.toString());
			id = 128;
		}
		// Se hace una primera comprobación sobre el propio ID y sobre el objeto que nos devuelve el método de clase getDeveloperById(id)
		if ((id < 128 && id > 0) && Developer.getDeveloperByID(id) != null) {
			// Si se cumple, se devuelve el objeto Developer
			return Developer.getDeveloperByID(id);
		} else {
			// Si no, da un aviso, y devuelve null.
			System.out.println("El ID introducido es erróneo");
		}
		return null;
	}

	/**
	 * Método para imprimir un listado con el empleado y su ID
	 */
	private static void showEmployeesID() {
		System.out.println("ID de los empleados:");
		// El bucle obtiene cada Developer almacenado en la List
		for (Developer a : Developer.getEmployeeNumber()) {
			System.out.println("El empleado " + a.getName() + " tiene el ID " + a.getIdNumber() + ".");
		}
	}

	/**
	 * Método para imprimir el número de empleados
	 */
	private static void printTotalEmployee() {
		// Se llama a la propiedad size de la Lista EMPLOYEE_NUMBER para saber cuántos empleados hay
		System.out.println("El número total de empleados es: " + Developer.getEmployeeNumber().size());
	}

	/**
	 * Método para instanciar objetos de la clase Developer
	 */
	private static void variablesChallenge() {
		// Se introduce el nombre del nuevo empleado y se instancia un objeto.
		System.out.println("Introduce el nombre del nuevo empleado:");
		String name = sc.nextLine();
		new Developer(name);
	}

}
