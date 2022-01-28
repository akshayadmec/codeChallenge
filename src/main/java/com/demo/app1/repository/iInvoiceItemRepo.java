package com.demo.app1.repository;

import com.demo.app1.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iInvoiceItemRepo  extends JpaRepository<InvoiceItem, Long> {
}

