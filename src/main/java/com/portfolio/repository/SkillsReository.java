package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.Skills;

public interface SkillsReository extends JpaRepository<Skills, Long> {

}
