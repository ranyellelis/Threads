import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;


public class Tarefa implements Callable {

	public Object call() throws Exception {
		System.out.println("Nova thread");
		
		Random r = new Random();
		int num = r.nextInt(10);
		System.out.println(num);
		if(num > 8){
			return new Date();
		} else {
			return null;
		}
		
	}

}
