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

@Entity(name = "KeywordHit")
@Table(name = "KeywordHit"
        , indexes = {
        @Index(name = " idx__keyword_hit__hit_count", columnList = "hit_count DESC")
        , @Index(name = " idx__keyword_hit__keyword", columnList = "keyword")
})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class KeywordHitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String keyword;
    @Column(nullable = false)
    private long hitCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime createdAt;

    public static KeywordHitEntity of(String keyword) {
        return KeywordHitEntity.builder()
                .keyword(keyword)
                .hitCount(1).build();
    }

    public void increaseHit() {
        hitCount++;
    }

}
