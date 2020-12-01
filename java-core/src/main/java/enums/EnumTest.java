package enums;

public class EnumTest {
}

enum Day{
    SUNDAY(1),MONDAY(2),TUESDAY(3),WEDNESDAY(4),THURSDAY(5),FRIDAY(6),SATURDAY(7);
    private int value;
    // can be only private constructor for enum
    private Day(int value){
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
}
class UserInterface{
    public static void main (String[] args) {
        //printing all constants of an enum
        for(Day day:Day.values())
            System.out.println("Day:"+day.name()+" Value:"+day.getValue());
    }
}
