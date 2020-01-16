public class SubDate {

    /*
    두 날짜의 차이를 구하기 위해서는 절대값(A의 총 일수 - B의 총 일수)를 구하면 쉽게 구할 수 있다.
    예를 들어 20200730의 총 일수는 1년부터 2020년까지의 총 일수, 1월1일부터 7월까지의 총 일수 + 30을 하면 총 일수를 구할 수 있다.
     */

    static final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 전년도까지의 총 일수를 구한다.
    public static int getYearDay(int year){
//        if(year == 1) return 0;
//        return 365;

        // 코드 리팩토링 진행
        int result = 0;
        for (int i=1; i < year; i++){
            if(isLeapYear(i)) result += 366;
            else result += 365;
        }
        return result;
    }

    public static boolean isLeapYear(int year) {

        // 테스트 통과를 위한 코드 작성
//        if(year == 0) return true;
//        if(year == 1) return false;
//        if(year == 4) return true;
//        return false;

        // 코드 리팩토링 진행
//        if(year % 4 == 0) return true;
//        return false;

        // 2차 코드 리팩토링 진행
//        if (year % 100 == 0) return false;
//        if (year % 4 == 0) return true;
//        return false;

        // 3차 코드 리팩토링 진행
        if( year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    // 윤달의 여부를 확인하기 위한 isLeep값 추가 - 윤년인 경우 true, 윤년이 아닌 경우 false
    public static int getMonthDay(int month, boolean isLeep) {
        int result = 0;
        for (int i = 1; i < month; i++) {
            result += monthDays[i-1];
        }
        if(isLeep && month>2) result += 1;
        return result;
    }

    // 특정 일자의 총 일수를 구하는 메소드
    public static int getTotalDay(String date) {
        int year = Integer.parseInt(date.substring(0,4)); // 년도를 추출
        int month = Integer.parseInt(date.substring(4,6)); // 월을 추출
        int day = Integer.parseInt(date.substring(6,8)); // 일을 추출

        return getYearDay(year) + getMonthDay(month, isLeapYear(year)) + day;
    }

    // 두 날짜간의 차이를 구하는 메소드
    public static int sub(String aOfDate, String bOfDate) {
        return Math.abs(getTotalDay(aOfDate) - getTotalDay(bOfDate));
    }
}