package br.com.itexto.springforum.entidades;

public class Assunto extends Entidade implements Comparable{
	
	private String nome;
	
	public String getNome() {return nome;}
	public void setNome(String valor) {nome = valor;}
	
	public int compareTo(Object o) {
		if (o instanceof Assunto) {
			return getNome().compareTo(((Assunto) o).getNome());
		} else {
			return 0;
		}
	}

}
