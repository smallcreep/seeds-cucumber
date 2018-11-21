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

import com.github.smallcreep.cucumber.seeds.sql.SimpleSql;
import com.jcabi.jdbc.Outcome;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test Case for {@link DataBaseFake}.
 * @since 0.2.0
 */
public final class DataBaseFakeTest {

    /**
     * A rule for handling an exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Connect throw unsupported exception.
     */
    @Test
    public void connectThrowException() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #connect() in this fake.");
        new DataBaseFake() {
        }.connect();
    }

    /**
     * Result throw unsupported exception.
     * @throws Exception if fails
     */
    @Test
    public void resultThrowException() throws Exception {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #result() in this fake.");
        new DataBaseFake() {
        }.result(
            new SimpleSql("resultThrowException"),
            Outcome.VOID
        );
    }

    /**
     * Update throw unsupported exception.
     * @throws Exception if fails
     */
    @Test
    public void updateThrowException() throws Exception {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #update() in this fake.");
        new DataBaseFake() {
        }.update(
            new SimpleSql("updateThrowException"),
            Outcome.VOID
        );
    }

    /**
     * Schema throw unsupported exception.
     */
    @Test
    public void schemaThrowException() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage("Unsupported #schema() in this fake.");
        new DataBaseFake() {
        }.schema("schemaThrowException");
    }
}
