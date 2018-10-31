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

package com.github.smallcreep.cucumber.seeds;

import com.jolbox.bonecp.BoneCPDataSource;
import javax.sql.DataSource;
import org.junit.Before;

/**
 * Connect for integration tests.
 * @since 0.2.0
 */
public class Connect {

    /**
     * Data Source.
     */
    private final DataSource src;

    /**
     * Ctor.
     */
    public Connect() {
        this(new BoneCPDataSource());
    }

    /**
     * Ctor.
     * @param src Data Source
     */
    private Connect(final DataSource src) {
        this.src = src;
    }

    /**
     * SetUp Data Source.
     */
    @Before
    public final void setUp() {
        ((BoneCPDataSource) this.src).setDriverClass("org.postgresql.Driver");
        ((BoneCPDataSource) this.src).setJdbcUrl(
            System.getProperty("jdbc.url.postgres")
        );
        ((BoneCPDataSource) this.src).setUser("testuser");
        ((BoneCPDataSource) this.src).setPassword("mysecret");
    }

    /**
     * Get source.
     * @return Source
     */
    public final DataSource source() {
        return this.src;
    }
}
