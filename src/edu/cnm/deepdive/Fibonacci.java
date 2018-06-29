package edu.cnm.deepdive;

import java.math.BigInteger;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Fibonacci implements Iterable<BigInteger> {
  
  private int terms;
  
  public Fibonacci() {
    this(-1);
  }
  
  public Fibonacci(int terms) {
    this.terms = terms;
  }


  @Override
  public Iterator<BigInteger> iterator() {
    // TODO Auto-generated method stub
    return new FibIterator(terms);
  }

  private static class FibIterator implements Iterator<BigInteger> {
    
    private int terms;
    private int count;
    private Deque<BigInteger> work = new LinkedList<>();
    
    private FibIterator(int terms) {
      this.terms = terms;
      work.addLast(BigInteger.valueOf(-1));
      work.addLast(BigInteger.ONE);
      count = 0;
    }

    @Override
    public boolean hasNext() {
      return (terms < 0 || count < terms);
    }

    @Override
    public BigInteger next() {
      BigInteger current = work.removeFirst();
      current = current.add(work.getLast());
      work.addLast(current);
      count++;
      return current;
    }
    
  }
  
  
}
