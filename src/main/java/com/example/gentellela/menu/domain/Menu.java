package com.example.gentellela.menu.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String icon;
    private String link;

    @ManyToOne
    private Menu parent;

    @OneToMany(mappedBy="parent")
    private List<Menu> childMenus = new ArrayList<>();

    public Menu(String name, String icon, String link) {
        this.name = name;
        this.icon = icon;
        this.link = link;
    }

    public void addMenu(Menu menu) {
        this.childMenus.add(menu);
        menu.setParent(this);
    }

    private void setParent(Menu parent) {
        this.parent = parent;
    }
}
