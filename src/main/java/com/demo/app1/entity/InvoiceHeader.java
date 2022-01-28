package com.demo.app1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Invoice_Headers")
@Entity
@Setter
@Getter
public class InvoiceHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long invoiceNumber;
    private Long totalAmount;
    private String externalSystem;
    private Long netAmount;

    @OneToMany(mappedBy = "invoice",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<InvoiceItem> items;

}
