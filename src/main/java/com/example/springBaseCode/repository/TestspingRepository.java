package com.example.springBaseCode.repository;

import com.example.springBaseCode.entity.Testsping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestspingRepository extends JpaRepository<Testsping, Long> {
}