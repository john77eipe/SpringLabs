package com.springlabs.pizzastore.domain;

import javax.persistence.*;
import java.util.StringJoiner;

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
        return new StringJoiner(", ", OptionGroup.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("optionGroup='" + optionGroup + "'")
                .toString();
    }
}
