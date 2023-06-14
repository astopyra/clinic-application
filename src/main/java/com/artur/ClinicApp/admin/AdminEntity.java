package com.artur.ClinicApp.admin;

import com.artur.ClinicApp.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="administrators")
public class AdminEntity {

    @Id
    @GeneratedValue
    private Long id;

   private String firstname;
   private String lastname;
   private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_details")
    private User user;

    public AdminEntity(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
