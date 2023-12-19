package com.dhyoon.kbb.apps.search.infrastructure.repository;

import com.dhyoon.kbb.apps.search.domain.entity.SearchHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity, Long> {
}
