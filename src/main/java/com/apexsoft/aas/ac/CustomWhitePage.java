package com.apexsoft.aas.ac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Custom white page, both servlet path and funcs
 * @see com.apexsoft.aas.ac.AcWhitePage is default white page, therefore
 * should use {@link Primary}, in order to override it.
 * @author linqz
 * @date 10/16/2018
 */
@Component
@Primary
public class CustomWhitePage extends AcWhitePage{
    @Override
    protected void buildPage() {
        super.buildPage();
//        this.pageList.add("/aaa");
    }

    @Override
    protected void buildFunc() {
        super.buildFunc();
    }
}
