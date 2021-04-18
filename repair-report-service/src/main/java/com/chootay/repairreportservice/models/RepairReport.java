package com.chootay.repairreportservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepairReport {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "report_id")
    private Integer repairReportId;
    @Column(name = "spare_part_id")
    private Integer sparePartId;
    @Column(name = "details")
    private String details;
    @Column(name = "cost")
    private Integer cost;

    public RepairReport() {
    }

    public RepairReport(Integer id, Integer repairReportId, Integer sparePartId, String details) {
        this.id = id;
        this.repairReportId = repairReportId;
        this.sparePartId = sparePartId;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepairReportId() {
        return repairReportId;
    }

    public void setRepairReportId(Integer repairReportId) {
        this.repairReportId = repairReportId;
    }

    public Integer getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(Integer sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
