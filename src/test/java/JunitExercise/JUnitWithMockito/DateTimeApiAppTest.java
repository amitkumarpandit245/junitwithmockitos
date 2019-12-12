package JunitExercise.JUnitWithMockito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JunitExercise.JUnitWithMockito.dateTimeApi.BankDepositExercise;
import JunitExercise.JUnitWithMockito.dateTimeApi.DateTimeExercise;
import JunitExercise.JUnitWithMockito.dateTimeApi.Utility;
import JunitExercise.JUnitWithMockito.dateTimeApi.WorkingDaysExercise;
@RunWith(MockitoJUnitRunner.class)
public class DateTimeApiAppTest {
	@Mock
	BankDepositExercise object;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before All Class");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After All Class");
	}

	@Test
	public void testgetInvestmentPeriod() {
		
		assertEquals("1 year 1 months", object.getInvestmentPeriod("11/10/2019", "12/11/2020"));
		//when(object.getInvestmentPeriod("11/10/2019", "12/11/2020")).thenReturn("1 year 1 months");
	}
	@Test
	public void testgetNextMonthsWorkingDays() {
		List<String> expected=Arrays.asList("01-01-2020", "02-01-2020", "03-01-2020", "06-01-2020", "07-01-2020", "08-01-2020", "09-01-2020", "10-01-2020", "13-01-2020", "14-01-2020", "15-01-2020", "16-01-2020", "17-01-2020", "20-01-2020", "21-01-2020", "22-01-2020", "23-01-2020", "24-01-2020", "27-01-2020", "28-01-2020", "29-01-2020", "30-01-2020", "31-01-2020");
	assertEquals(expected, WorkingDaysExercise.getNextMonthsWorkingDays());
	}
	@Test
	public void testgetBusSchedule() {
		List<LocalTime> expected=Arrays.asList(LocalTime.of(13, 59),LocalTime.of(15, 59),LocalTime.of(17, 59),LocalTime.of(19, 59),LocalTime.of(21, 59),LocalTime.of(23, 59));
	assertEquals(expected, Utility.getBusSchedule("13:59", Duration.ofHours(2)));
	}
	
	@Test
	public void testgetExpiringTables() {
		List<String> expected=Arrays.asList("Dizine", "Bikosule", "Pantids");
	assertEquals(expected, DateTimeExercise.getExpiringTables(2));
	}
	@Test
	public void testgetExpiringTabletsSorted() {
		List<String> expected=Arrays.asList("Bikosule", "Pantids", "Dizine", "Vicks");
	assertEquals(expected, DateTimeExercise.getExpiringTabletsSorted());
	}
	@Test
	public void testgetTabletExpiryPeriod() {
		Map<String,String> expected=new HashMap<>();
		expected.put("Dizine", "0 year/s 6 month/s 29 day/s ");
		expected.put("Bikosule", "0 year/s 2 month/s 27 day/s ");
		expected.put("Vicks", "1 year/s 9 month/s 1 day/s ");
		expected.put("Pantids", "0 year/s 1 month/s 0 day/s ");
	assertEquals(expected, DateTimeExercise.getTabletExpiryPeriod());
	}
	@Test
	public void getTablets() {
		Map<String,List<String>> expected=new HashMap<>();
		expected.put("abc", Arrays.asList("Dizine"));
		expected.put("def", Arrays.asList("Bikosule"));
		expected.put("ghi", Arrays.asList("Pantids"));
	assertEquals(expected, DateTimeExercise.getSameYearExpiry());
	}
	
	@Test
	public void testgetMaturityDate() {

	assertEquals("12-Feb-2019", BankDepositExercise.getMaturityDate("11/01/2018", Period.of(1, 1, 1)));
	}
}
