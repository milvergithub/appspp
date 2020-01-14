package com.transoft.appspp.mvp.pickup;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickupApiModel implements Serializable {

    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private String address;

    @Expose
    private String phone;

    @Expose
    private String amount;
}
