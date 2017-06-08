import java.util.Arrays;


public class quadruple {
	int linea;
	String[] cuadrupla;
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public String[] getCuadrupla() {
		return cuadrupla;
	}
	public void setCuadrupla(String[] cuadrupla) {
		this.cuadrupla = cuadrupla;
	}
	@Override
	public String toString() {
		return "\n" + linea + Arrays.toString(cuadrupla);
	}
	
	
}
