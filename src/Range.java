/**
 * Simple range class.
 */
public class Range {
    private int min, max;

    public Range(){
        min = 3;
        max = 3;
    }
    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }
}