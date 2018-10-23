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

package com.github.smallcreep.cucumber.seeds.db.fake;

import com.github.smallcreep.cucumber.seeds.DataBase;
import com.github.smallcreep.cucumber.seeds.Sql;
import com.github.smallcreep.cucumber.seeds.Table;
import com.jcabi.jdbc.Outcome;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Fake method update in database.
 * @since 0.2.0
 */
public final class DataBaseUpdateFake implements DataBase {

    private final ResultSet res;
    private final Statement statement;

    public DataBaseUpdateFake(final ResultSet res, final Statement statement) {
        this.res = res;
        this.statement = statement;
    }

    @Override
    public void connect() throws Exception {
        throw new UnsupportedOperationException(
            "Unsoported #connect() in this fake."
        );
    }

    @Override
    public <T> T result(final Sql sql, final Outcome<T> outcome) throws Exception {
        throw new UnsupportedOperationException(
            "Unsoported #result() in this fake."
        );
    }

    @Override
    public <E> E update(final Sql sql, final Outcome<E> outcome) throws Exception {
        return outcome.handle(
            this.res,
            this.statement
        );
    }

    @Override
    public Table table(final String name) {
        throw new UnsupportedOperationException(
            "Unsoported #table(String) in this fake."
        );
    }

    @Override
    public Table table(final String schema, final String name) {
        throw new UnsupportedOperationException(
            "Unsoported #table(String, String) in this fake."
        );
    }
}
