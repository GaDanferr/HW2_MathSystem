public class Date {
    protected int year;
    protected int month;
    protected int day;

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

        return Helper.bufferDate(day,Time.DAY) + "/" + Helper.bufferDate(month,Time.MONTH)
                + "/" + Helper.bufferDate(year,Time.YEAR);
    }

    @Override
    public int hashCode() {
        return this.day*(60*24) + (60*24*32)*this.month + (60*24*32*13)*this.year;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Date) ){
            return false;
        }
        Date otherDate = (Date) other;
        return (otherDate.getDay() == this.day) && (otherDate.getMonth() == this.month) &&
                (otherDate.getYear() == this.year);
    }
}
