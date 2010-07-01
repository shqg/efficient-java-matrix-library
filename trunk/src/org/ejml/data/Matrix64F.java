/*
 * Copyright (c) 2009-2010, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
 *
 * EJML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * EJML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with EJML.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.ejml.data;


/**
 * An abstract class for all 64 bit floating point rectangular matrices.
 *
 * @author Peter Abeles
 */
public abstract class Matrix64F {

    /**
     * Number of columns in the matrix.
     */
    public int numCols;
    /**
     * Number of rows in the matrix.
     */
    public int numRows;

    /**
     * Changes the number of rows and columns in a matrix and if possible does not declare new memory.  If saveValues is
     * true and new memory needs to be declared, the value of the old internal data will be copied over into the new internal data.
     *
     * @param numRows The new number of rows the matrix will have.
     * @param numCols The new number of columns the matrix will have.
     * @param saveValues If new memory is declared should it copy the old values over?
     */
    public abstract void reshape(int numRows, int numCols, boolean saveValues);

    /**
     * Returns the value of value of the specified matrix element..
     *
     * @param row Matrix element's row index..
     * @param col Matrix element's column index.
     * @return The specified element's value.
     */
    public abstract double get( int row , int col );

    /**
     * Sets the value of the specified matrix element.
     *
     * @param row Matrix element's row index..
     * @param col Matrix element's column index.
     * @param val  The element's new value.
     */
    public abstract void set( int row , int col , double val );

    /**
     * Creates a new iterator for traversing through a submatrix inside this matrix.  It can be traversed
     * by row or by column.  Range of elements is inclusive, e.g. minRow = 0 and maxRow = 1 will include rows
     * 0 and 1.  The iteration starts at (minRow,minCol) and ends at (maxRow,maxCol)
     *
     * @param rowMajor true means it will traverse through the submatrix by row first, false by columns.
     * @param minRow first row it will start at.
     * @param minCol first column it will start at.
     * @param maxRow last row it will stop at.
     * @param maxCol last column it will stop at.
     * @return A new MatrixIterator
     */
    public MatrixIterator iterator(boolean rowMajor, int minRow, int minCol, int maxRow, int maxCol)
    {
        return new MatrixIterator(this,rowMajor, minRow, minCol, maxRow, maxCol);
    }

    /**
     * Returns the number of rows in this matrix.
     *
     * @return Number of rows.
     */
    public int getNumRows() {
        return numRows;    
    }

    /**
     * Returns the number of columns in this matrix.
     *
     * @return Number of columns.
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * Returns the number of elements in this matrix, which is the number of rows
     * times the number of columns.
     *
     * @return Number of elements in this matrix.
     */
    public abstract int getNumElements();
}