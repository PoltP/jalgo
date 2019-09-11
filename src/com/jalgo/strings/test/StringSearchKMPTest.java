package com.jalgo.strings.test;

import com.jalgo.common.ISearchable;
import com.jalgo.strings.StringSearchKMP;

public class StringSearchKMPTest extends BaseStringSearchTest {
    protected ISearchable createSearchable() {
        return new StringSearchKMP();
    }
}
