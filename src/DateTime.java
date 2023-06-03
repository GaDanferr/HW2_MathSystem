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

        return super.toString() +" "  +Helper.bufferDate(hour,Time.HOUR)+ ":" + Helper.bufferDate(minute,Time.MINUTE);
    }

    @Override
    public int hashCode() {
        return this.minute + this.hour*60 +super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof DateTime) ){ //cant use this need to think of another method?
            return false;
        } //need to check date too
        DateTime otherDate = (DateTime) other;
        return (otherDate.getMinute() == this.minute) && (otherDate.getHour() == this.hour) &&
                (otherDate.getDay() == this.day)&& (otherDate.getMonth() == this.month) &&
                (otherDate.getYear() == this.year);
    }


}
