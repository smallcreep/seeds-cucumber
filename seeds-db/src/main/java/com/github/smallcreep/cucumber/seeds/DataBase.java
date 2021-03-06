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

package com.github.smallcreep.cucumber.seeds;

import com.jcabi.jdbc.Outcome;

/**
 * Connection to te DataBase.
 * @since 0.1.1
 */
public interface DataBase {

    /**
     * Check connection to the DataBase.
     * @throws Exception If any error of connection
     */
    void connect() throws Exception;

    /**
     * Execute SQL query.
     *
     * @param sql Sql query
     * @param outcome The outcome of the operation
     * @param <T> Type of response
     * @return The result
     * @throws Exception If fails
     */
    <T> T result(Sql sql, Outcome<T> outcome) throws Exception;

    /**
     * Execute SQL query update/insert.
     *
     * @param sql Sql query
     * @param outcome The outcome of the operation
     * @param <T> Type of response
     * @return The result
     * @throws Exception If fails
     */
    <T> T update(Sql sql, Outcome<T> outcome) throws Exception;

    /**
     * Get schema by name.
     * @param schema Schema name
     * @return Schema
     * @throws Exception If fails
     */
    Schema schema(String schema) throws Exception;
}
