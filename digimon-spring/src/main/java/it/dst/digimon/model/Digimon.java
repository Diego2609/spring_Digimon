package it.dst.digimon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Digimon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Allenatore allenatore;
	private String nome;
    private int atk;
    private int def;
    private int res;
    private String evoluzione;
	
    
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
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public String getEvoluzione() {
		return evoluzione;
	}
	public void setEvoluzione(String evoluzione) {
		this.evoluzione = evoluzione;
	}
	public Allenatore getAllenatore() {
		return allenatore;
	}
	public void setAllenatore(Allenatore allenatore) {
		this.allenatore = allenatore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allenatore == null) ? 0 : allenatore.hashCode());
		result = prime * result + atk;
		result = prime * result + def;
		result = prime * result + ((evoluzione == null) ? 0 : evoluzione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + res;
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
		Digimon other = (Digimon) obj;
		if (allenatore == null) {
			if (other.allenatore != null)
				return false;
		} else if (!allenatore.equals(other.allenatore))
			return false;
		if (atk != other.atk)
			return false;
		if (def != other.def)
			return false;
		if (evoluzione == null) {
			if (other.evoluzione != null)
				return false;
		} else if (!evoluzione.equals(other.evoluzione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (res != other.res)
			return false;
		return true;
	}
    
}
