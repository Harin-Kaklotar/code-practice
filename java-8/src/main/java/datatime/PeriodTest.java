package datatime;

import java.time.Period;

public class PeriodTest {

    public static void main(String[] args) {
        Period period = Period.of(1, 5, 2001);
        System.out.println(period.getDays() + "\t" + period.getMonths());
    }
}
