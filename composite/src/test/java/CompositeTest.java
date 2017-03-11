import com.epam.mentoring.lessfree.part.Part;
import com.epam.mentoring.lessfree.part.impl.PartImpl;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class CompositeTest {

    @Test
    public void test_CompositeGetChildren() {
        final Part whole = new PartImpl();

        final Part innerPart1 = new PartImpl();
        final Part innerPart2 = new PartImpl();
        final Part innerPart3 = new PartImpl();

        final List children = whole.getChildren();
        children.add(innerPart1);
        children.add(innerPart2);
        children.add(innerPart3);

        assertThat(whole.getChildren().size()).isEqualTo(3);
    }
}
