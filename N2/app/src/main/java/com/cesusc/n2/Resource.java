package com.cesusc.n2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resource {

    @SerializedName("message")
    public String message;
    @SerializedName("asteroid")
    public List<Model> models = null;

}
