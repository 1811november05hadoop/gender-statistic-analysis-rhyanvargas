package com.revature.reduce;
import java.io.IOException;

import com.revature.helpers.FormatDecimal;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/**
 * Contains logic of Reducer for Percent Change in Male employment from
 * the year 2000-2016.
 */
public class PercentChangeMaleEmploymentReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        int index = 0; 
        double  percentChangeTotal = 0.00, 
                firstYearPercentage = 0.00,                              
                lastYearPercentage = 0.00;
        for(DoubleWritable value : values){
            if(index == 0) {
                firstYearPercentage = value.get();
            } else {
                /**
                 * Will keep re-assigning variable until the end of
                 * the values list. the final assignment represents 
                 * the last percentage value we want.
                 */
                lastYearPercentage = value.get(); 
            }
            index += 1;
        }
        /**
         * Subtract the last and first year percentages for the difference. If
         * number is negative, it is a decrease in male employment
         */
        percentChangeTotal = lastYearPercentage - firstYearPercentage;
        percentChangeTotal = FormatDecimal.formatDecimal(percentChangeTotal);
        context.write(key, new DoubleWritable(percentChangeTotal));


    }
}