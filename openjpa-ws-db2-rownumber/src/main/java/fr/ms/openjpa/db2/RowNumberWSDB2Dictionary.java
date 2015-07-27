package fr.ms.openjpa.db2;

import org.apache.openjpa.jdbc.sql.SQLBuffer;

import com.ibm.ws.persistence.jdbc.sql.DB2Dictionary;

public class RowNumberWSDB2Dictionary extends DB2Dictionary {

    {
	supportsSelectStartIndex = true;
    }

    protected void appendSelectRange(final SQLBuffer buf, final long start, final long end, final boolean subselect) {

	if (!subselect) {
	    RowNumberDB2Dictionary.appendSelectRange(buf, start, end);
	}
    }
}
