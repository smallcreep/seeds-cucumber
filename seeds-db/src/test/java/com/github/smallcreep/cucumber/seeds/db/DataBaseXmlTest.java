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

import com.github.smallcreep.cucumber.seeds.Schema;
import com.github.smallcreep.cucumber.seeds.db.fake.DataBaseFake;
import com.github.smallcreep.cucumber.seeds.db.fake.DataBaseSchemaFake;
import com.github.smallcreep.cucumber.seeds.schema.SchemaSimple;
import com.github.smallcreep.cucumber.seeds.schema.SchemaXml;
import java.io.File;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.llorllale.cactoos.matchers.ScalarHasValue;

/**
 * Test Case for {@link DataBaseXml}.
 * @since 0.2.0
 */
public final class DataBaseXmlTest {

    /**
     * DataBaseXml return SchemaXml.
     * @throws Exception if fails
     */
    @Test
    public void checkDatabaseReturnSchemaXml() throws Exception {
        final String name = "schema";
        final Schema schema = new DataBaseXml(
            new DataBaseSchemaFake(
                new SchemaSimple(
                    name,
                    new DataBaseFake() {
                    }
                )
            ),
            new File(
                Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResource("base.xml")
                    .toURI()
            )
        ).schema(name);
        MatcherAssert.assertThat(
            schema,
            Matchers.instanceOf(SchemaXml.class)
        );
        MatcherAssert.assertThat(
            schema.table("checkSchemaReturnTableXml"),
            new ScalarHasValue<>(
                "schema.checkSchemaReturnTableXml"
            )
        );
    }
}
