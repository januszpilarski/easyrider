package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
