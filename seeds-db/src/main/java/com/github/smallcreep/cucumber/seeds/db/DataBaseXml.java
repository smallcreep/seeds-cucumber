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

package com.github.smallcreep.cucumber.seeds.db;

import com.github.smallcreep.cucumber.seeds.DataBase;
import com.github.smallcreep.cucumber.seeds.Schema;
import com.github.smallcreep.cucumber.seeds.Sql;
import com.github.smallcreep.cucumber.seeds.misc.FileFromXml;
import com.github.smallcreep.cucumber.seeds.schema.SchemaXml;
import com.jcabi.jdbc.Outcome;
import com.jcabi.xml.XMLDocument;
import java.io.File;
import java.io.IOException;
import org.cactoos.Func;

/**
 * DataBase XML read schema from xml file.
 * @since 0.2.0
 */
public final class DataBaseXml implements DataBase {

    /**
     * Origin database.
     */
    private final DataBase origin;

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
     * @param base Origin database
     * @param file Database file
     * @throws IOException if fails
     */
    public DataBaseXml(final DataBase base, final File file)
        throws IOException {
        this(
            base,
            new XMLDocument(file),
            file
        );
    }

    /**
     * Ctor.
     * @param base Origin database
     * @param document XML Document
     * @param file Database file
     */
    private DataBaseXml(
        final DataBase base,
        final XMLDocument document,
        final File file
    ) {
        this(
            base,
            document,
            new FileFromXml(file)
        );
    }

    /**
     * Ctor.
     * @param base Origin database
     * @param document XML Document
     * @param file Database file
     */
    private DataBaseXml(
        final DataBase base,
        final XMLDocument document,
        final Func<String, String> file
    ) {
        this.origin = base;
        this.document = document;
        this.file = file;
    }

    @Override
    public void connect() throws Exception {
        this.origin.connect();
    }

    @Override
    public <T> T result(final Sql sql, final Outcome<T> outcome)
        throws Exception {
        return this.origin.result(sql, outcome);
    }

    @Override
    public <T> T update(final Sql sql, final Outcome<T> outcome)
        throws Exception {
        return this.origin.update(sql, outcome);
    }

    @Override
    public Schema schema(final String schema) throws Exception {
        return new SchemaXml(
            this.origin.schema(schema),
            new File(
                this.file.apply(
                    this.document.xpath(
                        String.format(
                            "//schemas/schema[text()='%s']/@file",
                            schema
                        )
                    ).get(0)
                )
            )
        );
    }
}
