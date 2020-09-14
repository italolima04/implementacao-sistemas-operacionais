package ConsumoThreadsRecurso;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	final static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		List <PessoaConsome> pessoas = new ArrayList<>();
		Recurso recurso = new Recurso(true);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Nome: ");
			String nome = ler.nextLine();
			
			PessoaConsome p = new PessoaConsome(nome, recurso);
			
			pessoas.add(p);
		}
		
		for (int i = 0; i < pessoas.size(); i++) {
			pessoas.get(i).start();
		}
	}
}
