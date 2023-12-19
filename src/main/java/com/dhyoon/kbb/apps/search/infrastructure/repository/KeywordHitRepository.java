package com.dhyoon.kbb.apps.search.infrastructure.repository;

import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeywordHitRepository extends JpaRepository<KeywordHitEntity, Long> {

    Optional<KeywordHitEntity> findByKeyword(String keyword);

    List<KeywordHitEntity> findTop10ByOrderByHitCountDesc();
}
