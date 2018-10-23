/*
 * MIT License
 *
 * Copyright (c) 2018 Ilia Rogozhin (@smallcreep) <ilia.rogozhin@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.smallcreep.cucumber.seeds.fake;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * Fake ResultSet, throws of all methods {@link UnsupportedOperationException}.
 * @since 0.2.0
 */
public abstract class ResultSetFake implements ResultSet {

    @Override
    public boolean next() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #next()"
        );
    }

    @Override
    public void close() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #close()"
        );
    }

    @Override
    public boolean wasNull() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #wasNull()"
        );
    }

    @Override
    public String getString(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getString()"
        );
    }

    @Override
    public boolean getBoolean(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBoolean()"
        );
    }

    @Override
    public byte getByte(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getByte()"
        );
    }

    @Override
    public short getShort(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getInt(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getInt()"
        );
    }

    @Override
    public long getLong(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getLong()"
        );
    }

    @Override
    public float getFloat(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getFloat()"
        );
    }

    @Override
    public double getDouble(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getDouble()"
        );
    }

    @Deprecated
    @Override
    public BigDecimal getBigDecimal(final int columnIndex, final int scale) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBigDecimal()"
        );
    }

    @Override
    public byte[] getBytes(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBytes()"
        );
    }

    @Override
    public Date getDate(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getDate()"
        );
    }

    @Override
    public Time getTime(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getTime()"
        );
    }

    @Override
    public Timestamp getTimestamp(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getTimestamp()"
        );
    }

    @Override
    public InputStream getAsciiStream(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getAsciiStream()"
        );
    }

    @Deprecated
    @Override
    public InputStream getUnicodeStream(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getUnicodeStream()"
        );
    }

    @Override
    public InputStream getBinaryStream(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBinaryStream()"
        );
    }

    @Override
    public String getString(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getString()"
        );
    }

    @Override
    public boolean getBoolean(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBoolean()"
        );
    }

    @Override
    public byte getByte(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getByte()"
        );
    }

    @Override
    public short getShort(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getInt(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public long getLong(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public float getFloat(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public double getDouble(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Deprecated
    @Override
    public BigDecimal getBigDecimal(final String columnLabel, final int scale) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public byte[] getBytes(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Date getDate(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Time getTime(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Timestamp getTimestamp(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public InputStream getAsciiStream(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Deprecated
    @Override
    public InputStream getUnicodeStream(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public InputStream getBinaryStream(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public String getCursorName() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Object getObject(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Object getObject(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int findColumn(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Reader getCharacterStream(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public Reader getCharacterStream(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public BigDecimal getBigDecimal(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public BigDecimal getBigDecimal(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean isFirst() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean isLast() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void beforeFirst() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void afterLast() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean first() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean last() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean absolute(final int row) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean relative(final int rows) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean previous() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void setFetchDirection(final int direction) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void setFetchSize(final int rows) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getType() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getConcurrency() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean rowInserted() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateNull(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateBoolean(final int columnIndex, final boolean x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateByte(final int columnIndex, final byte x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateShort(final int columnIndex, final short x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateInt(final int columnIndex, final int x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateLong(final int columnIndex, final long x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public void updateFloat(final int columnIndex, final float x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateFloat()"
        );
    }

    @Override
    public void updateDouble(final int columnIndex, final double x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateDouble()"
        );
    }

    @Override
    public void updateBigDecimal(final int columnIndex, final BigDecimal x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBigDecimal()"
        );
    }

    @Override
    public void updateString(final int columnIndex, final String x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateString()"
        );
    }

    @Override
    public void updateBytes(final int columnIndex, final byte[] x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBytes()"
        );
    }

    @Override
    public void updateDate(final int columnIndex, final Date x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateDate()"
        );
    }

    @Override
    public void updateTime(final int columnIndex, final Time x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateTime()"
        );
    }

    @Override
    public void updateTimestamp(final int columnIndex, final Timestamp x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateTimestamp()"
        );
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final int length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateObject(final int columnIndex, final Object x, final int scaleOrLength) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void updateObject(final int columnIndex, final Object x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void updateNull(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNull()"
        );
    }

    @Override
    public void updateBoolean(final String columnLabel, final boolean x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBoolean()"
        );
    }

    @Override
    public void updateByte(final String columnLabel, final byte x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateByte()"
        );
    }

    @Override
    public void updateShort(final String columnLabel, final short x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateShort()"
        );
    }

    @Override
    public void updateInt(final String columnLabel, final int x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateInt()"
        );
    }

    @Override
    public void updateLong(final String columnLabel, final long x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateLong()"
        );
    }

    @Override
    public void updateFloat(final String columnLabel, final float x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateFloat()"
        );
    }

    @Override
    public void updateDouble(final String columnLabel, final double x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateDouble()"
        );
    }

    @Override
    public void updateBigDecimal(final String columnLabel, final BigDecimal x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBigDecimal()"
        );
    }

    @Override
    public void updateString(final String columnLabel, final String x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateString()"
        );
    }

    @Override
    public void updateBytes(final String columnLabel, final byte[] x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBytes()"
        );
    }

    @Override
    public void updateDate(final String columnLabel, final Date x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateDate()"
        );
    }

    @Override
    public void updateTime(final String columnLabel, final Time x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateTime()"
        );
    }

    @Override
    public void updateTimestamp(final String columnLabel, final Timestamp x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateTimestamp()"
        );
    }

    @Override
    public void updateAsciiStream(final String columnLabel, final InputStream x, final int length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final String columnLabel, final InputStream x, final int length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final String columnLabel, final Reader reader, final int length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateObject(final String columnLabel, final Object x, final int scaleOrLength) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void updateObject(final String columnLabel, final Object x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void insertRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #insertRow()"
        );
    }

    @Override
    public void updateRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateRow()"
        );
    }

    @Override
    public void deleteRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #deleteRow()"
        );
    }

    @Override
    public void refreshRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #refreshRow()"
        );
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #cancelRowUpdates()"
        );
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #moveToInsertRow()"
        );
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #moveToCurrentRow()"
        );
    }

    @Override
    public Statement getStatement() throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getStatement()"
        );
    }

    @Override
    public Object getObject(final int columnIndex, final Map<String, Class<?>> map) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public Ref getRef(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getRef()"
        );
    }

    @Override
    public Blob getBlob(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBlob()"
        );
    }

    @Override
    public Clob getClob(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getClob()"
        );
    }

    @Override
    public Array getArray(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getArray()"
        );
    }

    @Override
    public Object getObject(final String columnLabel, final Map<String, Class<?>> map) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public Ref getRef(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getRef()"
        );
    }

    @Override
    public Blob getBlob(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getBlob()"
        );
    }

    @Override
    public Clob getClob(final String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public Array getArray(final String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public Date getDate(final int columnIndex, final Calendar cal) throws SQLException {
        return null;
    }

    @Override
    public Date getDate(final String columnLabel, final Calendar cal) throws SQLException {
        return null;
    }

    @Override
    public Time getTime(final int columnIndex, final Calendar cal) throws SQLException {
        return null;
    }

    @Override
    public Time getTime(final String columnLabel, final Calendar cal) throws SQLException {
        return null;
    }

    @Override
    public Timestamp getTimestamp(final int columnIndex, final Calendar cal) throws SQLException {
        return null;
    }

    @Override
    public Timestamp getTimestamp(final String columnLabel, final Calendar cal) throws SQLException {
        return null;
    }

    @Override
    public URL getURL(final int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public URL getURL(final String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public void updateRef(final int columnIndex, final Ref x) throws SQLException {

    }

    @Override
    public void updateRef(final String columnLabel, final Ref x) throws SQLException {

    }

    @Override
    public void updateBlob(final int columnIndex, final Blob x) throws SQLException {

    }

    @Override
    public void updateBlob(final String columnLabel, final Blob x) throws SQLException {

    }

    @Override
    public void updateClob(final int columnIndex, final Clob x) throws SQLException {

    }

    @Override
    public void updateClob(final String columnLabel, final Clob x) throws SQLException {

    }

    @Override
    public void updateArray(final int columnIndex, final Array x) throws SQLException {

    }

    @Override
    public void updateArray(final String columnLabel, final Array x) throws SQLException {

    }

    @Override
    public RowId getRowId(final int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public RowId getRowId(final String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public void updateRowId(final int columnIndex, final RowId x) throws SQLException {

    }

    @Override
    public void updateRowId(final String columnLabel, final RowId x) throws SQLException {

    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public void updateNString(final int columnIndex, final String nString) throws SQLException {

    }

    @Override
    public void updateNString(final String columnLabel, final String nString) throws SQLException {

    }

    @Override
    public void updateNClob(final int columnIndex, final NClob nClob) throws SQLException {

    }

    @Override
    public void updateNClob(final String columnLabel, final NClob nClob) throws SQLException {

    }

    @Override
    public NClob getNClob(final int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public NClob getNClob(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getNClob()"
        );
    }

    @Override
    public SQLXML getSQLXML(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getSQLXML()"
        );
    }

    @Override
    public SQLXML getSQLXML(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getSQLXML()"
        );
    }

    @Override
    public void updateSQLXML(final int columnIndex, final SQLXML xmlObject) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateSQLXML()"
        );
    }

    @Override
    public void updateSQLXML(final String columnLabel, final SQLXML xmlObject) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateSQLXML()"
        );
    }

    @Override
    public String getNString(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getNString()"
        );
    }

    @Override
    public String getNString(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getNString()"
        );
    }

    @Override
    public Reader getNCharacterStream(final int columnIndex) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getNCharacterStream()"
        );
    }

    @Override
    public Reader getNCharacterStream(final String columnLabel) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getNCharacterStream()"
        );
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateNCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateBlob(final String columnLabel, final InputStream inputStream, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateNCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(final String columnLabel, final InputStream x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final String columnLabel, final InputStream x) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateBlob(final String columnLabel, final InputStream inputStream) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateClob(final String columnLabel, final Reader reader) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNClob(final String columnLabel, final Reader reader) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public <T> T getObject(final int columnIndex, final Class<T> type) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public <T> T getObject(final String columnLabel, final Class<T> type) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public <T> T unwrap(final Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #unwrap()"
        );
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException(
            "unsupported method #isWrapperFor()"
        );
    }


}
