package com.wm.mutildatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author: wangm
 * @date: 2021/7/28 14:07
 * @Description
 */
@Configuration
@MapperScan(basePackages = "com.wm.mutildatasource.mapper.local", sqlSessionFactoryRef = "localSqlSessionFactory")
public class LocalDataSourceConfig {

    @Bean(name = "localDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.local")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("localDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mapper/local/*.xml")
        );
        return bean.getObject();
    }

    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("localSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
