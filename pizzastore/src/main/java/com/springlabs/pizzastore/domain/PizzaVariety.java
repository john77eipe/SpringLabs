package com.springlabs.pizzastore.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pizza_variety")
public class PizzaVariety {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pizza_variety")
	private Long idPizzaVariety;
	
	@OneToMany
	@JoinColumn(name = "id_pizza_variant")
	private List<PizzaVariant> idPizzaVariant;

	@ManyToMany
	@JoinColumn(name = "id_pizza_option")
	private List<PizzaOption> idPizzaOption;

	public Long getIdPizzaVariety() {
		return idPizzaVariety;
	}

	public void setIdPizzaVariety(Long idPizzaVariety) {
		this.idPizzaVariety = idPizzaVariety;
	}

	public List<PizzaVariant> getIdPizzaVariant() {
		return idPizzaVariant;
	}

	public void setIdPizzaVariant(List<PizzaVariant> idPizzaVariant) {
		this.idPizzaVariant = idPizzaVariant;
	}

	public List<PizzaOption> getIdPizzaOption() {
		return idPizzaOption;
	}

	public void setIdPizzaOption(List<PizzaOption> idPizzaOption) {
		this.idPizzaOption = idPizzaOption;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PizzaVariety [idPizzaVariety=");
		builder.append(idPizzaVariety);
		builder.append(", idPizzaVariant=");
		builder.append(idPizzaVariant);
		builder.append(", idPizzaOption=");
		builder.append(idPizzaOption);
		builder.append("]");
		return builder.toString();
	}

}