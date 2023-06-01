package com.jmp.jmp_japan_music_player.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    @Column(name = "SEQ", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(name = "id",nullable = false , length = 20 , unique = true)
    private String id;
    @Column(name = "password",nullable = false , length = 30 )
    private String password;
    @Column(name = "userName",nullable = false , length = 10 , unique = true)
    private String userName;
    @Column(name = "Email", nullable = false , length = 40 , unique = true)
    private String Email;
    @Column(name = "created",nullable = false)
    @CreationTimestamp
    private Date created;
    @Column(name = "updated",nullable = false)
    @UpdateTimestamp
    private Date updated;
    @Column(name = "deleted",nullable = false)
    private boolean deleted; // 0 : false (삭제안됨) 1: Ture : 삭제됨


}
