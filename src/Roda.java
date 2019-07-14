import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Roda {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Date teste = null;
		
		Callable tarefa = new Tarefa();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		int itera = 0;

		while (teste == null && itera < 50) {
			System.out.println("Executou: "+itera+" vez");
			Future<Object> result = executor.submit(tarefa);
			teste = (Date) result.get();
			itera++;
		}
		
		if(teste != null){
			System.out.println("Não é nulo");
		}
		
		System.out.println("Treads criadas: "+itera);
		executor.shutdown();
	}
}
