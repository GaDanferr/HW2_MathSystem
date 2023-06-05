/**Class depicting a date containing a year month and day */
public class Date {
    private int year;
    private int month;
    private int day;

    /**
     * Using enum : TIME decides how to buffer the string to be represented as a string in toString() with the standard:
     * DD/MM/YYYY
     *
     * @param date the value to buffer.
     * @param time TIME controls what kind of buffer to apply to the date.
     * @return a string buffered with 0's to match the display standard.
     */
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

    /**
     * Initializes a new date whereas all attributes are integers and:
     * year is in range[-3999 ,3999] if invalid year is set to 0.
     * month is in range [1,12] if invalid month is set to 1.
     * day is in range [1,31] if invalid  day is set to 1.
     * @param year depicts the year of the date.
     * @param month depicts the month of the date.
     * @param day depicts the day of the date.
     */
    public Date(int year , int month , int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    /**
     * Checks if the date value inputted is value before submitted in the expected range of the class
     * (detailed further at builder)
     *
     * @param date the value to input
     * @param time the type of time using the enum: TIME
     * @return  returns true if the value is within acceptable range
     */
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

    /**
     * Converts the date represented to a string with the standard DD/MM/YY
     * whereas duplicating indicates desired length buffered with 0's if insufficient length.
     *
     * @return  the string representation for the date
     */
    @Override
    public String toString() {

        return bufferDate(day,Time.DAY) + "/" + bufferDate(month,Time.MONTH)
                + "/" + bufferDate(year,Time.YEAR);
    }

    /**
     * creates a 1:1 hash code for the object
     * @return int representing the hash code
     */
    @Override
    public int hashCode() {
        return (this.day-1)*(60*24) + ((60*24*31)*(this.month-1)) + (60*24*31*12)*this.year;
    }

    /**
     * checks if two objects are the same with the following requirement:
     * (1) Both objects have to be the class Date ONLY.
     * (2) Two objects are equal iff all of their attributes (day , month ,year) are equal.
     * @param other the object being compared with this object.
     * @return returns true if both objects are of same class and same attribute values.
     */
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
