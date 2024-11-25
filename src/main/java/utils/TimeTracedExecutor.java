package main.java.utils;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Logger;

public class TimeTracedExecutor<T,R,V> {
    Function<T,R> methodToExecute;
    BiFunction<T, V, R> methodToExecuteWithBiFunction;

    public TimeTracedExecutor(Function<T, R> methodToExecute) {
        this.methodToExecute = methodToExecute;
    }
    public TimeTracedExecutor(BiFunction<T, V, R> methodToExecute) {
        this.methodToExecuteWithBiFunction = methodToExecute;
    }

    public R executeWithInput(String taskDescription, T t){
        Long start = System.nanoTime();
        R r= methodToExecute.apply(t);
        Long finish = System.nanoTime();
        String format = "It took %s nanoseconds to "+taskDescription;
        String elapsedTime = NumberFormat.getNumberInstance().format(finish - start);
        System.out.println(String.format(format, elapsedTime));
        return r;
    }
    public R executeWithTwoInput(String taskDescription, T t, V v){
        Long start = System.nanoTime();
        R r= methodToExecuteWithBiFunction.apply(t, v);
        Long finish = System.nanoTime();
        String format = "It took %s nanoseconds to "+taskDescription;
        String elapsedTime = NumberFormat.getNumberInstance().format(finish - start);
        System.out.println(String.format(format, elapsedTime));
        return r;
    }
}
