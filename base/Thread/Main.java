package Thread;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	final static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		List <PessoaThread> pessoas = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Nome: ");
			String nome = ler.nextLine();
			
			System.out.println("Idade: ");
			int idade = Integer.parseInt(ler.nextLine());
			
			PessoaThread p = new PessoaThread(nome, idade);
			
			pessoas.add(p);
		}
		
		for (int i = 0; i < pessoas.size(); i++) {
			pessoas.get(i).start();
		}
	}
}
