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

package com.github.smallcreep.cucumber.seeds.sql;

import com.github.smallcreep.cucumber.seeds.Sql;
import java.util.Map;
import org.cactoos.iterable.Mapped;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.cactoos.text.UncheckedText;

/**
 * Insert Sql.
 * @since 0.2.0
 */
public final class InsertSql implements Sql {

    /**
     * Columns heads.
     */
    private final Iterable<String> heads;

    /**
     * Insert Rows.
     */
    private final Iterable<Map<String, String>> rows;

    /**
     * Table name.
     */
    private final String table;

    /**
     * Ctor.
     * @param heads Columns heads
     * @param rows Insert Rows
     * @param table Table nameTable namev
     */
    public InsertSql(
        final Iterable<String> heads,
        final Iterable<Map<String, String>> rows,
        final String table
    ) {
        this.heads = heads;
        this.rows = rows;
        this.table = table;
    }

    @Override
    public String query() throws Exception {
        return new FormattedText(
            "INSERT INTO %s (%s) VALUES %s",
            this.table,
            new JoinedText(
                ", ",
                this.heads
            ).asString(),
            new JoinedText(
                ", ",
                new Mapped<>(
                    row -> new UncheckedText(
                        new FormattedText(
                            "(%s)",
                            new JoinedText(
                                ", ",
                                new Mapped<>(
                                    head -> row.getOrDefault(
                                        head,
                                        "null"
                                    ),
                                    this.heads
                                )
                            )
                        )
                    ).asString(),
                    this.rows
                )
            ).asString()
        ).asString();
    }
}
