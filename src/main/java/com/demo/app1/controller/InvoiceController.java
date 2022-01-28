package com.demo.app1.controller;

import com.demo.app1.entity.InvoiceHeader;
import com.demo.app1.entity.InvoiceItem;
import com.demo.app1.service.CalculateService;
import com.demo.app1.service.SendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.app1.repository.iInvoiceHeaderRepo;
import com.demo.app1.repository.iInvoiceItemRepo;
import java.util.List;
import com.google.gson.Gson;


@RestController
public class InvoiceController {
    @Autowired
    private CalculateService calcService;
    @Autowired
    private SendData sendData;
    @Autowired
    iInvoiceHeaderRepo headerRepo;
    @Autowired
    iInvoiceItemRepo itemRepo;
    @PostMapping("/saveInvoice")
    public ResponseEntity<InvoiceHeader> save(@RequestBody String inv){
        try{

            InvoiceHeader invoice = new Gson().fromJson(inv, InvoiceHeader.class);

            InvoiceItem item =  new Gson().fromJson(inv, InvoiceItem.class);
            headerRepo.save(invoice);
//            itemRepo.save(item);
            double tax = calcService.calcTax("India","Senior",40000);
            sendData.sendName("Senior");
            return new ResponseEntity<>( HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getInvoice")
    public ResponseEntity<List<InvoiceHeader>> getInv(){
        try {
            List<InvoiceHeader> eg = headerRepo.findAll();
            if(eg.isEmpty()||eg.size()==0){
                return new ResponseEntity<List<InvoiceHeader>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<InvoiceHeader>>(eg,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

