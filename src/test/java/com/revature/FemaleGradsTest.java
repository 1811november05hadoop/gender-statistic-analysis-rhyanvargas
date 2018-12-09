// package com.revature;

// // import java.util.ArrayList;
// // import java.util.List;

// import com.revature.map.FemaleGradsMapper;

// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.LongWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mrunit.mapreduce.MapDriver;
// // import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
// // import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
// import org.junit.Before;
// import org.junit.Test;

// /**
//  * Unit test for simple App.
//  */
// public class FemaleGradsTest
// {
//     private MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
//     // private ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
//     /*
//      * arguments: [0, 1](K,V): input of mapper [2, 3](K,V): output of mapper [4,
//      * 5](K,V): output of reducer
//      */
//     // private MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

//     @Before
//     public void setUp() {
//         FemaleGradsMapper femaleGradsMapper = new FemaleGradsMapper();
//         mapDriver = new MapDriver<>();
//         mapDriver.setMapper(femaleGradsMapper);
//     }

//     @Test
//     public void testFemaleGradsMapper() {
//         /*
//          * Mock input simulating a line of the file, not a file
//          */
//         mapDriver.withInput(new LongWritable(1), new Text("afghanistan"));

//         // expected output
//         mapDriver.withOutput(new Text("afghanistan"), new IntWritable(1));
//         mapDriver.withOutput(new Text("afghanistan"), new IntWritable(1));
//         mapDriver.withOutput(new Text("afghanistan"), new IntWritable(1));

//         mapDriver.runTest();
//     }
// }
