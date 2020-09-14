package ConsumoThreadsRecurso;

public class PessoaConsome extends Thread{
	private String nome;
	private boolean estaComRecurso;
	private boolean aindaPegaRecurso;
	private int quantidadeUsoRecurso;
	private Recurso recursoOfertado;

	public PessoaConsome() { }

	public PessoaConsome(String nome, Recurso recurso) {
		this.nome = nome;
		this.estaComRecurso = false;
		this.aindaPegaRecurso = true;
		this.quantidadeUsoRecurso = 0;
		this.recursoOfertado = recurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEstaComRecurso() {
		return estaComRecurso;
	}

	public void setEstaComRecurso(boolean estaComRecurso) {
		this.estaComRecurso = estaComRecurso;
	}

	public boolean isAindaPegaRecurso() {
		return aindaPegaRecurso;
	}

	public void setAindaPegaRecurso(boolean aindaPegaRecurso) {
		this.aindaPegaRecurso = aindaPegaRecurso;
	}

	public int getQuantidadeUsoRecurso() {
		return quantidadeUsoRecurso;
	}

	public void setQuantidadeUsoRecurso(int quantidadeUsoRecurso) {
		this.quantidadeUsoRecurso = quantidadeUsoRecurso;
	}

	public Recurso getRecursoOfertado() {
		return recursoOfertado;
	}

	public void setRecursoOfertado(Recurso recursoOfertado) {
		this.recursoOfertado = recursoOfertado;
	}
	
	public void checaConsumoDeRecurso () {
		if (this.getQuantidadeUsoRecurso() == 33) {
			this.setAindaPegaRecurso(false);
		}
	}

	public void pegarRecurso() {
		if (this.isAindaPegaRecurso() == true) {
			if (this.isEstaComRecurso() == false) {
				if (this.recursoOfertado.isRecurso() == true) {
					this.setEstaComRecurso(true);
					this.recursoOfertado.setRecurso(false);
					
					System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Acabei de pegar o recurso!!! <<<<<<<<<<<<<<<<");
					this.setQuantidadeUsoRecurso(this.getQuantidadeUsoRecurso() + 1);
				} else {
					System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Nao temos recurso disponivel no momento!!! <<<<<<<<<<<<<<<<");
				}
			} else {
				System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Eu estou com o recurso!!! <<<<<<<<<<<<<<<<");
			}
		} else {
			System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Ja consumiu o recurso permitido!!! <<<<<<<<<<<<<<<<");
		}
	}
	
	public void largarRecurso() {
		if (this.isEstaComRecurso() == true) {
			this.setEstaComRecurso(false);
			
			System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Acabei de largar o recurso!!! <<<<<<<<<<<<<<<<");
			
			if (this.recursoOfertado.isRecurso() == false) {
				this.recursoOfertado.setRecurso(true);
				
				System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Devolvi o recurso!!! <<<<<<<<<<<<<<<<");
			} else {
				System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": O recurso já tinha sido devoldivo!!! <<<<<<<<<<<<<<<<");
			}
		} else {
			System.out.println(">>>>>>>>>>>>>>>>" + this.getNome() + ": Nao tenho o recurso!!! <<<<<<<<<<<<<<<<");
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println((i + 1) + "=> " + this.toString());
			
			this.pegarRecurso();
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				System.out.println("ERRO!!!");
			}
			
			this.largarRecurso();
			this.checaConsumoDeRecurso();
		}
	}

	@Override
	public String toString() {
		return "Sou a pessoa: " + this.getNome() + ", e: " + (this.isEstaComRecurso() == true ? "Estou com o recurso" : "Não estou com o recurso" + ", Ja peguei o recurso: " + this.getQuantidadeUsoRecurso() + " vezes");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (estaComRecurso ? 1231 : 1237);
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
		PessoaConsome other = (PessoaConsome) obj;
		if (estaComRecurso != other.estaComRecurso)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
