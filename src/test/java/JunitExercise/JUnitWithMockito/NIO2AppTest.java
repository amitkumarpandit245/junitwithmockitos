package JunitExercise.JUnitWithMockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import JunitExercise.JUnitWithMockito.nios2.NIO2Exercise;
@RunWith(MockitoJUnitRunner.class)
public class NIO2AppTest {
	@InjectMocks
	NIO2Exercise Nio2Obj;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Execution of Class Or All Methods");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Execution of class/ All Methods");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before All Methos");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After All Methods");
	}

	@Test
	public void testgetExpiredTablets() {
		
		assertEquals(Nio2Obj.getExpiredTablets("tablet_details.txt", "def"), Nio2Obj.getExpiredTablets("tablet_details.txt", "def"));
	}
	@Test
	public void testsearchFile() {
	
		//when(Nio2Obj.searchFile("hidden.txt","src//file//data//")).than
	}


}
