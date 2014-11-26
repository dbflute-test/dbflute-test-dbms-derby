package org.docksidestage.derby.dbflute.whitebox.container;

import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.docksidestage.derby.dbflute.cbean.MemberCB;
import org.docksidestage.derby.dbflute.exbhv.MemberBhv;
import org.docksidestage.derby.dbflute.exentity.Member;
import org.docksidestage.derby.unit.ContainerTestCase;
import org.junit.Test;

/**
 * CDI tests under JavaSE environment.
 *
 * @author taktos
 * @see http://junitcdi.sandbox.seasar.org/
 */
public class WxCDITest extends ContainerTestCase {

    @Inject
    private MemberBhv memberBhv;

    @Inject
    BeanManager beanManager;

    @Test
    public void testInject() throws Exception {
        assertNotNull("Behaviors are managed by container.", this.memberBhv);

        final List<Member> list = this.memberBhv.selectList(cb -> {});
        assertNotNull(list);
        assertTrue(0 < list.size());
    }

    @Test
    public void testUnmanagedBeans() throws Exception {
        @SuppressWarnings("serial")
        final Set<Bean<?>> cbBean = this.beanManager.getBeans(MemberCB.class, new AnnotationLiteral<Any>() {
        });
        assertNotNull(cbBean);
        assertEquals("ConditionBeans should not managed in container.", 0, cbBean.size());
    }
}
