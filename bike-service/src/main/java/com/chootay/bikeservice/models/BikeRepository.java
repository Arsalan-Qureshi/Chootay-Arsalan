package com.chootay.bikeservice.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BikeRepository extends CrudRepository<Bike, Integer> {
}