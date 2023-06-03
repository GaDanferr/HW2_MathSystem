public abstract class Helper {
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
}
