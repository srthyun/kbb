package com.dhyoon.kbb.apps.search.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name = "SearchHistory")
@Table(name = "SearchHistory"
        , indexes = {@Index(name = " idx_keyword", columnList = "keyword")})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SearchHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String keyword;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime createdAt;

    public static SearchHistoryEntity of(String keyword) {
        return SearchHistoryEntity.builder()
                .keyword(keyword).build();
    }


}
