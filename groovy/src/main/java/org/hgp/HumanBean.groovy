package org.hgp

/**
 * Created by hgp on 2017/5/10.
 */
class HumanBean {

    def name
    def Age
    def sex


    @Override
    String toString() {
        "HumanBean{" +
            "name='" + name + '\'' +
            ", Age=" + Age +
            ", sex='" + sex + '\'' +
            '}'
    }
}
