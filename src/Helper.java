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

    /*public boolean checkValid(int date ,Time time){
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
}
*/