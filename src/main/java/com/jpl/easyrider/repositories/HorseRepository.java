package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {
}