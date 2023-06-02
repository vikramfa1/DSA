import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class FileWritersThread implements Runnable{
    FileCreation fileCreation;

    public FileWritersThread(FileCreation fileCreation) {
        this.fileCreation = fileCreation;
    }
    public void run() {
        System.out.println("current Thread: "+Thread.currentThread().getName());
        //try {
            int value = fileCreation.incrementAndGetCounter();
            fileCreation.blockingQueue.add(new FileFetchAndWriters(fileCreation, fileCreation.reentrantLock, value));
            /*fileCreation.reentrantLock.lock();
            fileCreation.fileWriter.append("count: ").append(String.valueOf(value)).append("name: ").append(Thread.currentThread().getName()).append(System.lineSeparator());
            fileCreation.reentrantLock.unlock();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
class CustomThreadPoolExecutors extends ThreadPoolExecutor {

    public CustomThreadPoolExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}
class FileFetchAndWriters implements Runnable {

    ReentrantLock reentrantLock;
    FileCreation fileCreation;
    int value;
    public FileFetchAndWriters(FileCreation fileCreation, ReentrantLock reentrantLock, int value) {
        this.fileCreation = fileCreation;
        this.reentrantLock = reentrantLock;
        this.value = value;
    }
    @Override
    public void run() {
            fileCreation.reentrantLock.lock();
        try {
            System.out.println("int: "+value);
            fileCreation.fileWriter.append("count: ").append(String.valueOf(value)).append("name: ").append(Thread.currentThread().getName()).append(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileCreation.reentrantLock.unlock();
        }

    }
}
class FileCreation {

    FileWriter fileWriter;
    AtomicInteger atomicInteger = new AtomicInteger();
    ReentrantLock reentrantLock = new ReentrantLock(true);
    BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);

    public void createFileWriter(String fileName) throws IOException {
        File file = new File(fileName);
        this.fileWriter = new FileWriter(file, true);
    }

    public int getCounter() {
        return atomicInteger.get();
    }

    public int incrementAndGetCounter() {
        return atomicInteger.incrementAndGet();
    }
}
public class MultiThreadFileWriter {

    public static void main(String args[]) throws IOException, InterruptedException {

        FileCreation fileCreation = new FileCreation();
        fileCreation.createFileWriter("/Users/vigsrini/Documents/camundaBPM/temp/output.txt");
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("write started");
        for(int i=0;i<5;i++) {
            service.submit(new FileWritersThread(fileCreation));
        }
        boolean result = service.awaitTermination(5, TimeUnit.SECONDS);
        if(result) {
            service.shutdown();
        }

        CustomThreadPoolExecutors writeExecutors = new CustomThreadPoolExecutors(10, 15,5, TimeUnit.MINUTES, fileCreation.blockingQueue);
        writeExecutors.prestartAllCoreThreads();
        boolean threadResult = writeExecutors.awaitTermination(5, TimeUnit.SECONDS);
        if(threadResult) {
            writeExecutors.shutdown();
        }
        System.out.println("write closed");
        /*fileCreation.blockingQueue.stream().forEach(a -> {
            try {
                fileCreation.fileWriter.append("count: ").append(String.valueOf(a)).append("name: ").append(Thread.currentThread().getName()).append(System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });*/
        fileCreation.fileWriter.close();
        while(!fileCreation.blockingQueue.isEmpty()) {
            System.out.println(fileCreation.blockingQueue.poll());
        }
    }
}
