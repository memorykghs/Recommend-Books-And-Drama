package com.team.rbad.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class ItemIdSeqGenerator extends SequenceStyleGenerator {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";

    public static final String VALUE_PREFIX_DEFAULT = "B";

    private String valuePrefix;

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";

    public static final String NUMBER_FORMAT_DEFAULT = "%03d";

    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String today = sdf.format(new Timestamp(System.currentTimeMillis()));
        return valuePrefix + today + String.format(numberFormat, super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
    }

}
