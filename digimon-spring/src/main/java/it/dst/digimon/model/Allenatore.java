package it.dst.digimon.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Allenatore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Digimon> listaDigimon;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Digimon> getListaDigimon() {
		return listaDigimon;
	}
	public void setListaDigimon(List<Digimon> listaDigimon) {
		this.listaDigimon = listaDigimon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaDigimon == null) ? 0 : listaDigimon.hashCode());
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
		Allenatore other = (Allenatore) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaDigimon == null) {
			if (other.listaDigimon != null)
				return false;
		} else if (!listaDigimon.equals(other.listaDigimon))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Allenatore [id=" + id + ", nome=" + nome + ", listaDigimon=" + listaDigimon + "]";
	}
	
	
	

}
