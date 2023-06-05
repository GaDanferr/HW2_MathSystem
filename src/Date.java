public class Date {
    private int year;
    private int month;
    private int day;
    public static String bufferDate(int date , Time time) {
        if(time!=Time.YEAR){
            if(date<10){
                return "0"+date;
            }
            else{
                return ""+date;
            }
        }
        else{
            int absoluteYear;
            if(date < 0) {
                absoluteYear = -1 * date;
            }
            else {
                absoluteYear = date;
            }
            if(absoluteYear>1000){
                return ""+date;
            }
            if(absoluteYear>100) {
                return "0" + date;
            }
            if(absoluteYear>10) {
                return "00" + date;
            }
            else{
                return "000"+date;
            }

        }
    }

    public Date(int year , int month , int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    public boolean checkValid(int date ,Time time){
        switch(time){
            case MINUTE:
                if((date>=0)&&(date<=59)){
                    return true;
                }
                break;
            case HOUR:
                if((date>=0) &&(date<=23)){
                    return true;
                }
                break;
            case DAY:
                if((date >= 1) && (date <= 31)){
                    return true;
                }
                break;
            case MONTH:
                if((date >= 1) &&(date <= 12)){
                    return true;
                }
                break;
            case YEAR:
                if((date>= -3999)&&(date<=3999)){
                    return true;

                }
                break;
        }
        return false;
    }
    public int getYear(){return this.year;}
    public int getMonth(){return this.month;}
    public int getDay(){return this.day;}

    public void setYear(int year) {
        if(!(checkValid(year,Time.YEAR))){
            year = 0;
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if(!(checkValid(month,Time.MONTH))){
            month = 1;
        }
        this.month = month;
    }

    public void setDay(int day) {
        if(!(checkValid(day,Time.DAY))){
            day = 1;
        }
        this.day = day;
    }

    @Override
    public String toString() {

        return bufferDate(day,Time.DAY) + "/" + bufferDate(month,Time.MONTH)
                + "/" + bufferDate(year,Time.YEAR);
    }

    @Override
    public int hashCode() {
        return (this.day-1)*(60*24) + ((60*24*31)*(this.month-1)) + (60*24*31*12)*this.year;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Date) ){
            return false;
        }
        Date otherDate = (Date) other;

        if(otherDate.hashCode() != hashCode()){
            return false;
        }
        return (otherDate.getDay() == this.day) && (otherDate.getMonth() == this.month) &&
                (otherDate.getYear() == this.year);
    }
}
