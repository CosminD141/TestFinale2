package com.cosmin.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private LocalDate dataOdierna;
	@Column(nullable = false)
	private LocalDate dataPrenotazione;
	@ManyToOne
	@JoinColumn(name = "fk_biglietto")
	private Biglietti biglietto;
	@ManyToOne
	@JoinColumn(name = "fk_utente")
	private Utente utente;
	
	public Prenotazione() {};
	
	public Prenotazione(int id, LocalDate dataOdierna, LocalDate dataPrenotazione, Utente utente) {
		super();
		this.id = id;
		this.dataOdierna = dataOdierna;
		this.dataPrenotazione = dataPrenotazione;
		this.utente = utente;
	}
	

	public Prenotazione(LocalDate dataOdierna, LocalDate dataPrenotazione, Biglietti biglietto, Utente utente) {
		super();
		this.biglietto = biglietto;
		this.dataOdierna = dataOdierna;
		this.dataPrenotazione = dataPrenotazione;
		this.utente = utente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataOdierna() {
		return dataOdierna;
	}

	public void setDataOdierna(LocalDate dataOdierna) {
		this.dataOdierna = dataOdierna;
	}

	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", dataOdierna=" + dataOdierna + ", dataPrenotazione=" + dataPrenotazione
				+ ", utente=" + utente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataOdierna, dataPrenotazione, id, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		return Objects.equals(dataOdierna, other.dataOdierna)
				&& Objects.equals(dataPrenotazione, other.dataPrenotazione) && id == other.id
				&& Objects.equals(utente, other.utente);
	}
	
}