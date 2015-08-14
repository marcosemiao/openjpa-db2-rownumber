/*
 * Copyright 2015 Marco Semiao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package fr.ms.openjpa.db2;

import org.apache.openjpa.jdbc.conf.JDBCConfigurationImpl;
import org.apache.openjpa.lib.conf.AbstractProductDerivation;
import org.apache.openjpa.lib.conf.Configuration;
import org.apache.openjpa.lib.conf.PluginValue;
import org.apache.openjpa.lib.conf.ProductDerivation;

import fr.ms.util.ServiceLoader;

/**
 *
 * @see <a href="http://marcosemiao4j.wordpress.com">Marco4J</a>
 *
 *
 * @author Marco Semiao
 *
 */
@ServiceLoader
public class RowNumberDB2ProductDerivation extends AbstractProductDerivation {

    public int getType() {
	return ProductDerivation.TYPE_FEATURE;
    }

    @Override
    public boolean beforeConfigurationLoad(final Configuration conf) {
	if (conf instanceof JDBCConfigurationImpl) {
	    final JDBCConfigurationImpl jdbcConfig = (JDBCConfigurationImpl) conf;
	    final PluginValue dbdictionaryPlugin = jdbcConfig.dbdictionaryPlugin;

	    if (classPresent("com.ibm.ws.persistence.jdbc.sql.DB2Dictionary")) {
		dbdictionaryPlugin.setAlias("db2", RowNumberWSDB2Dictionary.class.getName());
		return true;
	    }

	    if (classPresent("org.apache.openjpa.jdbc.sql.DB2Dictionary")) {
		dbdictionaryPlugin.setAlias("db2", RowNumberDB2Dictionary.class.getName());
		return true;
	    }
	}
	return false;
    }

    private final static boolean classPresent(final String className) {
	try {
	    Class.forName(className);
	    return true;
	} catch (final ClassNotFoundException e) {
	    return false;
	}
    }
}
