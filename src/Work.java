public class Work {
    /**
     *The Work object is the overall task of the program.
     * @property workingRange:: is the actual range that needs to be evaluated.
     * @property bite:: the size of work chunks delivered for anyone who asks for work.
     * @property current:: where in the interval are we currently done.
     * @property done:: boolean is true is we have reached the end of the workingRange.
     */
    private Range workingRange;
    private int bite;
    private int current;
    private boolean done;

    /**
     * @param max max value of the workingRange
     * @param bite bite size
     */
    public Work(int max, int bite){
        this.workingRange = new Range(3, max);
        this.current = 3;
        this.bite = bite;
    }

    /**
     * @param min lower boundary of the workingRange
     * @param max higher boundary of the workingRange
     * @param bite bite size
     */
    public Work(int min, int max, int bite){
        this.workingRange = new Range(min, max);
        this.current = min;
        this.bite = bite;
    }


    /**
     * Synchronized method given that the work has to be split among threads.
     * @return a range task for a Prime Thread
     */
    public synchronized Range giveWork(){
        Range nextRange;
        if(!done)
        {
            if ((current+bite)> this.workingRange.getMax())
            {
                nextRange = new Range(this.current, workingRange.getMax());
                done = true;
            }else{
                nextRange = new Range(this.current, current+ bite-1);
                current += bite;
            }
            return nextRange;
        }else{
            return null;
        }
    }

    /**
     * Keeps track of telling whether or not there has more work to be done.
     * @return boolean.
     */
    public boolean isMoreWork(){
        return !this.done;
    }
}