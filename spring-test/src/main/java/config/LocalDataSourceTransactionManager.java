package config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class LocalDataSourceTransactionManager extends DataSourceTransactionManager {

	public LocalDataSourceTransactionManager(DataSource dataSource) {
		super(dataSource);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		System.out.println("begin-----------------------------");
		super.doBegin(transaction, definition);
		
		
	}

	@Override
	protected void doCommit(DefaultTransactionStatus status) {
		super.doCommit(status);
		System.out.println("commit-----------------------------");
	}

	@Override
	protected void doRollback(DefaultTransactionStatus status) {
		super.doRollback(status);
		System.out.println("rollback-----------------------------");
	}

	
	
}
