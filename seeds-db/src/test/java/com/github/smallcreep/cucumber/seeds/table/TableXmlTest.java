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

import com.github.smallcreep.cucumber.seeds.db.DbDefault;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.xml.XMLDocument;
import com.jolbox.bonecp.BoneCPDataSource;
import java.util.Collection;
import java.util.Map;
import org.cactoos.collection.CollectionOf;
import org.cactoos.iterable.IterableOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.llorllale.cactoos.matchers.ScalarHasValue;

/**
 * Test Case for {@link TableXml}.
 * @since 0.2.0
 * @checkstyle ClassDataAbstractionCouplingCheck (200 lines)
 */
public final class TableXmlTest {

    /**
     * Check TableXml can return envelope table name.
     */
    @Test
    public void returnEnvelopeTableName() {
        MatcherAssert.assertThat(
            new TableXml(
                new TableSimple(
                    "return",
                    "EnvelopeTableName",
                    new DbDefault(
                        new JdbcSession(new BoneCPDataSource())
                    )
                ),
                new XMLDocument("<table></table>")
            ),
            new ScalarHasValue<>("return.EnvelopeTableName")
        );
    }

    /**
     * Check TableXml wrap inserted values.
     * @throws Exception if fails
     */
    @Test
    public void wrapInsertedValues() throws Exception {
        final TableFakeInsert fake = new TableFakeInsert(
            new CollectionOf<Long>(),
            new TableSimple(
                "wrap",
                "InsertedValues",
                new DbDefault(
                    new JdbcSession(new BoneCPDataSource())
                )
            )
        );
        final String key = "first";
        new TableXml(
            fake,
            new XMLDocument(
                String.format(
                    "<columns>%s</columns>",
                    "<column name=\"first\" type=\"Varchar\"></column>"
                )
            )
        ).insert(
            new IterableOf<Map<String, String>>(
                new MapOf<String, String>(
                    new MapEntry<>(
                        key,
                        "test"
                    )
                )
            )
        );
        MatcherAssert.assertThat(
            fake.rows(),
            Matchers.hasItem(
                Matchers.hasEntry(
                    Matchers.equalTo(key),
                    Matchers.equalTo("CAST('test' as varchar)")
                )
            )
        );
    }

    /**
     * Check TableXml return insert result from origin table.
     * @throws Exception if fails
     */
    @Test
    public void insertReturnedFromTransferredValue() throws Exception {
        final Collection<Long> results = new CollectionOf<>();
        MatcherAssert.assertThat(
            new TableXml(
                new TableFakeInsert(
                    results,
                    new TableSimple(
                        () -> "public.insertReturnedFromTransferredValue",
                        new DbDefault(
                            new JdbcSession(new BoneCPDataSource())
                        )
                    )
                ),
                new XMLDocument(
                    "<columns></columns>"
                )
            ).insert(
                new IterableOf<Map<String, String>>()
            ),
            Matchers.equalTo(
                results
            )
        );
    }
}
