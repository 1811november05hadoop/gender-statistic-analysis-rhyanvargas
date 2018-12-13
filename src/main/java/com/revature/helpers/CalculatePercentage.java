package com.revature.helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;

/**
 * Class with static methods to calculate various percentage calculations/operations
 */
public class CalculatePercentage {

    public static double sumOfPercentChange(List<Double> percentChangeArray) {
        double sum = 0;
        for (Double percent : percentChangeArray) {
            sum += percent;
        }
        return sum;
    }
    /**
     * Calculates the total percent change from two different years
     * @param firstYearPercentage
     * @param lastYearPercentage
     * @return
     */
    public static double percentChangeTotal(double firstYearPercentage, double lastYearPercentage) {
        double percentChangeTotal = lastYearPercentage - firstYearPercentage;
        return  percentChangeTotal;
    }
    /**
     * This method takes in a Iterable and performs a delta for each pair of values
     * and returns an new ArrayList<>(); that holds those delta values
     * 
     * @param values
     * @return List<Double>
     */
    public static List<Double> arrayOfPercentChanges(Iterable<DoubleWritable> values) {
        List<Double> percentChangeArray = new ArrayList<>();
        double percentChange = 0.00, currentYearPercentage = 0.00, previousYearPercentage = 0.00;
        int index = 0;

        for (DoubleWritable value : values) {
            // *
            currentYearPercentage = value.get();
            if (index == 0) {
                /**
                 * Fetch the First year percentage
                 */
                percentChangeArray.add(currentYearPercentage);
            }
            // if (currentYearPercentage < 0) {
            //     /**
            //      * If value is negaitve, multiply by -1 to turn postitive
            //      */
            //     currentYearPercentage *= -1;
            // }
            if (index > 0) {
                /**
                 * Set the value of the previous and current year percentage
                 */
                previousYearPercentage = currentYearPercentage;
                currentYearPercentage = value.get();
                /**
                 * Calculate the percentage difference from the current and previous year.
                 */
                percentChange = currentYearPercentage - previousYearPercentage;
                /**
                 * Add percentage difference to array of percentage changes
                 */
                percentChangeArray.add(percentChange);
            }
            index += 1;
        }
        return percentChangeArray;
    }

    public static List<Double> getFirstAndLastVal(Iterable<DoubleWritable> values) {
        double  firstYearPercentage = 0.00,
                lastYearPercentage = 0.00;
        int index = 0;

        List<Double> arrOfPercentages = new ArrayList<>();
        for (DoubleWritable value : values) {
            if (index == 0) {
                firstYearPercentage = value.get();
                arrOfPercentages.add(firstYearPercentage);
            } else {
                /**
                 * Will keep re-assigning variable until the end of the values list. the final
                 * assignment represents the last percentage value we want.
                 */
                lastYearPercentage = value.get();
            }
            index += 1;
        }
        arrOfPercentages.add(lastYearPercentage);
        return arrOfPercentages;
    }

}