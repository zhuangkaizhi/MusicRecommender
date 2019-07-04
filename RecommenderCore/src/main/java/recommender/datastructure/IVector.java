package recommender.datastructure;

/**
 * @author Jason.Zhuang
 * Jun 1, 2019
 * Vector.java
 * Describe:
 */
public interface IVector extends Cloneable
{
    /**
     * Number of active entries.  
     * An "active element" is an element which is explicitly stored,
     * regardless of its value.  
     * Note that inactive entries have value 0.
     * @return an int
     */
    int getNumEntries();
    
    /**
     * Return an object of Vector.
     * VectorEntry representing an entry of this Vector. 
     * Useful when designing new iterator types.
     *
     * @param index Index of the Vector.VectorEntry required
     * @return The Vector.Element Object
     */
    ItemValueEntity getVectorEntry(int index);

    /**
     * Set the value at the given index, 
     * without checking bounds
     * @param index an int index into the receiver
     * @param value a double value to set
     */
    void set(int index, double value);

    /**
     * Return the value at the given index, 
     * without checking bounds
     * @param index an int index
     * @return the double at the index
     */
    double get(int index);

    /**
     * Return the sum of all the elements of the receiver
     *
     * @return a double
     */
    double sum();

    /**
     * Return the sum of all the elements's square
     * @return
     */
    double sumOfSquares();
    
    /**
     * Return the mean of all the elements
     *
     * @return a double
     */
    double mean();
    
    
    /**
	 * @return a formatted String suitable for output
	 */
    String toString();
    
}
