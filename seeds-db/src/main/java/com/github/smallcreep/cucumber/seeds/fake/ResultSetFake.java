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
 * @checkstyle DesignForExtensionCheck (2000 lines)
 * @checkstyle ParameterNameCheck (2000 lines)
 * @checkstyle ParameterNameCheck (2000 lines)
 * @checkstyle MissingDeprecatedCheck (2000 lines)
 * @checkstyle MethodCountCheck (2000 lines)
 * @checkstyle MissingDeprecatedCheck (2000 lines)
 */
@SuppressWarnings(
    {
        "PMD.AvoidDuplicateLiterals",
        "PMD.ExcessivePublicCount",
        "PMD.ExcessiveClassLength",
        "PMD.TooManyMethods"
    }
)
public abstract class ResultSetFake implements ResultSet {

    @Override
    public boolean next() {
        throw new UnsupportedOperationException(
            "unsupported method #next()"
        );
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException(
            "unsupported method #close()"
        );
    }

    @Override
    public boolean wasNull() {
        throw new UnsupportedOperationException(
            "unsupported method #wasNull()"
        );
    }

    @Override
    public String getString(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getString()"
        );
    }

    @Override
    public boolean getBoolean(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getBoolean()"
        );
    }

    @Override
    public byte getByte(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getByte()"
        );
    }

    @Override
    public short getShort(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getInt(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getInt()"
        );
    }

    @Override
    public long getLong(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getLong()"
        );
    }

    @Override
    public float getFloat(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getFloat()"
        );
    }

    @Override
    public double getDouble(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getDouble()"
        );
    }

    @Deprecated
    @Override
    public BigDecimal getBigDecimal(final int columnIndex, final int scale) {
        throw new UnsupportedOperationException(
            "unsupported method #getBigDecimal()"
        );
    }

    @Override
    public byte[] getBytes(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getBytes()"
        );
    }

    @Override
    public Date getDate(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getDate()"
        );
    }

    @Override
    public Time getTime(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getTime()"
        );
    }

    @Override
    public Timestamp getTimestamp(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getTimestamp()"
        );
    }

    @Override
    public InputStream getAsciiStream(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getAsciiStream()"
        );
    }

    @Deprecated
    @Override
    public InputStream getUnicodeStream(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getUnicodeStream()"
        );
    }

    @Override
    public InputStream getBinaryStream(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getBinaryStream()"
        );
    }

    @Override
    public String getString(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getString()"
        );
    }

    @Override
    public boolean getBoolean(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getBoolean()"
        );
    }

    @Override
    public byte getByte(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getByte()"
        );
    }

    @Override
    public short getShort(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getShort()"
        );
    }

    @Override
    public int getInt(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getInt()"
        );
    }

    @Override
    public long getLong(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getLong()"
        );
    }

    @Override
    public float getFloat(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getFloat()"
        );
    }

    @Override
    public double getDouble(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getDouble()"
        );
    }

    @Deprecated
    @Override
    public BigDecimal getBigDecimal(final String columnLabel, final int scale) {
        throw new UnsupportedOperationException(
            "unsupported method #getBigDecimal()"
        );
    }

    @Override
    public byte[] getBytes(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getBytes()"
        );
    }

    @Override
    public Date getDate(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getDate()"
        );
    }

    @Override
    public Time getTime(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getTime()"
        );
    }

    @Override
    public Timestamp getTimestamp(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getTimestamp()"
        );
    }

    @Override
    public InputStream getAsciiStream(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getAsciiStream()"
        );
    }

    @Deprecated
    @Override
    public InputStream getUnicodeStream(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getUnicodeStream()"
        );
    }

    @Override
    public InputStream getBinaryStream(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getBinaryStream()"
        );
    }

    @Override
    public SQLWarning getWarnings() {
        throw new UnsupportedOperationException(
            "unsupported method #getWarnings()"
        );
    }

    @Override
    public void clearWarnings() {
        throw new UnsupportedOperationException(
            "unsupported method #clearWarnings()"
        );
    }

    @Override
    public String getCursorName() {
        throw new UnsupportedOperationException(
            "unsupported method #getCursorName()"
        );
    }

    @Override
    public ResultSetMetaData getMetaData() {
        throw new UnsupportedOperationException(
            "unsupported method #getMetaData()"
        );
    }

    @Override
    public Object getObject(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public Object getObject(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public int findColumn(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #findColumn()"
        );
    }

    @Override
    public Reader getCharacterStream(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getCharacterStream()"
        );
    }

    @Override
    public Reader getCharacterStream(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getCharacterStream()"
        );
    }

    @Override
    public BigDecimal getBigDecimal(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getBigDecimal()"
        );
    }

    @Override
    public BigDecimal getBigDecimal(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getBigDecimal()"
        );
    }

    @Override
    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException(
            "unsupported method #isBeforeFirst()"
        );
    }

    @Override
    public boolean isAfterLast() {
        throw new UnsupportedOperationException(
            "unsupported method #isAfterLast()"
        );
    }

    @Override
    public boolean isFirst() {
        throw new UnsupportedOperationException(
            "unsupported method #isFirst()"
        );
    }

    @Override
    public boolean isLast() {
        throw new UnsupportedOperationException(
            "unsupported method #isLast()"
        );
    }

    @Override
    public void beforeFirst() {
        throw new UnsupportedOperationException(
            "unsupported method #beforeFirst()"
        );
    }

    @Override
    public void afterLast() {
        throw new UnsupportedOperationException(
            "unsupported method #afterLast()"
        );
    }

    @Override
    public boolean first() {
        throw new UnsupportedOperationException(
            "unsupported method #first()"
        );
    }

    @Override
    public boolean last() {
        throw new UnsupportedOperationException(
            "unsupported method #last()"
        );
    }

    @Override
    public int getRow() {
        throw new UnsupportedOperationException(
            "unsupported method #getRow()"
        );
    }

    @Override
    public boolean absolute(final int row) {
        throw new UnsupportedOperationException(
            "unsupported method #absolute()"
        );
    }

    @Override
    public boolean relative(final int rows) {
        throw new UnsupportedOperationException(
            "unsupported method #relative()"
        );
    }

    @Override
    public boolean previous() {
        throw new UnsupportedOperationException(
            "unsupported method #previous()"
        );
    }

    @Override
    public void setFetchDirection(final int direction) {
        throw new UnsupportedOperationException(
            "unsupported method #setFetchDirection()"
        );
    }

    @Override
    public int getFetchDirection() {
        throw new UnsupportedOperationException(
            "unsupported method #getFetchDirection()"
        );
    }

    @Override
    public void setFetchSize(final int rows) {
        throw new UnsupportedOperationException(
            "unsupported method #setFetchSize()"
        );
    }

    @Override
    public int getFetchSize() {
        throw new UnsupportedOperationException(
            "unsupported method #getFetchSize()"
        );
    }

    @Override
    public int getType() {
        throw new UnsupportedOperationException(
            "unsupported method #getType()"
        );
    }

    @Override
    public int getConcurrency() {
        throw new UnsupportedOperationException(
            "unsupported method #getConcurrency()"
        );
    }

    @Override
    public boolean rowUpdated() {
        throw new UnsupportedOperationException(
            "unsupported method #rowUpdated()"
        );
    }

    @Override
    public boolean rowInserted() {
        throw new UnsupportedOperationException(
            "unsupported method #rowInserted()"
        );
    }

    @Override
    public boolean rowDeleted() {
        throw new UnsupportedOperationException(
            "unsupported method #rowDeleted()"
        );
    }

    @Override
    public void updateNull(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNull()"
        );
    }

    @Override
    public void updateBoolean(final int columnIndex, final boolean x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBoolean()"
        );
    }

    @Override
    public void updateByte(final int columnIndex, final byte x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateByte()"
        );
    }

    @Override
    public void updateShort(final int columnIndex, final short x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateShort()"
        );
    }

    @Override
    public void updateInt(final int columnIndex, final int x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateInt()"
        );
    }

    @Override
    public void updateLong(final int columnIndex, final long x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateLong()"
        );
    }

    @Override
    public void updateFloat(final int columnIndex, final float x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateFloat()"
        );
    }

    @Override
    public void updateDouble(final int columnIndex, final double x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateDouble()"
        );
    }

    @Override
    public void updateBigDecimal(final int columnIndex, final BigDecimal x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBigDecimal()"
        );
    }

    @Override
    public void updateString(final int columnIndex, final String x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateString()"
        );
    }

    @Override
    public void updateBytes(final int columnIndex, final byte[] x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBytes()"
        );
    }

    @Override
    public void updateDate(final int columnIndex, final Date x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateDate()"
        );
    }

    @Override
    public void updateTime(final int columnIndex, final Time x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateTime()"
        );
    }

    @Override
    public void updateTimestamp(final int columnIndex, final Timestamp x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateTimestamp()"
        );
    }

    @Override
    public void updateAsciiStream(
        final int columnIndex, final InputStream x, final int length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(
        final int columnIndex, final InputStream x, final int length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(
        final int columnIndex, final Reader x, final int length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateObject(
        final int columnIndex, final Object x, final int scaleOrLength
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void updateObject(final int columnIndex, final Object x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void updateNull(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNull()"
        );
    }

    @Override
    public void updateBoolean(final String columnLabel, final boolean x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBoolean()"
        );
    }

    @Override
    public void updateByte(final String columnLabel, final byte x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateByte()"
        );
    }

    @Override
    public void updateShort(final String columnLabel, final short x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateShort()"
        );
    }

    @Override
    public void updateInt(final String columnLabel, final int x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateInt()"
        );
    }

    @Override
    public void updateLong(final String columnLabel, final long x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateLong()"
        );
    }

    @Override
    public void updateFloat(final String columnLabel, final float x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateFloat()"
        );
    }

    @Override
    public void updateDouble(final String columnLabel, final double x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateDouble()"
        );
    }

    @Override
    public void updateBigDecimal(final String columnLabel, final BigDecimal x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBigDecimal()"
        );
    }

    @Override
    public void updateString(final String columnLabel, final String x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateString()"
        );
    }

    @Override
    public void updateBytes(final String columnLabel, final byte[] x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBytes()"
        );
    }

    @Override
    public void updateDate(final String columnLabel, final Date x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateDate()"
        );
    }

    @Override
    public void updateTime(final String columnLabel, final Time x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateTime()"
        );
    }

    @Override
    public void updateTimestamp(final String columnLabel, final Timestamp x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateTimestamp()"
        );
    }

    @Override
    public void updateAsciiStream(
        final String columnLabel, final InputStream x, final int length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(
        final String columnLabel, final InputStream x, final int length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(
        final String columnLabel, final Reader reader, final int length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateObject(
        final String columnLabel, final Object x, final int scaleOrLength
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void updateObject(final String columnLabel, final Object x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateObject()"
        );
    }

    @Override
    public void insertRow() {
        throw new UnsupportedOperationException(
            "unsupported method #insertRow()"
        );
    }

    @Override
    public void updateRow() {
        throw new UnsupportedOperationException(
            "unsupported method #updateRow()"
        );
    }

    @Override
    public void deleteRow() {
        throw new UnsupportedOperationException(
            "unsupported method #deleteRow()"
        );
    }

    @Override
    public void refreshRow() {
        throw new UnsupportedOperationException(
            "unsupported method #refreshRow()"
        );
    }

    @Override
    public void cancelRowUpdates() {
        throw new UnsupportedOperationException(
            "unsupported method #cancelRowUpdates()"
        );
    }

    @Override
    public void moveToInsertRow() {
        throw new UnsupportedOperationException(
            "unsupported method #moveToInsertRow()"
        );
    }

    @Override
    public void moveToCurrentRow() {
        throw new UnsupportedOperationException(
            "unsupported method #moveToCurrentRow()"
        );
    }

    @Override
    public Statement getStatement() {
        throw new UnsupportedOperationException(
            "unsupported method #getStatement()"
        );
    }

    @Override
    public Object getObject(
        final int columnIndex, final Map<String, Class<?>> map
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public Ref getRef(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getRef()"
        );
    }

    @Override
    public Blob getBlob(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getBlob()"
        );
    }

    @Override
    public Clob getClob(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getClob()"
        );
    }

    @Override
    public Array getArray(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getArray()"
        );
    }

    @Override
    public Object getObject(
        final String columnLabel, final Map<String, Class<?>> map
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public Ref getRef(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getRef()"
        );
    }

    @Override
    public Blob getBlob(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getBlob()"
        );
    }

    @Override
    public Clob getClob(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getClob()"
        );
    }

    @Override
    public Array getArray(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getArray()"
        );
    }

    @Override
    public Date getDate(final int columnIndex, final Calendar cal) {
        throw new UnsupportedOperationException(
            "unsupported method #getDate()"
        );
    }

    @Override
    public Date getDate(final String columnLabel, final Calendar cal) {
        throw new UnsupportedOperationException(
            "unsupported method #getDate()"
        );
    }

    @Override
    public Time getTime(final int columnIndex, final Calendar cal) {
        throw new UnsupportedOperationException(
            "unsupported method #getTime()"
        );
    }

    @Override
    public Time getTime(final String columnLabel, final Calendar cal) {
        throw new UnsupportedOperationException(
            "unsupported method #getTime()"
        );
    }

    @Override
    public Timestamp getTimestamp(final int columnIndex, final Calendar cal) {
        throw new UnsupportedOperationException(
            "unsupported method #getTimestamp()"
        );
    }

    @Override
    public Timestamp getTimestamp(
        final String columnLabel, final Calendar cal
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #getTimestamp()"
        );
    }

    @Override
    public URL getURL(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getURL()"
        );
    }

    @Override
    public URL getURL(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getURL()"
        );
    }

    @Override
    public void updateRef(final int columnIndex, final Ref x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateRef()"
        );
    }

    @Override
    public void updateRef(final String columnLabel, final Ref x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateRef()"
        );
    }

    @Override
    public void updateBlob(final int columnIndex, final Blob x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateBlob(final String columnLabel, final Blob x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateClob(final int columnIndex, final Clob x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateClob(final String columnLabel, final Clob x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateArray(final int columnIndex, final Array x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateArray()"
        );
    }

    @Override
    public void updateArray(final String columnLabel, final Array x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateArray()"
        );
    }

    @Override
    public RowId getRowId(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getRowId()"
        );
    }

    @Override
    public RowId getRowId(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getRowId()"
        );
    }

    @Override
    public void updateRowId(final int columnIndex, final RowId x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateRowId()"
        );
    }

    @Override
    public void updateRowId(final String columnLabel, final RowId x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateRowId()"
        );
    }

    @Override
    public int getHoldability() {
        throw new UnsupportedOperationException(
            "unsupported method #getHoldability()"
        );
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException(
            "unsupported method #isClosed()"
        );
    }

    @Override
    public void updateNString(final int columnIndex, final String nString) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNString()"
        );
    }

    @Override
    public void updateNString(final String columnLabel, final String nString) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNString()"
        );
    }

    @Override
    public void updateNClob(final int columnIndex, final NClob nClob) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNClob(final String columnLabel, final NClob nClob) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public NClob getNClob(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getNClob()"
        );
    }

    @Override
    public NClob getNClob(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getNClob()"
        );
    }

    @Override
    public SQLXML getSQLXML(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getSQLXML()"
        );
    }

    @Override
    public SQLXML getSQLXML(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getSQLXML()"
        );
    }

    @Override
    public void updateSQLXML(final int columnIndex, final SQLXML xmlObject) {
        throw new UnsupportedOperationException(
            "unsupported method #updateSQLXML()"
        );
    }

    @Override
    public void updateSQLXML(final String columnLabel, final SQLXML xmlObject) {
        throw new UnsupportedOperationException(
            "unsupported method #updateSQLXML()"
        );
    }

    @Override
    public String getNString(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getNString()"
        );
    }

    @Override
    public String getNString(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getNString()"
        );
    }

    @Override
    public Reader getNCharacterStream(final int columnIndex) {
        throw new UnsupportedOperationException(
            "unsupported method #getNCharacterStream()"
        );
    }

    @Override
    public Reader getNCharacterStream(final String columnLabel) {
        throw new UnsupportedOperationException(
            "unsupported method #getNCharacterStream()"
        );
    }

    @Override
    public void updateNCharacterStream(
        final int columnIndex, final Reader x, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateNCharacterStream(
        final String columnLabel, final Reader reader, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(
        final int columnIndex, final InputStream x, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(
        final int columnIndex, final InputStream x, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(
        final int columnIndex, final Reader x, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(
        final String columnLabel, final InputStream x, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(
        final String columnLabel, final InputStream x, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(
        final String columnLabel, final Reader reader, final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateBlob(
        final int columnIndex,
        final InputStream inputStream,
        final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateBlob(
        final String columnLabel,
        final InputStream inputStream,
        final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateClob(
        final int columnIndex,
        final Reader reader,
        final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateClob(
        final String columnLabel,
        final Reader reader,
        final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateNClob(
        final int columnIndex,
        final Reader reader,
        final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNClob(
        final String columnLabel,
        final Reader reader,
        final long length
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateNCharacterStream(
        final String columnLabel,
        final Reader reader
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x) {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateAsciiStream(
        final String columnLabel,
        final InputStream x
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateAsciiStream()"
        );
    }

    @Override
    public void updateBinaryStream(
        final String columnLabel,
        final InputStream x
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBinaryStream()"
        );
    }

    @Override
    public void updateCharacterStream(
        final String columnLabel,
        final Reader reader
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateCharacterStream()"
        );
    }

    @Override
    public void updateBlob(
        final int columnIndex,
        final InputStream inputStream
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateBlob(
        final String columnLabel,
        final InputStream inputStream
    ) {
        throw new UnsupportedOperationException(
            "unsupported method #updateBlob()"
        );
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader) {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateClob(final String columnLabel, final Reader reader) {
        throw new UnsupportedOperationException(
            "unsupported method #updateClob()"
        );
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public void updateNClob(final String columnLabel, final Reader reader) {
        throw new UnsupportedOperationException(
            "unsupported method #updateNClob()"
        );
    }

    @Override
    public <T> T getObject(final int columnIndex, final Class<T> type) {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public <T> T getObject(final String columnLabel, final Class<T> type) {
        throw new UnsupportedOperationException(
            "unsupported method #getObject()"
        );
    }

    @Override
    public <T> T unwrap(final Class<T> iface) {
        throw new UnsupportedOperationException(
            "unsupported method #unwrap()"
        );
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface) {
        throw new UnsupportedOperationException(
            "unsupported method #isWrapperFor()"
        );
    }

}
