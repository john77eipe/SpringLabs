package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "option")
    private String option;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private OptionGroup optionGrpId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

	public OptionGroup getOptionGrpId() {
		return optionGrpId;
	}

	public void setOptionGrpId(OptionGroup optionGrpId) {
		this.optionGrpId = optionGrpId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Option [id=");
		builder.append(id);
		builder.append(", option=");
		builder.append(option);
		builder.append(", optionGrpId=");
		builder.append(optionGrpId);
		builder.append("]");
		return builder.toString();
	}
    
}