package config;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.alibaba.druid.pool.DruidDataSource;

//@Configuration // 表明此类是配置类
//@ComponentScan // 扫描自定义的组件(repository service component controller)
//@PropertySource("classpath:ApplicationConfig.properties") // 读取properties配置
////@MapperScan("config") // 扫描Mybatis的Mapper接口
//@EnableTransactionManagement(proxyTargetClass = true) // �?启事务管�?
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig_A {/*

	
	// 事务方法超时时间设置
	private static final int TX_METHOD_TIMEOUT = 5;
	
	
	@Autowired
    private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(env.getProperty("spring.datasource.user"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver"));
		dataSource.setMaxActive(20);
		dataSource.setMaxWait(6000);
		dataSource.setDefaultAutoCommit(false);
		dataSource.setInitialSize(5);
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource)
			throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("mybatis.type.alias.package");
//		sqlSessionFactoryBean.setConfiguration(configuration);
		PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(env.getProperty("mybatis.mapperLocations")));

		return sqlSessionFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
//		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		LocalDataSourceTransactionManager dataSourceTransactionManager = new LocalDataSourceTransactionManager(dataSource());
		
		dataSourceTransactionManager.setGlobalRollbackOnParticipationFailure(false);
		return dataSourceTransactionManager;

	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}





	*//**
	 * 增强(事务)的属性的配置
	 * isolation:DEFAULT  :事务的隔离级.
	 * propagation:事务的传播行.
	 * read-only:false.不是只读
	 * timeout:-1
	 * no-rollback-for:发生哪些异常不回
	 * rollback-for:发生哪些异常回滚事务
	 * @return       
	 *//*

	@Bean
	public TransactionInterceptor txAdvice() {
		// 增强(事务)的属性的配置
		NameMatchTransactionAttributeSource txAttributeS = transactionAttributeSource();
		TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager(), txAttributeS);
		return txAdvice;

	}

	@Bean
	public NameMatchTransactionAttributeSource transactionAttributeSource() {
		NameMatchTransactionAttributeSource txAttributeS = new NameMatchTransactionAttributeSource();

		 propagation="REQUIRED" , timeout=5 ;rollback-for=".. , .."配置 

		RuleBasedTransactionAttribute requiredAttr = new RuleBasedTransactionAttribute();
		requiredAttr.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		requiredAttr.setTimeout(TX_METHOD_TIMEOUT);
		requiredAttr.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		 propagation="SUPPORTS" , readOnly="true"配置 
		RuleBasedTransactionAttribute supportsAttr = new RuleBasedTransactionAttribute();
		supportsAttr.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
		supportsAttr.setReadOnly(true);
		
		 *  注意：方法名称来自类匹配的到方法   
		 
		Map<String, TransactionAttribute> txMethod = new HashMap<String, TransactionAttribute>();
		txMethod.put("save*", requiredAttr);
		txMethod.put("add*", requiredAttr);
		txMethod.put("insert*", requiredAttr);
		txMethod.put("update*", requiredAttr);
		txMethod.put("transfer*", requiredAttr); 
		txMethod.put("find*", supportsAttr);
		txMethod.put("select*", supportsAttr);
		txMethod.put("get*", supportsAttr);
		txMethod.put("does*", requiredAttr);
		txAttributeS.setNameMap(txMethod);
		return txAttributeS;
	}

	*//***
	 * AOP配置定义切面和切点的信息
	 * 
	 * @return
	 *//*
	@Bean
	public Advisor txAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(env.getProperty("aop_pointcut_expression"));
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}
	
	

	

*/}
