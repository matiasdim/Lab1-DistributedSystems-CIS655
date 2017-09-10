/*
 * Matías Gil Echavarría
 */
import org.apache.commons.cli.*;


public class Main {


    public static void main (String args[]){

        Options options = new Options();

        Option numberOfThreads = new Option("t", "threads", true, "number of threads");
        numberOfThreads.setRequired(true);
        options.addOption(numberOfThreads);

        Option isSafe = new Option("s", "safe", true, "safe or unsafe");
        isSafe.setRequired(true);
        options.addOption(isSafe);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
            return;
        }

        String threadNumberString = cmd.getOptionValue("threads");
        String isSafeBoolString = cmd.getOptionValue("safe");


        Threads thread= new Threads(Boolean.parseBoolean(isSafeBoolString));
        Thread[] thds = new Thread[Integer.parseInt(threadNumberString)];
        for(int i = 0; i< Integer.parseInt(threadNumberString); i++){
            thds[i] = new Thread(thread);
        }
        for(int i = 0; i< Integer.parseInt(threadNumberString); i++){
            thds[i].start();
        }

        try {
            for(int i = 0; i< Integer.parseInt(threadNumberString); i++){
                thds[i].join();
            }
            System.out.println(thread.count);
        }catch(InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}
