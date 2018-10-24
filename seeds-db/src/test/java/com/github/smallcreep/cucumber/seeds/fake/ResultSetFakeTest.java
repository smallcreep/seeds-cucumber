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
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import org.cactoos.io.InputStreamOf;
import org.cactoos.io.ReaderOf;
import org.cactoos.map.MapOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test Case for {@link ResultSetFake}.
 * @checkstyle JavadocTypeCheck (2000 lines)
 * @checkstyle JavadocMethodCheck (2000 lines)
 * @checkstyle AbbreviationAsWordInNameCheck (2000 lines)
 * @checkstyle MissingDeprecatedCheck (2000 lines)
 * @checkstyle ClassDataAbstractionCouplingCheck (2000 lines)
 * @checkstyle MethodCountCheck (2000 lines)
 * @checkstyle FileLengthCheck (2000 lines)
 * @since 0.2.0
 */
@SuppressWarnings(
    {
        "PMD.AvoidDuplicateLiterals",
        "PMD.ExcessivePublicCount",
        "PMD.ExcessiveClassLength",
        "PMD.TooManyMethods"
    }
)
public final class ResultSetFakeTest {

    /**
     * A rule for handling an exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void checkNextThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #next()");
        new ResultSetThrowsFake().next();
    }

    @Test
    public void checkCloseThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #close()");
        new ResultSetThrowsFake().close();
    }

    @Test
    public void checkWasNullThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #wasNull()");
        new ResultSetThrowsFake().wasNull();
    }

    @Test
    public void checkGetStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getString()");
        new ResultSetThrowsFake().getString(1);
    }

    @Test
    public void checkGetBooleanThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBoolean()");
        new ResultSetThrowsFake().getBoolean(1);
    }

    @Test
    public void checkGetByteThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getByte()");
        new ResultSetThrowsFake().getByte(1);
    }

    @Test
    public void checkGetShortThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getShort()");
        new ResultSetThrowsFake().getShort(1);
    }

    @Test
    public void checkGetIntThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getInt()");
        new ResultSetThrowsFake().getInt(1);
    }

    @Test
    public void checkGetLongThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getLong()");
        new ResultSetThrowsFake().getLong(1);
    }

    @Test
    public void checkGetFloatThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getFloat()");
        new ResultSetThrowsFake().getFloat(1);
    }

    @Test
    public void checkGetDoubleThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getDouble()");
        new ResultSetThrowsFake().getDouble(1);
    }

    @Deprecated
    @Test
    public void checkGetBigDecimalThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBigDecimal()");
        new ResultSetThrowsFake().getBigDecimal(1, 1);
    }

    @Test
    public void checkGetBytesThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBytes()");
        new ResultSetThrowsFake().getBytes(1);
    }

    @Test
    public void checkGetDateThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getDate()");
        new ResultSetThrowsFake().getDate(1);
    }

    @Test
    public void checkGetTimeThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTime()");
        new ResultSetThrowsFake().getTime(1);
    }

    @Test
    public void checkGetTimestampThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTimestamp()");
        new ResultSetThrowsFake().getTimestamp(1);
    }

    @Test
    public void checkGetAsciiStreamThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getAsciiStream()");
        new ResultSetThrowsFake().getAsciiStream(1);
    }

    @Deprecated
    @Test
    public void checkGetUnicodeStreamThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getUnicodeStream()");
        new ResultSetThrowsFake().getUnicodeStream(1);
    }

    @Test
    public void checkGetBinaryStreamThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBinaryStream()");
        new ResultSetThrowsFake().getBinaryStream(1);
    }

    @Test
    public void checkGetStringByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getString()");
        new ResultSetThrowsFake().getString("1");
    }

    @Test
    public void checkGetBooleanByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBoolean()");
        new ResultSetThrowsFake().getBoolean("1");
    }

    @Test
    public void checkGetByteByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getByte()");
        new ResultSetThrowsFake().getByte("1");
    }

    @Test
    public void checkGetShortByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getShort()");
        new ResultSetThrowsFake().getShort("1");
    }

    @Test
    public void checkGetIntByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getInt()");
        new ResultSetThrowsFake().getInt("1");
    }

    @Test
    public void checkGetLongByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getLong()");
        new ResultSetThrowsFake().getLong("1");
    }

    @Test
    public void checkGetFloatByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getFloat()");
        new ResultSetThrowsFake().getFloat("1");
    }

    @Test
    public void checkGetDoubleByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getDouble()");
        new ResultSetThrowsFake().getDouble("1");
    }

    @Deprecated
    @Test
    public void checkGetBigDecimalByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBigDecimal()");
        new ResultSetThrowsFake().getBigDecimal("1", 1);
    }

    @Test
    public void checkGetBytesByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBytes()");
        new ResultSetThrowsFake().getBytes("1");
    }

    @Test
    public void checkGetDateByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getDate()");
        new ResultSetThrowsFake().getDate("1");
    }

    @Test
    public void checkGetTimeByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTime()");
        new ResultSetThrowsFake().getTime("1");
    }

    @Test
    public void checkGetTimestampByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTimestamp()");
        new ResultSetThrowsFake().getTimestamp("1");
    }

    @Test
    public void checkGetAsciiStreamByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getAsciiStream()");
        new ResultSetThrowsFake().getAsciiStream("1");
    }

    @Deprecated
    @Test
    public void checkGetUnicodeStreamByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getUnicodeStream()");
        new ResultSetThrowsFake().getUnicodeStream("1");
    }

    @Test
    public void checkGetBinaryStreamByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBinaryStream()");
        new ResultSetThrowsFake().getBinaryStream("1");
    }

    @Test
    public void checkGetWarningsThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getWarnings()");
        new ResultSetThrowsFake().getWarnings();
    }

    @Test
    public void checkClearWarningsThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #clearWarnings()");
        new ResultSetThrowsFake().clearWarnings();
    }

    @Test
    public void checkGetCursorNameThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getCursorName()");
        new ResultSetThrowsFake().getCursorName();
    }

    @Test
    public void checkGetMetaDataThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getMetaData()");
        new ResultSetThrowsFake().getMetaData();
    }

    @Test
    public void checkGetObjectThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getObject()");
        new ResultSetThrowsFake().getObject(1);
    }

    @Test
    public void checkGetObjectByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getObject()");
        new ResultSetThrowsFake().getObject("1");
    }

    @Test
    public void checkFindColumnThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #findColumn()");
        new ResultSetThrowsFake().findColumn("1");
    }

    @Test
    public void checkGetCharacterStreamThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #getCharacterStream()"
        );
        new ResultSetThrowsFake().getCharacterStream(1);
    }

    @Test
    public void checkGetCharacterStreamByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #getCharacterStream()"
        );
        new ResultSetThrowsFake().getCharacterStream("1");
    }

    @Test
    public void checkGetBigDecimalWithoutScaleThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBigDecimal()");
        new ResultSetThrowsFake().getBigDecimal(1);
    }

    @Test
    public void checkGetBigDecimalWithoutScaleByStringThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBigDecimal()");
        new ResultSetThrowsFake().getBigDecimal("1");
    }

    @Test
    public void checkIsBeforeFirstThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isBeforeFirst()");
        new ResultSetThrowsFake().isBeforeFirst();
    }

    @Test
    public void checkIsAfterLastThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isAfterLast()");
        new ResultSetThrowsFake().isAfterLast();
    }

    @Test
    public void checkIsFirstThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isFirst()");
        new ResultSetThrowsFake().isFirst();
    }

    @Test
    public void checkIsLastThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isLast()");
        new ResultSetThrowsFake().isLast();
    }

    @Test
    public void checkBeforeFirstThrew() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #beforeFirst()");
        new ResultSetThrowsFake().beforeFirst();
    }

    @Test
    public void afterLast() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #afterLast()");
        new ResultSetThrowsFake().afterLast();
    }

    @Test
    public void first() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #first()");
        new ResultSetThrowsFake().first();
    }

    @Test
    public void last() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #last()");
        new ResultSetThrowsFake().last();
    }

    @Test
    public void getRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getRow()");
        new ResultSetThrowsFake().getRow();
    }

    @Test
    public void absolute() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #absolute()");
        new ResultSetThrowsFake().absolute(1);
    }

    @Test
    public void relative() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #relative()");
        new ResultSetThrowsFake().relative(1);
    }

    @Test
    public void previous() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #previous()");
        new ResultSetThrowsFake().previous();
    }

    @Test
    public void setFetchDirection() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setFetchDirection()");
        new ResultSetThrowsFake().setFetchDirection(ResultSet.FETCH_FORWARD);
    }

    @Test
    public void getFetchDirection() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getFetchDirection()");
        new ResultSetThrowsFake().getFetchDirection();
    }

    @Test
    public void setFetchSize() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setFetchSize()");
        new ResultSetThrowsFake().setFetchSize(1);
    }

    @Test
    public void getFetchSize() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getFetchSize()");
        new ResultSetThrowsFake().getFetchSize();
    }

    @Test
    public void getType() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getType()");
        new ResultSetThrowsFake().getType();
    }

    @Test
    public void getConcurrency() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getConcurrency()");
        new ResultSetThrowsFake().getConcurrency();
    }

    @Test
    public void rowUpdated() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #rowUpdated()");
        new ResultSetThrowsFake().rowUpdated();
    }

    @Test
    public void rowInserted() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #rowInserted()");
        new ResultSetThrowsFake().rowInserted();
    }

    @Test
    public void rowDeleted() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #rowDeleted()");
        new ResultSetThrowsFake().rowDeleted();
    }

    @Test
    public void updateNull() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNull()");
        new ResultSetThrowsFake().updateNull(1);
    }

    @Test
    public void updateBoolean() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBoolean()");
        new ResultSetThrowsFake().updateBoolean(1, true);
    }

    @Test
    public void updateByte() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateByte()");
        new ResultSetThrowsFake().updateByte(1, (byte) 1);
    }

    @Test
    public void updateShort() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateShort()");
        new ResultSetThrowsFake().updateShort(1, (short) 1);
    }

    @Test
    public void updateInt() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateInt()");
        new ResultSetThrowsFake().updateInt(1, 1);
    }

    @Test
    public void updateLong() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateLong()");
        new ResultSetThrowsFake().updateLong(1, 1L);
    }

    @Test
    public void updateFloat() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateFloat()");
        new ResultSetThrowsFake().updateFloat(1, 1f);
    }

    @Test
    public void updateDouble() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateDouble()");
        new ResultSetThrowsFake().updateDouble(1, 1d);
    }

    @Test
    public void updateBigDecimal() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBigDecimal()");
        new ResultSetThrowsFake().updateBigDecimal(1, BigDecimal.ONE);
    }

    @Test
    public void updateString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateString()");
        new ResultSetThrowsFake().updateString(1, "1");
    }

    @Test
    public void updateBytes() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBytes()");
        new ResultSetThrowsFake().updateBytes(1, new byte[] {});
    }

    @Test
    public void updateDate() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateDate()");
        new ResultSetThrowsFake().updateDate(1, new Date(1L));
    }

    @Test
    public void updateTime() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateTime()");
        new ResultSetThrowsFake().updateTime(1, new Time(1L));
    }

    @Test
    public void updateTimestamp() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateTimestamp()");
        new ResultSetThrowsFake().updateTimestamp(1, new Timestamp(1L));
    }

    @Test
    public void updateAsciiStream() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateAsciiStream()");
        new ResultSetThrowsFake().updateAsciiStream(
            1,
            new InputStreamOf(new byte[] {}),
            1
        );
    }

    @Test
    public void updateBinaryStream() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateBinaryStream()"
        );
        new ResultSetThrowsFake().updateBinaryStream(
            1,
            new InputStreamOf(new byte[] {}),
            1
        );
    }

    @Test
    public void updateCharacterStream() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateCharacterStream()"
        );
        new ResultSetThrowsFake().updateCharacterStream(1, new ReaderOf(), 1);
    }

    @Test
    public void updateObjectWithScale() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateObject()");
        new ResultSetThrowsFake().updateObject(1, new Object(), 1);
    }

    @Test
    public void updateObject() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateObject()");
        new ResultSetThrowsFake().updateObject(1, new Object());
    }

    @Test
    public void updateNullByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNull()");
        new ResultSetThrowsFake().updateNull("1");
    }

    @Test
    public void updateBooleanByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBoolean()");
        new ResultSetThrowsFake().updateBoolean("1", true);
    }

    @Test
    public void updateByteByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateByte()");
        new ResultSetThrowsFake().updateByte("1", (byte) 1);
    }

    @Test
    public void updateShortByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateShort()");
        new ResultSetThrowsFake().updateShort("1", (short) 1);
    }

    @Test
    public void updateIntByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateInt()");
        new ResultSetThrowsFake().updateInt("1", 1);
    }

    @Test
    public void updateLongByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateLong()");
        new ResultSetThrowsFake().updateLong("1", 1L);
    }

    @Test
    public void updateFloatByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateFloat()");
        new ResultSetThrowsFake().updateFloat("1", 1f);
    }

    @Test
    public void updateDoubleByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateDouble()");
        new ResultSetThrowsFake().updateDouble("1", 1d);
    }

    @Test
    public void updateBigDecimalByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBigDecimal()");
        new ResultSetThrowsFake().updateBigDecimal("1", BigDecimal.ONE);
    }

    @Test
    public void updateStringByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateString()");
        new ResultSetThrowsFake().updateString("1", "1");
    }

    @Test
    public void updateBytesByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBytes()");
        new ResultSetThrowsFake().updateBytes("1", new byte[] {});
    }

    @Test
    public void updateDateByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateDate()");
        new ResultSetThrowsFake().updateDate("1", new Date(1L));
    }

    @Test
    public void updateTimeByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateTime()");
        new ResultSetThrowsFake().updateTime("1", new Time(1L));
    }

    @Test
    public void updateTimestampByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateTimestamp()");
        new ResultSetThrowsFake().updateTimestamp("1", new Timestamp(1L));
    }

    @Test
    public void updateAsciiStreamByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateAsciiStream()");
        new ResultSetThrowsFake().updateAsciiStream(
            "1",
            new InputStreamOf(new byte[] {}),
            1
        );
    }

    @Test
    public void updateBinaryStreamByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateBinaryStream()"
        );
        new ResultSetThrowsFake().updateBinaryStream(
            "1",
            new InputStreamOf(new byte[] {}),
            1
        );
    }

    @Test
    public void updateCharacterStreamByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateCharacterStream()"
        );
        new ResultSetThrowsFake().updateCharacterStream("1", new ReaderOf(), 1);
    }

    @Test
    public void updateObjectWithScaleByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateObject()");
        new ResultSetThrowsFake().updateObject("1", new Object(), 1);
    }

    @Test
    public void updateObjectByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateObject()");
        new ResultSetThrowsFake().updateObject("1", new Object());
    }

    @Test
    public void insertRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #insertRow()");
        new ResultSetThrowsFake().insertRow();
    }

    @Test
    public void updateRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateRow()");
        new ResultSetThrowsFake().updateRow();
    }

    @Test
    public void deleteRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #deleteRow()");
        new ResultSetThrowsFake().deleteRow();
    }

    @Test
    public void refreshRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #refreshRow()");
        new ResultSetThrowsFake().refreshRow();
    }

    @Test
    public void cancelRowUpdates() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #cancelRowUpdates()");
        new ResultSetThrowsFake().cancelRowUpdates();
    }

    @Test
    public void moveToInsertRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #moveToInsertRow()");
        new ResultSetThrowsFake().moveToInsertRow();
    }

    @Test
    public void moveToCurrentRow() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #moveToCurrentRow()");
        new ResultSetThrowsFake().moveToCurrentRow();
    }

    @Test
    public void getStatement() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getStatement()");
        new ResultSetThrowsFake().getStatement();
    }

    @Test
    public void getObjectWithMap() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getObject()");
        new ResultSetThrowsFake().getObject(1, new MapOf<String, Class<?>>());
    }

    @Test
    public void getRef() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getRef()");
        new ResultSetThrowsFake().getRef(1);
    }

    @Test
    public void getBlob() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBlob()");
        new ResultSetThrowsFake().getBlob(1);
    }

    @Test
    public void getClob() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getClob()");
        new ResultSetThrowsFake().getClob(1);
    }

    @Test
    public void getArray() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getArray()");
        new ResultSetThrowsFake().getArray(1);
    }

    @Test
    public void getObjectWithMapByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getObject()");
        new ResultSetThrowsFake().getObject("1", new MapOf<String, Class<?>>());
    }

    @Test
    public void getRefByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getRef()");
        new ResultSetThrowsFake().getRef("1");
    }

    @Test
    public void getBlobByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getBlob()");
        new ResultSetThrowsFake().getBlob("1");
    }

    @Test
    public void getClobByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getClob()");
        new ResultSetThrowsFake().getClob("1");
    }

    @Test
    public void getArrayByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getArray()");
        new ResultSetThrowsFake().getArray("1");
    }

    @Test
    public void getDateWithCalendar() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getDate()");
        new ResultSetThrowsFake().getDate(1, new GregorianCalendar());
    }

    @Test
    public void getDateWithCalendarByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getDate()");
        new ResultSetThrowsFake().getDate("1", new GregorianCalendar());
    }

    @Test
    public void getTimeWithCalendar() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTime()");
        new ResultSetThrowsFake().getTime(1, new GregorianCalendar());
    }

    @Test
    public void getTimeWithCalendarByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTime()");
        new ResultSetThrowsFake().getTime("1", new GregorianCalendar());
    }

    @Test
    public void getTimestampWithCalendar() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTimestamp()");
        new ResultSetThrowsFake().getTimestamp(1, new GregorianCalendar());
    }

    @Test
    public void getTimestampWithCalendarByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getTimestamp()");
        new ResultSetThrowsFake().getTimestamp("1", new GregorianCalendar());
    }

    @Test
    public void getURL() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getURL()");
        new ResultSetThrowsFake().getURL(1);
    }

    @Test
    public void getURLByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getURL()");
        new ResultSetThrowsFake().getURL("1");
    }

    @Test
    public void updateRef() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateRef()");
        new ResultSetThrowsFake().updateRef(1, null);
    }

    @Test
    public void updateRefByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateRef()");
        new ResultSetThrowsFake().updateRef("1", null);
    }

    @Test
    public void updateBlob() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBlob()");
        new ResultSetThrowsFake().updateBlob(1, (Blob) null);
    }

    @Test
    public void updateBlobByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBlob()");
        new ResultSetThrowsFake().updateBlob("1", (Blob) null);
    }

    @Test
    public void updateClob() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateClob()");
        new ResultSetThrowsFake().updateClob(1, (Clob) null);
    }

    @Test
    public void updateClobByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateClob()");
        new ResultSetThrowsFake().updateClob("1", (Clob) null);
    }

    @Test
    public void updateArray() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateArray()");
        new ResultSetThrowsFake().updateArray(1, null);
    }

    @Test
    public void updateArrayByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateArray()");
        new ResultSetThrowsFake().updateArray("1", null);
    }

    @Test
    public void getRowId() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getRowId()");
        new ResultSetThrowsFake().getRowId(1);
    }

    @Test
    public void getRowIdByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getRowId()");
        new ResultSetThrowsFake().getRowId("1");
    }

    @Test
    public void updateRowId() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateRowId()");
        new ResultSetThrowsFake().updateRowId(1, null);
    }

    @Test
    public void updateRowIdByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateRowId()");
        new ResultSetThrowsFake().updateRowId("1", null);
    }

    @Test
    public void getHoldability() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getHoldability()");
        new ResultSetThrowsFake().getHoldability();
    }

    @Test
    public void isClosed() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isClosed()");
        new ResultSetThrowsFake().isClosed();
    }

    @Test
    public void updateNString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNString()");
        new ResultSetThrowsFake().updateNString(1, "1");
    }

    @Test
    public void updateNStringByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNString()");
        new ResultSetThrowsFake().updateNString("1", "1");
    }

    @Test
    public void updateNClob() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNClob()");
        new ResultSetThrowsFake().updateNClob(1, (NClob) null);
    }

    @Test
    public void updateNClobByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNClob()");
        new ResultSetThrowsFake().updateNClob("1", (NClob) null);
    }

    @Test
    public void getNClob() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getNClob()");
        new ResultSetThrowsFake().getNClob(1);
    }

    @Test
    public void getNClobByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getNClob()");
        new ResultSetThrowsFake().getNClob("1");
    }

    @Test
    public void getSQLXML() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getSQLXML()");
        new ResultSetThrowsFake().getSQLXML(1);
    }

    @Test
    public void getSQLXMLByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getSQLXML()");
        new ResultSetThrowsFake().getSQLXML("1");
    }

    @Test
    public void updateSQLXML() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateSQLXML()");
        new ResultSetThrowsFake().updateSQLXML(1, null);
    }

    @Test
    public void updateSQLXMLByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateSQLXML()");
        new ResultSetThrowsFake().updateSQLXML("1", null);
    }

    @Test
    public void getNString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getNString()");
        new ResultSetThrowsFake().getNString(1);
    }

    @Test
    public void getNStringByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getNString()");
        new ResultSetThrowsFake().getNString("1");
    }

    @Test
    public void getNCharacterStream() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #getNCharacterStream()"
        );
        new ResultSetThrowsFake().getNCharacterStream(1);
    }

    @Test
    public void getNCharacterStreamByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #getNCharacterStream()"
        );
        new ResultSetThrowsFake().getNCharacterStream("1");
    }

    @Test
    public void updateNCharacterStream() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateNCharacterStream()"
        );
        new ResultSetThrowsFake().updateNCharacterStream(1, null);
    }

    @Test
    public void updateNCharacterStreamByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateNCharacterStream()"
        );
        new ResultSetThrowsFake().updateNCharacterStream("1", null);
    }

    @Test
    public void updateAsciiStreamLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateAsciiStream()");
        new ResultSetThrowsFake().updateAsciiStream(1, null, 1L);
    }

    @Test
    public void updateBinaryStreamLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateBinaryStream()"
        );
        new ResultSetThrowsFake().updateBinaryStream(1, null, 1L);
    }

    @Test
    public void updateCharacterStreamLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateCharacterStream()"
        );
        new ResultSetThrowsFake().updateCharacterStream(1, null, 1L);
    }

    @Test
    public void updateAsciiStreamLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateAsciiStream()");
        new ResultSetThrowsFake().updateAsciiStream("1", null, 1L);
    }

    @Test
    public void updateBinaryStreamLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateBinaryStream()"
        );
        new ResultSetThrowsFake().updateBinaryStream("1", null, 1L);
    }

    @Test
    public void updateCharacterStreamLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateCharacterStream()"
        );
        new ResultSetThrowsFake().updateCharacterStream("1", null, 1L);
    }

    @Test
    public void updateBlobLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBlob()");
        new ResultSetThrowsFake().updateBlob(1, null, 1L);
    }

    @Test
    public void updateBlobLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBlob()");
        new ResultSetThrowsFake().updateBlob("1", null, 1L);
    }

    @Test
    public void updateClobLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateClob()");
        new ResultSetThrowsFake().updateClob(1, null, 1L);
    }

    @Test
    public void updateClobLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateClob()");
        new ResultSetThrowsFake().updateClob("1", null, 1L);
    }

    @Test
    public void updateNClobLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNClob()");
        new ResultSetThrowsFake().updateNClob(1, null, 1L);
    }

    @Test
    public void updateNClobLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNClob()");
        new ResultSetThrowsFake().updateNClob("1", null, 1L);
    }

    @Test
    public void updateNCharacterStreamLongLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateNCharacterStream()"
        );
        new ResultSetThrowsFake().updateNCharacterStream(1, null, 1L);
    }

    @Test
    public void updateNCharacterStreamLongLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateNCharacterStream()"
        );
        new ResultSetThrowsFake().updateNCharacterStream("1", null, 1L);
    }

    @Test
    public void updateAsciiStreamWithoutLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateAsciiStream()");
        new ResultSetThrowsFake().updateAsciiStream(1, null);
    }

    @Test
    public void updateBinaryStreamWithoutLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateBinaryStream()"
        );
        new ResultSetThrowsFake().updateBinaryStream(1, null);
    }

    @Test
    public void updateCharacterStreamWithoutLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateCharacterStream()"
        );
        new ResultSetThrowsFake().updateCharacterStream(1, null);
    }

    @Test
    public void updateAsciiStreamWithoutLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateAsciiStream()");
        new ResultSetThrowsFake().updateAsciiStream("1", null);
    }

    @Test
    public void updateBinaryStreamWithoutLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateBinaryStream()"
        );
        new ResultSetThrowsFake().updateBinaryStream("1", null);
    }

    @Test
    public void updateCharacterStreamWithoutLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #updateCharacterStream()"
        );
        new ResultSetThrowsFake().updateCharacterStream("1", null);
    }

    @Test
    public void updateBlobWithoutLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBlob()");
        new ResultSetThrowsFake().updateBlob(1, (InputStream) null);
    }

    @Test
    public void updateBlobWithoutLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateBlob()");
        new ResultSetThrowsFake().updateBlob("1", (InputStream) null);
    }

    @Test
    public void updateClobWithoutLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateClob()");
        new ResultSetThrowsFake().updateClob(1, (Reader) null);
    }

    @Test
    public void updateClobWithoutLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateClob()");
        new ResultSetThrowsFake().updateClob("1", (Reader) null);
    }

    @Test
    public void updateNClobWithoutLength() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNClob()");
        new ResultSetThrowsFake().updateNClob(1, (Reader) null);
    }

    @Test
    public void updateNClobWithoutLengthByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #updateNClob()");
        new ResultSetThrowsFake().updateNClob("1", (Reader) null);
    }

    @Test
    public void getObjectWithClass() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getObject()");
        new ResultSetThrowsFake().getObject(1, Object.class);
    }

    @Test
    public void getObjectWithClassByString() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getObject()");
        new ResultSetThrowsFake().getObject("1", Object.class);
    }

    @Test
    public void unwrap() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #unwrap()");
        new ResultSetThrowsFake().unwrap(Object.class);
    }

    @Test
    public void isWrapperFor() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isWrapperFor()");
        new ResultSetThrowsFake().isWrapperFor(Object.class);
    }

    private class ResultSetThrowsFake extends ResultSetFake {

    }
}
