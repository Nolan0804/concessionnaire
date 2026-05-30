package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;
import model.RevenueResult;

import java.time.LocalDate;

public class RevenueBusinessTest {
    private RevenueBusiness revenueBusiness;

    @BeforeEach
    public void setUp() {
        // Arrange commun : initialisation de la classe à tester
        revenueBusiness = new RevenueBusiness();
    }

    @Test
    public void isPeriodValid_periodValid_returnsTrue() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 12, 31);

        boolean result = revenueBusiness.isPeriodValid(start, end);

        assertTrue(result);
    }

    @Test
    public void isPeriodValid_nullStartDate_returnsFalse() {
        LocalDate end = LocalDate.of(2024, 12, 31);

        boolean result = revenueBusiness.isPeriodValid(null, end);

        assertFalse(result);
    }

    @Test
    public void isPeriodValid_nullEndDate_returnsFalse() {
        LocalDate start = LocalDate.of(2024, 1, 1);

        boolean result = revenueBusiness.isPeriodValid(start, null);

        assertFalse(result);
    }

    @Test
    public void isPeriodValid_startAfterEnd_returnsFalse() {
        LocalDate start = LocalDate.of(2024, 12, 31);
        LocalDate end = LocalDate.of(2024, 1, 1);

        boolean result = revenueBusiness.isPeriodValid(start, end);

        assertFalse(result);
    }

    @Test
    public void isPeriodValid_futureStartDate_returnsFalse() {
        LocalDate start = LocalDate.now().plusDays(1);
        LocalDate end = LocalDate.now().plusDays(10);

        boolean result = revenueBusiness.isPeriodValid(start, end);

        assertFalse(result);
    }

    @Test
    public void calculateNetProfit_validResult_returnsCorrectValue() throws InvalidInputException {
        RevenueResult result = new RevenueResult(
                50000.0, 30000.0, 5,
                15000.0, 5000.0, 12000.0, 4000.0
        );

        double netProfit = revenueBusiness.calculateNetProfit(result);

        assertEquals(20000.0, netProfit, 0.01);
    }

    @Test
    public void calculateNetProfit_costsHigherThanRevenue_returnsNegative() throws InvalidInputException {
        // Arrange : charges > CA → perte
        RevenueResult result = new RevenueResult(
                10000.0, 20000.0, 2,
                6000.0, 4000.0, 12000.0, 8000.0
        );

        double netProfit = revenueBusiness.calculateNetProfit(result);

        assertEquals(-10000.0, netProfit, 0.01);
    }

    @Test
    public void calculateNetProfit_nullResult_throwsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> {
            revenueBusiness.calculateNetProfit(null);
        });
    }

    @Test
    public void calculateRevenue_nullDates_throwsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> {
            revenueBusiness.calculateRevenue(null, null);
        });
    }


    @Test
    public void calculateRevenue_startAfterEnd_throwsInvalidInputException() {
        LocalDate start = LocalDate.of(2024, 12, 31);
        LocalDate end = LocalDate.of(2024, 1, 1);

        assertThrows(InvalidInputException.class, () -> {
            revenueBusiness.calculateRevenue(start, end);
        });
    }
}