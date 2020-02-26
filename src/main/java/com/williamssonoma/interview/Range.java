package com.williamssonoma.interview;

/**
 * @author jesusacosta 
 * 
 * Ranges of ZipCodes e.g [94600,94699]
 * 
 */
public class Range implements Comparable<Range> {
  private Integer lower;
  private Integer upper;

  public Range(Integer lower, Integer upper) throws NullPointerException {
    if (lower == null || upper == null)
      throw new NullPointerException();

    if (lower <= upper) {
      this.lower = lower;
      this.upper = upper;
    } else {
      this.lower = upper;
      this.upper = lower;
    }
  }

  // Getters and Setters
  public Integer getLower() {
    return lower;
  }

  public void setLower(Integer lower) {
    this.lower = lower;
  }

  public Integer getUpper() {
    return upper;
  }

  public void setUpper(Integer upper) {
    this.upper = upper;
  }

  // Compare lower and upper ranges of all Ranges to sort
  public int compareTo(Range r) {
    int lastCmp = lower.compareTo(r.lower);
    return (lastCmp != 0 ? lastCmp : upper.compareTo(r.upper));
  }

  // Equals method
  public boolean equals(Object o) {
    if (!(o instanceof Range))
      return false;

    Range range = (Range) o;
    return range.getLower().equals(lower) && range.getUpper().equals(upper);
  }

  @Override
  public String toString() {
    // return "Range [lower=" + lower + ", upper=" + upper + "]";
    return "[" + lower + ", " + upper + "]";
  }
}
