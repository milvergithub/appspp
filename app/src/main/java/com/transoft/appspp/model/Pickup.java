package com.transoft.appspp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pickup implements Serializable {

    private Integer id;

    private String name;

    private String address;

    private String phone;

    private String amount;
}
