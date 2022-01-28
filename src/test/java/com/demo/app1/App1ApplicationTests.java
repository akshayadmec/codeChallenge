package com.demo.app1;
import com.demo.app1.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class App1ApplicationTests {

	@Test
	void contextLoads() {
		CalculateService calc = new CalculateService();
		double tax = calc.calcTax("India","Senior",40000);
	}

}
