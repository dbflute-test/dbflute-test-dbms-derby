/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package org.docksidestage.derby.dbflute.cbean.nss;

import org.docksidestage.derby.dbflute.cbean.cq.MemberWithdrawalCQ;

/**
 * The nest select set-upper of MEMBER_WITHDRAWAL.
 * @author DBFlute(AutoGenerator)
 */
public class MemberWithdrawalNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final MemberWithdrawalCQ _query;
    public MemberWithdrawalNss(MemberWithdrawalCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * MEMBER by my MEMBER_ID, named 'member'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMember() {
        _query.xdoNss(() -> _query.queryMember());
        return new MemberNss(_query.queryMember());
    }
    /**
     * With nested relation columns to select clause. <br>
     * WITHDRAWAL_REASON by my WITHDRAWAL_REASON_CODE, named 'withdrawalReason'.
     */
    public void withWithdrawalReason() {
        _query.xdoNss(() -> _query.queryWithdrawalReason());
    }
}
