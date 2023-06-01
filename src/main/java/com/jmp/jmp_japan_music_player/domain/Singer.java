package com.jmp.jmp_japan_music_player.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "singer")
public class Singer {
    @Id
    @Column(nullable = false)
    private Long seq;
    @Column(nullable = false , length = 30 )
    private String name_singer;
    @Column(nullable = true , length = 30 )
    private String content_singer;
    @Column(nullable = true , length = 30 )
    private String img_root_singer;

    /** basic start*/
    @Column(nullable = false)
    private Date created;
    @Column(nullable = false)
    private Date updated;
    @Column(nullable = false)
    private boolean deleted; // 0 : false (삭제안됨) 1: Ture : 삭제됨
    /** basic End*/


    /**foreign key start*/
    @JoinColumn
    @Column(nullable = false , length = 10 , unique = true)
    private String userName;
    /**foreign key end*/
}
