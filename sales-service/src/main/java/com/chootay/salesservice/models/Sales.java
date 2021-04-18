package com.chootay.salesservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "bike_id")
    private Integer bikeId;
    @Column(name = "repair_report_id")
    private Integer repairReportId;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "date")
    private String date;

    public Sales() {
    }

    public Sales(Integer id, Integer customerId, Integer bikeId, Integer repairReportId, Integer cost, String date) {
        this.id = id;
        this.customerId = customerId;
        this.bikeId = bikeId;
        this.repairReportId = repairReportId;
        this.cost = cost;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getRepairReportId() {
        return repairReportId;
    }

    public void setRepairReportId(Integer repairReportId) {
        this.repairReportId = repairReportId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
