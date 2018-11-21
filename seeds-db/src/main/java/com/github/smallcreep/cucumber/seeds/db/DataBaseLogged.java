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

package com.github.smallcreep.cucumber.seeds.db;

import com.github.smallcreep.cucumber.seeds.DataBase;
import com.github.smallcreep.cucumber.seeds.Schema;
import com.github.smallcreep.cucumber.seeds.Sql;
import com.github.smallcreep.cucumber.seeds.sql.SqlSticky;
import com.jcabi.jdbc.Outcome;
import com.jcabi.log.Logger;

/**
 * Logged Database.
 * @since 0.2.1
 */
public final class DataBaseLogged implements DataBase {

    /**
     * Origin database.
     */
    private final DataBase base;

    /**
     * Ctor.
     * @param base Origin database
     */
    public DataBaseLogged(final DataBase base) {
        this.base = base;
    }

    @Override
    public void connect() throws Exception {
        this.base.connect();
    }

    @Override
    public <T> T result(final Sql sql, final Outcome<T> outcome)
        throws Exception {
        return this.base.result(this.logged(sql), outcome);
    }

    @Override
    public <T> T update(final Sql sql, final Outcome<T> outcome)
        throws Exception {
        return this.base.update(this.logged(sql), outcome);
    }

    @Override
    public Schema schema(final String schema) throws Exception {
        return this.base.schema(schema);
    }

    /**
     * Logging sql, and return cached sql.
     * @param sql Sql
     * @return Cached sql
     * @throws Exception If fails
     */
    private Sql logged(final Sql sql) throws Exception {
        final Sql cached = new SqlSticky(sql);
        Logger.info(this, "EXECUTE SQL: %s", cached.query());
        return cached;
    }
}
