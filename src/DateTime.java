public class DateTime extends Date{
    private int hour;
    private int minute;

    public DateTime(int year , int month ,int day ,int hour , int minute){
        super( year ,  month , day);
        setHour(hour);
        setMinute(minute);

    }
    private int getHour(){
        return this.hour;
    }
    private int getMinute(){
        return this.minute;
    }
    public void setMinute(int minute){
        if(!(checkValid(minute,Time.MINUTE))){
            minute = 0;
        }
        this.minute = minute;
    }
    public void setHour(int hour){
        if(!(checkValid(hour,Time.HOUR))){
            hour = 0;
        }
        this.hour = hour;
    }
    @Override
    public String toString() {

        return super.toString() + " "  + bufferDate(hour, Time.HOUR)+ ":" + bufferDate(minute, Time.MINUTE);
    }

    @Override
    public int hashCode() {

        return (this.minute) + (this.hour * 60) + super.hashCode() +1 ;
    }

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
