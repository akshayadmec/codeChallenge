package com.demo.app1.repository;

import com.demo.app1.entity.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iInvoiceHeaderRepo extends JpaRepository<InvoiceHeader, Long> {
}


