package com.demo.app1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Invoice_Item")
@Entity
@Setter
@Getter
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long invoiceNumber;
    private Long itemNumber;
    private String country;
    private String taxCode;
    private Long amount;
    private Long netComputedAmount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoiceNumber",insertable = false, updatable = false, nullable = false)
    private InvoiceHeader invoice;

}
