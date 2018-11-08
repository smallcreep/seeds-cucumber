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

package com.github.smallcreep.cucumber.seeds.db.fake;

import com.github.smallcreep.cucumber.seeds.fake.ResultSetFakeGetLong;
import com.github.smallcreep.cucumber.seeds.fake.StatementFake;
import com.github.smallcreep.cucumber.seeds.sql.SimpleSql;
import java.util.Map;
import org.cactoos.iterator.IteratorOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test Case for {@link DataBaseUpdateFake}.
 * @since 0.2.0
 */
public final class DataBaseUpdateFakeTest {

    /**
     * DataBaseUpdateFake can return to update outcome
     * ResultSet and Statement from constructor.
     * @throws Exception if fails
     */
    @Test
    public void returnTheSameParamsFromCtor() throws Exception {
        final ResultSetFakeGetLong res = new ResultSetFakeGetLong(
            new IteratorOf<Map<String, Long>>(
            )
        );
        final StatementFake state = new StatementFake() {
        };
        new DataBaseUpdateFake(
            res,
            state
        ).update(
            new SimpleSql("updateThrowException"),
            (result, statement) -> {
                MatcherAssert.assertThat(
                    result,
                    Matchers.equalTo(res)
                );
                MatcherAssert.assertThat(
                    statement,
                    Matchers.equalTo(state)
                );
                return null;
            }
        );
    }
}
