// package main.java.com.revature.reduce;

// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Partitioner;

// /**
//  * FemaleGradsReducer
//  */
// public class FemaleGradsReducer extends Partitioner<Text, IntWritable> {

//     private static char FIRST_SECTION_END = "World";
//     private static char SECOND_SECTION_START = "Afghanistan";

//     @Override
//     public int getPartition(Text key, IntWritable value, int numReduceTask) {
//         char firstCharacter = key.toString().charAt(0);

//         if (firstCharacter <= FIRST_SECTION_END) {
//             // Send it to the first reducer
//             return 0;
//         } else if (firstCharacter >= SECOND_SECTION_START &&
//         // Send it to the second reducer
//                 firstCharacter <= SECOND_SECTION_END) {
//             return 1;
//         } else {
//             // Send it to the third reducer
//             return 2;
//         }
//     }

// }