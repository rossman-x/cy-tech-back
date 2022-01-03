package com.cytech.cytechback.criteria;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.option.Option;

public class CriteriaDTO implements SimpleDto {

    private String content;

    private Option option;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
