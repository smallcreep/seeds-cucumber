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

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test Case for {@link StatementFake}.
 * @checkstyle JavadocMethodCheck (1500 lines)
 * @since 0.2.0
 */
@SuppressWarnings(
    {
        "PMD.AvoidDuplicateLiterals",
        "PMD.ExcessivePublicCount",
        "PMD.TooManyMethods"
    }
)
public final class StatementFakeTest {

    /**
     * A rule for handling an exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void executeQuery() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #executeQuery()");
        new StatementFake() {
        }.executeQuery("1");
    }

    @Test
    public void executeUpdate() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #executeUpdate()");
        new StatementFake() {
        }.executeUpdate("1");
    }

    @Test
    public void close() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #close()");
        new StatementFake() {
        }.close();
    }

    @Test
    public void getMaxFieldSize() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getMaxFieldSize()");
        new StatementFake() {
        }.getMaxFieldSize();
    }

    @Test
    public void setMaxFieldSize() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setMaxFieldSize()");
        new StatementFake() {
        }.setMaxFieldSize(1);
    }

    @Test
    public void getMaxRows() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getMaxRows()");
        new StatementFake() {
        }.getMaxRows();
    }

    @Test
    public void setMaxRows() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setMaxRows()");
        new StatementFake() {
        }.setMaxRows(1);
    }

    @Test
    public void setEscapeProcessing() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #setEscapeProcessing()"
        );
        new StatementFake() {
        }.setEscapeProcessing(true);
    }

    @Test
    public void getQueryTimeout() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getQueryTimeout()");
        new StatementFake() {
        }.getQueryTimeout();
    }

    @Test
    public void setQueryTimeout() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setQueryTimeout()");
        new StatementFake() {
        }.setQueryTimeout(1);
    }

    @Test
    public void cancel() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #cancel()");
        new StatementFake() {
        }.cancel();
    }

    @Test
    public void getWarnings() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getWarnings()");
        new StatementFake() {
        }.getWarnings();
    }

    @Test
    public void clearWarnings() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #clearWarnings()");
        new StatementFake() {
        }.clearWarnings();
    }

    @Test
    public void setCursorName() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setCursorName()");
        new StatementFake() {
        }.setCursorName("1");
    }

    @Test
    public void execute() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #execute()");
        new StatementFake() {
        }.execute("1");
    }

    @Test
    public void getResultSet() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getResultSet()");
        new StatementFake() {
        }.getResultSet();
    }

    @Test
    public void getUpdateCount() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getUpdateCount()");
        new StatementFake() {
        }.getUpdateCount();
    }

    @Test
    public void getMoreResults() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getMoreResults()");
        new StatementFake() {
        }.getMoreResults();
    }

    @Test
    public void setFetchDirection() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setFetchDirection()");
        new StatementFake() {
        }.setFetchDirection(1);
    }

    @Test
    public void getFetchDirection() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getFetchDirection()");
        new StatementFake() {
        }.getFetchDirection();
    }

    @Test
    public void setFetchSize() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setFetchSize()");
        new StatementFake() {
        }.setFetchSize(1);
    }

    @Test
    public void getFetchSize() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getFetchSize()");
        new StatementFake() {
        }.getFetchSize();
    }

    @Test
    public void getResultSetConcurrency() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #getResultSetConcurrency()"
        );
        new StatementFake() {
        }.getResultSetConcurrency();
    }

    @Test
    public void getResultSetType() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getResultSetType()");
        new StatementFake() {
        }.getResultSetType();
    }

    @Test
    public void addBatch() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #addBatch()");
        new StatementFake() {
        }.addBatch("1");
    }

    @Test
    public void clearBatch() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #clearBatch()");
        new StatementFake() {
        }.clearBatch();
    }

    @Test
    public void executeBatch() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #executeBatch()");
        new StatementFake() {
        }.executeBatch();
    }

    @Test
    public void getConnection() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getConnection()");
        new StatementFake() {
        }.getConnection();
    }

    @Test
    public void getMoreResultsWithCurrent() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getMoreResults()");
        new StatementFake() {
        }.getMoreResults(1);
    }

    @Test
    public void getGeneratedKeys() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #getGeneratedKeys()");
        new StatementFake() {
        }.getGeneratedKeys();
    }

    @Test
    public void executeUpdateWithAutoGeneratedKeys() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #executeUpdate()");
        new StatementFake() {
        }.executeUpdate("1", 1);
    }

    @Test
    public void executeUpdateWithColumnIndexes() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #executeUpdate()");
        new StatementFake() {
        }.executeUpdate("1", new int[] {});
    }

    @Test
    public void executeUpdateWithColumnNames() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #executeUpdate()");
        new StatementFake() {
        }.executeUpdate("1", new String[] {});
    }

    @Test
    public void executeWithAutoGeneratedKeys() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #execute()");
        new StatementFake() {
        }.execute("1", 1);
    }

    @Test
    public void executeWithColumnIndexes() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #execute()");
        new StatementFake() {
        }.execute("1", new int[] {});
    }

    @Test
    public void executeWithColumnNames() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #execute()");
        new StatementFake() {
        }.execute("1", new String[] {});
    }

    @Test
    public void getResultSetHoldability() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #getResultSetHoldability()"
        );
        new StatementFake() {
        }.getResultSetHoldability();
    }

    @Test
    public void isClosed() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isClosed()");
        new StatementFake() {
        }.isClosed();
    }

    @Test
    public void setPoolable() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #setPoolable()");
        new StatementFake() {
        }.setPoolable(true);
    }

    @Test
    public void isPoolable() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isPoolable()");
        new StatementFake() {
        }.isPoolable();
    }

    @Test
    public void closeOnCompletion() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #closeOnCompletion()");
        new StatementFake() {
        }.closeOnCompletion();
    }

    @Test
    public void isCloseOnCompletion() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "unsupported method #isCloseOnCompletion()"
        );
        new StatementFake() {
        }.isCloseOnCompletion();
    }

    @Test
    public void unwrap() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #unwrap()");
        new StatementFake() {
        }.unwrap(Object.class);
    }

    @Test
    public void isWrapperFor() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("unsupported method #isWrapperFor()");
        new StatementFake() {
        }.isWrapperFor(Object.class);
    }
}
