package com.protocall_service.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PrefixNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final String TABLE_PREFIX = "prtcall_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        // Use Identifier.toIdentifier to ensure the naming remains consistent
        return Identifier.toIdentifier(TABLE_PREFIX + name.getText(), name.isQuoted());
    }

}
