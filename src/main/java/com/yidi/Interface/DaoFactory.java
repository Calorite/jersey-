package com.yidi.Interface;

import com.yidi.DapImpl.DBService;

public interface DaoFactory {
	ParameterService getprocess();
	AboutParametersDAO getparametersdao(DBService helper);
	AboutQuestionDAO getquestiondao();
	AboutSolutionDAO getsolution();
}
