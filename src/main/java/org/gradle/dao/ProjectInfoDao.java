package org.gradle.dao;

import org.gradle.modle.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInfoDao extends JpaRepository<ProjectInfo, Long> {

}
