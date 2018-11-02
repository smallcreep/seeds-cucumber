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

import com.github.smallcreep.cucumber.seeds.Table;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Fake Table return Collections from constructor.
 * Save inserted inserted.
 * @since 0.2.0
 */
public final class TableFakeInsert implements Table {

    /**
     * Fake results to insert.
     */
    private final Collection<Long> results;

    /**
     * Origin table.
     */
    private final Table origin;

    /**
     * Inserted rows.
     */
    private final AtomicReference<Iterable<Map<String, String>>> inserted;

    /**
     * Ctor.
     * @param results Fake results to insert
     * @param origin Origin table
     */
    public TableFakeInsert(final Collection<Long> results, final Table origin) {
        this(results, origin, new AtomicReference<>());
    }

    /**
     * Ctor.
     * @param results Fake results to insert
     * @param origin Origin table
     * @param inserted Inserted rows
     */
    private TableFakeInsert(
        final Collection<Long> results,
        final Table origin,
        final AtomicReference<Iterable<Map<String, String>>> inserted
    ) {
        this.results = results;
        this.origin = origin;
        this.inserted = inserted;
    }

    @Override
    public Collection<Long> insert(final Iterable<Map<String, String>> rows) {
        this.inserted.set(rows);
        return this.results;
    }

    @Override
    public String value() throws Exception {
        return this.origin.value();
    }

    /**
     * Get inserted inserted.
     * @return Inserted inserted
     */
    public Iterable<Map<String, String>> rows() {
        return this.inserted.get();
    }
}
