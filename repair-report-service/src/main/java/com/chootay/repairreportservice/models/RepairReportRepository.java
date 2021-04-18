package com.chootay.repairreportservice.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepairReportRepository extends CrudRepository<RepairReport, Integer> {
}