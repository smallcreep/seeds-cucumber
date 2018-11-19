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
import com.github.smallcreep.cucumber.seeds.context.CxSimple;
import com.github.smallcreep.cucumber.seeds.db.DataBaseXml;
import com.github.smallcreep.cucumber.seeds.db.DbDefault;
import com.jcabi.jdbc.JdbcSession;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.cactoos.iterable.IterableOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.text.JoinedText;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
     * @checkstyle LocalFinalVariableNameCheck (10 lines)
     */
    @Test
    @SuppressWarnings("PMD.ExcessiveMethodLength")
    public void checkInsertNewRow() throws Exception {
        final String id = "id";
        final String title = "title";
        final String value = "value";
        final String md5 = "md5";
        final Map<String, Object> values = new HashMap<>();
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
            ),
            new CxSimple(values),
            "public.test"
        ).add();
        final Collection<Map<String, String>> select = new JdbcSession(
            this.source()
        ).sql(
            new JoinedText(
                " ",
                "SELECT id, title, value, encode(md5, 'hex') as md5",
                "FROM public.test"
            ).asString()
        ).select(
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
        final Map<String, String> row = select.iterator().next();
        MatcherAssert.assertThat(
            values,
            Matchers.allOf(
                Matchers.hasEntry(
                    Matchers.equalTo("#Storage#public.test#iid=1(iid)"),
                    Matchers.equalTo("1")
                ),
                Matchers.hasEntry(
                    Matchers.equalTo("#Storage#public.test#iid=1(id)"),
                    Matchers.equalTo(row.get(id))
                ),
                Matchers.hasEntry(
                    Matchers.equalTo(
                        "#Storage#public.test#iid=1(title)"
                    ),
                    Matchers.equalTo(row.get(title))
                ),
                Matchers.hasEntry(
                    Matchers.equalTo(
                        "#Storage#public.test#iid=1(value)"
                    ),
                    Matchers.equalTo(row.get(value))
                ),
                Matchers.hasEntry(
                    Matchers.equalTo(
                        "#Storage#public.test#iid=1(md5)"
                    ),
                    Matchers.equalTo(row.get(md5))
                )
            )
        );
    }
}
