public class Threads implements Runnable{
    public int count;
    private boolean isSafe;

    Threads(boolean isSafe){
        super();
        count = 0;
        this.isSafe = isSafe;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000000; i++) {
            if (isSafe) {
                safeIncrement();
            }else{
                increment();
            }
        }
    }

    synchronized private void safeIncrement(){
        count++;
    }

    private void increment(){
        count++;
    }

}
