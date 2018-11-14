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

import com.github.smallcreep.cucumber.seeds.Connect;
import com.github.smallcreep.cucumber.seeds.db.DataBaseXml;
import com.github.smallcreep.cucumber.seeds.db.DbDefault;
import com.jcabi.jdbc.JdbcSession;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.cactoos.iterable.IterableOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test Case for {@link RwDefault}.
 * @since 0.2.0
 * @checkstyle ClassDataAbstractionCouplingCheck (200 lines)
 */
public final class RwDefaultItCase extends Connect {

    /**
     * RwDefault can insert new rows to table.
     * @throws Exception if fails
     * @todo #101:15m/TEST Add assertion to correct inserted values after
     *  implemented method insert into table(#117) and added info of inserted
     *  rows to properties(#116).
     * @todo #142:20m/DEV Placeholders with parameters may brake regexp.
     *  For example #Encryption#Md5(').*) need escape string before replace.
     *  Need change PlaceholderWithParams. This is very big problem.
     * @checkstyle LocalFinalVariableNameCheck (10 lines)
     */
    @Ignore("Wait todo")
    @Test
    public void checkInsertNewRow() throws Exception {
        final String id = "id";
        final String title = "title";
        final String value = "value";
        final String md5 = "md5";
        new RwDefault(
            new DataBaseXml(
                new DbDefault(
                    new JdbcSession(this.source())
                ),
                new File(
                    Thread
                        .currentThread()
                        .getContextClassLoader()
                        .getResource("RwDefaultItCase/base.xml")
                        .toURI()
                )
            ).schema("public").table("test"),
            new IterableOf<Map<String, String>>(
                new MapOf<String, String>(
                    new MapEntry<>(
                        "iid", "1"
                    ),
                    new MapEntry<>(
                        id, "#Random#Serial"
                    ),
                    new MapEntry<>(
                        title, "#Random#String#Timestamp#Now"
                    ),
                    new MapEntry<>(
                        value, "#Random#String(10)"
                    ),
                    new MapEntry<>(
                        md5, "#Encryption#Md5(#Random#String)"
                    )
                )
            )
        ).add();
        final Collection<Map<String, String>> select = new JdbcSession(
            this.source()
        )
            .sql(
                "SELECT id, title, value, encode(md5, 'hex') FROM public.test"
            )
            .select(
                (rset, statement) -> {
                    final Collection<Map<String, String>> result =
                        new LinkedList<>();
                    while (rset.next()) {
                        result.add(
                            new MapOf<String, String>(
                                new MapEntry<>(
                                    id,
                                    String.valueOf(rset.getInt(id))
                                ),
                                new MapEntry<>(title, rset.getString(title)),
                                new MapEntry<>(value, rset.getString(value)),
                                new MapEntry<>(md5, rset.getString(md5))
                            )
                        );
                    }
                    return result;
                }
            );
        MatcherAssert.assertThat(
            select,
            Matchers.hasSize(1)
        );
    }
}
