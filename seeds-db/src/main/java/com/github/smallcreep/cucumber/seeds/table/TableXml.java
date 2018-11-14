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

import com.github.smallcreep.cucumber.seeds.SqlValue;
import com.github.smallcreep.cucumber.seeds.Table;
import com.github.smallcreep.cucumber.seeds.sqlvalue.Serial;
import com.github.smallcreep.cucumber.seeds.sqlvalue.Varchar;
import com.jcabi.xml.XML;
import java.util.Collection;
import java.util.Map;
import org.cactoos.iterable.Mapped;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

/**
 * Envelope Table, add to values correct wrap use XML document for type.
 * @since 0.2.0
 */
public final class TableXml implements Table {

    /**
     * Origin origin.
     */
    private final Table origin;

    /**
     * Xml table schema.
     */
    private final XML schema;

    /**
     * SqlValues casting map.
     */
    private final Map<String, SqlValue> values;

    /**
     * Ctor.
     * @param table Origin origin
     * @param schema Xml table schema
     */
    public TableXml(final Table table, final XML schema) {
        this(
            table,
            schema,
            new MapOf<String, SqlValue>(
                new MapEntry<>(
                    "Varchar",
                    new Varchar()
                ),
                new MapEntry<>(
                    "Serial",
                    new Serial()
                )
            )
        );
    }

    /**
     * Ctor.
     * @param table Origin origin
     * @param schema Xml table schema
     * @param values SqlValues casting map.
     */
    private TableXml(
        final Table table,
        final XML schema,
        final Map<String, SqlValue> values
    ) {
        this.origin = table;
        this.schema = schema;
        this.values = values;
    }

    // @todo #133:15m/DEV add correct exception if not found in this.value
    //  value, because now threw java.lang.NullPointerException with next
    //  stacktrace:
    //  at com.github.smallcreep.cucumber.seeds.table.TableXml
    //  .lambda$null$0(TableXml.java:107)
    //  at org.cactoos.map.MapOf.lambda$new$0(MapOf.java:83)
    //  at org.cactoos.func.UncheckedFunc.lambda$apply$0(UncheckedFunc.java:56)
    //  at org.cactoos.scalar.CheckedScalar.value(CheckedScalar.java:76)
    //  at org.cactoos.scalar.IoCheckedScalar.value(IoCheckedScalar.java:63)
    @Override
    public Collection<Long> insert(
        final Iterable<Map<String, String>> rows
    ) throws Exception {
        return this.origin.insert(
            new Mapped<Map<String, String>, Map<String, String>>(
                input -> new MapOf<String, String>(
                    Map.Entry::getKey,
                    entry -> this.values.get(
                        this.schema.xpath(
                            String.format(
                                "//column[text()='%s']/@type",
                                entry.getKey()
                            )
                        ).get(0)
                    ).apply(entry.getValue()),
                    input.entrySet()
                ),
                rows
            )
        );
    }

    @Override
    public String value() throws Exception {
        return this.origin.value();
    }
}
