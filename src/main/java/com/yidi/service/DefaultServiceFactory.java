package com.yidi.service;

import com.yidi.DapImpl.DBService;
import com.yidi.DapImpl.DefaultDaoFactory;
import com.yidi.Interface.AboutParametersDAO;
import com.yidi.Interface.AboutQuestionDAO;
import com.yidi.Interface.AboutSolutionDAO;
import com.yidi.Interface.DaoFactory;
import com.yidi.Interface.ParameterService;
import com.yidi.Interface.ServiceFactory;

public class DefaultServiceFactory implements ServiceFactory {
	private DaoFactory daoFactory;

	public DefaultServiceFactory() {
		this(new DefaultDaoFactory());
	}

	public DefaultServiceFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public ParameterService getparameterService() {
		// TODO Auto-generated method stub
		return daoFactory.getprocess();
	}

	@Override
	public AboutParametersDAO getparameterDao(DBService helper) {
		// TODO Auto-generated method stub
		return daoFactory.getparametersdao(helper);
	}

	@Override
	public DBService getDBhelper() {
		// TODO Auto-generated method stub
		return new DBService();
	}

	@Override
	public AboutQuestionDAO getquestionDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AboutSolutionDAO getsolutionDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
