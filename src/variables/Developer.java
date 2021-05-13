package variables;

import java.util.ArrayList;
import java.util.List;

/**
 * Desafío 1 - Java
 * 
 * @author aguerrre
 *
 */
public class Developer {

	/**
	 * ATRIBUTOS DE CLASE
	 */
	private static final String DEV_COMPANY = "Everis";
	private static final List<Developer> EMPLOYEE_NUMBER = new ArrayList<Developer>();
	private static final int HOLIDAY_MAX_DAYS = 21;
	/**
	 * ATRIBUTOS DE INSTANCIA
	 */
	private String name;
	private int idNumber;
	private int holidayUsed;

	/**
	 * Constructor con el nombre del empleado
	 * 
	 * @param name
	 */
	public Developer(String name) {
		super();
		// Comprueba si el número de empleados es menor a 127. Si es menor, crea un nuevo empleado. Si es mayor, no lo crea.
		if (EMPLOYEE_NUMBER.size() < 128) {
			this.name = name;
			this.idNumber = EMPLOYEE_NUMBER.size() + 1;
			this.holidayUsed = 0;
			EMPLOYEE_NUMBER.add(this);
		} else {
			System.out.println("No se pueden agregar más empleados.");
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idNumber
	 */
	public int getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber
	 *            the idNumber to set
	 */
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * @return the holidayUsed
	 */
	public int getHolidayUsed() {
		return holidayUsed;
	}

	/**
	 * @param holidayUsed
	 *            the holidayUsed to set
	 */
	public void setHolidayUsed(int holidayUsed) {
		this.holidayUsed = holidayUsed;
	}

	/**
	 * 
	 * @return the holiday day's remains
	 */
	public int holidayRemain() {
		// Obtiene el número de días de vacaciones disponibles para un empleado.
		return Developer.getHolidayMaxDays() - this.getHolidayUsed();
	}

	/**
	 * @return the devCompany
	 */
	public static String getDevCompany() {
		return DEV_COMPANY;
	}

	/**
	 * @return the employeeNumber
	 */
	public static List<Developer> getEmployeeNumber() {
		return EMPLOYEE_NUMBER;
	}

	/**
	 * @return the holidayMaxDays
	 */
	public static int getHolidayMaxDays() {
		return HOLIDAY_MAX_DAYS;
	}

	/**
	 * Método que devuelve un objeto Developer si el id del objeto coincide con el id pasado por parámetro.
	 * @param id
	 * @return Developer
	 */
	public static Developer getDeveloperByID(int id) {
		for (Developer a : EMPLOYEE_NUMBER) {
			if (id == a.getIdNumber())
				return a;
		}
		return null;
	}
}
