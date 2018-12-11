// package com.revature;

// import java.io.BufferedReader;
// import java.io.FileReader;

// // import java.util.ArrayList;
// // import java.util.List;
// import com.revature.map.FemaleGradsMapper;
// import com.revature.reduce.FemaleGradsReducer;

// import org.apache.hadoop.io.DoubleWritable;
// import org.apache.hadoop.io.LongWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mrunit.mapreduce.MapDriver;

// import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
// import org.apache.log4j.Logger;
// import org.junit.Before;
// import org.junit.Test;

// /**
//  * Unit test for simple App.
//  */
// public class FemaleGradsTest
// {
//     private static final String TEST_DATA_REQUIREMENT1_TXT = "/Users/rhyanvargas/Revature/gender-statistic-analysis-rhyanvargas/src/test/java/com/revature/TestData/requirement1.txt";
//     private MapDriver<LongWritable, Text, Text, DoubleWritable> mapDriver;
//     private ReduceDriver<Text, DoubleWritable, Text, DoubleWritable> reduceDriver;

//     String requirementOneLine;

//     Logger LOGGER = Logger.getLogger(FemaleGradsTest.class);

//     @Before
//     public void setUp() throws Exception {
//         FemaleGradsMapper femaleGradsMapper = new FemaleGradsMapper();
//         FemaleGradsReducer femaleGradsReducer = new FemaleGradsReducer();

//         mapDriver = new MapDriver<>();
//         mapDriver.setMapper(femaleGradsMapper);
//         reduceDriver.setReducer(femaleGradsReducer);

//         // Read 1 line from the test data file
//         FileReader fr = new FileReader(TEST_DATA_REQUIREMENT1_TXT);
//         BufferedReader br = new BufferedReader(fr);
//         requirementOneLine = br.readLine();
//         br.close();
//         fr.close();

//        System.out.println("BEFORE" + requirementOneLine);
//     }

//     @Test
//     public void testFemaleGradsMapper() {
//         /*
//          * Mock input simulating a line of the file, not a file
//          */
//         mapDriver.withInput(new LongWritable(1), new Text(requirementOneLine));
//         // expected output
//         mapDriver.withOutput(new Text("Antigua and Barbuda"), new DoubleWritable(1.417));
//         System.out.println("TEST" + requirementOneLine);
//         mapDriver.runTest();
//     }

//     // public static void main(String[] args) throws Exception {
//     //     String requirementOneLine;
//     //     // Read 1 line from the test data file
//     //     FileReader fr = new FileReader(TEST_DATA_REQUIREMENT1_TXT);
//     //     BufferedReader br = new BufferedReader(fr);
//     //     requirementOneLine = br.readLine();
//     //     br.close();
//     //     fr.close();

//     //     System.out.println(requirementOneLine);
//     // }
// }
