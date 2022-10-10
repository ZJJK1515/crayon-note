package com.crayon.user.infrastructure.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Table(name = "crayon_user")
@Entity
@ToString
public class CrayonUserDO {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 20)
    @NotNull
    @Column(name = "login_name", nullable = false, length = 20)
    private String loginName;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 20)
    @NotNull
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Size(max = 1000)
    @NotNull
    @Column(name = "user_avatar", nullable = false, length = 1000)
    private String userAvatar;

    @NotNull
    @Column(name = "create_user_id", nullable = false)
    private Long createUserId;

    @Size(max = 20)
    @NotNull
    @Column(name = "create_username", nullable = false, length = 20)
    private String createUsername;

    @NotNull
    @Column(name = "modify_user_id", nullable = false)
    private Long modifyUserId;

    @Size(max = 20)
    @NotNull
    @Column(name = "modify_username", nullable = false, length = 20)
    private String modifyUsername;


}