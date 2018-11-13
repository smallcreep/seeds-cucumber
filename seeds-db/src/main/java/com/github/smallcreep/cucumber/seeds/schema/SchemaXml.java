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

package com.github.smallcreep.cucumber.seeds.schema;

import com.github.smallcreep.cucumber.seeds.Schema;
import com.github.smallcreep.cucumber.seeds.Table;
import com.github.smallcreep.cucumber.seeds.misc.FileFromXml;
import com.github.smallcreep.cucumber.seeds.table.TableXml;
import com.jcabi.xml.XMLDocument;
import java.io.File;
import java.io.IOException;
import org.cactoos.Func;

/**
 * XML Schema, read config from xml.
 * @since 0.2.0
 */
public final class SchemaXml implements Schema {

    /**
     * Origin schema.
     */
    private final Schema origin;

    /**
     * XML Document.
     */
    private final XMLDocument document;

    /**
     * Function get file from xml file.
     */
    private final Func<String, String> file;

    /**
     * Ctor.
     * @param origin Origin schema
     * @param file Schema file
     * @throws IOException if fails
     */
    public SchemaXml(final Schema origin, final File file) throws IOException {
        this(
            origin,
            new XMLDocument(file),
            file
        );
    }

    /**
     * Ctor.
     * @param schema Origin schema
     * @param document XML Document
     * @param file Schema file
     */
    private SchemaXml(
        final Schema schema,
        final XMLDocument document,
        final File file
    ) {
        this(
            schema,
            document,
            new FileFromXml(file)
        );
    }

    /**
     * Ctor.
     * @param schema Origin schema
     * @param document XML Document
     * @param file Function get file from xml file
     */
    private SchemaXml(
        final Schema schema,
        final XMLDocument document,
        final Func<String, String> file
    ) {
        this.origin = schema;
        this.document = document;
        this.file = file;
    }

    @Override
    public Table table(final String table) throws Exception {
        return new TableXml(
            this.origin.table(table),
            new XMLDocument(
                new File(
                    this.file.apply(
                        this.document.xpath(
                            String.format(
                                "//tables/table[text()='%s']/@file",
                                table
                            )
                        ).get(0)
                    )
                )
            )
        );
    }
}
