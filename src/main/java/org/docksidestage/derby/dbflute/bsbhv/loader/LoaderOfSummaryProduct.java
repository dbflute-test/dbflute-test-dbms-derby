/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package org.docksidestage.derby.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.docksidestage.derby.dbflute.exbhv.*;
import org.docksidestage.derby.dbflute.exentity.*;

/**
 * The referrer loader of SUMMARY_PRODUCT as VIEW. <br>
 * <pre>
 * [primary key]
 *     PRODUCT_ID
 *
 * [column]
 *     PRODUCT_ID, PRODUCT_NAME, PRODUCT_STATUS_CODE, LATEST_PURCHASE_DATETIME
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     PRODUCT_STATUS
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     productStatus
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfSummaryProduct {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<SummaryProduct> _selectedList;
    protected BehaviorSelector _selector;
    protected SummaryProductBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfSummaryProduct ready(List<SummaryProduct> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected SummaryProductBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(SummaryProductBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfProductStatus _foreignProductStatusLoader;
    public LoaderOfProductStatus pulloutProductStatus() {
        if (_foreignProductStatusLoader == null)
        { _foreignProductStatusLoader = new LoaderOfProductStatus().ready(myBhv().pulloutProductStatus(_selectedList), _selector); }
        return _foreignProductStatusLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<SummaryProduct> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
