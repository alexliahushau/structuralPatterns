package com.epam.mentoring.lessfree.leaf;

import com.epam.mentoring.lessfree.Component;
import com.epam.mentoring.lessfree.composite.Composite;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Aliaksandr_Liahushau on 3/12/2017.
 */
public class Leaf implements Component {
    final static Logger LOG = LoggerFactory.getLogger(Leaf.class);

    private String x;
    private String y;

    public Leaf(final String x, final String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void print() {
        LOG.debug(this.toString());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("x", x)
                .append("y", y)
                .toString();
    }
}
