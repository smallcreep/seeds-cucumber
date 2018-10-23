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
import com.github.smallcreep.cucumber.seeds.db.DbDefault;
import com.github.smallcreep.cucumber.seeds.db.fake.DataBaseUpdateFake;
import com.github.smallcreep.cucumber.seeds.fake.ResultSetFakeGetLong;
import com.github.smallcreep.cucumber.seeds.fake.StatementFake;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.StaticSource;
import java.util.Map;
import java.util.Properties;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterator.IteratorOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.h2.Driver;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link TableSimple}.
 * @since 0.2.0
 */
public final class TableSimpleTest {

    /**
     * TableSimple can return table name.
     * @throws Exception if fails
     */
    @Test
    public void returnTableName() throws Exception {
        MatcherAssert.assertThat(
            new TableSimple(
                "public",
                "test",
                new DbDefault(
                    new JdbcSession(
                        new StaticSource(
                            new Driver().connect(
                                "jdbc:h2:mem:returnTableName;DB_CLOSE_DELAY=-1",
                                new Properties()
                            )
                        )
                    )
                )
            ).value(),
            CoreMatchers.equalTo("public.test")
        );
    }

    /**
     * TableSimple can insert new rows.
     * @throws Exception if fails
     */
    @Test
    public void returnInsertedRows() throws Exception {
        final DataBase db2 = new DataBaseUpdateFake(
            new ResultSetFakeGetLong(
                new IteratorOf<Map<String, Long>>(
                    new MapOf<String, Long>(
                        new MapEntry<String, Long>(
                            "id", 1L
                        )
                    ),
                    new MapOf<String, Long>(
                        new MapEntry<String, Long>(
                            "id", 2L
                        )
                    )
                )
            ),
            new StatementFake() {
            }
        );
        MatcherAssert.assertThat(
            new TableSimple(
                "public",
                "test",
                db2
            ).insert(
                new IterableOf<Map<String, String>>(
                    new MapOf<String, String>(
                        new MapEntry<>(
                            "first", "1"
                        )
                    ),
                    new MapOf<String, String>(
                        new MapEntry<>(
                            "first", "2"
                        ),
                        new MapEntry<>(
                            "second", "2"
                        )
                    )
                )
            ),
            CoreMatchers.hasItems(
                1L,
                2l
            )
        );
    }
}
