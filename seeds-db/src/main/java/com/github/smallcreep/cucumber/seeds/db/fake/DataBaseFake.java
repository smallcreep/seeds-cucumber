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
import com.github.smallcreep.cucumber.seeds.Schema;
import com.github.smallcreep.cucumber.seeds.Sql;
import com.jcabi.jdbc.Outcome;

/**
 * Fake Database, unsupported all methods.
 * @since 0.2.0
 */
public abstract class DataBaseFake implements DataBase {

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    public void connect() {
        throw new UnsupportedOperationException(
            "Unsupported #connect() in this fake."
        );
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    public <T> T result(final Sql sql, final Outcome<T> outcome)
        throws Exception {
        throw new UnsupportedOperationException(
            "Unsupported #result() in this fake."
        );
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    public <T> T update(final Sql sql, final Outcome<T> outcome)
        throws Exception {
        throw new UnsupportedOperationException(
            "Unsupported #update() in this fake."
        );
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    public Schema schema(final String schema) {
        throw new UnsupportedOperationException(
            "Unsupported #schema() in this fake."
        );
    }
}
