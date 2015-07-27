package fr.ms.openjpa.db2;

import org.apache.openjpa.jdbc.sql.DB2Dictionary;
import org.apache.openjpa.jdbc.sql.SQLBuffer;

public class RowNumberDB2Dictionary extends DB2Dictionary {

    {
	supportsSelectStartIndex = true;
    }

    protected void appendSelectRange(final SQLBuffer buf, final long start, final long end, final boolean subselect) {

	if (!subselect) {
	    appendSelectRange(buf, start, end);
	}
    }

    protected static void appendSelectRange(final SQLBuffer buf, final long start, final long end) {
	final StringBuilder builder = new StringBuilder("SELECT * FROM (SELECT rr.*, ROW_NUMBER() OVER(ORDER BY ORDER OF rr) AS rn FROM (");
	builder.append(buf.getSQL());
	builder.append(") AS rr) AS r WHERE rn > ");
	builder.append(start);
	builder.append(" AND rn <= ");
	builder.append(end);

	buf.replaceSqlString(0, buf.getSQL().length(), builder.toString());
    }
}
