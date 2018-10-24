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

package com.github.smallcreep.cucumber.seeds.outcome;

import com.jcabi.jdbc.Outcome;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import lombok.EqualsAndHashCode;

/**
 * Outcome inserted primary keys.
 * @since 0.2.0
 */
@EqualsAndHashCode(of = "primary")
public final class OutcomeIds implements Outcome<Collection<Long>> {

    /**
     * Column primary keys name.
     */
    private final String primary;

    /**
     * Ctor.
     */
    public OutcomeIds() {
        this("id");
    }

    /**
     * Ctor.
     * @param primary Column primary keys name
     */
    public OutcomeIds(final String primary) {
        this.primary = primary;
    }

    @Override
    public Collection<Long> handle(
        final ResultSet rset,
        final Statement stmt
    ) throws SQLException {
        final LinkedList<Long> ids = new LinkedList<>();
        while (rset.next()) {
            ids.add(
                rset.getLong(this.primary)
            );
        }
        return ids;
    }
}
