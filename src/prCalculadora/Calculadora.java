package prCalculadora;

public class Calculadora {

	public int sumar(int op1, int op2) {
		/*long aux1 = op1;
		long aux2 = op2;
		long result = aux1 + aux2;
		
		if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)){
			throw new ArithmeticException("La suma se sale de rango.");
		}*/
		int resultado = op1 + op2;
		if ((op1 > 0 && op2 > 0 && resultado < 0) ||
			(op1 < 0 && op2 < 0 && resultado > 0)) {
			StringBuilder msg = componerMensaje(op1, op2, resultado);
			
			throw new ArithmeticException(msg.toString());
		} /*else if (op1 < 0 && op2 < 0 && resultado > 0) {
			throw new ArithmeticException("Suma fuera de rango");
		}*/
		
		return resultado;
	}
	
	public int restar(int op1, int op2) {
		int resultado = sumar(op1, -op2);
		
		return resultado;		
	}

	private StringBuilder componerMensaje(int op1, int op2, int resultado) {
		StringBuilder msg = new StringBuilder();
		msg.append("Fuera de rango: ");
		msg.append(op1);
		msg.append(" + ");
		msg.append(op2);
		msg.append(" = ");
		msg.append(resultado);
		System.err.println(msg);
		return msg;
	}

}
