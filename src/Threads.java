public class Threads implements Runnable{
    public int count; // count variable
    private boolean isSafe; // Boolean to know whether execute safe or unsafe threading method

    //CLass init
    Threads(boolean isSafe){
        super();
        count = 0;
        this.isSafe = isSafe;
    }

    // Thread run
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            // Callinf particular increment methods based on a received boolean
            if (isSafe) {
                safeIncrement();
            }else{
                increment();
            }
        }
    }

    // Safe increment
    synchronized private void safeIncrement(){
        System.out.println(count);
        count++;
    }

    // non-safe increment
    private void increment(){
        count++;
    }

}
