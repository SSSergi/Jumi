package pthreads;


public class simpleThreads {
    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class messageLoop implements Runnable{

        public void run(){

            String importantInfo[] = {"top Riven", "jungla Evelyn", "mid Zoe", "adc Jhin", "sup Thresh"};

            try{
                for (int i=0; i < importantInfo.length; i++) {
                    Thread.sleep(2000);
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("No está terminado.");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException{

        long patience = 1000*20;

        if (args.length > 0) {
            try{
                patience = Long.parseLong(args[0])*1000;
            } catch (NumberFormatException e) {
                System.err.println("El argumento ha de ser un INTEGER.");
                System.exit(1);
            }
        }

        threadMessage("Comenzando mensage en bucle");
        long StartTime = System.currentTimeMillis();
        Thread t = new Thread(new messageLoop());
        t.start();

        threadMessage("Esperando a que la tarea MessageLoop acabe.");

        while (t.isAlive()) {
            threadMessage("Esperando...");
            t.join(1000);

            if (((System.currentTimeMillis() - StartTime) > patience) && t.isAlive()) {
                threadMessage("Ya vale de esperar boludo.");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Por fin.");
    }
}