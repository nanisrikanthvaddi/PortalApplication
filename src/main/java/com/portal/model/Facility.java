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
@Table(name = "Facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="facility_sequence" )
    @SequenceGenerator(name = "facility_sequence"  ,sequenceName ="facility_sequence" ,allocationSize = 1)
    @Column(name = "facility_id")
    private Long id;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;
}
