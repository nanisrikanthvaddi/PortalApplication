package com.portal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permissions {

    public void Permission(Long id){

        this.id=id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="permission_sequence")
    @SequenceGenerator(name = "permission_sequence" , sequenceName =  "permission_sequence", initialValue = 0,allocationSize = 1)
    @Column(name = "permission_id")
    private Long id;

    @Column(name = "permission")
    private String permission;




}
