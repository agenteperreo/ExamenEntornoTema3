package fraccion;

/**
 * En esta clase definiremos una fraccion
 * 
 * @author igarcia
 *
 */
public class Fraccion {

	/**
	 * Atributo que será el numerador de la fracción
	 */
	private int num;

	/**
	 * Atributo que será el denominador de la fracción
	 */
	private int den;

	/**
	 * Constructor por defecto que debe generar el valor neutro que es 0/1
	 */

	public Fraccion() {
		num = 0;
		den = 1;

	}

	/**
	 * Constructor con parámetros que debe evitar crear fracciones con 0 en el
	 * divisor y llamo a la funcion simplificar para simplificar la fracción
	 * 
	 * @param num Numerador de la fracción
	 * @param den Denominador de la fracción
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	/**
	 * Constructor copia
	 * 
	 * @param f La fracción hecha una constante
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * Setter del numerador de la fracción
	 * 
	 * @param num Numerador de la fracción
	 */

	public void setNum(int num) {
		this.num = num;

	}

	/**
	 * Getter del numerador de la fracción
	 * 
	 * @return Numerador de la fracción
	 */
	public int getNum() {
		return num;

	}

	/**
	 * Setter del denominador de la fracción
	 * 
	 * @param den denominador de la fracción
	 */
	public void setDen(int den) {
		this.den = den;
	}

	/**
	 * Getter del denominador de la fracción
	 * 
	 * @return Denominador de la fracción
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Clase en la que calcularemos el máximo común divisor por el algoritmo de
	 * Euclides
	 * 
	 * @return u Máximo común divisor
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * Función para sinplificar las fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * Sobre escritura del método toString
	 */

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * Metodo para la suma de fracciones
	 * 
	 * @param f Fracción
	 * @return Resultado de la suma simplificada
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Metodo para la resta de fracciones
	 * 
	 * @param f Fracción
	 * @return Resultado de la resta simplificada
	 */

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Metodo para la multiplicación de fracciones
	 * @param f Fracción
	 * @return Resultado de la multiplicación simplificada
	 */

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Metodo para la suma de fracciones
	 * @param f Fraccion
	 * @return Resultado de la multiplicación simplificado
	 */

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
