package com.jalgo.strings.test;

import com.jalgo.common.ISearchable;
import com.jalgo.strings.StringSearchRK;

public class StringSearchRKTest extends BaseStringSearchTest {
    protected ISearchable createSearchable() {
        return new StringSearchRK();
    }
}
