package org.docksidestage.derby.unit;

import org.junit.runner.RunWith;
import org.seasar.junitcdi.core.runner.CDI;

/**
 * @author jflute
 * @since 1.1.0 (2014/11/10 Monday)
 */
@RunWith(CDI.class)
public abstract class ContainerTestCase extends PlainTestCase {

    // TODO jflute test: Derby, CDI transaction
    //// ===================================================================================
    ////                                                                           Attribute
    ////                                                                           =========
    //@Inject
    //private UserTransaction userTransaction;
    //
    //// ===================================================================================
    ////                                                                            Settings
    ////                                                                            ========
    //@Override
    //protected TransactionResource beginNewTransaction() {
    //    try {
    //        this.userTransaction.begin();
    //    } catch (final SystemException e) {
    //        throw new IllegalStateException(e);
    //    } catch (final NotSupportedException e) {
    //        throw new IllegalStateException(e);
    //    }
    //    final CDITransactionResource resource = new CDITransactionResource();
    //    resource.setUserTransaction(this.userTransaction);
    //    return resource;
    //}
    //
    //public static class CDITransactionResource implements TransactionResource {
    //    protected UserTransaction userTransaction;
    //
    //    public void commit() {
    //        try {
    //            this.userTransaction.commit();
    //        } catch (final Exception e) {
    //            throw new IllegalStateException(e);
    //        }
    //    }
    //
    //    public void rollback() {
    //        try {
    //            this.userTransaction.rollback();
    //        } catch (final SystemException e) {
    //            throw new IllegalStateException(e);
    //        }
    //    }
    //
    //    public UserTransaction getUserTransaction() {
    //        return this.userTransaction;
    //    }
    //
    //    public void setUserTransaction(final UserTransaction transactionManager) {
    //        this.userTransaction = transactionManager;
    //    }
    //}
}
