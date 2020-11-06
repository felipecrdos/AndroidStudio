package com.cesusc.n2;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Model implements Serializable {

    @SerializedName("_id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("diameter")
    private Integer diameter;
    @SerializedName("sum_distance")
    private String distance;
    @SerializedName("finder")
    private String finder;

    public Model(){}

    public Model(Integer id, String name, Integer diameter, String distance, String finder) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.distance = distance;
        this.finder = finder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFinder() {
        return finder;
    }

    public void setFinder(String finder) {
        this.finder = finder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nID: " + this.id);
        sb.append("\nName: " + this.name);
        sb.append("\nDiameter: " + this.diameter);
        sb.append("\nDistance: " + this.distance);
        sb.append("\nFinder: " + this.finder);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id.equals(model.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
