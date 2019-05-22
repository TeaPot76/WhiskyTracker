package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WhiskyRepository whiskyRepository;
	@Autowired
	DistilleryRepository distilleryRepository;


	@Test
	public void findWhiskyByYear(){
		List<Whisky> whiskies = whiskyRepository.findWhiskyByYear(1991);
		assertEquals(1991,whiskies.get(0).getYear());
	}

	@Test
	public void findWhiskyFromDistilleryByAge(){
		List<Whisky> found = whiskyRepository.findWhiskyFromDistilleryByAge(1L, 15);
		System.out.println(found);

	}

}
