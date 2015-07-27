package fr.ms.openjpa.db2;

import org.apache.openjpa.jdbc.conf.JDBCConfigurationImpl;
import org.apache.openjpa.lib.conf.AbstractProductDerivation;
import org.apache.openjpa.lib.conf.Configuration;
import org.apache.openjpa.lib.conf.PluginValue;
import org.apache.openjpa.lib.conf.ProductDerivation;

public class RowNumberDB2ProductDerivation extends AbstractProductDerivation {

    public int getType() {
	return ProductDerivation.TYPE_FEATURE;
    }

    @Override
    public boolean beforeConfigurationLoad(final Configuration conf) {
	if (conf instanceof JDBCConfigurationImpl) {
	    final JDBCConfigurationImpl jdbcConfig = (JDBCConfigurationImpl) conf;
	    final PluginValue dbdictionaryPlugin = jdbcConfig.dbdictionaryPlugin;

	    try {
		Class.forName("com.ibm.ws.persistence.jdbc.sql.DB2Dictionary");
		dbdictionaryPlugin.setAlias("db2", RowNumberWSDB2Dictionary.class.getName());
		return true;
	    } catch (final ClassNotFoundException e) {
		// Rien
	    }

	    try {
		Class.forName("org.apache.openjpa.jdbc.sql.DB2Dictionary");
		dbdictionaryPlugin.setAlias("db2", RowNumberDB2Dictionary.class.getName());
		return true;
	    } catch (final ClassNotFoundException e) {
		// Rien
	    }
	}
	return false;
    }
}
