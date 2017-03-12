package com.epam.mentoring.lessfree.composite;

import com.epam.mentoring.lessfree.Component;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class Composite implements Component {
    final static Logger LOG = LoggerFactory.getLogger(Composite.class);

    private List<Component> children = new ArrayList<>(0);

    public boolean addChild(final Component child) {
        return this.children.add(child);
    }

    public boolean removeChild(final Component child) {
        return this.children.remove(child);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("children", children)
                .toString();
    }

    @Override
    public void print() {
        children.forEach(Component::print);
    }
}
