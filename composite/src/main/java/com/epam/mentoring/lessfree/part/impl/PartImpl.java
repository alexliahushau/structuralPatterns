package com.epam.mentoring.lessfree.part.impl;

import com.epam.mentoring.lessfree.part.Part;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class PartImpl implements Part {
    final static Logger LOG = LoggerFactory.getLogger(PartImpl.class);

    private List<Part> children = new ArrayList<>(0);

    public PartImpl() {
        LOG.debug("Create part object");
    }

    public PartImpl(final List children) {
        LOG.debug("Create part object with children: [{}]", children);
        this.children = children;
    }

    @Override
    public List<Part> getChildren() {
        LOG.debug("Create part object with children: [{}]", children);
        return this.children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("children", children)
                .toString();
    }
}
