package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime) // Measure average time per operation
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Show results in nanoseconds (super fast)
public class BenchmarkRunner {

    private Teacher teacher;

    @Setup
    public void setup() {
        // Prepare data before the clock starts
        teacher = new Teacher("T1", "Benchmark Teacher", "Math", 10);
    }

    // This is the "Demanding Component" we are measuring
    @Benchmark
    public int measureSalaryCalculation() {
        return teacher.calculateSalary(10);
    }

    // Main method to run the benchmark directly
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .forks(1)              // Use 1 separate process
                .warmupIterations(1)   // Warm up the Java engine (1 time)
                .measurementIterations(3) // Measure the speed (3 times)
                .build();

        new Runner(opt).run();
    }
}