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

import com.github.smallcreep.cucumber.seeds.Context;
import com.github.smallcreep.cucumber.seeds.DataBases;
import com.github.smallcreep.cucumber.seeds.Rows;
import com.github.smallcreep.cucumber.seeds.Table;
import com.github.smallcreep.cucumber.seeds.generator.Surrogate;
import com.github.smallcreep.cucumber.seeds.generator.surrogate.SurrogateSimple;
import com.github.smallcreep.cucumber.seeds.storage.StorageScenarioProperties;
import com.github.smallcreep.cucumber.seeds.storage.StorageWithoutIids;
import java.util.Map;
import org.cactoos.iterable.Mapped;
import org.cactoos.text.JoinedText;

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
     * Scenario context.
     */
    private final Context ctx;

    /**
     * Properties name in Storage.
     */
    private final String props;

    /**
     * Ctor.
     * @param rows Rows
     * @param context Scenario context
     * @param schema Database schema
     * @param table Database table
     * @throws Exception if fails
     * @checkstyle ParameterNumberCheck (6 lines)
     */
    public RwDefault(
        final Iterable<Map<String, String>> rows,
        final Context context,
        final String schema,
        final String table
    ) throws Exception {
        this(
            ((DataBases) context.value("databases"))
                .database()
                .schema(schema)
                .table(table),
            rows,
            new SurrogateSimple(),
            context,
            new JoinedText(
                ".",
                schema,
                table
            ).asString()
        );
    }

    /**
     * Ctor.
     * @param table Database Table
     * @param rows Rows
     * @param context Scenario context
     * @param props Properties name in Storage.
     * @throws Exception if fails
     * @checkstyle ParameterNumberCheck (6 lines)
     */
    public RwDefault(
        final Table table,
        final Iterable<Map<String, String>> rows,
        final Context context,
        final String props
    ) throws Exception {
        this(table, rows, new SurrogateSimple(), context, props);
    }

    /**
     * Ctor.
     * @param table Database Table
     * @param rows Rows
     * @param surrogate Surrogate
     * @param context Scenario context
     * @param props Properties name in Storage.
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    RwDefault(
        final Table table,
        final Iterable<Map<String, String>> rows,
        final Surrogate surrogate,
        final Context context,
        final String props
    ) {
        this.table = table;
        this.rows = rows;
        this.surrogate = surrogate;
        this.ctx = context;
        this.props = props;
    }

    @Override
    public void add() throws Exception {
        this.table.insert(
            new StorageWithoutIids(
                new StorageScenarioProperties(
                    new Mapped<>(
                        this.surrogate,
                        this.rows
                    ),
                    this.ctx,
                    this.props
                )
            )
        );
    }
}
