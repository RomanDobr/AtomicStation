package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.department.SecutiryDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityDepartmentTest {
	@Autowired
	private SecutiryDepartment secutiryDepartment;

	@Test
	void addAccidentSuccess() {
		secutiryDepartment.addAccident();
		Assertions.assertEquals(1, secutiryDepartment.getCountAccidents());
	}

	@Test
	void resetAccidentSuccess() {
		secutiryDepartment.reset();
		Assertions.assertEquals(0, secutiryDepartment.getCountAccidents());
	}

}
