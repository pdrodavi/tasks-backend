package br.com.pedrodavi.taskbackend.utils;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        LocalDate date = LocalDate.of(2030, 10, 10);
        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(date);
        assertTrue(equalOrFutureDate);
    }

    @Test
    public void deveRetornarFaseParaDatasAntigas() {
        LocalDate date = LocalDate.of(2010, 10, 10);
        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(date);
        assertFalse(equalOrFutureDate);
    }

    @Test
    public void dataAtual() {
        LocalDate date = LocalDate.now();
        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(date);
        assertTrue(equalOrFutureDate);
    }

}
