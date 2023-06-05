/**Depicts a polyinomial function
 *
 *  Coefficient depicts the cofficient of the polynomial and the index depicts the power of the X.
 *  arrSize Depicts the size of the inputted array.
 */
public class Polynomial extends Function{
    private final double[] coefficient;
    private final int arrSize;

    /**
     * Creates a new polynomial function
     * @param varargs the coefficient of the polynomial whereas the index of the array would be the power of the X.
     */
    public Polynomial(double... varargs){
        this.arrSize = varargs.length;
        this.coefficient = new double[arrSize];

        for(int i = 0; i < arrSize ;i++){
            this.coefficient[i] = varargs[i];
        }
    }
    protected int findFirstNonZero(){
        double currentCoefficient;
        if(arrSize==1){
            return 0;
        }
        else{
            for (int i = 1 ;i < arrSize; i++) {
                currentCoefficient = getCoefficient(i);
                if (currentCoefficient !=0){
                    return i;
                }
            }
        }


            return arrSize;
    }

    protected double getCoefficient(int i){
        return coefficient[i];
    }

    /**
     * Counts the amount of Non-Zero coefficients the polynomial contains. Used exclusively by the toString method.
     * @return integer depicting the amount of Non-zero coefficients.
     */
    public int countNonZeroCoefficient(){
        int count = 0;
        for(int i = 0 ;i < arrSize ;i++){
            if(getCoefficient(i)!=0){
                count++;
            }
        }
        return count;
    }

    /**
     * Creates a string depicting the polynomial with the following attributes:
     * ax^i : a - depicts the coefficient , i - depicts the power x is being raised by.
     * in addition:
     * (1) if all coefficients are 0 the string representing the polynomial would be : (0)
     * (2) if a coefficient is 1 or -1 they are being ignored and print as x^i or -x^i respectively
     * unless they are the free number.
     * (3) ignores all 0's if there is at least one non-zero coefficient.
     * @return a string representing the polynomial with said restrictions.
     */
    @Override
    public String toString() {
        double[] nonZeroCoefficientArray;
        int[] nonZeroIndexArray;
        int count = this.countNonZeroCoefficient();

        if(count == 0 ){
            return "(0)";
        }


        nonZeroCoefficientArray = new double[count];
        nonZeroIndexArray = new int[count];
        int counter = 0;
        for(int i = 0 ;i < arrSize ;i++ ){
            double currentCoefficient = getCoefficient(i);
            if(currentCoefficient!=0){
                nonZeroCoefficientArray[counter] = currentCoefficient;
                nonZeroIndexArray[counter] = i;
                counter++;
            }
        }


        StringBuilder string = new StringBuilder();
        int firstIndex = nonZeroIndexArray[0];
        double firstCoefficient = nonZeroCoefficientArray[0] ;
        if(firstIndex == 0) {
            if (convertInt(firstCoefficient)) {
                string.append((int) firstCoefficient);
            } else {
                string.append(firstCoefficient);
            }
        }
        else {
            if (absoluteValue(firstCoefficient) != 1) {
                if(convertInt(firstCoefficient)){
                    string.append((int)firstCoefficient);
                }
                else{
                    string.append(firstCoefficient);
                }
            }
            else{
                if(firstCoefficient<0){
                    string.append("-");
                }
            }
        }
        if(firstIndex>=1){
            string.append("x");
        }
        if(firstIndex>1){
            string.append("^").append(firstIndex);
        }

        for(int i = 1 ;i < count ;i++){
            double currentNumber = nonZeroCoefficientArray[i];
            int currentIndex = nonZeroIndexArray[i];
            if(currentNumber > 0){
                string.append(" + ");
            }
            else{
                string.append(" - ");
            }
            currentNumber = absoluteValue(currentNumber);
            if(currentNumber!=1){
                if(convertInt(currentNumber)){
                    string.append((int)currentNumber);
                }
                else{
                    string.append(currentNumber);
                }
            }
            string.append("x");
            if(currentIndex > 1){
                string.append("^").append(currentIndex);
            }
        }
        return "(" + string + ")";
    }

    @Override
    public Polynomial derivative() {
        if ((arrSize == 1) ||findFirstNonZero()==arrSize){
            return new Constant(0);
        }
        if (arrSize == 2){
            return new Constant(this.getCoefficient(1));
        }
        else {
            int newArrSize = arrSize-1;
            double[] DervCoefficient = new double[newArrSize];
            for(int i = 0 ; i<newArrSize;i++) {
                DervCoefficient[i] = this.getCoefficient(i+1)*(i+1);
            }
            return new Polynomial(DervCoefficient);
        }
    }

    /**
     * Evaluates the polynomial at the point x.
     * @param x receives as input a point in which the function will be evaluated.
     * @return the value of the function at x.
     */
    @Override
    public double valueAt(double x) {
        double value = this.getCoefficient(0) ;
        for(int i = 1; i< arrSize ; i++){
            value += this.getCoefficient(i)*Math.pow(x,i);
        }
        return value;
    }

}
