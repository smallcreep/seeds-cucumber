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
import com.github.smallcreep.cucumber.seeds.DataBases;
import com.github.smallcreep.cucumber.seeds.Props;
import com.github.smallcreep.cucumber.seeds.Suit;
import com.github.smallcreep.cucumber.seeds.props.PrDbsSuit;
import com.jcabi.jdbc.JdbcSession;
import com.jolbox.bonecp.BoneCPDataSource;
import java.io.File;
import java.io.IOException;

/**
 * Default Data Bases.
 * @since 0.1.1
 */
public final class DbsDefault implements DataBases {

    /**
     * DataBase properties.
     */
    private final Props<Props<String>> props;

    /**
     * Current connected database.
     */
    private DataBase current;

    /**
     * Ctor.
     * @param suit Suit
     */
    public DbsDefault(final Suit suit) {
        this(new PrDbsSuit(suit));
    }

    /**
     * Ctor.
     * @param props DataBase properties
     */
    DbsDefault(final Props<Props<String>> props) {
        this.props = props;
    }

    @Override
    public DataBase database(final String name) throws IOException {
        final BoneCPDataSource src = new BoneCPDataSource();
        final Props<String> base = this.props.property(name);
        src.setDriverClass(base.property("jdbc.driver"));
        src.setJdbcUrl(
            base.property("jdbc.url")
        );
        src.setUser(base.property("user"));
        src.setPassword(base.property("password"));
        this.current = new DataBaseLogged(
            new DataBaseXml(
                new DbDefault(
                    new JdbcSession(src)
                ),
                new File(base.property("schema"))
            )
        );
        return this.database();
    }

    @Override
    public DataBase database() {
        return this.current;
    }
}
