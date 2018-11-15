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

package com.github.smallcreep.cucumber.seeds.db.steps;

import com.github.smallcreep.cucumber.seeds.Suit;
import com.github.smallcreep.cucumber.seeds.rows.RwDefault;
import com.github.smallcreep.cucumber.seeds.suit.StSmart;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

/**
 * Steps insert row or rows to database table.
 * @since 0.2.0
 */
public final class StpDefInsert {

    /**
     * Current Suit.
     */
    private final Suit suit;

    /**
     * Ctor.
     */
    public StpDefInsert() {
        this(StSmart.instance());
    }

    /**
     * Ctor.
     * @param suit Current Suit
     */
    StpDefInsert(final Suit suit) {
        this.suit = suit;
    }

    /**
     * Insert row into table with name schema.table.
     * @param schema Table schema
     * @param table Table name
     * @param rows Table rows
     * @throws Exception if fails
     */
    @Given("^There is row in the table ([^\\.]+)\\.([^\\.]+):$")
    public void insert(
        final String schema,
        final String table,
        final DataTable rows
    ) throws Exception {
        new RwDefault(
            rows.asMaps(String.class, String.class),
            this.suit
                .scenario()
                .context(),
            schema,
            table
        ).add();
    }
}
