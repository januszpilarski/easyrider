package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository <DBFile, Long> {
}
