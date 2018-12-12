package com.revature.reduce;

import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.revature.helpers.FormatDecimal;

/**
 * FemaleGradsReducer
 */
public class FemaleGradsReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
   
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {

        double  average = 0,
                sum = 0,
                averageBelow30Percent = 0,
                numYears = 6; // represents number of years of percentages tracked

        for (DoubleWritable value : values) {
             sum += value.get();
        }
        average = (sum / numYears);
        if (average < 30) {
            averageBelow30Percent = average;
            averageBelow30Percent = FormatDecimal.formatDecimal(averageBelow30Percent);
        }
        context.write(key, new DoubleWritable(averageBelow30Percent));
    }
    
}