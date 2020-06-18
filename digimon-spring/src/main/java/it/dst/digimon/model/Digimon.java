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
    
}
