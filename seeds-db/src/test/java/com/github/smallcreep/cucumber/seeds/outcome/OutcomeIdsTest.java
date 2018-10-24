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

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.StaticSource;
import java.util.Collection;
import java.util.Properties;
import javax.sql.DataSource;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.h2.Driver;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link OutcomeIds}.
 * @since 0.2.0
 */
public final class OutcomeIdsTest {

    /**
     * OutcomeIds can return the all primary key for new inserted rows.
     * @throws Exception If there is some problem inside
     */
    @Test
    public void retrievesInsertedPrimaryKey() throws Exception {
        final DataSource source = new StaticSource(
            new Driver().connect(
                "jdbc:h2:mem:retrievesInsertedPrimaryKey;DB_CLOSE_DELAY=-1",
                new Properties()
            )
        );
        final JdbcSession session = new JdbcSession(source);
        session
            .autocommit(false)
            .sql(
                "CREATE TABLE foo (id integer, name VARCHAR(50))"
            )
            .execute()
            .sql("INSERT INTO foo (id, name) VALUES (?, ?)")
            .set(1)
            .set("John Ivanov")
            .execute()
            .set(2)
            .set("Ivan Ivanov")
            .execute();
        final Collection<Long> ids = session
            .sql("SELECT id, name FROM foo")
            .select(new OutcomeIds());
        MatcherAssert.assertThat(
            ids,
            CoreMatchers.hasItems(
                1L,
                2L
            )
        );
    }

    /**
     * Check {@link OutcomeIds#equals(Object)} and
     * {@link OutcomeIds#hashCode()}.
     */
    @Test
    public void checkEqualsAndHashCode() {
        EqualsVerifier.forClass(OutcomeIds.class).verify();
    }
}
