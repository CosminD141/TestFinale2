package com.cosmin.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries(value = { @NamedQuery(name = "Biglietti.findAll", query = "select b from Biglietti b") })
public class Biglietti{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String luogoPartenza;
	@Column(nullable = false)
	private String luogoArrivo;

	@OneToMany(mappedBy = "biglietto")
	private List<Prenotazione> prenotazioni;
	
	@ManyToMany(mappedBy = "biglietto")
	private List<Utente> utenti;
	
	public Biglietti() {
		
	}

	public Biglietti(int id, String luogoPartenza, String luogoArrivo, List<Prenotazione> prenotazioni,
			List<Utente> utenti) {
		super();
		this.id = id;
		this.luogoPartenza = luogoPartenza;
		this.luogoArrivo = luogoArrivo;
		this.prenotazioni = prenotazioni;
		this.utenti = utenti;
	}

	public Biglietti(String luogoPartenza, String luogoArrivo, List<Prenotazione> prenotazioni, List<Utente> utenti) {
		super();
		this.luogoPartenza = luogoPartenza;
		this.luogoArrivo = luogoArrivo;
		this.prenotazioni = prenotazioni;
		this.utenti = utenti;
	}

	
	public Biglietti(int id, String luogoPartenza, String luogoArrivo) {
		super();
		this.id = id;
		this.luogoPartenza = luogoPartenza;
		this.luogoArrivo = luogoArrivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLuogoPartenza() {
		return luogoPartenza;
	}

	public void setLuogoPartenza(String luogoPartenza) {
		this.luogoPartenza = luogoPartenza;
	}

	public String getLuogoArrivo() {
		return luogoArrivo;
	}

	public void setLuogoArrivo(String luogoArrivo) {
		this.luogoArrivo = luogoArrivo;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return "Biglietti [id=" + id + ", luogoPartenza=" + luogoPartenza + ", luogoArrivo=" + luogoArrivo
				+ ", prenotazioni=" + prenotazioni + ", utenti=" + utenti + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, luogoArrivo, luogoPartenza, prenotazioni, utenti);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biglietti other = (Biglietti) obj;
		return id == other.id && Objects.equals(luogoArrivo, other.luogoArrivo)
				&& Objects.equals(luogoPartenza, other.luogoPartenza)
				&& Objects.equals(prenotazioni, other.prenotazioni) && Objects.equals(utenti, other.utenti);
	}

}