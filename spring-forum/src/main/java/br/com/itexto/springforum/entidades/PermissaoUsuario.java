package br.com.itexto.springforum.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.security.core.GrantedAuthority;

@Entity @Table(name="permissao_usuario")
public class PermissaoUsuario  implements GrantedAuthority, java.io.Serializable {
	
	@Id @Generated(GenerationTime.INSERT) 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true) 
	protected long id;
	
	public long getId() {return id;}
	public void setId(long valor) {this.id = valor;}
	
	@Column(name="role", nullable=false, length=64)
	private String role;
	@ManyToOne @JoinColumn(name="usuario_id", nullable=false)
	private Usuario usuario;
	
	public String getRole() {return role;}
	public void setRole(String valor) {role = valor;}
	
	public Usuario getUsuario() {return usuario;}
	public void setUsuario(Usuario usr) {usuario = usr;}
	
	public String getAuthority() {
		return role;
	}
	
}
