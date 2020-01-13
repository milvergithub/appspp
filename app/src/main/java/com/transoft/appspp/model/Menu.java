package com.transoft.appspp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private String image;
}
