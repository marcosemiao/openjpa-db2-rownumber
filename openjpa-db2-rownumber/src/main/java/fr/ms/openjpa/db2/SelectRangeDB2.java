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

import org.apache.openjpa.jdbc.sql.SQLBuffer;

/**
 *
 * @see <a href="http://marcosemiao4j.wordpress.com">Marco4J</a>
 *
 *
 * @author Marco Semiao
 *
 */
final class SelectRangeDB2 {

    static void appendSelectRange(final SQLBuffer buf, final long start, final long end, final boolean subselect) {
	if (!subselect) {
	    final boolean isStart = (start != 0);
	    final boolean isEnd = (end != Long.MAX_VALUE);

	    if (!(isStart | isEnd)) {
		final StringBuilder query = new StringBuilder("SELECT * FROM (");

		query.append("SELECT rr.*, ROW_NUMBER() OVER(ORDER BY ORDER OF rr) AS row_number_openjpa_db2 FROM (");
		query.append(buf.getSQL());
		query.append(") AS rr");

		query.append(") ");

		query.append("WHERE ");

		if (isStart) {
		    query.append("row_number_openjpa_db2 > ");
		    query.append(start);
		}

		if (isStart && isEnd) {
		    query.append(" AND ");
		}

		if (isEnd) {
		    query.append("row_number_openjpa_db2 <= ");
		    query.append(end);
		}

		buf.replaceSqlString(0, buf.getSQL().length(), query.toString());
	    }
	}
    }
}
