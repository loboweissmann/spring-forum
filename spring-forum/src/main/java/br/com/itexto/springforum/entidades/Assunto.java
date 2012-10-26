package br.com.itexto.springforum.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity @Table(name="assunto")
public class Assunto implements Comparable, java.io.Serializable {
	
	@Id @Generated(GenerationTime.INSERT) 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true) 
	protected long id;
	
	public long getId() {return id;}
	public void setId(long valor) {this.id = valor;}
		
	@Column(name="nome", unique=true, length=128)
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
