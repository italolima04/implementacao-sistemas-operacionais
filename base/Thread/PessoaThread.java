package Thread;

public class PessoaThread extends Thread{
	private String nome;
	private int idade;
	
	public PessoaThread() { }

	public PessoaThread(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " => " + this.toString());
			
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("ERROR!!!");
			}
		}
		
		System.out.println("Tchau!!!" + this.getNome());
	}
	
	@Override
	public String toString() {
		return "Sou a pessoa: " + this.getNome() + ", minha idade é idade: " + this.getIdade();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaThread other = (PessoaThread) obj;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
		
	
}
