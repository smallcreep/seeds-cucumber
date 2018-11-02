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

package com.github.smallcreep.cucumber.seeds.rows;

import com.github.smallcreep.cucumber.seeds.Rows;
import com.github.smallcreep.cucumber.seeds.Table;
import com.github.smallcreep.cucumber.seeds.generator.Surrogate;
import com.github.smallcreep.cucumber.seeds.generator.surrogate.SurrogateSimple;
import java.util.Map;
import org.cactoos.iterable.Mapped;

/**
 * Default implementation {@link Rows}.
 * @since 0.2.0
 */
public final class RwDefault implements Rows {

    /**
     * Database Table.
     */
    private final Table table;

    /**
     * Rows.
     */
    private final Iterable<Map<String, String>> rows;

    /**
     * Surrogate.
     */
    private final Surrogate surrogate;

    /**
     * Ctor.
     * @param table Database Table
     * @param rows Rows
     */
    public RwDefault(
        final Table table,
        final Iterable<Map<String, String>> rows
    ) {
        this(table, rows, new SurrogateSimple());
    }

    /**
     * Ctor.
     * @param table Database Table
     * @param rows Rows
     * @param surrogate Surrogate
     */
    RwDefault(
        final Table table,
        final Iterable<Map<String, String>> rows,
        final Surrogate surrogate
    ) {
        this.table = table;
        this.rows = rows;
        this.surrogate = surrogate;
    }

    @Override
    public void add() throws Exception {
        this.table.insert(
            new Mapped<>(
                this.surrogate,
                this.rows
            )
        );
    }
}
