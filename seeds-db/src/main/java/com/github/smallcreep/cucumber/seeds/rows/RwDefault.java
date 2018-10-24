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

package com.github.smallcreep.cucumber.seeds.rows;

import com.github.smallcreep.cucumber.seeds.Rows;
import com.github.smallcreep.cucumber.seeds.Table;
import cucumber.api.DataTable;

/**
 * Default implementation {@link Rows}.
 * @since 0.2.0
 */
public final class RwDefault implements Rows {

    /**
     * Database Table.
     */
    private final Table table;

    /**
     * Rows.
     */
    private final DataTable rows;

    /**
     * Ctor.
     * @param table Database Table
     * @param rows Rows
     */
    public RwDefault(
        final Table table,
        final DataTable rows
    ) {
        this.table = table;
        this.rows = rows;
    }

    // @todo #63:30/TEST Add integration test to this method.
    //  For example this test must insert to exist database table.
    //  To create table can use liquibase, see for example usage
    //  https://www.yegor256.com/2014/07/20/liquibase-in-maven.html
    // @todo #63:30/DEV Add change values from placeholders.
    //  We need use placeholders for example #Random#Integer.
    //  This placeholder should replace before insert.
    //  Placeholders to implementation:
    //  #Random#Integer - random integer;
    //  #Random#String - random string;
    //  #Timestamp#Now - current timestamp by default in
    //  format YYYY/MM/DD hh:mm:ss
    //  #Random#String#End(endString) - random string with string in the end,
    //  can send another placeholder as parameter;
    //  #Random#String(length) - random string length from parameter;
    //  #Encryption#Md5() - encrypt string to md5 hash,
    //  can send another placeholder as parameter;
    @Override
    public void add() throws Exception {
        this.table.insert(
            this.rows.asMaps(String.class, String.class)
        );
    }
}
