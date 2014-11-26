package org.docksidestage.derby.unit;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.annotation.sql.DataSourceDefinition;
import javax.sql.XADataSource;

import org.dbflute.util.DfResourceUtil;
import org.docksidestage.derby.dbflute.allcommon.DBFluteModule;
import org.seasar.extension.dbcp.impl.XADataSourceImpl;
import org.seasar.junitcdi.jta.datasource.AbstractDataSource;

/**
 * @author jflute
 * @since 1.1.0 (2014/11/10 Monday)
 */
@DataSourceDefinition(name = "jdbc/maihamadb" // ???
, className = "org.apache.derby.jdbc.EmbeddedDriver" // JDBC driver
, user = "maihamadb", password = "maihamadb" // DB user
)
public class MaihamaDBDataSource extends AbstractDataSource {

    @Override
    protected XADataSource createXADataSource(final DataSourceDefinition definition) throws SQLException {
        final XADataSourceImpl xaDataSource = new XADataSourceImpl();
        xaDataSource.setDriverClassName(definition.className());
        xaDataSource.setURL(this.buildUrl("/database/maihamadb"));
        xaDataSource.setUser(definition.user());
        xaDataSource.setPassword(definition.password());
        xaDataSource.setLoginTimeout(definition.loginTimeout());
        return xaDataSource;
    }

    protected String buildUrl(final String urlSuffix) {
        try {
            final File dir = DfResourceUtil.getBuildDir(DBFluteModule.class);
            final String canonicalPath = dir.getCanonicalPath();
            final String url = "jdbc:derby:" + canonicalPath.replace('\\', '/') + urlSuffix;
            return url;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
