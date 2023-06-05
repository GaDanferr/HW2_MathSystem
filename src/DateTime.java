/**Class depicting a date with extra attributes: hour and minute. */
public class DateTime extends Date{
    private int hour;
    private int minute;

    /**
     * Creates a new datetime object depicting a certain time.
     * @param year  depicts the year of the object.
     * @param month depicts the month of the object.
     * @param day depicts the day of the object.
     * @param hour depicts the hour of the object.
     * @param minute depicts the minute of the object.
     */
    public DateTime(int year , int month ,int day ,int hour , int minute){
        super( year ,  month , day);
        setHour(hour);
        setMinute(minute);

    }

    /**
     * grabs the hour of the object.
     * @return the hour of the object.
     */
    private int getHour(){
        return this.hour;
    }
    /**
     * gets the minute of the object.
     * @return the minute of the object.
     */
    private int getMinute(){
        return this.minute;
    }

    /**
     * Sets the minute whereas if outside the range [0,59] sets the minute to 0.
     * @param minute the minute attempted to set.
     */
    public void setMinute(int minute){
        if(!(checkValid(minute,Time.MINUTE))){
            minute = 0;
        }
        this.minute = minute;
    }

    /**
     * Sets the hour whereas if outside the range [0,23] sets the hour to 0.
     * @param hour the hour attempted to set.
     */
    public void setHour(int hour){
        if(!(checkValid(hour,Time.HOUR))){
            hour = 0;
        }
        this.hour = hour;
    }
    /**
     * Converts the DateTime represented to a string with the standard DD/MM/YY MM:HH
     * whereas duplicating indicates desired length buffered with 0's if insufficient length.
     *
     * @return  the string representation for the DateTime object.
     */
    @Override
    public String toString() {

        return super.toString() + " "  + bufferDate(hour, Time.HOUR)+ ":" + bufferDate(minute, Time.MINUTE);
    }

    /**
     * Creates a 1:1 hashcode for the object adds 1 to differentiate with Date class
     * @return integer representing a hashcode.
     */
    @Override
    public int hashCode() {

        return (this.minute) + (this.hour * 60) + super.hashCode() + 1;
    }

    /**
     * checks if two objects are the same with the following requirement:
     * (1) Both objects have to be the class DateTime ONLY.
     * (2) Two objects are equal iff all of their attributes (minute,hour,day , month ,year) are equal.
     * @param other the object being compared with this object.
     * @return returns true if both objects are of same class and same attribute values.
     */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof DateTime) ){
            return false;
        }
        DateTime otherDate = (DateTime) other;
        if(otherDate.hashCode() != this.hashCode()){
            return false;
        }
        return (otherDate.getMinute() == this.minute) && (otherDate.getHour() == this.hour) &&
                (otherDate.getDay() == this.getDay())&& (otherDate.getMonth() == this.getMonth()) &&
                (otherDate.getYear() == this.getYear());
    }


}
