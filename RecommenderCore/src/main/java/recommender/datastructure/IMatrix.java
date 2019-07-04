package recommender.datastructure;

/**
 * @author Jason.Zhuang
 * Jun 3, 2019
 * IMatrix.java
 * Describe: the basic interface of Matrix
 */
public interface IMatrix extends Cloneable 
{
	/**
	 * add a new Vector to the Matrix
	 * @param v
	 */
	void addVector(AbstractVector v);
	
	
	/**
	 * add a new Vector to the Matrix by key
	 * @param v
	 */
	void addVector(int v_key, AbstractVector v);
	
	/**
	 * add a new Vector to the Matrix
	 * @param v
	 */
	AbstractVector getVector(int v_key);
	
	/**
     * @return The number of rows in the matrix.
     */
    int columnSize();

    /**
     * @return Returns the number of rows in the matrix.
     */
    int rowSize();

    /**
     * Return a reference to a row.  
     * Changing the Vector will change the original matrix.
     *
     * @param rowIdx
     * @return
     */
    IVector getRow(int rowIdx);

    /**
     * Return a reference to a column.  
     * Changing the Vector will change the original matrix.
     * @param columnIdx
     * @return
     */
    IVector getColumn(int columnIdx);

    /**
     * Return the value at the given indexes, without checking bounds
     *
     * @param row    an int row index
     * @param column an int column index
     * @return the double at the index
     * @throws IndexException if the index is out of bounds
     */
    double getCell(int row, int column);

    /**
     * Set the value at the given index, without checking bounds
     *
     * @param row    an int row index into the receiver
     * @param column an int column index into the receiver
     * @param value  a double value to set
     * @throws IndexException if the index is out of bounds
     */
    void setCell(int row, int column, double value);

    
    /**
     * @return a formatted String suitable for output
     */
    String toString();
    
    
}
