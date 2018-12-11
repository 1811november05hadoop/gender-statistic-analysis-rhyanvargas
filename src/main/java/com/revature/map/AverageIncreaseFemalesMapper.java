package com.revature.map;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * Contains logic of Mapper for average increase in female education in the U.S. from the year 2000. AverageMap
 */
public class AverageIncreaseFemalesMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        int index = 0;
        double percent;
        String country = "";
        boolean flag = false;
        /**
         * Fetch Gross graduation ratio of Females
         */
        if (line.matches("(.*)SE.TER.CMPL.FE.ZS(.*)")) {
            for (String word : line.split(",")) {
                // @Debating whether to keep null values or not..
                word = word.replace("\"", "");
                if (index == 0) {
                    if (word.equals("United States")) {
                        country = word;
                        flag = true;
                    }
                } else {
                    /** 
                     * Fetch percentages from year 2000 onwards
                     */ 
                    if (index > 46 && !word.equals("") && flag == true ) {
                        percent = Double.parseDouble(word);
                        context.write(new Text(country), new DoubleWritable(percent));
                    }
                }
                index += 1;
            }
        }
    }
}