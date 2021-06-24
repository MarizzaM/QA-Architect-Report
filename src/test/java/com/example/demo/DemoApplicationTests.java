package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test_highway_legal_speed_pos() {

		Utils utils = new Utils();
		assertEquals(true, utils.checkHighwayLegalSpeed(TestData.highway_legal_speed));
	}

	@Test
	public void test_highway_legal_speed_neg() {

		Utils utils = new Utils();
		assertEquals(false, utils.checkHighwayLegalSpeed(TestData.highway_illegal_speed));
	}

	@Test
	public void test_urban_legal_speed_pos() {

		Utils utils = new Utils();
		assertEquals(true, utils.checkUrbanLegalSpeed(TestData.urban_legal_speed));
	}

	@Test
	public void test_urban_legal_speed_neg() {

		Utils utils = new Utils();
		assertEquals(false, utils.checkUrbanLegalSpeed(TestData.urban_illegal_speed));
	}

}
