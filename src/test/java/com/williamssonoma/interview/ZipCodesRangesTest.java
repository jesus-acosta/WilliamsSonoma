package com.williamssonoma.interview;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import com.williamssonoma.interview.Range;
import com.williamssonoma.interview.ZipCodesRanges;

import junit.framework.TestCase;

public class ZipCodesRangesTest extends TestCase {

  public ZipCodesRangesTest(String name) {
    super(name);
  }

  protected void setUp() throws Exception {
    super.setUp();
  }

  public void testProduceMinNumRanges() {
    //try 2 different inputs
    
    // Input 1:
    List<Range> rangesList = Arrays.asList(new Range(94133, 94133), new Range(94200, 94299), new Range(94600, 94699));
    List<Range> rangesListExpected = Arrays.asList(new Range(94133, 94133), new Range(94200, 94299),
	new Range(94600, 94699));

    // Input 2:
//     List<Range> rangesList = Arrays.asList(new Range(94133, 94133), new
//     Range(94200, 94299), new Range(94226, 94399));
//     List<Range> rangesListExpected = Arrays.asList(new Range(94133, 94133), new Range(94200, 94399));

    //Test produceMinNumRanges method
    List<Range> rangeListResult = ZipCodesRanges.produceMinNumRanges(new TreeSet<>(rangesList));
    assertEquals(rangesListExpected, rangeListResult);
  }

}
