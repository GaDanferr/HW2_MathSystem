public class Constant extends Polynomial{

    public Constant(double number){
        super(number);
    }


    @Override
    public String toString() {
        double value = getCoefficient(0);
        if(Function.convertInt(value)){
            return "(" + (int)value + ")";
        }
        else {
            return "(" + value + ")";
        }
    }

    @Override
    public Constant derivative() {
        return new Constant(0);
    }

}
