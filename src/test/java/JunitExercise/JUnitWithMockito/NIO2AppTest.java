package JunitExercise.JUnitWithMockito;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import JunitExercise.JUnitWithMockito.nios2.NIO2Exercise;
@RunWith(MockitoJUnitRunner.class)
public class NIO2AppTest {
	@Mock
	NIO2Exercise Nio2Obj;

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before ->Before All Methos");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After ->After All Methods");
	}

	@Test
	public void testgetExpiredTablets() {
		Map<String,LocalDate> expected=new HashMap<>();
		expected.put("D-cold Total", LocalDate.of(2001, 02, 10));
		expected.put("D-cold Total1", LocalDate.of(2000, 07, 10));
		assertEquals("Test Case For getExpiredTablets",expected, Nio2Obj.getExpiredTablets("tablet_details.txt", "def"));
	}

}
