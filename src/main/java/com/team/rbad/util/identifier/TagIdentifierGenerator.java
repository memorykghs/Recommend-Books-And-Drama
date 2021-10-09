package com.team.rbad.util.identifier;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * 自訂 CategoryInfo 序號產生
 * @author memorykghs
 */
public class TagIdentifierGenerator implements IdentifierGenerator {

	private String valuePrefix = "G";

	private static int idValue;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Connection connection = session.connection();
		if (idValue == 0) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("select count('TAG_SEQ') as TAG_ID from Ashley.all_sequences");
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					idValue = rs.getRow() + 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}else {
			idValue++;
		}

		String seq = StringUtils.leftPad(String.valueOf(idValue), 5, "0");
		String genId = valuePrefix + seq;

		System.out.println("Generated Stock Code: " + genId);
		return genId;

	}

}
