public enum Turno {
	MANHA("manha"),
	TARDE("tarde"),
	NOITE("noite");

	private String descricao;
	
	Turno (String descricao) {
		this.descricao= descricao;
	} //é necessario declarar

	public String horarioEntrada(String descricao) {
		return Turno.valueOf(descricao).descricao;
	}
}