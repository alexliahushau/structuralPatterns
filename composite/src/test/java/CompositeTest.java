import com.epam.mentoring.lessfree.Component;
import com.epam.mentoring.lessfree.composite.Composite;
import com.epam.mentoring.lessfree.leaf.Leaf;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class CompositeTest {

    final static Logger LOG = LoggerFactory.getLogger(CompositeTest.class);

    @Test
    public void test_Composite() {

        final String[] a = {"1", "2", "3"};
        final String[] b = {"4", "5", "8", "10"};
        final Composite ab = new Composite();

        int count = 0;

        for (String x : a) {
            for (String y : b) {
                ab.addChild(new Leaf(x, y));
                ab.addChild(new Leaf(y, x));
                count+=2;
            }
        }

        ab.print();

        assertThat(count).isEqualTo(a.length*b.length*2);

    }
}
