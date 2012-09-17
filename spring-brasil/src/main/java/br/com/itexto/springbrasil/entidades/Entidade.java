package br.com.itexto.springbrasil.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade implements java.io.Serializable {
	
	@Id 
	@Column(name="id", unique=true) 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="autoincrement")
	private long id;
	
	public long getId() {return id;}
	public void setId(long valor) {this.id = valor;}
	
	public boolean equals(Object obj) {
		return  obj == this ||
				((obj instanceof Entidade) &&
				getClass().equals(obj.getClass()) &&
				getId() == ((Entidade) obj).getId());
	}
	
	public int hashCode() {
		return (getClass().getName() + "-" + getId()).hashCode();
	}
	
	public String toString() {
		return getClass().getName() + " - " + getId();
	}
	
}
