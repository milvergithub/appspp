package com.transoft.appspp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat implements Serializable {

    private Integer id;
    private String number;
    private String status;
}
