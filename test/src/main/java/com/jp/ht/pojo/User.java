package com.jp.ht.pojo;



import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
//lombok  在编译阶段,为实体类自动生成setter  getter toString
// pom文件中引入依赖   在实体类上添加注解
@Data
public class User {
    private Integer loginId;
    private String personalNumber;
    private String lastNameKanji;
    private String firstNameKanji;
    private String lastNameKana;
    private String firstNameKana;
    private String postalCode;
    private String address1;
    private String address2;
    private String address3;
    private String phoneType;
    private String phone1;
    private String phone2;
    private String birthDate;
    private Integer age;
    @NotEmpty
    @Email
    private String email;
    private LocalDateTime registrationDate;
    private LocalDateTime updateDate;
    private String registrantName;
    private String updaterName;
}
