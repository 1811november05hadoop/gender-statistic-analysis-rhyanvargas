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
public class PercentChangeMaleEmploymentReducer extends Reducer<Text, DoubleWritable, Text, Text> {
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        int index = 0; 
        double  percentChangeTotal = 0.00,
                firstYearPercentage = 0.00,                           
                lastYearPercentage = 0.00;
        String percentChangeString = "";
        StringBuilder arrOfPercentDeltas = new StringBuilder();

        for(DoubleWritable value : values){
            if(index == 0) {
                firstYearPercentage = value.get();
            } else {
                lastYearPercentage = value.get(); 
                percentChangeTotal = lastYearPercentage - firstYearPercentage;

                percentChangeString = String.valueOf(percentChangeTotal);
                if(index == 1) {
                      arrOfPercentDeltas
                        .append("--> Year 2000-2001: " +percentChangeString+ " || ");
                } else if(index < 9 ) {
                    arrOfPercentDeltas
                        .append("Year 200" +index+ "-200" +(index + 1)+ ": " +percentChangeString+ " || ");
                } else if (index == 9 ) {
                    arrOfPercentDeltas
                            .append("Year 2009-20" +(index + 1)+ ": " + percentChangeString + " || ");
                } else {
                    arrOfPercentDeltas
                            .append("Year 20" +index+ "-20" +(index + 1)+ ": " + percentChangeString + " || ");
                }
            }
            index += 1;
        }
        percentChangeTotal = FormatDecimal.formatDecimal(percentChangeTotal);
        context.write(key, new Text(arrOfPercentDeltas.toString()));
    }
}