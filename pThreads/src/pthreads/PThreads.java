package pthreads;


public class PThreads implements Runnable{


    public static void main(String[] args) {
        
        (new Thread(new PThreads())).start();
    }
    
    @Override
    public void run(){
        System.err.println("Hello there :D");
        System.err.println("Hello there, general Kenobi >:)");
    }
    
}
