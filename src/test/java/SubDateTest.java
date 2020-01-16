import org.junit.Test;

import static org.junit.Assert.*;

public class SubDateTest {

    // 전년도까지의 총 일수를 구한다.
    @Test
    public void testGetYearDay(){
        assertEquals(0, SubDate.getYearDay(1)); // 0년이란 것은 존재하지 않기 떄문에 1년 까지의 총 일수는 0이 되어야 한다.
        assertEquals(365, SubDate.getYearDay(2)); // 2년까지의      총 일수는 1년 1월 1일부터 2년 1월 1일까지 이므로 365가 되어야 한다.
        assertEquals(365+365+365+366, SubDate.getYearDay(5)); // 5년 미만의 총 일수를 구하기.
    }

    // 윤년인지 아닌지를 확인할 수 있는 테스트
    /*
    서력 기원 연수가 4로 나누어 떨어지는 해는 윤년,
    그 중에서 100으로 다시 나누어 떨어지는 해는 평년,
    다만 400으로 나누어 떨어지는 해는 다시 윤년
     */
    @Test
    public void isLeapYear(){
//        assertTrue(SubDate.isLeapYear(0));
        assertFalse(SubDate.isLeapYear(1));
        assertTrue(SubDate.isLeapYear(4));
        assertTrue(SubDate.isLeapYear(1200)); // 2차 리팩토링 코드는 이 테스트 케이스에서 실패.
        assertFalse(SubDate.isLeapYear(700)); // 1차 리팩토링 코드는 이 테스트 케이스에서 실패.
        assertTrue(SubDate.isLeapYear(2020));
    }

    // 전월까지의 총 일수를 구한다.
    @Test
    public void testGetMonthDay(){
        assertEquals(31+28, SubDate.getMonthDay(3, false));
        assertEquals(31+29, SubDate.getMonthDay(3, true));
    }

    // 특정 일자의 총 일수를 구한다.
    @Test
    public void testGetTotalDay(){
        // 20200730의 총 일수는 1년부터 2020년까지의 총 일수, 1월1일부터 7월까지의 총 일수 + 30을 하면 총 일수를 구할 수 있다.
        assertEquals(1, SubDate.getTotalDay("00010101")); // 1년 1월 1일의 총 일수는 1일
        assertEquals(366, SubDate.getTotalDay("00020101")); // 2년 1월 1일의 총 일수는 366일
    }

    // 두 날짜의 차이 일자를 구한다.
    @Test
    public void testSubDate(){
        assertEquals(1, SubDate.sub("20061231", "20070101"));
        assertEquals(31+28+30+31+14, SubDate.sub("20070101", "20070515"));
        assertEquals(31+29+30+31+14, SubDate.sub("20080101", "20080515"));
    }


}