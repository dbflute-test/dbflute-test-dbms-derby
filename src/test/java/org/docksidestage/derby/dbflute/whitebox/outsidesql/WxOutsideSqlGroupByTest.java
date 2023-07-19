package org.docksidestage.derby.dbflute.whitebox.outsidesql;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.dbflute.cbean.result.ListResultBean;
import org.docksidestage.derby.dbflute.exbhv.PurchaseBhv;
import org.docksidestage.derby.dbflute.exbhv.pmbean.MemberMonthlyPurchasePmb;
import org.docksidestage.derby.dbflute.exentity.customize.MemberMonthlyPurchase;
import org.docksidestage.derby.unit.UnitContainerTestCase;
import org.junit.Test;

/**
 * @author jflute
 * @since 1.2.7 (2023/07/19 Wednesday at ichihara)
 */
public class WxOutsideSqlGroupByTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Inject
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    @Test
    public void test_outsideSql_groupBy_allRecords() {
        // ## Arrange ##
        MemberMonthlyPurchasePmb pmb = new MemberMonthlyPurchasePmb();

        // ## Act ##
        ListResultBean<MemberMonthlyPurchase> purchaseList = purchaseBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (MemberMonthlyPurchase purchase : purchaseList) {
            showPurchase(purchase);
        }
    }

    // ===================================================================================
    //                                                                  where Range Search
    //                                                                  ==================
    @Test
    public void test_outsideSql_groupBy_where_purchaseDatetimeFrom() {
        // ## Arrange ##
        MemberMonthlyPurchasePmb pmb = new MemberMonthlyPurchasePmb();
        pmb.setPurchaseDatetimeFrom(LocalDateTime.of(2005, 4, 1, 0, 0, 0));

        // ## Act ##
        ListResultBean<MemberMonthlyPurchase> purchaseList = purchaseBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (MemberMonthlyPurchase purchase : purchaseList) {
            showPurchase(purchase);
        }
    }

    public void test_outsideSql_groupBy_where_monthFromBad() {
        // ## Arrange ##
        MemberMonthlyPurchasePmb pmb = new MemberMonthlyPurchasePmb();
        pmb.setMonthFromBad(LocalDate.of(2005, 4, 1)); // grouping item

        // ## Act ##
        ListResultBean<MemberMonthlyPurchase> purchaseList = purchaseBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (MemberMonthlyPurchase purchase : purchaseList) {
            showPurchase(purchase);
        }
    }

    // ===================================================================================
    //                                                                 having Range Search
    //                                                                 ===================
    @Test
    public void test_outsideSql_groupBy_having_monthToHaving() {
        // ## Arrange ##
        MemberMonthlyPurchasePmb pmb = new MemberMonthlyPurchasePmb();
        pmb.setMonthToHaving(LocalDate.of(2167, 9, 1)); // grouping item

        // ## Act ##
        ListResultBean<MemberMonthlyPurchase> purchaseList = purchaseBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (MemberMonthlyPurchase purchase : purchaseList) {
            showPurchase(purchase);
        }
    }

    @Test
    public void test_outsideSql_groupBy_having_priceMaxFrom() {
        // ## Arrange ##
        MemberMonthlyPurchasePmb pmb = new MemberMonthlyPurchasePmb();
        pmb.setPriceMaxFrom(100); // aggregation item

        // ## Act ##
        ListResultBean<MemberMonthlyPurchase> purchaseList = purchaseBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (MemberMonthlyPurchase purchase : purchaseList) {
            showPurchase(purchase);
        }
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private void showPurchase(MemberMonthlyPurchase purchase) {
        // cannot genearte purchase.getMemberName() for now by jflute (2023/07/19)
        log(purchase.getMemberId(), purchase.getPurchaseMonth(), purchase.getPurchasePriceAvg(), purchase.getPurchasePriceMax());
    }
}
