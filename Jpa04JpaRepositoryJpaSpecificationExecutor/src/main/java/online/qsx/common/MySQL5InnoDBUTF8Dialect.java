package online.qsx.common;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * ÒýÇæ InnoDB
 * ×Ö·û¼¯ UTF-8
 */
public class MySQL5InnoDBUTF8Dialect extends MySQL5Dialect {

	@Override
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=UTF8";
	}

}
