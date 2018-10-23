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

import java.util.Map;
import org.cactoos.iterable.IterableOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.text.JoinedText;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link InsertSql}.
 * @since 0.2.0
 */
public final class InsertSqlTest {

    /**
     * Check SQL Insert query correct.
     * @throws Exception if fails
     */
    @Test
    public void checkSqlInsertQuery() throws Exception {
        final String first = "first";
        final String second = "second";
        final String third = "third";
        final String table = "test";
        final IterableOf<String> heads = new IterableOf<>(
            first,
            second,
            third
        );
        MatcherAssert.assertThat(
            new InsertSql(
                heads,
                new IterableOf<Map<String, String>>(
                    new MapOf<String, String>(
                        new MapEntry<>(
                            first, "1"
                        ),
                        new MapEntry<>(
                            second, "2"
                        ),
                        new MapEntry<>(
                            third, "3"
                        )
                    ),
                    new MapOf<String, String>(
                        new MapEntry<>(
                            first, "md5('1234')"
                        ),
                        new MapEntry<>(
                            second, "sec"
                        ),
                        new MapEntry<>(
                            "fourty", "4"
                        )
                    )
                ),
                table
            ).query(),
            CoreMatchers.equalTo(
                String.format(
                    "INSERT INTO %s (%s) VALUES %s, %s",
                    table,
                    new JoinedText(
                        ", ",
                        heads
                    ),
                    "(1, 2, 3)",
                    "(md5('1234'), sec, null)"
                )
            )
        );
    }
}
