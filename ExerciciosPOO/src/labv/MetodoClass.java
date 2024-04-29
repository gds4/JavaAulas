package labv;

public class MetodoClass {
	public void welcome() {
		System.out.println("Seja Bem Vindo!!");
	}
	
	public int addTwo(int valor) {
		return (valor + 2);
	}
	
	public static void main(String[] args) {
		int variavel = 19;
		
		MetodoClass testando = new MetodoClass();
		
		int print_var = testando.addTwo(variavel);
		
		System.out.println(print_var);
	}
}
