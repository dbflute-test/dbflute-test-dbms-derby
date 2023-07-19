/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package org.docksidestage.derby.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import org.docksidestage.derby.dbflute.allcommon.*;
import org.docksidestage.derby.dbflute.exentity.customize.*;

/**
 * The DB meta of MemberMonthlyPurchase. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberMonthlyPurchaseDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberMonthlyPurchaseDbm _instance = new MemberMonthlyPurchaseDbm();
    private MemberMonthlyPurchaseDbm() {}
    public static MemberMonthlyPurchaseDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((MemberMonthlyPurchase)et).getMemberId(), (et, vl) -> ((MemberMonthlyPurchase)et).setMemberId(cti(vl)), "memberId");
        setupEpg(_epgMap, et -> ((MemberMonthlyPurchase)et).getPurchaseMonth(), (et, vl) -> ((MemberMonthlyPurchase)et).setPurchaseMonth(ctld(vl)), "purchaseMonth");
        setupEpg(_epgMap, et -> ((MemberMonthlyPurchase)et).getPurchasePriceAvg(), (et, vl) -> ((MemberMonthlyPurchase)et).setPurchasePriceAvg(cti(vl)), "purchasePriceAvg");
        setupEpg(_epgMap, et -> ((MemberMonthlyPurchase)et).getPurchasePriceMax(), (et, vl) -> ((MemberMonthlyPurchase)et).setPurchasePriceMax(cti(vl)), "purchasePriceMax");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MemberMonthlyPurchase";
    protected final String _tableDispName = "MemberMonthlyPurchase";
    protected final String _tablePropertyName = "memberMonthlyPurchase";
    protected final TableSqlName _tableSqlName = new TableSqlName("MemberMonthlyPurchase", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, false, false, false, "INTEGER", 10, 0, null, null, false, null, "// grouping item", null, null, null, false);
    protected final ColumnInfo _columnPurchaseMonth = cci("PURCHASE_MONTH", "PURCHASE_MONTH", null, null, java.time.LocalDate.class, "purchaseMonth", null, false, false, false, "DATE", 10, 0, null, null, false, null, "// grouping item, depends on DBMS", null, null, null, false);
    protected final ColumnInfo _columnPurchasePriceAvg = cci("PURCHASE_PRICE_AVG", "PURCHASE_PRICE_AVG", null, null, Integer.class, "purchasePriceAvg", null, false, false, false, "INTEGER", 10, 0, null, null, false, null, "// aggregation item", null, null, null, false);
    protected final ColumnInfo _columnPurchasePriceMax = cci("PURCHASE_PRICE_MAX", "PURCHASE_PRICE_MAX", null, null, Integer.class, "purchasePriceMax", null, false, false, false, "INTEGER", 10, 0, null, null, false, null, "// me too", null, null, null, false);

    /**
     * MEMBER_ID: {INTEGER(10), refers to MEMBER.MEMBER_ID}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * PURCHASE_MONTH: {DATE(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchaseMonth() { return _columnPurchaseMonth; }
    /**
     * PURCHASE_PRICE_AVG: {INTEGER(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchasePriceAvg() { return _columnPurchasePriceAvg; }
    /**
     * PURCHASE_PRICE_MAX: {INTEGER(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchasePriceMax() { return _columnPurchasePriceMax; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnPurchaseMonth());
        ls.add(columnPurchasePriceAvg());
        ls.add(columnPurchasePriceMax());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        throw new UnsupportedOperationException("The table does not have primary key: " + getTableDbName());
    }
    public boolean hasPrimaryKey() { return false; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "org.docksidestage.derby.dbflute.exentity.customize.MemberMonthlyPurchase"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberMonthlyPurchase> getEntityType() { return MemberMonthlyPurchase.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public MemberMonthlyPurchase newEntity() { return new MemberMonthlyPurchase(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((MemberMonthlyPurchase)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((MemberMonthlyPurchase)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
