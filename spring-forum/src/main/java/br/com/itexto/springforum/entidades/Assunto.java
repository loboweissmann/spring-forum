package br.com.itexto.springforum.entidades;

public class Assunto extends Entidade implements Comparable{
	
	private String nome;
	
	public String getNome() {return nome;}
	public void setNome(String valor) {nome = valor;}
	
	public Assunto() {}
	
	public Assunto(Long id, String nome) {
		setId(id);
		setNome(nome);
	}
	
	public int compareTo(Object o) {
		if (o instanceof Assunto) {
			return getNome().compareTo(((Assunto) o).getNome());
		} else {
			return 0;
		}
	}

}
