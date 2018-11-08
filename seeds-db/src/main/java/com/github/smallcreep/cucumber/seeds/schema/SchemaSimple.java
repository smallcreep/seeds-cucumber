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

package com.github.smallcreep.cucumber.seeds.schema;

import com.github.smallcreep.cucumber.seeds.DataBase;
import com.github.smallcreep.cucumber.seeds.Schema;
import com.github.smallcreep.cucumber.seeds.Table;
import com.github.smallcreep.cucumber.seeds.table.TableSimple;

/**
 * Simple implementation schema.
 * @since 0.2.0
 */
public final class SchemaSimple implements Schema {

    /**
     * Schema name.
     */
    private final String name;

    /**
     * DataBase.
     */
    private final DataBase base;

    /**
     * Ctor.
     * @param name Schema name
     * @param base DataBase
     */
    public SchemaSimple(final String name, final DataBase base) {
        this.name = name;
        this.base = base;
    }

    @Override
    public Table table(final String table) {
        return new TableSimple(this.name, table, this.base);
    }
}
