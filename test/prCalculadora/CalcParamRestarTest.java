package prCalculadora;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalcParamRestarTest {
	private Calculadora calc = new Calculadora();
	private int op1;
	private int op2;
	private int resultado;

	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, 0, 0},
			{5, 5, 0},
			{5, 8, -3},
			{8, 5, 3},
			{5, 0, 5},
			{0, 5, -5},
			{5, -8, 13},
			{-5, 8, -13},
			{-5, -8, 3}
		});
	}

	
	
	public CalcParamRestarTest(int op1, int op2, int resultado) {
		//super();
		this.op1 = op1;
		this.op2 = op2;
		this.resultado = resultado;
	}



	@Test
	public void testRestar() {
		//fail("Not yet implemented");
		assertEquals(calc.restar(op1, op2), resultado);
	}

}
