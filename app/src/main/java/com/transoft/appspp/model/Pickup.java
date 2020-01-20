package com.transoft.appspp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pickup implements Serializable {

    private Long id;

    private String name;

    private String address;

    private String latitude;

    private String longitude;

    private String amount;

    private String ci;

    private String phone;
}
