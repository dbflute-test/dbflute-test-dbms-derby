package org.docksidestage.derby.unit;

import javax.inject.Inject;

import org.dbflute.bhv.BehaviorSelector;
import org.dbflute.bhv.BehaviorWritable;
import org.dbflute.bhv.writable.DeleteOption;
import org.dbflute.cbean.ConditionBean;
import org.dbflute.cbean.scoping.ModeQuery;
import org.dbflute.exception.NonSpecifiedColumnAccessException;
import org.docksidestage.derby.dbflute.exbhv.MemberAddressBhv;
import org.docksidestage.derby.dbflute.exbhv.MemberFollowingBhv;
import org.docksidestage.derby.dbflute.exbhv.MemberLoginBhv;
import org.docksidestage.derby.dbflute.exbhv.MemberSecurityBhv;
import org.docksidestage.derby.dbflute.exbhv.MemberServiceBhv;
import org.docksidestage.derby.dbflute.exbhv.MemberWithdrawalBhv;
import org.docksidestage.derby.dbflute.exbhv.PurchaseBhv;

/**
 * @author jflute
 * @since 1.1.0 (2014/11/10 Monday)
 */
public abstract class UnitContainerTestCase extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Inject
    private BehaviorSelector _behaviorSelector;

    // ===================================================================================
    //                                                                         Data Helper
    //                                                                         ===========
    protected void deleteAll(Class<? extends BehaviorWritable> clazz) {
        BehaviorWritable bhv = _behaviorSelector.select(clazz);
        ConditionBean cb = bhv.newConditionBean();
        bhv.rangeRemove(cb, new DeleteOption<ConditionBean>().allowNonQueryDelete());
    }

    protected void deleteMemberReferrer() {
        deleteAll(MemberAddressBhv.class);
        deleteAll(MemberFollowingBhv.class);
        deleteAll(MemberLoginBhv.class);
        deleteAll(MemberServiceBhv.class);
        deleteAll(MemberSecurityBhv.class);
        deleteAll(MemberWithdrawalBhv.class);
        // TODO jflute test: Derby, payment
        //deleteAll(PurchasePaymentBhv.class);
        deleteAll(PurchaseBhv.class);
    }

    // ===================================================================================
    //                                                                       Assert Helper
    //                                                                       =============
    protected void assertNonSpecifiedAccess(ModeQuery noArgInLambda) { // rental interface
        try {
            noArgInLambda.query();
            fail();
        } catch (NonSpecifiedColumnAccessException e) {
            log(e.getMessage());
        }
    }
}
