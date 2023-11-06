
package com.example.demo.repository;

import com.example.demo.model.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, String> {}
