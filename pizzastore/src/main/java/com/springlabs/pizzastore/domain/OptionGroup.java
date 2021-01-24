package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_option_group")
public class OptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "group")
    private String optionGroup;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(String optionGroup) {
        this.optionGroup = optionGroup;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OptionGroup{");
        sb.append("id=").append(id);
        sb.append(", optionGroup='").append(optionGroup).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
