package com.yidi.DapImpl;

import com.yidi.Interface.AboutParametersDAO;
import com.yidi.Interface.AboutQuestionDAO;
import com.yidi.Interface.AboutSolutionDAO;
import com.yidi.Interface.DaoFactory;
import com.yidi.Interface.ParameterService;

public class DefaultDaoFactory implements DaoFactory {

	@Override
	public ParameterService getprocess() {
		// TODO Auto-generated method stub
		return new ProcessFactoryImpl();
	}

	@Override
	public AboutParametersDAO getparametersdao(DBService helper) {
		// TODO Auto-generated method stub
		return new AboutParameterImpl(helper);
	}

	@Override
	public AboutQuestionDAO getquestiondao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AboutSolutionDAO getsolution() {
		// TODO Auto-generated method stub
		return null;
	}


}
