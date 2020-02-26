package com.williamssonoma.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


/**
 * @author jesusacosta
 * 
 * BACKGROUND:
 * Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a 
 * series of ranges of 5 digit codes. For example if the ranges are:
 *
 * [94133,94133] [94200,94299] [94600,94699]
 *
 * Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 
 * 94133, 94650, 94230, 94600, or 94299.
 *
 * Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.
 *
 * PROBLEM:
 * Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an 
 * algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.
 *
 * NOTES:
 * - The ranges above are just examples, your implementation should work for any set of arbitrary ranges
 * - Ranges may be provided in arbitrary order
 * - Ranges may or may not overlap
 * - Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards 
 *   and best practices
 *
 * EXAMPLES:
 * If the input = [94133,94133] [94200,94299] [94600,94699]
 * Then the output should be = [94133,94133] [94200,94299] [94600,94699]
 *
 * If the input = [94133,94133] [94200,94299] [94226,94399] 
 * Then the output should be = [94133,94133] [94200,94399]
 *
 * Evaluation Guidelines:
 * Your work will be evaluated against the following criteria:
 * - Successful implementation
 * - Efficiency of the implementation
 * - Design choices and overall code organization
 * - Code quality and best practices
 * 
 */
public class ZipCodesRanges {

  public static List<Range> produceMinNumRanges(TreeSet<Range> rangesSet) {
    List<Range> rangesImprovedList = new ArrayList<>();
    int i = -1;
 
    for (Range toAddRange : rangesSet) {
      if (rangesImprovedList.isEmpty()) {
	rangesImprovedList.add(toAddRange);
	i++;

      } else {
	Range currentRange = rangesImprovedList.get(i);
	
	if (toAddRange.getLower() > currentRange.getUpper()) {
	  // toAddRange outside higher of existing range
	  rangesImprovedList.add(toAddRange);
	  // increment index to get element from rangesImprovedList
	  i++;

	} else if (toAddRange.getLower() <= currentRange.getUpper()) {
	  // Range to add overlaps with current range, then merge them
	  toAddRange.setLower(currentRange.getLower());

	  if (toAddRange.getUpper() <= currentRange.getUpper()) {
	    toAddRange.setUpper(currentRange.getUpper());
	  }
	  
	  // Remove currentRage from rangesImprovedList and add new merged range
	  rangesImprovedList.remove(currentRange);
	  rangesImprovedList.add(toAddRange);
	}
      }
    }
    return rangesImprovedList;
  }

  
  public static void main(String[] args) {
    // Create Ranges
//     Range r2 = new Range(94133,94133);
//     Range r1 = new Range(94200,94299);
//     Range r0 = new Range(94600,94699);
    Range r2 = new Range(94133, 94133);
    Range r1 = new Range(94299, 94200); //In the contructor the lower and upper are corrected
    Range r0 = new Range(94226, 94399);
    List<Range> rangesList = Arrays.asList(r0, r1, r2);

    // Sort and eliminate duplicate ranges by converting List to HashSet
    TreeSet<Range> rangesTreeSet = new TreeSet<>(rangesList);

    System.out.println("Original list with Zip Code Ranges:");
    rangesList.forEach(System.out::println);
    
    System.out.println("Original list without duplicates and ordered in ascendent order:");
    rangesTreeSet.forEach(System.out::println);

    // Produces the minimum number of ranges
    List<Range> newRangesList = produceMinNumRanges(rangesTreeSet);

    System.out.println("improved list with minimum number of ranges:");
    newRangesList.forEach(System.out::println);
  }
}
