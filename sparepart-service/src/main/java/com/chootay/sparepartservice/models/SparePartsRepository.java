package com.chootay.sparepartservice.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SparePartsRepository extends CrudRepository<SpareParts, Integer> {
}