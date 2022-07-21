import java.util.Random;
public class GetRand {
    int x;
    GetRand(){
        Random r = new Random();
        x = r.nextInt(5)+1;
    }
    int getX(){
        return x;
    }
    int resetX(){
        Random r = new Random();
        x = r.nextInt(5)+1;
        return x;
    }
}
