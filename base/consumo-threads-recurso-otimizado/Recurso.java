package ConsumoThreadsRecurso;

public class Recurso {
	private boolean recurso;

	public Recurso() { }

	public Recurso(boolean recurso) {
		this.recurso = recurso;
	}

	public boolean isRecurso() {
		return recurso;
	}

	public void setRecurso(boolean recurso) {
		this.recurso = recurso;
	}

	@Override
	public String toString() {
		return "Tenho recurso: " + (this.isRecurso() == true ? "Sim" : "Não");
	}
}
