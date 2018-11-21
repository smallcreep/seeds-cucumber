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

import com.github.smallcreep.cucumber.seeds.db.fake.DataBaseFake;
import com.github.smallcreep.cucumber.seeds.db.fake.DataBaseQueryFake;
import com.github.smallcreep.cucumber.seeds.fake.ResultSetFakeGetLong;
import com.github.smallcreep.cucumber.seeds.fake.StatementFake;
import com.github.smallcreep.cucumber.seeds.sql.SimpleSql;
import com.jcabi.jdbc.Outcome;
import java.util.Collections;
import java.util.Map;
import org.cactoos.iterator.IteratorOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

/**
 * Test Case for {@link DataBaseLogged}.
 * @since 0.2.1
 */
public final class DataBaseLoggedTest {

    /**
     * A rule for handling an exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Logger.
     */
    private final TestLogger logger = TestLoggerFactory
        .getTestLogger(DataBaseLogged.class);

    /**
     * Clear logger before test.
     */
    @Before
    public void setUp() {
        this.logger.clear();
    }

    /**
     * DataBaseLogged run connect from origin Database.
     * @throws Exception if fails
     */
    @Test
    public void runConnectFromOrigin() throws Exception {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #connect() in this fake.");
        new DataBaseLogged(
            new DataBaseFake() {
            }
        ).connect();
    }

    /**
     * DataBaseLogged run result from origin Database.
     * @throws Exception if fails
     */
    @Test
    public void runResultFromOrigin() throws Exception {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #result() in this fake.");
        new DataBaseLogged(
            new DataBaseFake() {
            }
        ).result(
            new SimpleSql("runResultFromOrigin"),
            Outcome.VOID
        );
    }

    /**
     * DataBaseLogged run update from origin Database.
     * @throws Exception if fails
     */
    @Test
    public void databaseXmlRunUpdateFromOrigin() throws Exception {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #update() in this fake.");
        new DataBaseLogged(
            new DataBaseFake() {
            }
        ).update(
            new SimpleSql("databaseXmlRunUpdateFromOrigin"),
            Outcome.VOID
        );
    }

    /**
     * DataBaseLogged write to log sql query before run #result.
     * @throws Exception if fails
     */
    @Test
    public void writeToLogResultQuery() throws Exception {
        final ResultSetFakeGetLong res = new ResultSetFakeGetLong(
            new IteratorOf<Map<String, Long>>(
            )
        );
        final StatementFake state = new StatementFake() {
        };
        new DataBaseLogged(
            new DataBaseQueryFake(
                res,
                state
            )
        ).result(
            new SimpleSql("writeToLogResultQuery"),
            Outcome.VOID
        );
        MatcherAssert.assertThat(
            this.logger.getLoggingEvents(),
            Matchers.is(
                Collections.singletonList(
                    LoggingEvent.info(
                        "EXECUTE SQL: writeToLogResultQuery"
                    )
                )
            )
        );
    }

    /**
     * DataBaseLogged write to log sql query before run #update.
     * @throws Exception if fails
     */
    @Test
    public void writeToLogUpdateQuery() throws Exception {
        final ResultSetFakeGetLong res = new ResultSetFakeGetLong(
            new IteratorOf<Map<String, Long>>(
            )
        );
        final StatementFake state = new StatementFake() {
        };
        new DataBaseLogged(
            new DataBaseQueryFake(
                res,
                state
            )
        ).update(
            new SimpleSql("writeToLogUpdateQuery"),
            Outcome.VOID
        );
        MatcherAssert.assertThat(
            this.logger.getLoggingEvents(),
            Matchers.is(
                Collections.singletonList(
                    LoggingEvent.info(
                        "EXECUTE SQL: writeToLogUpdateQuery"
                    )
                )
            )
        );
    }
}
