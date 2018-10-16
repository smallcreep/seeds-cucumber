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

package com.github.smallcreep.cucumber.seeds.props;

import com.github.smallcreep.cucumber.seeds.Context;
import com.github.smallcreep.cucumber.seeds.Props;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Database property from context.
 * @since 0.1.1
 * @todo #48:15m/DEV Implement this #property(String) method.
 *  This method was return default value if has not specific value.
 *  Returned values mapping:
 *  "jdbs.driver" = "cucumber.seeds.db.%db_name%.jdbc.driver"
 *  "jdbs.url" = "cucumber.seeds.db.%db_name%.jdbc.url"
 *  "user" = "cucumber.seeds.db.%db_name%.user"
 *  "password" = "cucumber.seeds.db.%db_name%.password"
 * @checkstyle HiddenFieldCheck (500 lines)
 */
@EqualsAndHashCode(of = {"name", "ctx"})
@ToString(of = {"name", "ctx"})
public final class PrDbContext implements Props<String> {

    /**
     * Context.
     */
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Context ctx;

    /**
     * DataBase name.
     */
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final String name;

    /**
     * Ctor.
     * @param ctx Context
     * @param name DataBase name
     */
    PrDbContext(final Context ctx, final String name) {
        this.ctx = ctx;
        this.name = name;
    }

    @Override
    public String property(final String name) {
        return null;
    }
}
