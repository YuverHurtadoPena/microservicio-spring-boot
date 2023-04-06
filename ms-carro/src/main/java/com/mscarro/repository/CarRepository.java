package com.mscarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mscarro.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByUserId(int userId);
}