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
@MapperScan(basePackages = "com.wm.mutildatasource.mapper.aliyun",sqlSessionFactoryRef = "aliyunSqlSessionFactory")
public class AliyunDataSourceConfig {

    @Bean(name = "aliyunDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.aliyun")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "aliyunSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("aliyunDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mapper/aliyun/*.xml")
        );
        return bean.getObject();
    }

    public SqlSessionTemplate sqlSessionTemplate( @Qualifier("aliyunSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
