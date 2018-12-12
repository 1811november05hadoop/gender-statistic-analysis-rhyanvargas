package com.revature.reduce;
import java.io.IOException;
import java.text.DecimalFormat;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.ArrayList;
import java.util.List;

import com.revature.helpers.FormatDecimal;
/**
 * Contains logic of Reducer for average increase in female education in the U.S. from the year 2000. AverageMap
 */
public class AverageIncreaseFemalesReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        double  averageOfSums, 
                sumOfPercentChanges = 0,
                averageYearIncrease, 
                currentYearPercentage , 
                previousYearPercentage;
        int     count = 0;
        final int RANGE_OF_YEARS = 16;
        List<Double> percentChangeArray = new ArrayList<>();

        for (DoubleWritable value : values) {
            currentYearPercentage = value.get();
            if(count == 0) {
                /**
                 * Fetch the First year percentage
                 */
                percentChangeArray.add(currentYearPercentage);
            }
            if (currentYearPercentage < 0) {
                /**
                 *  If value is negaitve, multiply by -1 to turn 
                 *  postitive
                 */ 
                currentYearPercentage *= -1;
            } 
            if(count > 0) {
                /**
                 * Set the value of the previous and current year percentage
                 */
                previousYearPercentage = currentYearPercentage;
                currentYearPercentage = value.get();
                /**
                 * Calculate the percentage difference from the current and previous year.
                 */
                averageYearIncrease = currentYearPercentage - previousYearPercentage;
                /**
                 * Add percentage difference to array of percentage changes
                 */
                percentChangeArray.add(averageYearIncrease);      
            } 
            count += 1;
        }
        /**
         * Calculate Sum of Percentage increases
         */
        for(Double percent: percentChangeArray) {
               sumOfPercentChanges += percent;
        }
        /**
         * Calculate the Average Sum Percent increase
         */
        averageOfSums = sumOfPercentChanges / RANGE_OF_YEARS;
        /**
         * Calculate the Average Sum Percent increase
         */
        averageOfSums = FormatDecimal.formatDecimal(averageOfSums);
        context.write(key, new DoubleWritable(averageOfSums));
    }
}