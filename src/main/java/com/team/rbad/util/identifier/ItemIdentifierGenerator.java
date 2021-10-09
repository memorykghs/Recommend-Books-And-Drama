package com.team.rbad.util.identifier;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * 自訂 ItemInfo 序號產生
 * @author memorykghs
 */
public class ItemIdentifierGenerator implements IdentifierGenerator {

	private String valuePrefix = "I";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Connection connection = session.connection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("select count('ITEM_SEQ') as ITEM_ID from Ashley.all_sequences");
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				int id = rs.getInt(1) + 1;
				String seq = StringUtils.leftPad(String.valueOf(id), 3, "0");
				String today = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now()).toString();
				String genId = valuePrefix + today + seq;

				System.out.println("Generated Stock Code: " + genId);
				return genId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
