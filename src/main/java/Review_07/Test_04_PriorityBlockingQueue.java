package Review_07;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author RickYinPeng
 * @ClassName Test_04_PriorityBlockingQueue
 * @Description
 * @date 2019/2/21/17:56
 */
public class Test_04_PriorityBlockingQueue {


    static class Task implements Comparable<Task>{
        private int priority = 0;
        private String taskName;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public int compareTo(Task o) {
            if(this.priority>=o.priority){
                return 1;
            }else {
                return -1;
            }
        }
        public void doSomeThing(){
            System.out.println(taskName+":"+priority);
        }
    }



    public static void main(String[] args) {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<Task>();

        Random random  = new Random();
        for (int i = 0;i<10;i++){
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskName"+i);
            priorityBlockingQueue.offer(task);
        }

        while (!priorityBlockingQueue.isEmpty()){
            Task task = priorityBlockingQueue.poll();
            if(null!=task){
                task.doSomeThing();
            }
        }


    }
}
