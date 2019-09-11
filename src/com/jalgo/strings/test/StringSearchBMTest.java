package com.jalgo.strings.test;

import com.jalgo.common.ISearchable;
import com.jalgo.strings.StringSearchBM;

public class StringSearchBMTest extends BaseStringSearchTest {
    protected ISearchable createSearchable() {
        return new StringSearchBM();
    }
}
