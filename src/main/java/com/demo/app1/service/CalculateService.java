package com.demo.app1.service;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public Double calcTax(String country, String code, int amount) {
        if (country == "India") {
            if (code == "Senior") {
            return (amount*0.1);
            } else if (code == "Default") {
                return (amount*0.3);
            }
        } else if (country == "Germany") {
            if (code == "Default") {
                return (amount*0.4);
            }
        } else if (country == "Default") {
            if (code == "Default") {
                return (amount*0.15);
            }
        }
        return 0.0;
    }
}
