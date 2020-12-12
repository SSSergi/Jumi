package pthreads;


public class SleepMessages {
    
    public static void main(String[] args) throws InterruptedException{
        
        String importantInfo[] = {"top Riven", "jungla Evelyn", "mid Zoe", "adc Jhin", "sup Thresh"};
        String[] inputs = {"top Riven", "jungla Evelyn", "mid Zoe", "adc Jhin", "sup Thresh"};
        
        for (int i=0; i < importantInfo.length; i++){
            try{
                Thread.sleep(500);
            } catch(InterruptedException e) {
                // Interrupción, se para los mensajes.
                return;
            }
            System.err.println(importantInfo[i]);
        }
        
        for (int i=0; i < inputs.length; i++){
            heavyCrunch(inputs[i]);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
    }
    public static String heavyCrunch(String i){
        System.err.println(i);
        String string= i;
        return i;
    }
}
