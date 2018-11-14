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

package com.github.smallcreep.cucumber.seeds.table;

import com.github.smallcreep.cucumber.seeds.DataBase;
import com.github.smallcreep.cucumber.seeds.Table;
import com.github.smallcreep.cucumber.seeds.outcome.OutcomeIds;
import com.github.smallcreep.cucumber.seeds.sql.InsertSql;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.cactoos.Text;
import org.cactoos.text.FormattedText;

/**
 * Simple implementation table.
 * @since 0.2.0
 */
public final class TableSimple implements Table {

    /**
     * Table name.
     */
    private final Text name;

    /**
     * Database.
     */
    private final DataBase base;

    /**
     * Ctor.
     * @param schema Database schema
     * @param name Table name
     * @param base Database
     */
    public TableSimple(
        final String schema,
        final String name,
        final DataBase base
    ) {
        this(new FormattedText("%s.%s", schema, name), base);
    }

    /**
     * Ctor.
     * @param name Table name
     * @param base Database
     */
    public TableSimple(final Text name, final DataBase base) {
        this.name = name;
        this.base = base;
    }

    @Override
    public String value() throws Exception {
        return this.name.asString();
    }

    @Override
    public Collection<Long> insert(final Iterable<Map<String, String>> rows)
        throws Exception {
        final List<String> heads = new LinkedList<>();
        rows.forEach(
            row -> row.keySet().forEach(
                column -> {
                    if (!heads.contains(column)) {
                        heads.add(column);
                    }
                }
            )
        );
        return this.base.update(
            new InsertSql(
                heads,
                rows,
                this.value()
            ),
            new OutcomeIds()
        );
    }
}
