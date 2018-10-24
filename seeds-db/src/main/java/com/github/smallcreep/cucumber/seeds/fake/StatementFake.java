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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * Fake Statement throws {@link UnsupportedOperationException} for all methods.
 * @since 0.2.0
 * @checkstyle DesignForExtensionCheck (1000 lines)
 * @checkstyle ParameterNameCheck (1000 lines)
 */
@SuppressWarnings(
    {
        "PMD.AvoidDuplicateLiterals",
        "PMD.TooManyMethods"
    }
)
public abstract class StatementFake implements Statement {

    @Override
    public ResultSet executeQuery(final String sql) {
        throw new UnsupportedOperationException(
            "unsupported method #executeQuery()"
        );
    }

    @Override
    public int executeUpdate(final String sql) {
        throw new UnsupportedOperationException(
            "unsupported method #executeUpdate()"
        );
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException(
            "unsupported method #close()"
        );
    }

    @Override
    public int getMaxFieldSize() {
        throw new UnsupportedOperationException(
            "unsupported method #getMaxFieldSize()"
        );
    }

    @Override
    public void setMaxFieldSize(final int max) {
        throw new UnsupportedOperationException(
            "unsupported method #setMaxFieldSize()"
        );
    }

    @Override
    public int getMaxRows() {
        throw new UnsupportedOperationException(
            "unsupported method #getMaxRows()"
        );
    }

    @Override
    public void setMaxRows(final int max) {
        throw new UnsupportedOperationException(
            "unsupported method #setMaxRows()"
        );
    }

    @Override
    public void setEscapeProcessing(final boolean enable) {
        throw new UnsupportedOperationException(
            "unsupported method #setEscapeProcessing()"
        );
    }

    @Override
    public int getQueryTimeout() {
        throw new UnsupportedOperationException(
            "unsupported method #getQueryTimeout()"
        );
    }

    @Override
    public void setQueryTimeout(final int seconds) {
        throw new UnsupportedOperationException(
            "unsupported method #setQueryTimeout()"
        );
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException(
            "unsupported method #cancel()"
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
    public void setCursorName(final String name) {
        throw new UnsupportedOperationException(
            "unsupported method #setCursorName()"
        );
    }

    @Override
    public boolean execute(final String sql) {
        throw new UnsupportedOperationException(
            "unsupported method #execute()"
        );
    }

    @Override
    public ResultSet getResultSet() {
        throw new UnsupportedOperationException(
            "unsupported method #getResultSet()"
        );
    }

    @Override
    public int getUpdateCount() {
        throw new UnsupportedOperationException(
            "unsupported method #getUpdateCount()"
        );
    }

    @Override
    public boolean getMoreResults() {
        throw new UnsupportedOperationException(
            "unsupported method #getMoreResults()"
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
    public int getResultSetConcurrency() {
        throw new UnsupportedOperationException(
            "unsupported method #getResultSetConcurrency()"
        );
    }

    @Override
    public int getResultSetType() {
        throw new UnsupportedOperationException(
            "unsupported method #getResultSetType()"
        );
    }

    @Override
    public void addBatch(final String sql) {
        throw new UnsupportedOperationException(
            "unsupported method #addBatch()"
        );
    }

    @Override
    public void clearBatch() {
        throw new UnsupportedOperationException(
            "unsupported method #clearBatch()"
        );
    }

    @Override
    public int[] executeBatch() {
        throw new UnsupportedOperationException(
            "unsupported method #executeBatch()"
        );
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException(
            "unsupported method #getConnection()"
        );
    }

    @Override
    public boolean getMoreResults(final int current) {
        throw new UnsupportedOperationException(
            "unsupported method #getMoreResults()"
        );
    }

    @Override
    public ResultSet getGeneratedKeys() {
        throw new UnsupportedOperationException(
            "unsupported method #getGeneratedKeys()"
        );
    }

    @Override
    public int executeUpdate(final String sql, final int autoGeneratedKeys) {
        throw new UnsupportedOperationException(
            "unsupported method #executeUpdate()"
        );
    }

    @Override
    public int executeUpdate(final String sql, final int[] columnIndexes) {
        throw new UnsupportedOperationException(
            "unsupported method #executeUpdate()"
        );
    }

    @Override
    public int executeUpdate(final String sql, final String[] columnNames) {
        throw new UnsupportedOperationException(
            "unsupported method #executeUpdate()"
        );
    }

    @Override
    public boolean execute(final String sql, final int autoGeneratedKeys) {
        throw new UnsupportedOperationException(
            "unsupported method #execute()"
        );
    }

    @Override
    public boolean execute(final String sql, final int[] columnIndexes) {
        throw new UnsupportedOperationException(
            "unsupported method #execute()"
        );
    }

    @Override
    public boolean execute(final String sql, final String[] columnNames) {
        throw new UnsupportedOperationException(
            "unsupported method #execute()"
        );
    }

    @Override
    public int getResultSetHoldability() {
        throw new UnsupportedOperationException(
            "unsupported method #getResultSetHoldability()"
        );
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException(
            "unsupported method #isClosed()"
        );
    }

    @Override
    public void setPoolable(final boolean poolable) {
        throw new UnsupportedOperationException(
            "unsupported method #setPoolable()"
        );
    }

    @Override
    public boolean isPoolable() {
        throw new UnsupportedOperationException(
            "unsupported method #isPoolable()"
        );
    }

    @Override
    public void closeOnCompletion() {
        throw new UnsupportedOperationException(
            "unsupported method #closeOnCompletion()"
        );
    }

    @Override
    public boolean isCloseOnCompletion() {
        throw new UnsupportedOperationException(
            "unsupported method #isCloseOnCompletion()"
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
