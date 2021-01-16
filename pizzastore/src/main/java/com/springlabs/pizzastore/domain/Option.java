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

    @Column(name = "option_group_id")
    private Long optionGrpId;

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

    public Long getOptionGrpId() {
        return optionGrpId;
    }

    public void setOptionGrpId(Long optionGrpId) {
        this.optionGrpId = optionGrpId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaOption{");
        sb.append("id=").append(id);
        sb.append(", option='").append(option).append('\'');
        sb.append(", optionGrpId=").append(optionGrpId);
        sb.append('}');
        return sb.toString();
    }
}
